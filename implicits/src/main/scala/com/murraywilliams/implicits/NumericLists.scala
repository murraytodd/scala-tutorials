package com.murraywilliams.implicits

object NumericLists {
  
  implicit class Ops[T: Numeric](list: List[T]) {
    def +(other: List[T])(implicit n: Numeric[T]): List[T] = {
      val len = Math.max(list.length, other.length)
      (list.padTo(len,n.zero) zip other.padTo(len,n.zero)).map { t =>
        n.plus(t._1, t._2)
      }
    }
  }

}
