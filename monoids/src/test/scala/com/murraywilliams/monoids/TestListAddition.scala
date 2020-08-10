package com.murraywilliams.monoids

import org.scalatest.{FunSuite, Matchers}

class TestListAddition extends FunSuite with Matchers {

  test("Add lists of monoids.") {

    import cats.instances.all._
    import ListAddition._

    List(1,2) + List(5,2) shouldBe List(6,4)

    List(1.2, 3.4) + List(4.3, 0.6, 2.3) shouldBe List(5.5, 4.0, 2.3)

    List(2L, 3L) + List(5L, 6L) shouldBe List(7L, 9L)

  }

}
