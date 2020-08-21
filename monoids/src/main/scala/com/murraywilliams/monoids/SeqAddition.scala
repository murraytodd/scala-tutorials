package com.murraywilliams.monoids

import cats.Monoid

object SeqAddition {

  implicit class SeqOps[T: Monoid](seq: Seq[T]) {
    def +(other: Seq[T])(implicit m: Monoid[T]): Seq[T] = {
      val len = Math.max(seq.size, other.size)
      (seq.padTo(len,m.empty) zip other.padTo(len,m.empty)).map { t => 
        m.combine(t._1, t._2)
      }
    }
  }

  implicit class ArrayOps[T: Monoid](data: Array[T]) {
    import scala.reflect.ClassTag

    def +(other: Array[T])(implicit m: Monoid[T], ct: ClassTag[T]): Array[T] = {
      val len = Math.max(data.size, other.size)
      (data.padTo(len,m.empty) zip other.padTo(len,m.empty)).map { t => 
        m.combine(t._1, t._2)
      }
    }
  }
  import scala.jdk.CollectionConverters._
}
