package com.murraywilliams.monoids

import cats.Monoid

object Stats {
  
  type StatsAggregator = (Double, Double, Long)

  def toStats(x: Double): StatsAggregator = (x, x * x, 1L)

  implicit class StatsAggregatorOps(stats: StatsAggregator) {
    def sum: Double = stats._1
    def sumOfSquares: Double = stats._2
    def count: Long = stats._3

    lazy val mean: Double = if (count > 0) (sum / count) else Double.NaN
    lazy val variance: Double = if (count > 0) 
      (sumOfSquares - (square(sum) / count)) / (count - 1)
    else
      Double.NaN 
    lazy val sdev: Double = Math.sqrt(variance)
  }

  val statsAggregatorMonoid = new Monoid[StatsAggregator] {

    override def combine(x: StatsAggregator, y: StatsAggregator): StatsAggregator =
      (x._1 + y._1, x._2 + y._2, x._3 + y._3)

    override def empty: StatsAggregator = (0.0, 0.0, 0L)

  }

}
