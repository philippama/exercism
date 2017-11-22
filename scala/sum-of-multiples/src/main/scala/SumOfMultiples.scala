object SumOfMultiples {
    def sum(factors: Set[Int], limit: Int): Int = {
        var accumulator: Int = 0
        for (i <- 1 until limit if hasFactor(factors, i)) accumulator = accumulator + i
        accumulator
    }

    def hasFactor(factors: Set[Int], number: Int): Boolean = {
        factors.exists(factor => number % factor == 0)
    }
}
