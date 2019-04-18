package load

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Scenarios {

  val s1 = scenario("Test GET request scenario")
      .exec(
        http("Google Main").get("/")
      )
}
