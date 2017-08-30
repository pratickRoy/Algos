package com.extnds.algos.graph

import java.util.*

/**
 *  References:
 *  @See <a href="http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph">DFS GeeksForGeeks</a>
 *  @See <a href="https://en.wikipedia.org/wiki/Depth-first_search">DFS Wikipedia</a>
 */
object DepthFirstSearch {

    fun search(adjacentLists: Array<List<Int>>, startPosition: Int) : IntArray {

        val visitedArray = BooleanArray(adjacentLists.size)
        val dfsArray = ArrayList<Int>(adjacentLists.size)
        val stack = ArrayDeque<Int>()

        stack.add(startPosition)

        while (!stack.isEmpty()) {

            val currentNode = stack.removeLast()
            if (!visitedArray[currentNode]) {
                dfsArray.add(currentNode)
            }
            visitedArray[currentNode] = true

            adjacentLists[currentNode].filterNotTo(stack) { visitedArray[it] }
        }

        return dfsArray.toIntArray()
    }
}