package com.extnds.algos.graph

import java.util.ArrayDeque


/**
 *  References:
 *  @See <a href="http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph">BFS GeeksForGeeks</a>
 *  @See <a href="https://en.wikipedia.org/wiki/Breadth-first_search">BFS Wikipedia</a>
 */
object BreadthFirstSearch {
    
    fun search(adjacentLists: Array<List<Int>>, startPosition: Int) : IntArray {

        val visitedArray = BooleanArray(adjacentLists.size)
        val bfsArray = ArrayList<Int>(adjacentLists.size)
        val queue = ArrayDeque<Int>()

        queue.add(startPosition)

        while (!queue.isEmpty()) {

            val currentNode = queue.removeFirst()
            if (!visitedArray[currentNode]) {
                bfsArray.add(currentNode)
            }
            visitedArray[currentNode] = true

            adjacentLists[currentNode].filterNotTo(queue) { visitedArray[it] }
        }

        return bfsArray.toIntArray()
    }
}