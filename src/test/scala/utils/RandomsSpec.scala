package utils

import java.time.LocalDate

import org.scalatest._

class RandomsSpec extends FlatSpec with Matchers {
  import Randoms._

  "randomDate" should "return data in a range" in {
    val date_from = LocalDate.of(2018, 9, 1)
    val date_to = LocalDate.of(2018, 10, 1)
    val date = randomDateBetween(date_from, date_to)
    assert((date isAfter date_from) || (date isEqual date_from), s"$date should be after $date_from")
    assert((date isBefore date_to) || (date isEqual date_to), s"$date should be before $date_to")
  }

  "DateExt" should "implicitly format LocalDate class" in {
    val actual = date(2018, 9, 1).formatAs("YYYY-MM-dd")
    assertResult("2018-09-01")(actual)
  }

  "randomValueFromDomain" should "Return random value from specified domain in values" in {
    val domain = Set("a", "b", "c", "d")
    val randomLetter = randomValueFromDomain(domain)
      assert(domain.contains(randomLetter()))
  }

  it should "trow exception if empty domain passed" in {
    val domain = Set[String]()
    intercept[Exception] {
      randomValueFromDomain(domain)
    }

  }
}
