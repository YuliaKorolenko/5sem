package dijkstra

import java.util.*
import java.util.concurrent.Phaser
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock
import kotlin.Comparator
import kotlin.concurrent.thread

private val NODE_DISTANCE_COMPARATOR = Comparator<Node> { o1, o2 -> Integer.compare(o1!!.distance, o2!!.distance) }

private class MultiQueue(var workers: Int) {
    private class Queue<E>() {
        val priorityQueue = PriorityQueue(NODE_DISTANCE_COMPARATOR)
    }

    var size = AtomicInteger(0)
    private val listOfQueue = Array(workers) { Queue<Node>() }
    fun insert(element: Node) {
        while (true) {
            val i1 = ThreadLocalRandom.current().nextInt(0, workers)
            val q = listOfQueue[i1]
            synchronized(q) {
                q.priorityQueue.add(element)
                size.incrementAndGet()
            }
            return
        }
    }

    fun delete(): Node? {
        while (true) {
            val i1 = ThreadLocalRandom.current().nextInt(0, workers)
            var i2 = ThreadLocalRandom.current().nextInt(0, workers)
            val q1 = listOfQueue[i1]
            val q2 = listOfQueue[i2]

            var q = q2
            var isq1Empty = q1.priorityQueue.isEmpty()
            var isq2Empty = q2.priorityQueue.isEmpty()

            if (isq1Empty && isq2Empty) {
                return null
            }
            if (isq1Empty) q = q2
            if (isq2Empty) q = q1

            if (!isq1Empty && !isq2Empty && NODE_DISTANCE_COMPARATOR.compare(
                    q1.priorityQueue.peek(),
                    q2.priorityQueue.peek()
                ) < 0
            ) {
                q = q1
            }

            synchronized(q) {
                val element = q.priorityQueue.poll()
                return element
            }
        }
    }

    fun isEmpty() = size.compareAndSet(0, 0)
}

// Returns `Integer.MAX_VALUE` if a path has not been found.
fun shortestPathParallel(start: Node) {
    val workers = Runtime.getRuntime().availableProcessors()
    // The distance to the start node is `0`
    start.distance = 0
    // Create a priority (by distance) queue and add the start node into it
    val q = MultiQueue(2 * workers) // TODO replace me with a multi-queue based PQ!
    q.insert(start)
    // Run worker threads and wait until the total work is done
    val onFinish = Phaser(workers + 1) // `arrive()` should be invoked at the end by each worker
    repeat(workers) {
        thread {
            while (true) {
                // TODO Write the required algorithm here,
                // TODO break from this loop when there is no more node to process.
                // TODO Be careful, "empty queue" != "all nodes are processed".
                val cur: Node? = synchronized(q) { q.delete() }
                if (cur == null) {
                    if (q.isEmpty()) break else continue
                }
                for (e in cur.outgoingEdges) {
                    while (true) {
                        val previous = e.to.distance
                        val current = cur.distance + e.weight
                        if (previous > current) {
                            if (e.to.casDistance(previous, current)) {
                                q.insert(e.to)
                            } else {
                                continue
                            }
                        } else {
                            break
                        }
                    }
                }
                q.size.decrementAndGet();
            }
            onFinish.arrive()
        }
    }
    onFinish.arriveAndAwaitAdvance()
}
