package o1.people

class Passenger(val name: String, val card: Option[TravelCard]) {

  /** Determines whether a valid travel card is associated with the person or not. */
  def canTravel: Boolean = hasCard && card.get.isValid

  /** Determines whether the person is associated with a travel card or not. */
  def hasCard: Boolean = card.isDefined
}
