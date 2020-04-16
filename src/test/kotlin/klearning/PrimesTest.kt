package klearning

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class PrimesTest {

    ///
    // assertThat ( SOMETHING ). has some property
    @Test
    fun `2 is a prime`() {
        assertThat(isPrime(2)).isTrue()
    }

    @Test
    fun `3 is a prime`() {
        assertThat(isPrime(3)).isTrue()
    }

    @Test
    fun `4 is not a prime`() {
        assertThat(isPrime(4)).isFalse()
    }

    @Test
    fun `5 is a prime`() {
        assertThat(isPrime(5)).isTrue()
    }

    @Test
    fun `6 is not a prime`() {
        assertThat(isPrime(6)).isFalse()
    }

    @Test
    fun `9 is not a prime`() {
        assertThat(isPrime(9)).isFalse()
    }

    @Test
    fun `25 is not a prime`() {
        assertThat(isPrime(25)).isFalse()
    }

    @Test
    fun `49 is not a prime`() {
        assertThat(isPrime(49)).isFalse()
    }

    @Test
    fun `121 is not a prime`() {
        assertThat(isPrime(121)).isFalse()
    }

    @Test
    fun `25 is divisivble by 25`() {
        assertThat(isGreaterThanAndDivisibleBy(25, 25)).isFalse()
    }

    @Test
    fun `25 is divisible by 5`() {
        assertThat(isGreaterThanAndDivisibleBy(25, 5)).isTrue()
    }

    @Test
    fun `25 is divisible by 4`() {
        assertThat(isGreaterThanAndDivisibleBy(25, 4)).isFalse()
    }

    @Test
    fun `7741 is a prime?`() {
        assertThat(isPrime(7741)).isTrue()
    }

    @Test
    fun `7740 is not a prime?`() {
        assertThat(isPrime(7740)).isFalse()
    }

    fun isPrime(number: Int): Boolean {
        for (divider in 2..number) {
            if (isGreaterThanAndDivisibleBy(number, divider)) return false
        }
        return true
    }

    fun isGreaterThanAndDivisibleBy(number: Int, divider: Int): Boolean {
        o (number <= divider) return false
        return number % divider == 0
    }
}
