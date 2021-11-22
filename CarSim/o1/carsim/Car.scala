package o1.carsim
import o1.Pos


class Car(val fuelConsumption: Double, val tankSize: Double, private val initialFuel: Double, private val initialLocation: Pos) {

  private var currentLocation = initialLocation
  private var currentFuel = initialFuel
  private var totalMeters = 0.0

  def location: Pos = currentLocation

  def fuel(toBeAdded: Double): Double = {
    if(toBeAdded >= 0) {
      val beforeFuel = currentFuel
      if (toBeAdded + currentFuel >= tankSize) currentFuel = tankSize else currentFuel += toBeAdded
      currentFuel - beforeFuel
    } else 0
  }

  def fuel(): Double = {
    val beforeFuel = currentFuel
    currentFuel = tankSize
    currentFuel - beforeFuel
  }

  def fuelRatio: Double = (currentFuel*100.0)/tankSize

  def metersDriven: Double = totalMeters

  def fuelRange: Double = (currentFuel/fuelConsumption) * 100000.0

  def drive(destination: Pos, metersToDestination: Double): Unit = {

    if (metersToDestination <= fuelRange) {
      currentLocation = destination
      currentFuel -= (metersToDestination/100000) * fuelConsumption
      totalMeters += metersToDestination
    } else {
      val distanceRatio = fuelRange / metersToDestination
      var changeInPos = destination.subtract(currentLocation)
      changeInPos = changeInPos.multiply(distanceRatio)
      currentLocation = currentLocation.add(changeInPos)
      totalMeters += fuelRange
      currentFuel = 0.0
    }
  }

}

