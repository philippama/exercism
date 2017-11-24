object SumOfMultiples {
    def sum(factors: Set[Int], limit: Int): Int = {
        sumBetter(factors, limit)
    }

    def sumMine(factors: Set[Int], limit: Int): Int = {
        (1 until limit).filter(number => factors.exists(factor => number % factor == 0))
                .sum
    }

    // From http://exercism.io/rdblyth
    def sumBetter(factors: Set[Int], limit: Int): Int = {
        (1 until limit).filter(n => factors.exists(n % _ == 0))
                .sum
    }
}
