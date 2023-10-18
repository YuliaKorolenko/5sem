import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.atomicArrayOfNulls
import java.util.*
import java.util.concurrent.ThreadLocalRandom

class FCPriorityQueue<E : Comparable<E>> {
    private val q = PriorityQueue<E>()
    private val lock = atomic(false)
    val THREAD_NUMBER = 10
    private val array = atomicArrayOfNulls<Operation<E>?>(THREAD_NUMBER )

    class Operation<E>(var isReady: Boolean, var type: Type, var element: E?)
    enum class Type {
        POLL, ADD, PEEK, DONE
    }

    /**
     * Retrieves the element with the highest priority
     * and returns it as the result of this function;
     * returns `null` if the queue is empty.
     */
    fun poll(): E? {
        val op = helper(Operation(false, Type.POLL, null))
        return op
    }

    /**
     * Returns the element with the highest priority
     * or `null` if the queue is empty.
     */
    fun peek(): E? {
       var op =  helper(Operation(false, Type.PEEK, null))
       return op
    }

    /**
     * Adds the specified element to the queue.
     */
    fun add(element: E) {
       var op = helper(Operation(false, Type.ADD, element))
    }

    private fun tryLock(): Boolean {
        return lock.compareAndSet(false, true)
    }
    private fun unlock() {
        lock.getAndSet(false)
    }

    fun helper(curOperation: Operation<E>): E? {
        while (true) {
            val randomElement = ThreadLocalRandom.current().nextInt(0, THREAD_NUMBER)
            if (array[randomElement].compareAndSet(null, curOperation)) {
                while (!curOperation.isReady) {
                    if (tryLock()) {
                        for (j in 0 until THREAD_NUMBER) {
                            val curElement = array[j].value
                            if (curElement === null) {
                                continue
                            }
                            if (curElement.isReady){
                                continue
                            }
                            if (curElement.type == Type.ADD) {
                                q.add(curElement.element)
                            }
                            if (curElement.type == Type.PEEK) {
                                curElement.element = q.peek()
                            }
                            if (curElement.type == Type.POLL) {
                                curElement.element = q.poll()
                            }
                            curElement.isReady = true
                        }
                        unlock()
                    }
                }
                array[randomElement].value = null
                return curOperation.element
            }
        }
    }
}