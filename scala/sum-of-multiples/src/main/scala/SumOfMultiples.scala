object SumOfMultiples {
    def sum(factors: Set[Int], limit: Int): Int = {
        (1 until limit).filter(number => factors.exists(factor => number % factor == 0))
                .sum
    }
}
