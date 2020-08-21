package com.murraywilliams.implicits



object GeneralSeqAddition {
  
  implicit class SeqOps[T: Numeric](data: Seq[T]) {
    def +(other: Seq[T])(implicit n: Numeric[T]): Seq[T] = {
      val len = Math.max(data.length, other.length)
      (data.padTo(len,n.zero) zip other.padTo(len,n.zero)).map { t =>
        n.plus(t._1, t._2)
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
  }

}
