package klearning

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FizzBuzzTest {

    @Test
    fun `1 is not a fizz`() {
        assertThat(fizzBuzz(1)).isEqualTo("1")
    }

    @Test
    fun `2 is not a fizz`() {
        assertThat(fizzBuzz(2)).isEqualTo("2")
    }

    @Test
    fun `3 is a fizz`() {
        assertThat(fizzBuzz(3)).isEqualTo("Fizz")
    }

    @Test
    fun `4 is not a fizz`() {
        assertThat(fizzBuzz(4)).isEqualTo("4")
    }

    @Test
    fun `5 is a buzz`() {
        assertThat(fizzBuzz(5)).isEqualTo("Buzz")
    }

    @Test
    fun `6 is a fizz`() {
        assertThat(fizzBuzz(6)).isEqualTo("Fizz")
    }

    @Test
    fun `10 is a buzz`() {
        assertThat(fizzBuzz(10)).isEqualTo("Buzz")
    }

    @Test
    fun `15 is a fizzbuzz`() {
        assertThat(fizzBuzz(15)).isEqualTo("FizzBuzz")
    }

    // if( BOOLEAN ) ...
    // logical operators take booleans and return booleans
    // and  &&
    // or ||


    fun fizzBuzz(number: Int): String {
        val isDivisibleBy3 = (number % 3) == 0
        val isDivisibleBy5 = (number % 5) == 0

        if (isDivisibleBy3 && isDivisibleBy5) return "FizzBuzz"
        if (isDivisibleBy5) return "Buzz"
        if (isDivisibleBy3) return "Fizz"
        return "$number"
    }
}