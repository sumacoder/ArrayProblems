package com.dsa.arrayproblems.array

object RemoveDuplicates {

    /**
     * Removing duplicates from sorted array can be done by comparing next item(s) in array.
     * if a[0] is equal to a[1] then remove a[1] or do not increment index value used for counting.
     * Solution: We used two index values, one for looping through the array and one to count
     * unique occurrences
     * Time complexity: O(n)
     * Aux Space complexity: O(1)
     */
    // TODO: for unsorted array we can use Set DS to achieve this by storing unique values
    fun removeDuplicatesFromSortedArray(data: Array<Int>) {

        val size = data.size
        var j = 0 // to maintain unique occurrences

        for (i in 0 until size - 1) {
            if (data[i] != data[i + 1]) {
                data[j++] = data[i]
            }
        }
        // We need to add this because we are comparing current char with next char and adding
        // unique value at last. As we are looping (size - 1) times we don't add last value either
        // its duplicate or no. So need to add here
        data[j++] = data[size - 1]

        for (k in 0 until j) {
            println("Unique value: ${data[k]}")
        }
    }

}