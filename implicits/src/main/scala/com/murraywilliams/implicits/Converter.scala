package com.murraywilliams.implicits

import java.text.NumberFormat

case class Color(red: Double, green: Double, blue: Double)

trait Converter[T] {
  def parse(s: String): T
  def format(o: T): String
  def formalFormat(o: T): String = "The answer is " + format(o)
}

object Converter {
  implicit class StringOps(s: String) {
    def parse[T](implicit c: Converter[T]): T = c.parse(s)
  }
  implicit class ConvOps[T](o: T) {
    def format(implicit c: Converter[T]): String = c.format(o)
    def formal(implicit c: Converter[T]): String = c.formalFormat(o)
  }
}

class NumberConverter(f: NumberFormat) extends Converter[Number] {
  override def parse(s: String): Number = f.parse(s)
  override def format(o: Number): String = f.format(o)
}

object ColorConverter extends Converter[Color] {
  override def parse(s: String): Color = s match {
    case "Red" => Color(1.0, 0.0, 0.0)
    case "Green" => Color(0.0, 1.0, 0.0)
    case "Blue" => Color(0.0, 0.0, 1.0)
    case _ => Color(0.0, 0.0, 0.0)
  }
  override def format(o: Color): String = o match {
    case Color(1.0, 0.0, 0.0) => "Red"
    case Color(0.0, 1.0, 0.0) => "Green"
    case Color(0.0, 0.0, 1.0) => "Blue"
    case _ => "Unknown Color"
  }
}
