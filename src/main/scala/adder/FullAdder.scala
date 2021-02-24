package adder
import chisel3._

/**
  * Implements a 1-bit full adder
  *  
  */
class FullAdder extends Module {
  val io = IO(new Bundle {
    val in_a  = Input(UInt(1.W))
    val in_b  = Input(UInt(1.W))
    val c_in  = Input(UInt(1.W))
    val en    = Input(Bool())
    val sum   = Output(UInt(1.W))
    val c_out = Output(UInt(1.W))
  })

  // TODO: FILL ME IN!
}
