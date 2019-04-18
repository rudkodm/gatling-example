package utils

import java.time.LocalDate
import java.time.temporal.ChronoUnit.DAYS
import java.time.format.DateTimeFormatter
import scala.util.Random._

import scala.util.Random

object Randoms {

  implicit def date(y:Int, m: Int, d: Int) = LocalDate.of(y,m,d)

  implicit class DateExt(date: LocalDate) {
    def formatAs(pattern: String) = {
      val formatter = DateTimeFormatter.ofPattern(pattern)
      date.format(formatter)
    }
  }

  def randomDateBetween(from: LocalDate, to: LocalDate): LocalDate = {
    val diff = DAYS.between(from, to)
    val random = new Random(System.nanoTime)
    from.plusDays(random.nextInt(diff.toInt))
  }


  def randomValueFromDomain(domain: Set[String]): () => String = {
    if (domain.isEmpty) throw new IllegalArgumentException("Domain should not be empty")
    () => domain.toSeq(nextInt(domain.size))
  }

}
