package com.murraywilliams.implicits

import scala.reflect.ClassTag

object GeneralSeqAddition {
  
  implicit class SeqOps[T: Numeric](data: Seq[T]) {
    def +(other: Seq[T])(implicit n: Numeric[T]): Seq[T] = {
      val len = Math.max(data.length, other.length)
      (data.padTo(len,n.zero) zip other.padTo(len,n.zero)).map { t =>
        n.plus(t._1, t._2)
      }
    }

    def -(other: Seq[T])(implicit n: Numeric[T], ct: ClassTag[T]): Seq[T] = {
      val len = Math.max(data.length, other.length)
      (data.padTo(len,n.zero) zip other.padTo(len,n.zero)).map { t =>
        n.minus(t._1, t._2)
      }
    }

    def *(other: Seq[T])(implicit n: Numeric[T], ct: ClassTag[T]): Seq[T] = {
      val len = Math.max(data.length, other.length)
      (data.padTo(len,n.one) zip other.padTo(len,n.one)).map { t =>
        n.times(t._1, t._2)
      }
    }

    def /(other: Seq[T])(implicit n: Fractional[T], ct: ClassTag[T]): Seq[T] = {
      val len = Math.max(data.length, other.length)
      (data.padTo(len,n.one) zip other.padTo(len,n.one)).map { t =>
        n.div(t._1,t._2)
      }
    }
  }

  implicit class ArrayOps[T: Numeric](data: Array[T]) {
    import scala.reflect.ClassTag

    def +(other: Array[T])(implicit n: Numeric[T], ct: ClassTag[T]): Array[T] = {
      val len = Math.max(data.length, other.length)
      (data.padTo(len,n.zero) zip other.padTo(len,n.zero)).map { t =>
        n.plus(t._1, t._2)
      }
    }
    
    def -(other: Array[T])(implicit n: Numeric[T], ct: ClassTag[T]): Array[T] = {
      val len = Math.max(data.length, other.length)
      (data.padTo(len,n.zero) zip other.padTo(len,n.zero)).map { t =>
        n.minus(t._1, t._2)
      }
    }

    def *(other: Array[T])(implicit n: Numeric[T], ct: ClassTag[T]): Array[T] = {
      val len = Math.max(data.length, other.length)
      (data.padTo(len,n.one) zip other.padTo(len,n.one)).map { t =>
        n.times(t._1, t._2)
      }
    }

    def /(other: Array[T])(implicit n: Fractional[T], ct: ClassTag[T]): Array[T] = {
      val len = Math.max(data.length, other.length)
      (data.padTo(len,n.one) zip other.padTo(len,n.one)).map { t =>
        n.div(t._1,t._2)
      }
    }
  }

}
