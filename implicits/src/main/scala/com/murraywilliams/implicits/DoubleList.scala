package com.murraywilliams.implicits

object DoubleList {
  
  implicit class ops(list: List[Double]) {
    def +(other: List[Double]): List[Double] = {
      (list zip other).map(t => t._1 + t._2)
    }
  }

}
