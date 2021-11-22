package o1.odds

// This program is developed in Chapters 2.7 and 3.4.
// It creates a single Odds object and uses some of its methods.

import scala.io.StdIn._

object OddsTest1 extends App {

  println("Please enter the odds of an event as two integers on separate lines.")
  println("For instance, to enter the odds 5/1 (one in six chance of happening), write 5 and 1 on separate lines.")
  val firstInput = readInt()
  val secondInput = readInt()

  val odds = new Odds(firstInput, secondInput)

  println("The odds you entered are:")
  println(s"In fractional format: ${odds.fractional}")
  println(s"In decimal format: ${odds.decimal}")
  println(s"In moneyline format: ${odds.moneyline}")
  println(s"Event probability: ${odds.probability}")
  println(s"Reverse odds: ${odds.not}")
  println(s"Odds of happening twice: ${odds.both(odds)}")

  println("Please enter the size of a bet:")
  val thirdInput = readDouble()
  println(s"If successful, the bettor would claim ${odds.winnings(thirdInput)}")

  println("Please enter the odds of a second event as two integers on separate lines.")
  val fourthInput = readInt()
  val fifthInput = readInt()
  val anotherOdds = new Odds(fourthInput, fifthInput)

  println(s"The odds of both events happening are: ${odds.both(anotherOdds)}")
  println(s"The odds of one or both happening are: ${odds.either(anotherOdds)}")
}