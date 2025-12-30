class Fraction(var numerator: Int, var denominator: Int) {
    fun gcd(number1: Int, number2: Int): Int {
        var m = number1
        var n = number2
        while (m % n != 0) {
            val saveM = m
            m = n
            n = saveM % n
        }
        return n
    }

    fun add(other: Fraction): Fraction {
        val newNumerator = this.numerator * other.denominator +
                this.denominator * other.numerator
        val newDenominator = this.denominator * other.denominator

        val common = gcd(newNumerator, newDenominator)

        return Fraction(
            newNumerator / common,
            newDenominator / common
        )
    }

    operator fun plus(other: Fraction): Fraction {
        return this.add(other)
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Fraction) {
            return false
        }
        val product1 = this.numerator * other.denominator
        val product2 = this.denominator * other.numerator

        return product1 == product2
    }

}

fun main() {
    val myFraction = Fraction(3, 5)
    println(myFraction)

    val f1 = Fraction(1, 4)
    val f2 = Fraction(1, 2)
    val f3 = f1.add(f2)
    println(f3)

    val f4 = Fraction(3, 5)
    val f5 = f4
    val f6 = Fraction(3, 5)
    println(f4 === f5) // comparing references is true
    println(f4 === f6) // but references aren't same
    println(f4 == f5) // deep compare is true
    println(f4 == f6) // and here also.

    val f7 = Fraction(1, 2)
    val f8 = Fraction(1, 3)
    val f9 = f7 + f8
    println(f9)
}
