package com.murraywilliams.monoids

import org.scalatest.FunSuite
import org.scalatest.Matchers
import scala.util.Using

class TestUsing extends FunSuite with Matchers {

  test("quick") {

    val count = Using.resource( getClass().getResourceAsStream("/iris.data")) { stream =>
      scala.io.Source.fromInputStream(stream).getLines.size
    }

    count shouldBe 151

  }

}
