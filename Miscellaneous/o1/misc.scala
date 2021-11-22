package o1
object misc { // These definitions at the top are discussed in Chapter 5.2.

  // Various small assignments across several chapters will ask you to define functions in this file.
  // Please enter your code below this comment.

  def isPortrait(picture: Pic): Boolean = picture.height > picture.width

  def together(melodies: Vector[String], tempo: Int): String = melodies.mkString("&") + "/" + tempo





  def isInOrder(pairOfNumbers: (Int, Int)): Boolean = pairOfNumbers._1 <= pairOfNumbers._2    // This example function is introduced in Chapter 8.4. You can ignore it until then.

}