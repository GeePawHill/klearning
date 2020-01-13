package klearning

import org.assertj.core.api.Assertions.*
import org.junit.Test

class DumbTest {

    @Test
    fun `This tests nothing in particular and fails`() {
        assertThat(1).isEqualTo(1)
    }

    @Test
    fun `This tests nothing in particular and passes`() {
        assertThat(1).isEqualTo(1)
    }

    @Test
    fun `bomb test`() {
        assertThat("Mike").isNotEqualTo("Kahlil")
    }

}