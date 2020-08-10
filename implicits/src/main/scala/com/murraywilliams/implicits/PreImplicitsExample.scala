package com.murraywilliams.implicits

import java.text.NumberFormat

object PreImplicitsExample {

  def makeString(n: Double, f: NumberFormat): String = f.format(n)
  def reportError(n: Double, f: NumberFormat): String = makeString(n,f) + " isn't allowed here."
  def printDouble(n: Double, f: NumberFormat): String = makeString(n * 2,f)

  // sample implementation...

  val formatter = NumberFormat.getPercentInstance()
  reportError(1.2, formatter)
  printDouble(0.3, formatter)

}

object WithImplicitsExample {

  def makeString(n: Double)(implicit f: NumberFormat): String = f.format(n)
  def reportError(n: Double)(implicit f: NumberFormat): String = makeString(n)(f) + " isn't allowed here."
  def printDouble(n: Double)(implicit f: NumberFormat): String = makeString(n * 2)(f)

  implicit val formatter = NumberFormat.getInstance()

  reportError(-1.2)

}
