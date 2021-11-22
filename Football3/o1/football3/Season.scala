package o1.football3

import scala.collection.mutable.Buffer
import scala.math.abs

class Season() {

  private val season = Buffer[Match]() //container: matches are added here
  private var biggest: Option[Match] = None

  /** Adds a match result to the season. The match is assumed to have finished, so no further goals will be added to it later. */
  def addResult(newResult: Match): Unit = {
    season += newResult
    this.biggest match {
      case None =>
        this.biggest = Some(newResult)
      case Some(oldResult) =>
        val newBiggest = newResult.chooseBetter(oldResult)
        this.biggest = Some(newBiggest)
    }
  }

  /** Returns the match whose margin of victory was higher than that of any other match in the season.
    * If there is a tie for the biggest win, returns the match that was added to the season first. */
  def biggestWin: Option[Match] = biggest

  /** Returns the match most recently added to this season. */
  def latestMatch: Option[Match] = this.matchNumber(numberOfMatches - 1)

  /** Returns a match played in this season. */
  def matchNumber(number: Int): Option[Match] = season.lift(number)

  /** Returns the number of matches played in the season so far. */
  def numberOfMatches: Int = season.length


}