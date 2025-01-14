import org.junit.Test

import org.junit.Assert.*
import java.lang.Exception
import kotlin.test.assertFailsWith

class FizzBuzzTest {

    @Test
    fun Test_normal() {
        assertEquals("1", fizzBuzzWhizz(1))
        assertEquals("2", fizzBuzzWhizz(2))
    }

    @Test
    fun Test_3() {
        assertEquals("Fizz", fizzBuzzWhizz(3))
        assertEquals("Fizz", fizzBuzzWhizz(6))
    }

    @Test
    fun Test_5() {
        assertEquals("Buzz", fizzBuzzWhizz(5))
        assertEquals("Buzz", fizzBuzzWhizz(10))
    }

    @Test
    fun Test_7() {
        assertEquals("Whizz", fizzBuzzWhizz(7))
        assertEquals("Whizz", fizzBuzzWhizz(77))
    }

    @Test
    fun Test_15() {
        assertEquals("FizzBuzz", fizzBuzzWhizz(15))
        assertEquals("FizzBuzz", fizzBuzzWhizz(30))
    }

    @Test
    fun Test_When_5_appear_should_Buzz() {
        assertEquals("Buzz", fizzBuzzWhizz(25))
        assertEquals("Buzz", fizzBuzzWhizz(52))
    }

    @Test
    fun Test_When_7_appear_should_Whizz() {
        assertEquals("Whizz", fizzBuzzWhizz(7))
        assertEquals("Whizz", fizzBuzzWhizz(17))
    }

    @Test
    fun Test_When_3_appear_should_Fizz() {
        assertEquals("Fizz", fizzBuzzWhizz(31))
    }

    @Test
    fun Test_When_3_and_5_appear_should_FizzBuzz() {
        assertEquals("FizzBuzzWhizz", fizzBuzzWhizz(35))
        assertEquals("FizzBuzz", fizzBuzzWhizz(53))
    }

    @Test
    fun Test_When_3_and_7_appear_should_FizzWhizz() {
        assertEquals("FizzWhizz", fizzBuzzWhizz(37))
        assertEquals("FizzWhizz", fizzBuzzWhizz(73))
    }

    @Test
    fun Test_When_5_and_7_appear_should_BuzzWhizz() {
        assertEquals("FizzBuzzWhizz", fizzBuzzWhizz(57))
        assertEquals("FizzBuzzWhizz", fizzBuzzWhizz(75))
    }

    @Test
    fun Test_boundary() {
        assertFailsWith<Exception>("wtf ") { fizzBuzzWhizz(101) }
        assertFailsWith<Exception>("wtf ") { fizzBuzzWhizz(-1) }
    }

    private fun fizzBuzzWhizz(n: Int): String {
        if (n < 0 || n > 100) throw Exception()
        val shouldFizz: String = run { if (isMultiple(n, 3) || n.toString().contains("3")) "Fizz" else "" }
        val shouldBuzz = run { if (isMultiple(n, 5) || n.toString().contains("5")) "Buzz" else "" }
        val shouldWhizz = run { if (isMultiple(n, 7) || n.toString().contains("7")) "Whizz" else "" }
        val normalNumber = run { if (shouldBuzz == "" && shouldFizz == "" && shouldWhizz == "") n.toString() else "" }

        return shouldFizz + shouldBuzz + shouldWhizz + normalNumber
    }

    private fun isMultiple(n: Int, b: Int) = n % b == 0
}