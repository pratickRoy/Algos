package com.extnds.algos.search

import com.extnds.algos.graph.BreadthFirstSearch
import com.extnds.algos.graph.DepthFirstSearch
import com.extnds.algos.sort.*
import org.junit.Assert
import org.junit.Test
import java.util.Arrays
import java.util.ArrayList
import java.util.stream.Collectors


class GraphTest {

    object Graph {

        lateinit var adjLists : Array<List<Int>>
        lateinit var adjWeights : Array<List<Int>>

        fun unweightedGraph() : Graph {

            adjLists = Array(8, { listOf(0)})

            adjLists[1] = ArrayList(Arrays.asList(2, 3, 7))
            adjLists[2] = ArrayList(Arrays.asList(1, 3, 7))
            adjLists[3] = ArrayList(Arrays.asList(1, 2, 4, 5, 6))
            adjLists[4] = ArrayList(Arrays.asList(3, 5, 6))
            adjLists[5] = ArrayList(Arrays.asList(3, 4, 6))
            adjLists[6] = ArrayList(Arrays.asList(3, 4, 5, 7))
            adjLists[7] = ArrayList(Arrays.asList(1, 2, 6))

            adjWeights = Array(adjLists.size, { i -> adjLists[i]
                .stream()
                .map({1})
                .collect(Collectors.toList())})

            return this
        }
    }

    @Test
    fun breadthFirstSearchTest() {

        Assert.assertArrayEquals(intArrayOf(1, 2, 3, 7, 4, 5, 6),
            BreadthFirstSearch.search(Graph.unweightedGraph().adjLists, 1))

    }

    @Test
    fun depthFirstSearchTest() {

        Assert.assertArrayEquals(intArrayOf(1, 7, 6, 5, 4, 3, 2),
                DepthFirstSearch.search(Graph.unweightedGraph().adjLists, 1))

    }

}