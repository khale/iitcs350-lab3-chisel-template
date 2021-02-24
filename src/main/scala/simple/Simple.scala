package simple

import chisel3._

/**
  * Implements a simple, one-bit combinational circuit for 
  *  EN & ((~A AND B) OR (A AND ~B))
  */
class Simple extends Module {
  val io = IO(new Bundle {
    val a   = Input(Bool())
    val b   = Input(Bool())
    val en  = Input(Bool())
    val out = Output(Bool())
  })

  // TODO: FILL ME IN!
}
