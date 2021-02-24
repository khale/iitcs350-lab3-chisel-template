// See README.md for license details.

package simple

import org.scalatest._
import chiseltest._
import chisel3._

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * testOnly simple.SimpleTester
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'testOnly simple.SimpleTester'
  * }}}
  */
class SimpleTester extends FlatSpec with ChiselScalatestTester with Matchers {
  behavior of "Simple"
  it should "produce correct values for all combinations of inputs" in {
    test(new Simple()) { c => 
      for (i <- 0 to 1) {
        for (j <- 0 to 1) {
          for (k <- 0 to 1) {
            println(s"A: $i B: $j EN: $k")
            c.io.a.poke(i.B)
            c.io.b.poke(j.B)
            c.io.en.poke(k.B)
            val expected = k & ((~i & j) | (i & ~j))
            println(s"Expected: $expected Yours: ${c.io.out.peek()}")
            c.io.out.expect(expected.B)
            println("SUCCESS!")
          }
        }
      }
    }
  }
}
