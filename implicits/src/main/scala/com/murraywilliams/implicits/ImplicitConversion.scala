package com.murraywilliams.implicits

object ImplicitConversion {
  
  import scala.language.implicitConversions

  case class Color(name: String)

  implicit def colorFromString(name: String): Color = name.toLowerCase match {
    case "red" => Color("Red")
    case "blue" => Color("Blue")
    case "green" => Color("Green")
    case _ => Color("Unknown")
  }

}
