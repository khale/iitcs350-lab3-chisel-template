package adder

import org.scalatest._
import chiseltest._
import chisel3._

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * testOnly adder.AdderTester
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'testOnly adder.AdderTester'
  * }}}
  */
class AdderTester extends FlatSpec with ChiselScalatestTester with Matchers {
  behavior of "Adder"
  it should "produce correct values for all combinations of inputs" in {
    test(new FullAdder()) { c => 
      for (i <- 0 to 1) {
        for (j <- 0 to 1) {
          for (k <- 0 to 1) {
            for (l <- 0 to 1) {
              println(s"A: $i B: $j EN: $k C_in: $l")
              c.io.in_a.poke(i.U)
              c.io.in_b.poke(j.U)
              c.io.en.poke(k.B)
              c.io.c_in.poke(l.U)
              val sum = k & ((i ^ j) ^ l)
              val carry = k & ((i & j) | (l & (i ^ j)))
              c.io.sum.expect(sum.B)
              c.io.c_out.expect(carry.B)
            }
          }
        }
      }
    }
  }
}
