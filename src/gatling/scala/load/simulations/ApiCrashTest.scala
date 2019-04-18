package load.simulations

import io.gatling.core.Predef._
import load.{BaseSimulation, Scenarios}

import scala.concurrent.duration._


class ApiCrashTest extends Simulation with BaseSimulation {
  setUp(
    Scenarios.s1.inject(
      rampUsersPerSec(1) to (5) during (10 second)
    )
  ).protocols(baseJson)
}