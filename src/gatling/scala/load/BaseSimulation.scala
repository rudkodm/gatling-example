package load

import io.gatling.core.Predef._
import io.gatling.http.Predef._

trait BaseSimulation {
  val url = sys.env.getOrElse(
  	"BASE_URL",
    throw new RuntimeException("Please specify BASE_URL environment variable")
  )

  val baseJson = http
  .baseURL(url)
  .header("Content-Type", "application/json")
}
