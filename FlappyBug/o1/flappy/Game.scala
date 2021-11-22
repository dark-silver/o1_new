package o1.flappy

import o1._

class Game {

  val bug = new Bug(Pos(100,40))
  val obstacle = new Obstacle(70)

  def activateBug(): Unit = {
    this.bug.flap(15)
  }
    def timePasses(): Unit = {
    this.bug.fall()
    this.obstacle.approach()
  }

  // Your code goes here. Please add only what is requested in the ebook. To avoid
  // confusing our automatic assessment system, please don’t invent additions of your own
  // here (at least not before you’re done with the ebook’s official FlappyBug assignments).

  def isLost: Boolean = this.obstacle.touches(this.bug) || !this.bug.isInBounds

}