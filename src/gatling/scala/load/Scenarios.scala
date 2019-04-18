package load

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import load.Feeders.random

object Scenarios {

  val s1 = scenario("Test GET request scenario")
      .exec(
        http("Some Resource Name").get("/some/url/here")
      )
}
