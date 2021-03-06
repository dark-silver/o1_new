package o1.flappy

import o1._

object FlappyBugApp extends App {

  val scenery = {

    val sky    = rectangle(ViewWidth, ViewHeight,  LightBlue)
    val ground = rectangle(ViewWidth, GroundDepth, SandyBrown)
    val tree = {
      val trunk   = rectangle(30, 250, SaddleBrown)
      val foliage = circle(200, ForestGreen)
      trunk.onto(foliage, TopCenter, Center)
    }

    val rootedTree = tree.onto(ground, BottomCenter, new Pos(ViewWidth / 2, 30))
    sky.place(rootedTree, BottomLeft, BottomLeft)

  }

  val bugPic = Pic("ladybug.png")
//  def rockPic(obstacle: Obstacle) = circle(obstacle.radius * 2, Black)
//  discarded for Pic("obstacle.png")
  val game = new Game
  val gui = new View(game, "FlappyBug") {

    var background = scenery

    def makePic = {
      val obstaclePic = Pic("obstacle.png").scaleTo(game.obstacle.diameterOfObstacle)
      background.place(obstaclePic, game.obstacle.pos).place(bugPic, game.bug.pos)
    }
    override def onKeyDown(pressedKey: Key) = {
        if (pressedKey == Key.Space)
          game.activateBug()
    }
    override def onTick() = {
      game.timePasses()
      this.background = this.background.shiftLeft(2)
    }
    override def isDone = game.isLost

  }

  gui.start()

}