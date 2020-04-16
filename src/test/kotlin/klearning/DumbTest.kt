package klearning

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class DumbTest {

    @Test
    fun `Empty String Does not Have a Z`() {
        val actual = hasZ("")
        assertThat(actual).isEqualTo(false)
    }

    @Test
    fun `Kahlil Does not Have a Z`() {
        val actual = hasZ("Kahlil")
        assertThat(actual).isFalse()
    }

    @Test
    fun `String has a lower-case Z`() {
        val actual = hasZ("z")
        assertThat(actual).isEqualTo(true)
    }

    @Test
    fun `string has upper-case Z`() {
        val actual = hasZ("Z")
        assertThat(actual).isTrue()
    }

    @Test
    fun `Arizona has z`() {
        val actual = hasZ("Arizona")
        assertThat(actual).isTrue()
    }

    @Test
    fun `Arizona has a z at position 3`() {
        val actual = whereZ("Arizona")
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `z has a z at position 0`() {
        val actual = whereZ("z")
        assertThat(actual).isEqualTo(0)
    }

    @Test
    fun `grumpy has a z at position -1 NO Z`() {
        val actual = whereZ("grumpy")
        assertThat(actual).isEqualTo(-1)
    }

    @Test
    fun `empty string has a z at position -1 NO Z`() {
        val actual = whereZ("")
        assertThat(actual).isEqualTo(-1)
    }

    fun hasZ(input: String): Boolean {
        for (mychar in input) {
            if (mychar == 'z' || mychar == 'Z') return true
        }
        return false
    }

    fun whereZ(input: String): Int {
        var pos = 0
        for (mychar in input) {
            if (mychar == 'z' || mychar == 'Z') return pos
            pos = pos + 1
        }
        return -1
    }

    fun whereZwithotherloop(input: String): Int {
        for (pos in input.indices) {
            val mychar = input[pos]
            if (mychar == 'z' || mychar == 'Z') return pos
        }
        return -1
    }

    @Test
    fun `the cow is two words`() {
        assertThat(howManyWords("the cow")).isEqualTo(2)
    }

    @Test
    fun `cow is one word`() {
        assertThat(howManyWords("cow")).isEqualTo(1)
    }

    @Test
    fun `there are no words`() {
        assertThat(howManyWords("")).isEqualTo(0)
    }

    @Test
    fun `trailing spaces counted correctly`() {
        assertThat(howManyWords("abc ")).isEqualTo(1)
    }

    @Test
    fun `multiple spaces counted correctly`() {
        assertThat(howManyWords("cows  chew ")).isEqualTo(2)
    }

    @Test
    fun `there's nothing`() {
        assertThat(howManyWords(" ")).isEqualTo(0)

    }

    @Test
    fun `comma check me out`() {
        assertThat(howManyWords("a, b")).isEqualTo(2)
    }

    @Test
    fun `comma with no spaces`() {
        assertThat(howManyWords("a,b")).isEqualTo(2)
    }

    @Test
    fun `newlines with no spaces`() {
        assertThat(howManyWords("a\nb")).isEqualTo(2)
    }

    @Test
    fun `tabs with no spaces`() {
        assertThat(howManyWords("a\tb")).isEqualTo(2)
    }

    /*
    expression is anything that is one whole computable thing.
    a literal string is an expression "abc"
    a literal char is an expression 'a'
    a literal integer is an expression 1
    a number with a decimal point is an expression 1.3
    a *calculation* is an expression: "abc" + "def"
    a function with a return value is an expression stinkyFunction(): Int
    a true/false flag is an expression true

    (exor && expr)

     */

    fun howManyWords(input: String): Int {
        var words = 0
        var charsInThisWord = 0
        for (anything in input) {
            if (isWordSeparator(anything)) {
                if (charsInThisWord != 0) {
                    words += 1
                    charsInThisWord = 0
                }
            } else charsInThisWord += 1
        }
        if (charsInThisWord > 0) words += 1
        return words
    }

    private fun isWordSeparator(aChar: Char): Boolean {
        return (aChar == ' ') || (aChar == ',') || (aChar == '\n') || (aChar == '\t')
    }

    // output
    //  return a list of words in the input
    //  sorted alphabetically
    //  only unique words
    //  all lower-case
    //  honest-to-god words, not just things separated by spaces

    @Ignore("WIP")
    @Test
    fun storyTest() {
        val input = """
This is a story with words. 
It's got sentences. It is 
a good story.
        """.trimIndent()
        val actual = wordize(input)
        assertThat(actual).containsExactly(
            "a",
            "good",
            "got",
            "is",
            "it",
            "it's",
            "sentences",
            "story",
            "this",
            "with",
            "words"
        )
    }

    @Test
    fun `story is empty`() {
        assertThat(findWords("")).isEmpty()
    }

    @Test
    fun `story as one word`() {
        assertThat(findWords("word")).containsExactly("word")
    }

    @Test
    fun `story as another word`() {
        assertThat(findWords("cow")).containsExactly("cow")
    }

    @Test
    fun `story as yet a different another word`() {
        assertThat(findWords("abracadabra")).containsExactly("abracadabra")
    }

    @Test
    fun `story has blank space`() {
        assertThat(findWords("a ")).containsExactly("a")
    }

    /*
    look at the next word
    if i don't have it
        add it to the sorted list
    rewrite it all in lower case

     */
    fun findWords(story: String): List<String> {
        val words = mutableListOf<String>()
        if (story.isEmpty()) {
            return words           // DON'T DO ANOTHER LINE, GET OUTTA HERE
        }
        var unfinishedWord = ""
        for (tile in story) {
            if (tile != ' ') {
                unfinishedWord += tile
            } else {
                if (unfinishedWord.isNotEmpty()) {
                    words += unfinishedWord
                    unfinishedWord = ""
                }
            }
        }
        if (unfinishedWord.isNotEmpty()) {
            words += unfinishedWord
        }
        // while I give you a tile
        // if the tile is part of a word, add it to the unfinishedWord
        // else
        //      if i got a word i'm working on, add it to my list
        //      else just keep going
        //  endif
        return words
    }

    fun wordize(text: String): List<String> {
        return emptyList()
    }

}

