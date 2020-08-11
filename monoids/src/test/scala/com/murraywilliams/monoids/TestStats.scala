package com.murraywilliams.monoids

import org.scalatest.FunSuite
import org.scalatest.Matchers

class TestStats extends FunSuite with Matchers {
  
  test("Basic Stats") {
    import Stats._
    import cats._
    import cats.implicits._

    val data = List(2.2, 3.3, 0.7, 1.4)

    val stats = data.map(toStats).combineAll
    println(stats)
    println(s"${stats.mean} ${stats.variance} ${stats.sdev}")
  }

}
