import kotlinx.atomicfu.AtomicRef
import kotlinx.atomicfu.atomic
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * An element is transferred from sender to receiver only when [send] and [receive]
 * invocations meet in time (rendezvous), so [send] suspends until another coroutine
 * invokes [receive] and [receive] suspends until another coroutine invokes [send].
 */
class SynchronousQueue<E> {
    /**
     * Sends the specified [element] to this channel, suspending if there is no waiting
     * [receive] invocation on this channel.
     */

    private val head: AtomicRef<Node<E>>
    private val tail: AtomicRef<Node<E>>

    init {
        val dummy = Node<E>()
        head = atomic(dummy)
        tail = atomic(dummy)
    }

    suspend fun send(element: E) {
        while (true) {
            val h = head.value
            val t = tail.value

            if (h === t || t.type === Type.SEND) {
                val next = t.next.value
                if (next !== null) {
                    tail.compareAndSet(t, next)
                } else {
                    val newTail = Node(Type.SEND, element)

                    val result = suspendCoroutine<Boolean> { continuation ->
                        newTail.continuation = continuation
                        if (t.next.compareAndSet(null, newTail)) {
                            tail.compareAndSet(t, newTail)
                        } else {
                            continuation.resume(false)
                        }
                    }

                    if (result) return
                }
            } else {
                val next = h.next.value
                if (t !== tail.value || h !== head.value || next === null) {
                    continue
                }
                if (next.type === Type.RECIEVE && head.compareAndSet(h, next)) {
                    next.element = element
                    next.continuation!!.resume(true)
                    return
                }
            }
        }
    }

    /**
     * Retrieves and removes an element from this channel if there is a waiting [send] invocation on it,
     * suspends the caller if this channel is empty.
     */
    suspend fun receive(): E {
        while (true) {
            val h = head.value
            val t = tail.value

            if (h === t || t.type === Type.RECIEVE) {
                val next = t.next.value
                if (next !== null) {
                    tail.compareAndSet(t, next)
                } else {
                    val newTail = Node<E>(Type.RECIEVE, null)
                    val result = suspendCoroutine<Boolean> { continuation ->
                        newTail.continuation = continuation
                        if (t.next.compareAndSet(null, newTail)) {
                            tail.compareAndSet(t, newTail)
                        } else {
                            continuation.resume(false)
                        }
                    }
                    if (result) return newTail.element!!
                }
            } else {
                val next = h.next.value
                if (t !== tail.value || h !== head.value || next === null)
                    continue

                if (next.type === Type.SEND && head.compareAndSet(h, next)) {
                    next.continuation!!.resume(true)
                    return next.element!!
                }
            }
        }
    }

    enum class Type {
        RECIEVE, SEND, NONE
    }

    class Node<E>() {
        var continuation: Continuation<Boolean>? = null
        var type: Type = Type.NONE
        val next: AtomicRef<Node<E>?> = atomic(null)
        var element: E? = null

        constructor(type: Type, element: E?) : this() {
            this.type = type
            this.element = element
        }
    }
}

