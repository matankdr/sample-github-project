package com.github.matankdr.example

import org.scalatest._

class CalculatorSpec extends FlatSpec with MustMatchers{
  "Calculator" should "add 2 numbers correctly" in {
    Calculator.add(2, 3) must be (5)
  }
}
