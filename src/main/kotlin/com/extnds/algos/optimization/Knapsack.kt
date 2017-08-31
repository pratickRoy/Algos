package com.extnds.algos.optimization

/**
 *  References:
 *  @See <a href="https://en.wikipedia.org/wiki/Knapsack_problem">Knapsack Wikipedia</a>
 */
class Knapsack(private val items : ArrayList<Item>, private val knapsackSpace : Int) {

    class Item(val value: Int, val space: Int) {

        override fun toString() : String {
            return "[$value|$space]"
        }
    }

    fun fractionalKnapsack() : Double {

        val sortedItems = items.sortedWith(Comparator { item1, item2 ->

            if((item1.value.toDouble() / item1.space) > (item2.value.toDouble() / item2.space)) {
                return@Comparator -1
            }
            return@Comparator 1
        })

        var availableSpace : Double = knapsackSpace.toDouble()
        var knapsackValue = 0.0
        for (item in sortedItems) {

            if(item.space <= availableSpace) {

                knapsackValue += item.value
                availableSpace -= item.space
            } else {

                knapsackValue += item.value * (availableSpace / item.space)
                break
            }
        }
        return knapsackValue
    }

    fun zeroOneKnapsack(unpickedItems : ArrayList<Item> = items,
                        pickedItems : ArrayList<Item> = ArrayList(),
                        availableSpace : Int = knapsackSpace) : Int {

        val localUnpickedItems = ArrayList(unpickedItems)
        val localPickedItems = ArrayList(pickedItems)

        if(localUnpickedItems.isEmpty()) {
            return 0
        }

        val currentItem = localUnpickedItems.removeAt(0)
        val knapsackValueIfNotPicked = zeroOneKnapsack(localUnpickedItems,
            localPickedItems,
            availableSpace)

        if (availableSpace - currentItem.space < 0) {
            return knapsackValueIfNotPicked
        }

        localPickedItems.add(currentItem)
        val knapsackValueIfPicked = zeroOneKnapsack(localUnpickedItems,
            localPickedItems,
            availableSpace - currentItem.space) + currentItem.value

        if (knapsackValueIfPicked > knapsackValueIfNotPicked) {
            return knapsackValueIfPicked
        }
        return knapsackValueIfNotPicked
    }

    fun memoizedZeroOneKnapsack(unpickedItems : ArrayList<Item> = items,
                                pickedItems : ArrayList<Item> = ArrayList(),
                                knapsackValueMemo : HashMap<String, Int> = HashMap(),
                                availableSpace : Int = knapsackSpace) : Int {

        val localUnpickedItems = ArrayList(unpickedItems)
        val localPickedItems = ArrayList(pickedItems)

        if(localUnpickedItems.isEmpty()) {
            return 0
        }

        val currentItem = localUnpickedItems.removeAt(0)

        val knapsackValueIfNotPicked = knapsackValueMemo
            .computeIfAbsent(localUnpickedItems.toString() + availableSpace,
                { memoizedZeroOneKnapsack(localUnpickedItems,
                    localPickedItems,
                    knapsackValueMemo,
                    availableSpace) })

        if (availableSpace - currentItem.space < 0) {
            return knapsackValueIfNotPicked
        }

        localPickedItems.add(currentItem)
        val knapsackValueIfPicked = knapsackValueMemo
            .computeIfAbsent(localUnpickedItems.toString() + (availableSpace - currentItem.space),
                { memoizedZeroOneKnapsack(localUnpickedItems,
                    localPickedItems,
                    knapsackValueMemo,
                    availableSpace - currentItem.space) }) + currentItem.value

        if (knapsackValueIfPicked > knapsackValueIfNotPicked) {
            return knapsackValueIfPicked
        }
        return knapsackValueIfNotPicked
    }

    fun tabulatedZeroOneKnapsack() : Int {

        val knapsackValueTable = Array(items.size + 1, { IntArray(knapsackSpace + 1) })

        for (itemIndex in 1 until knapsackValueTable.size) {

            for (availableSpace in 1 until knapsackValueTable[0].size) {

                if(items[itemIndex - 1].space <= availableSpace) {

                    /*
                     *   items[itemIndex - 1] as we consider NoItem as an Item!
                     *   so if itemIndex = 2 then
                     *   items[0] = 1stItem
                     *   items[1] = 2ndItem
                     *   .
                     *   .
                     *
                     *   but,
                     *   knapsackValueTable[0] = NoItem
                     *   knapsackValueTable[1] = 1stItem
                     *   knapsackValueTable[2] = 2ndItem
                     *   .
                     *   .
                     *
                     */
                    knapsackValueTable[itemIndex][availableSpace] = maxOf(items[itemIndex - 1].value +
                            knapsackValueTable[itemIndex - 1][availableSpace - items[itemIndex - 1].space],
                        knapsackValueTable[itemIndex -1][availableSpace])
                } else {

                    knapsackValueTable[itemIndex][availableSpace] = knapsackValueTable[itemIndex -1][availableSpace]
                }
            }
        }

        return knapsackValueTable[items.size][knapsackSpace]
    }


}