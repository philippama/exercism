object OptimiseBatches {

  def apply(batches: List[List[Int]]): List[List[Int]] = {
    val (fives, remainder5) = batches.partition(_.length == 5)
    val (threes, remainder) = remainder5.partition(_.length == 3)

    remainder ++ optimiseFivesAndThrees(fives, threes)
  }

  def optimiseFivesAndThrees(fives: List[List[Int]], threes: List[List[Int]]): List[List[Int]] = {

    val fivesAndThrees = fives.zipAll(threes, List.empty, List.empty)

    fivesAndThrees.flatMap(tuple => {
      val (five, three) = tuple
      if (five.nonEmpty && three.nonEmpty) {
        val bookToMove = five.diff(three).head
        val four1 = three :+ bookToMove
        val four2 = five.filter(_ != bookToMove)
        List(four1, four2)
      }
      else {
        List(five ++ three)
      }
    })
  }

}
