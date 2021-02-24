all: test-simple test-adder


test-simple: src/main/scala/simple/Simple.scala
	sbt 'testOnly simple.SimpleTester'

	
test-adder: src/main/scala/adder/FullAdder.scala
	sbt 'testOnly adder.AdderTester'
