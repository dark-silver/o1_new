package o1.blood


class BloodType(val abo: String, val rhesus: Boolean) {


  override def toString = s"$abo${if (rhesus) "+" else "-"}"


  def hasSafeABOFor(recipient: BloodType):Boolean = {
    if (this.abo == "O") {true}
    else if (this.abo == "A" && (recipient.abo=="A"||recipient.abo=="AB")) {true}
    else if (this.abo == "B" && (recipient.abo=="B"||recipient.abo=="AB")) {true}
    else if (this.abo == "AB" && recipient.abo=="AB") {true}
    else false
  }

  def hasSafeRhesusFor(recipient: BloodType): Boolean = {
    if ((!this.rhesus) || (this.rhesus == recipient.rhesus)) {true} else false
  }


  def canDonateTo(recipient: BloodType): Boolean = if (this.hasSafeRhesusFor(recipient)&&this.hasSafeABOFor(recipient)) {true} else false

  def canReceiveFrom(donor: BloodType): Boolean = if (donor.hasSafeRhesusFor(this)&&donor.hasSafeABOFor(this)) {true} else false

}
