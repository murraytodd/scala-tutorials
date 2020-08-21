package com.murraywilliams.monoids

import org.scalatest.{FunSuite, Matchers}

class TestListAddition extends FunSuite with Matchers {

  test("Add lists of monoids.") {

    import cats.instances.all._
    import SeqAddition._

    List(1,2) + List(5,2) shouldBe List(6,4)

    Vector(1.2, 3.4) + Vector(4.3, 0.6, 2.3) shouldBe Vector(5.5, 4.0, 2.3)

    // Note that array didn't automatically work with the SeqOps, so we had to make a separate
    // implementation for Array, and also interestingly, that implementation required an extra
    // implicit ClassTag to be passed!
    Array(2L, 3L) + Array(5L, 6L) shouldBe Array(7L, 9L)

  }

}
