package com.murraywilliams.implicits

import org.scalatest.FunSuite
import org.scalatest.Matchers

class TestDoubleList extends FunSuite with Matchers {
  
  test("Basic list addition") {
    import DoubleList._

    ( List(1.0, 2.0) + List(3.0, 4.0) ) shouldBe List(4.0, 6.0)
  }

}
