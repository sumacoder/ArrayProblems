package com.dsa.arrayproblems.problems

import java.util.function.BiFunction

/**
 * Object to print a given input permutation Strings. This process will take care of duplicates
 * Space complexity: O(n) for map, character array and count array
 * Time complexity: O(n!)
 * Source: https://www.youtube.com/watch?v=nYFd7VHKyWQ
 */
object StringPermutations {

    /**
     * This just prints all combination without worrying about duplicates results
     */
    fun printPermutation(input: String, result: String) {
        if (input.isEmpty()) {
            println("Output: $result")
            return
        }

        val size = input.length
        for (i in 0 until size) {
            /**
             * Step 1: Input: abc, output: ""
             * In first Step we copy first character from input string to result string and remove that character
             * from input string. Pass that input and result to recursive function call
             *
             * Step 2: Input: bc, output: a
             * Step 3: Input: c, output: ab
             * Step 4: Input: , output: abc -> Print out string
             * Till here only recursive call happens so i value will be 0
             *
             * Step 5: Input: b, output: ac
             * Step 6: Input: , output: acb -> Print out string
             *
             * Step 7: Input: ac, output: b
             * Step 8: Input: c, output: ba
             * Step 9: Input: , output: bac -> Print out string
             *
             * Step 10: Input: a, output: bc
             * Step 11: Input: , output: bca -> Print out string
             *
             * Step 12: Input: ab, output: c
             * Step 13: Input: b, output: ca
             * Step 14: Input: , output: cab -> Print out string
             *
             * Step 15: Input: a, output: cb
             * Step 16: Input: , output: cba -> Print out string
             */
            printPermutation(input.substring(0, i) + input.substring(i + 1, input.length),
                result + input[i])
        }
    }

    /**
     * This prints permutations of a string with out any duplicates and in efficient way than regular
     * recursive and backtracking.
     */
    fun printPermutationsNoDuplicates(input: String) {
        println("Input String: $input")
        val inputSize = input.length
        // this map is used to hold unique characters as key and number of times it repeats in the
        // input string as value.
        val countMap = HashMap<Char, Int>()

        for (i in 0 until inputSize) {
            val c = input[i]
            println("Char at index: $i is: $c")

            // This compute method with BiFunction will check if the key already exist in the
            // map or not, if exist then increase value by 1 or else set value 1
            countMap.compute(c, BiFunction { _, value ->
                if (value == null || value == 0) 1 else value + 1
            })
        }
        val mapSize = countMap.size
        // This two arrays will hold characters from the input string without duplicates and
        // count of each repeated character
        val chars = CharArray(mapSize)
        val counts = IntArray(mapSize)

        var index = 0
        for (entrySet in countMap) {
            chars[index] = entrySet.key
            counts[index++] = entrySet.value
        }
        // Result should always be input size
        val result = CharArray(inputSize)
        // level should always start with 0
        permutationUtil(chars, counts, result, 0)
    }

    /**
     * This will take unique characters array and count of each character array as input and
     * works on string permutation results using recursion and backtracking mechanism.
     *
     * @param chars unique character array from input string.
     * @param count count of each character in [chars].
     * @param result to hold input permutation result and print.
     * @param level Depth level and this indicate the index of result array wr we need to insert
     * character from [chars].
     */
    private fun permutationUtil(chars: CharArray, count: IntArray, result: CharArray, level: Int) {

        if (level == result.size) {
            printArray(result)
            return
        }

        val size = chars.size
        for (i in 0 until size) {
            if (count[i] == 0)
                continue
            result[level] = chars[i]
            count[i]--
            permutationUtil(chars, count, result, level + 1)
            //println("Index value: $i")
            // TODO: why are we incrementing here ??
            // As we need to back track to before value to create a combination we need to
            // increment count[i] value.
            count[i]++
        }
    }

    private fun printArray(chars: CharArray) {
        val str = StringBuilder()
        for (c in chars)
            str.append(c)
        println("Combination: $str")
    }


}