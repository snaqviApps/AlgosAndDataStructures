package ghar.learn.algorithms.structures.lists

fun main() {

        val myList = MyLinkedList<Int>()
        myList.push(3).push(2).push(1)

        // Test the insert
        println("pre removal: $myList")

        val index = 1
        val node = myList.nodeAt(index - 1)
        val removedValue: Any? =  if(node != null) {
                myList.removeAfter(node)
        } else { }

        println("post-removing last node at index: $index: $myList")
        println("removed value: $removedValue")

}