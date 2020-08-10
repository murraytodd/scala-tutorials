package com.murraywilliams.implicits

import org.scalatest.FunSuite
import org.scalatest.Matchers
import java.text.NumberFormat

class TestConverter extends FunSuite with Matchers {
  
  test("Use implicit converters") {

    import Converter._

    implicit val colorConverter = ColorConverter
    implicit val percentConverter = new NumberConverter(NumberFormat.getPercentInstance())

    val color = "Red".parse[Color]
    color shouldBe Color(1.0, 0.0, 0.0)
    val pct = "130%".parse[Number]
    pct shouldBe 1.3

    val colorStr = Color(0.0, 1.0, 0.0).format
    colorStr shouldBe "Green"
    val pctStr = pct.format
    pctStr shouldBe "130%"
  }

}
