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

    def normalize(x: Double): Double = (x - mean) / sdev
    def denormalize(x: Double): Double = (x * sdev) + mean
  }

  import cats.implicits._
  val statsAggregatorMonoid = implicitly(Monoid[StatsAggregator])

  implicit class SeqNormalization(data: Seq[Double]) {
    lazy val stats: StatsAggregator = data.map(toStats(_)).foldLeft(statsAggregatorMonoid.empty)(statsAggregatorMonoid.combine)
    lazy val mean = stats.mean
    lazy val sdev = stats.sdev
    lazy val normalize = data.map(stats.normalize)
  }

  implicit class ArrayNormalization(data: Array[Double]) extends SeqNormalization(data.toIndexedSeq)

}
