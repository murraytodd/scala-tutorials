package com.murraywilliams.basicmonads

import scala.util.Try

object OptionExamples {

  def main(args: Array[String]): Unit = {

    val x: Option[Int] = Some(3)

    val y = if (x.isDefined) {
      x.get + 3
    } else {
      None
    }

    val y2 = x.map(_ + 3)
    val y3 = x.map(_ * 2)

    val z = for {
      ax <- Some(3)
      ay2 = ax + 3
      ay3 = ax * 2
    } yield (ay2 + ay3)

    val z2 = Some(3).map(ax => { val ay2 = ax + 3; val ay3 = ax * 2; ay2 + ay3 })

    println(s"z = $z = $z2")

    val bp = Try(scala.io.Source.fromFile("build.sbt").getLines())

    val lineCount = if (bp.isSuccess) {
      Some(bp.get.size)
    } else {
      None
    }

    println(lineCount)

    val o = Some(3)

    def test1(x: Int): Option[Int] = if (x % 2 == 0) Some(x) else None
    def test2(x: Int): Option[Int] = if (x % 5 == 0) Some(x) else None
    def test3(x: Int): Option[Int] = if (x % 7 == 0) Some(x) else None

    for {
      x <- 0 to 100
      t1 <- test1(x)
      t2 <- test2(t1)
      t3 <- test3(t2)
    } yield t3

  }

}
