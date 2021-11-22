package o1.flappy

import o1._

class Bug(private var position: Pos) {

  val radius = 15
  private var yVelocity = 0.0

  def fall() = {
    if (this.position.y < 350)
      yVelocity = yVelocity + 2.0
    move(yVelocity)
  }

  def flap(height: Double) = {
    yVelocity = -1.0*height
  }

  def isInBounds: Boolean = this.position.y < 350 && this.position.y > 0

  def pos = this.position

  def move(distance: Double) = {
    this.position = this.position.addY(distance).clampY(0, 350)
  }

  override def toString = s"center at (${this.pos.x},${this.pos.y}), radius $radius"

}
