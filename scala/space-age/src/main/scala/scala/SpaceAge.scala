package scala

object SpaceAge {
    private val earthYearSeconds: Double = 60 * 60 * 24 * 365.25
    private val mercuryYearSeconds: Double = earthYearSeconds * 0.2408467
    private val venusYearSeconds: Double = earthYearSeconds * 0.61519726
    private val marsYearSeconds: Double = earthYearSeconds * 1.8808158
    private val jupiterYearSeconds: Double = earthYearSeconds * 11.862615
    private val saturnYearSeconds: Double = earthYearSeconds * 29.447498
    private val uranusYearSeconds: Double = earthYearSeconds * 84.016846
    private val neptuneYearSeconds: Double = earthYearSeconds * 164.79132

    def onEarth(ageInSeconds: Double): Double = toPlanetYears(ageInSeconds, earthYearSeconds)
    def onMercury(ageInSeconds: Double): Double = toPlanetYears(ageInSeconds, mercuryYearSeconds)
    def onVenus(ageInSeconds: Double): Double = toPlanetYears(ageInSeconds, venusYearSeconds)
    def onMars(ageInSeconds: Double): Double = toPlanetYears(ageInSeconds, marsYearSeconds)
    def onJupiter(ageInSeconds: Double): Double = toPlanetYears(ageInSeconds, jupiterYearSeconds)
    def onSaturn(ageInSeconds: Double): Double = toPlanetYears(ageInSeconds, saturnYearSeconds)
    def onUranus(ageInSeconds: Double): Double = toPlanetYears(ageInSeconds, uranusYearSeconds)
    def onNeptune(ageInSeconds: Double): Double = toPlanetYears(ageInSeconds, neptuneYearSeconds)

    private def toPlanetYears(seconds: Double, planetYearSeconds: Double): Double = {
        toTwoDecimalPlaces(seconds / planetYearSeconds)
    }

    private def toTwoDecimalPlaces(double: Double) = {
        Math.round(double * 100).toDouble / 100
    }

}
