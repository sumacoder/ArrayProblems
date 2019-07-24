package com.dsa.arrayproblems

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dsa.arrayproblems.array.RemoveDuplicates
import com.dsa.arrayproblems.string.RepeatedCharacters

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Print string permutations
         */
        // This will remove duplicates and print permutation in lexicographical order
        //StringPermutations.printPermutationsNoDuplicates("aabc")

        // This prints with duplicates
        //StringPermutations.printPermutation("aabc", "")

        /**
         * String reversal iterative way and recursive way
         */
        //StringReverse.reverseStringIterative("abcde")
        //val reverse = StringReverse.reverseStringRecursive("abcde")
        //println("Reverse String: $reverse")

        /**
         * Print repeated characters in a given string
         */
        //RepeatedCharacters.printRepeatedCharCount("Goooggle")

        /**
         * Remove duplicate characters from string and print only unique chars in given order.
         */
        //RepeatedCharacters.removeRepeatedChars("bananas")
        //RepeatedCharacters.removeRepeatedChars("Goooogggllleee")

        /**
         * Remove duplicated from Int array
         */
        RemoveDuplicates.removeDuplicatesFromSortedArray(arrayOf(1, 1, 1, 2, 2, 2, 2, 2, 4, 5, 6, 7, 7, 7))

    }
}
