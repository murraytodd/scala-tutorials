package com.murraywilliams.implicits

object AltSeqMath {
  
  implicit class AltSeqOps[T: Numeric](data: Seq[T]) {

    def +(other: T)(implicit n: Numeric[T]): Seq[T] = {
      data.map(n.plus(other,_))
    }

    def +(other: Seq[T])(implicit n: Numeric[T]): Seq[T] = {
      (data zip other).map(t => n.plus(t._1,t._2))
    }

  }

  implicit class AltNumOps[T: Numeric](value: T) {

    def +(other: Seq[T])(implicit n: Numeric[T]): Seq[T] = {
      other.map(n.plus(value,_))
    }

  }

}
