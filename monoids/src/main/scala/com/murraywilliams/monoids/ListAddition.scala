package com.murraywilliams.monoids

import cats.Monoid

object ListAddition {
  
  implicit class ListOps[T: Monoid](list: List[T]) {
    def +(other: List[T])(implicit m: Monoid[T]): List[T] = {
      val len = Math.max(list.length, other.length)
      (list.padTo(len,m.empty) zip other.padTo(len,m.empty)).map { t => 
        m.combine(t._1, t._2)
      }
    }
  }

}
