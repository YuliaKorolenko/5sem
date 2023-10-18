package mpp.stackWithElimination

import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.atomicArrayOfNulls
import kotlin.random.Random

class TreiberStackWithElimination<E> {
    private val top = atomic<Node<E>?>(null)
    private val eliminationArray = atomicArrayOfNulls<Element<E>>(ELIMINATION_ARRAY_SIZE)

    /**
     * Adds the specified element [x] to the stack.
     */
    fun push(x: E) {
        while (true) {
            val cur_top = top.value
            val new_top = Node(x, cur_top)
            val element = Element(x)
            if (top.compareAndSet(cur_top, new_top)) {
                return
            } else {
                val index = Random.nextInt(ELIMINATION_ARRAY_SIZE)
                if (eliminationArray[index].value == null) {
                    if (eliminationArray[index].compareAndSet(null, element)) {
                        repeat(500) {}
                        if (eliminationArray[index].compareAndSet(element, null)) {
                            continue
                        } else {
                            return
                        }
                    }
                }
            }
        }
    }

    /**
     * Retrieves the first element from the stack
     * and returns it; returns `null` if the stack
     * is empty.
     */
    fun pop(): E? {
        while (true) {
            val cur_top = top.value
            if (cur_top == null) {
                return null
            }
            val new_top = cur_top.next
            if (top.compareAndSet(cur_top, new_top)) {
                return cur_top.x
            } else {
                val index = Random.nextInt(ELIMINATION_ARRAY_SIZE)
                val element = eliminationArray[index].value
                if (element != null) {
                    if (eliminationArray[index].compareAndSet(element, null)) {
                        return element.x
                    }
                }
            }
        }

    }
}

private class Node<E>(val x: E, val next: Node<E>?)

private class Element<E>(val x: E)

private const val ELIMINATION_ARRAY_SIZE = 2 // DO NOT CHANGE IT