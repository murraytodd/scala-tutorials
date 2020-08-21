package com.murraywilliams.implicits

import org.scalatest.FunSuite
import org.scalatest.Matchers

class TestGeneralSeqAddition extends FunSuite with Matchers {
  
  test("Basic pairwise addition") {

    import GeneralSeqAddition._

    Seq(1,2) + Seq(3,4) shouldBe Seq(4,6)
    List(2.3, 3.4) + List(-2.3, -3.4) shouldBe List(0.0, 0.0)
    Vector(13L, 0L) + Vector(1L, 1L) shouldBe Vector(14L, 1L)

  }

}
