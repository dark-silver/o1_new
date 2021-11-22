package o1.odds
import scala.util.Random

// This class is gradually developed between Chapters 2.4 and 3.4.

class Odds(val wont: Int, val will: Int) {

  def probability: Double = 1.0 * this.will / (this.wont + this.will)

  def fractional = s"$wont/$will"

  def decimal: Double = 1.0 + ((1.0 * this.wont) /(1.0 * this.will))

  def winnings(investment: Double): Double = investment * this.decimal

  def not = new Odds(this.will, this.wont)

  override def toString: String = fractional

  def both(anotherOdds: Odds) = new Odds(this.wont * anotherOdds.wont + this.wont * anotherOdds.will + this.will * anotherOdds.wont, this.will * anotherOdds.will)

  def either(anotherOdds: Odds) = new Odds(this.wont * anotherOdds.wont, this.wont * anotherOdds.will + this.will * anotherOdds.wont + this.will * anotherOdds.will)

  def isLikely: Boolean = this.will > this.wont

  def isLikelierThan(otherEvent: Odds): Boolean =  this.probability > otherEvent.probability

  def moneyline: Int =
    if (this.probability <= 0.5) {
      100 * this.wont / this.will
    } else {
      -100 * this.will / this.wont
    }
}