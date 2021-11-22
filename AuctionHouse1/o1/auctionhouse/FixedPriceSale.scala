package o1.auctionhouse

class FixedPriceSale(val description: String, val price: Int, duration: Int) {

  private var buyerOption: Option[String] = None
  private var remainingDays: Int = duration

  /** Records one day as having passed.
    * In practice, what this means is that the item becomes one day closer to expiring, unless it had already been bought in which case its state does not change. */
  def advanceOneDay(): Unit = if(isOpen) remainingDays -= 1

  /** Buys the item for the given customer. The sale now has a buyer (and is therefore no longer open).
    * This only works, however, if the sale was open to begin with. The method returns true if the item was successfully bought, false if the purchase failed. */
  def buy(buyer: String): Boolean = if(isOpen) {
    buyerOption = Some(buyer)
    true
  } else false

  /** Returns the buyer of the item, wrapped in an Option; None is returned if nobody has bought the item yet. */
  def buyer: Option[String] = if(isOpen) None else buyerOption

  /** Returns the number of days remaining until the sale expires, unless someone buys the item. */
  def daysLeft: Int = remainingDays

  /** Determines whether the sale has expired.  That is, determines whether the item is no longer available because time has run out.
    * Note that if the item is unavailable because it was bought, it has not "expired" in this sense and this method will return false.*/
  def isExpired: Boolean = remainingDays <= 0

  /** Determines if the sale is open, that is, if the item can still be bought.
    * A fixed-price sale is always open if nobody has yet bought the item and the sale has not yet expired. */
  def isOpen: Boolean = remainingDays > 0 && buyerOption.isEmpty

  /** Returns a textual description of the item. This text is the same as that returned by description. */
  override def toString(): String = description
}
