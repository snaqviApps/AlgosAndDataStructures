package ghar.learn.algorithms.structures.lists

import java.lang.IndexOutOfBoundsException


class MyLinkedList<T> : Iterable<T> {
     private var head : Node<T>? = null         // first node
     private var tail : Node<T>? = null         // last node
    var size = 0
         private set

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }

    private fun isEmpty(): Boolean {
       return size == 0
    }



    /**
     * this returning of the 'this' is actually implementing same
     * 'fluent interface' approach that is used in 'Builder' pattern
     */
    fun push(value : T) : MyLinkedList<T> {
        head = Node(value = value, next = head)
        if(tail == null) {
            tail = head
        }
        size++
        return this
    }

    /**
     * Insert at 'tail'
     */
    fun append(value: T) {
        if(isEmpty()) {   // empty list, adding is same as 'push()' functionality
            push(value)
            return
        }
        tail?.next = Node(value= value)
        size++
    }

    fun nodeAt(index : Int): Node<T>? {
        // 1
        var currentNode = head
        var currentIndex = 0

        // 2
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }
    fun insert(value: T, afterNode: Node<T>) : Node<T> {
        // 1
        if(tail == afterNode) {
            append(value)
            tail?.let {
                return it
            }
        }
        // 2
        val newNode = Node(value = value, next = afterNode.next)
        // 3
        afterNode.next = newNode
        return newNode
    }

    /**
     * Removes a value at the Front of the list
     */
    fun pop() : T? {
        if(!isEmpty()) size--
        val result = head?.value
        if (isEmpty()) {
            tail = null
        }
        return result
    }

    /**
     * removes a value from the End-of-the-list
     */
    fun removeLast() : T? {
        val head = head ?: return null  // 1
        if(head.next == null) return pop()       // 2
        size--                                   // 3

        var prev = head                 // 4, search till Last-Node is Null (line# 89)
        var current = head
        var next = current.next
        while (next != null){
            prev = current
            current = next
            next = current.next
        }

        prev.next = null                         // 5, last Node of the list
        tail = prev                              // Update as last Node
        return current.value
    }

    /**
     * removing a node at a particular point in the list
     */
    fun removeAfter(node: Node<T>) : T? {
        val result = node.next?.value
        if(node.next == tail) {
            tail = node
        }
        if(node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }

    override fun toString(): String {
        return if(isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    data class Node<T>(var value: T, var next: Node<T>? = null) {
        override fun toString(): String {
            return if (next != null) {
                "$value -> ${next.toString()}"
            } else {
                "$value" }
        }
    }
}

class LinkedListIterator<T>(private val myLinkedList: MyLinkedList<T>) : Iterator<T> {

    /**
     * part of making this class as 'Iterable'
     */
    private var index = 0

    /**
     * to find out if 'Last Node' exists
     */
    private var lastNode : MyLinkedList.Node<T>? = null
    override fun hasNext(): Boolean {
        return index < myLinkedList.size
    }

    override fun next(): T {

        if (index >= myLinkedList.size) throw IndexOutOfBoundsException()       // 1

        lastNode = if(index == 0) {                                             // 2
            myLinkedList.nodeAt(0)
        } else {
            lastNode?.next
        }
        index++

        return lastNode!!.value
    }

}
