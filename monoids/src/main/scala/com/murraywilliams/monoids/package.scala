package com.murraywilliams

package object monoids {
  
  @inline def square[T: Numeric](x: T)(implicit n: Numeric[T]): T = n.times(x,x)

}
