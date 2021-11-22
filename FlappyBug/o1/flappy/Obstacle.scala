package o1.flappy

import o1._
import scala.util.Random

// This class is introduced in Chapter 2.6.

class Obstacle(val radius: Int) {

  private var currentPos = randomLaunchPosition()
  val diameterOfObstacle = this.radius*2

  def pos = this.currentPos

  private def randomLaunchPosition() = {
    val launchX = ViewWidth + this.radius + Random.nextInt(500)
    val launchY = Random.nextInt(400)
    new Pos(launchX, launchY)
  }

  def approach() = {
    if (isActive) {
      this.currentPos = this.currentPos.addX(-ObstacleSpeed)
    } else {
      this.currentPos = randomLaunchPosition()
    }
  }

  def touches(bug: Bug) = bug.pos.distance(this.pos) < (this.radius + bug.radius)

  def isActive = (this.currentPos.x > -1*this.radius) || (this.currentPos.x == -1*this.radius)

  /*An effect-free method isActive in class Obstacle. This method takes no parameters.
  It returns true if the obstacle’s right edge is located to the right of the screen’s left edge,
  or if it’s exactly at the screen’s left edge. Otherwise, the method returns false.*/

  override def toString = "center at " + this.pos + ", radius " + this.radius
}
