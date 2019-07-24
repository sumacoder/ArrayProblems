package com.dsa.arrayproblems.string

import java.util.function.BiFunction

object RepeatedCharacters {

    /**
     * Print repeated characters with count in the given input.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    fun printRepeatedCharCount(input: String) {

        /**
         * TODO: Question: what about capital and small letters ? Should we consider then same ??
         * A: By default map considers them as different
         */
        val map = HashMap<Char, Int>()
        val length = input.length

        /**
         * Copy all characters as keys to a map along with its repeated count.
         * Time complexity: O(n)
         * Space complexity: O(n) for map
         */
        for (i in 0 until length) {
            map.compute(input[i], BiFunction { _, value ->
                if (value == null || value == 0) 1 else value + 1
            })
        }

        /**
         * Iterate through the map elements and print all key and values if value is greater
         * than 1.
         * Time complexity: O(n)
         */
        for (pair in map) {
            val value = pair.value
            if (value > 1) {
                println("Repeated key: ${pair.key} value: $value")
            }
        }
    }

    /**
     * Remove repeated characters and print the remaining characters in the same given order.
     * Eg: Input: Bananas Output: Bans
     * TODO: Question? What about capital and small letters ?
     * Time complexity: O(n)
     * Space complexity: O(n) for set
     */
    fun removeRepeatedChars(input: String) {

        // TODO: Capital and small letters are treated as different here
        var strData = input
        var size = strData.length

        // This will hold characters from the input string to check for duplicates
        val set = HashSet<Char>()

        var i = 0
        while (i < size) {
            val char = strData[i]
            if (set.contains(char)) {
                strData = strData.substring(0, i) + strData.subSequence(i + 1, size)
                size--
            } else {
                set.add(char)
                i++
            }
        }
        println("No duplicate characters string: $strData")
    }

}