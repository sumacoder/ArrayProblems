package com.dsa.arrayproblems.string

import java.lang.StringBuilder

object StringReverse {

    /**
     * Time complexity O(n) - happens in O(n/2) times but still considered as linear time
     * Space complexity O(1) for temp to hold while swapping + StringBuilder ??
     */
    fun reverseStringIterative(input: String) {

        val strBuilder = StringBuilder(input)
        val length = strBuilder.length - 1
        val halfLength = length / 2
        var temp: Char

        for (i in 0..halfLength) {
            temp = strBuilder[i]
            strBuilder[i] = strBuilder[length - i]
            strBuilder[length - i] = temp
        }
        println("Input string: $input Reverse: $strBuilder")
    }

    /**
     * Recursive way: Here we move each character from 0th index to last in a recursive way
     * Time complexity: O(n)
     */
    fun reverseStringRecursive(input: String): String {
        // Base break case, if only one character then no need to reverse it
        if (input.length < 2) {
            println("Return char: $input")
            return input
        }
        println("Input: $input")
        return reverseStringRecursive(input.substring(1)) + input[0]
    }

}