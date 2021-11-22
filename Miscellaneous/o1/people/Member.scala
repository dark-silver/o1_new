package o1.people

class Member(val id: Int, val name: String, val yearOfBirth: Int, val yearOfDeath: Option[Int]) {

  /** Returns a boolean value indicating whether the member is alive or not.
    * That is, returns true if the member does not have a year of death,* and false if they do. */

  def isAlive: Boolean = yearOfDeath.isEmpty

  /** Returns a compact string description of the member. The description of a dead person has the form "Name(YoB-YoD)" */

  override def toString: String = s"$name($yearOfBirth-${yearOfDeath.getOrElse("")})"

}
