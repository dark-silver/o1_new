package o1.football2

import scala.collection.mutable.Buffer

/** The class `Match` represents match results in a football match statistics program.
  * A match is played between teams from two clubs: a home club and an away club.
  * Goals scored by players of either team can be added to the match object with the
  * method `addGoal`.
  *
  * The class is expected to be used so that a match object with no goals is initially
  * created as a real-life match starts. Goals are added incrementally as the match
  * progresses. (A match object has mutable state.)
  *
  * @param home  the club whose team plays at home in the match
  * @param away  the club whose team plays away in the match */
class Match(val home: Club, val away: Club) {

  private val homeScorers = Buffer[Player]()    // container: goalscorers of the home team are added here
  private val awayScorers = Buffer[Player]()    // container: goalscorers of the away team are added here

  /** Returns the number of goals that have been scored (so far) by the home team. */
  def homeGoals: Int = homeScorers.length


  /** Returns the number of goals that have been scored (so far) by the away team. */
  def awayGoals: Int = awayScorers.length

  /** Returns the goal difference of the match. The sign of the number indicates which team scored more goals. */
  def goalDifference = {
    homeScorers.length - awayScorers.length
  }

  /** Returns a boolean value indicating whether the given player scored in this match. */
  def hasScorer(possibleScorer: Player): Boolean = {
    homeScorers.contains(possibleScorer) || awayScorers.contains(possibleScorer)
  }

  /** Returns a vector that contains all the players who scored in the match. */
  def allScorers: Vector[Player] = homeScorers.toVector ++ awayScorers.toVector

  /** Returns a boolean value indicating whether the home team won (or would win if the match ended with the current score). */
  def isHomeWin: Boolean = goalDifference > 0

  /** Returns a boolean value indicating whether the away team won (or would win if the match ended with the current score). */
  def isAwayWin: Boolean = goalDifference < 0

  /** Determines whether this match is entirely goalless, that is, whether neither team has scored a single goal. */
  def isGoalless: Boolean = (goalDifference == 0) && homeScorers.isEmpty

  /** Determines whether this match has a higher total score than another given match.
    * @return `true` if more goals were scored in total in this match than in the given match, `false` otherwise */
  def isHigherScoringThan(anotherMatch: Match) = this.totalGoals > anotherMatch.totalGoals

  /** Returns a boolean value indicating whether the game ended in a draw (or would do so if the match ended with the current score). */
  def isTied: Boolean = (goalDifference == 0)

  /** Returns the name of the stadium where the match is played. */
  def location: String = home.stadium

  /** Returns the total number of goals scored by the two teams. */
  def totalGoals: Int = homeScorers.length + awayScorers.length

  def winnerName = {
    if (this.goalDifference < 0)
      this.away.name
    else if (this.goalDifference > 0)
      this.home.name
    else
      "no winner"
  }

  /** Returns the name of the player who scored the so-called "winning goal". */
  def winningScorerName: String = {
    if(isHomeWin) {
      homeScorers(homeScorers.length - goalDifference).name
    } else if(isAwayWin) {
      awayScorers(awayScorers.length + goalDifference).name
    } else "no winning goal"
  }

  /** Records a goal as having been scored by the given player. The goal is recorded for the player's own team; no own goals. */
  def addGoal(scorer: Player): Unit = {
    if (scorer.employer == this.home) {
      this.homeScorers += scorer
    } else if (scorer.employer == this.away) {
      this.awayScorers += scorer
    }
  }

  /**  Produces a textual description of the match's current state */
  override def toString = {
    home.name + " vs. " + away.name + " at " + home.stadium + ": " + {
      if (isTied) {
        "tied at " + (if (isGoalless) "nil-nil" else s"${homeGoals}-all")
      } else {
        if (isHomeWin) s"$homeGoals-$awayGoals to ${home.name}" else s"$awayGoals-$homeGoals to ${away.name}"
      }
    }
  }



}


