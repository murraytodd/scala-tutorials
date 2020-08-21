package com.murraywilliams.monoids

import org.scalatest.FunSuite
import org.scalatest.Matchers

class TestStats extends FunSuite with Matchers {
  
  test("Basic Stats") {
    import Stats._
    import cats._
    import cats.implicits._

    val data = List(2.2, 3.3, 0.7, 1.4)

    val stats = data.stats
    println(stats)
    println(s"${stats.mean} ${stats.variance} ${stats.sdev}")
  }

  test("Automatic Array and Vector functionality") {
    import Stats._
    val data = Array(1.0, 2.0, 3.0)
    data.normalize shouldBe Array(-1.0, 0, 1.0)
    println(data.normalize)
    val vData = Vector(1.0, 2.0, 3.0)
    vData.mean shouldBe 2.0
  }

}
