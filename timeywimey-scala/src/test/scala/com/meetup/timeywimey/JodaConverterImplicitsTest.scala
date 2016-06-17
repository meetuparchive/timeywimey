package com.meetup.timeywimey

import org.scalatest._
import JodaConverterImplicits._

class JodaConverterImplicitsTest extends FunSpec with Matchers {
  describe("JodaConverterImplicits") {
    it("should convert LocalDate") {
      val year = 2000
      val month = 3
      val day = 14
      val javaLocalDate = java.time.LocalDate.of(year, month, day)

      val jodaLocalDate = javaLocalDate.asJoda
      jodaLocalDate.getYear should equal(year)
      jodaLocalDate.getMonthOfYear should equal(month)
      jodaLocalDate.getDayOfMonth should equal(day)

      val newJavaLocalDate = jodaLocalDate.asJava
      newJavaLocalDate.getYear should equal(year)
      newJavaLocalDate.getMonthValue should equal(month)
      newJavaLocalDate.getDayOfMonth should equal(day)
    }
  }

  it("should convert LocalTime") {
    val hour = 11
    val minute = 22
    val second = 33
    val millis = 44
    val nano = millis * 1000000
    val javaLocalTime = java.time.LocalTime.of(hour, minute, second, nano)

    val jodaLocalTime = javaLocalTime.asJoda
    jodaLocalTime.getHourOfDay should equal(hour)
    jodaLocalTime.getMinuteOfHour should equal(minute)
    jodaLocalTime.getSecondOfMinute should equal(second)
    jodaLocalTime.getMillisOfSecond should equal(millis)

    val newJavaLocalTime = jodaLocalTime.asJava
    newJavaLocalTime.getHour should equal(hour)
    newJavaLocalTime.getMinute should equal(minute)
    newJavaLocalTime.getSecond should equal(second)
    newJavaLocalTime.getNano should equal(nano)
  }

  it("should convert LocalDateTime") {
    val year = 2000
    val month = 3
    val day = 14
    val hour = 11
    val minute = 22
    val second = 33
    val millis = 44
    val nano = millis * 1000000
    val javaLocalDateTime = java.time.LocalDateTime.of(year, month, day, hour, minute, second, nano)

    val jodaLocalDateTime = javaLocalDateTime.asJoda
    jodaLocalDateTime.getYear should equal(year)
    jodaLocalDateTime.getMonthOfYear should equal(month)
    jodaLocalDateTime.getDayOfMonth should equal(day)
    jodaLocalDateTime.getHourOfDay should equal(hour)
    jodaLocalDateTime.getMinuteOfHour should equal(minute)
    jodaLocalDateTime.getSecondOfMinute should equal(second)
    jodaLocalDateTime.getMillisOfSecond should equal(millis)

    val newJavaLocalDateTime = jodaLocalDateTime.asJava
    newJavaLocalDateTime.getYear should equal(year)
    newJavaLocalDateTime.getMonthValue should equal(month)
    newJavaLocalDateTime.getDayOfMonth should equal(day)
    newJavaLocalDateTime.getHour should equal(hour)
    newJavaLocalDateTime.getMinute should equal(minute)
    newJavaLocalDateTime.getSecond should equal(second)
    newJavaLocalDateTime.getNano should equal(nano)
  }

  it("should convert MonthDay") {
    val month = 3
    val day = 14
    val javaMonthDay = java.time.MonthDay.of(month, day)

    val jodaMonthDay = javaMonthDay.asJoda
    jodaMonthDay.getMonthOfYear should equal(month)
    jodaMonthDay.getDayOfMonth should equal(day)

    val newJavaMonthDay = jodaMonthDay.asJava
    newJavaMonthDay.getMonthValue should equal(month)
    newJavaMonthDay.getDayOfMonth should equal(day)
  }

  it("should convert YearMonth") {
    val year = 2000
    val month = 3
    val javaYearMonth = java.time.YearMonth.of(year, month)

    val jodaYearMonth = javaYearMonth.asJoda
    jodaYearMonth.getYear should equal(year)
    jodaYearMonth.getMonthOfYear should equal(month)

    val newJavaYearMonth = jodaYearMonth.asJava
    newJavaYearMonth.getYear should equal(year)
    newJavaYearMonth.getMonthValue should equal(month)
  }

  it("should convert ZonedDateTime and DateTime") {
    val year = 2000
    val month = 3
    val day = 14
    val hour = 11
    val minute = 22
    val second = 33
    val millis = 44
    val nano = millis * 1000000
    val tz = "Africa/Nairobi"
    val tzId = java.time.ZoneId.of(tz)
    val javaDateTime = java.time.ZonedDateTime.of(year, month, day, hour, minute, second, nano, tzId)

    val jodaDateTime = javaDateTime.asJoda
    jodaDateTime.getYear should equal(year)
    jodaDateTime.getMonthOfYear should equal(month)
    jodaDateTime.getDayOfMonth should equal(day)
    jodaDateTime.getHourOfDay should equal(hour)
    jodaDateTime.getMinuteOfHour should equal(minute)
    jodaDateTime.getSecondOfMinute should equal(second)
    jodaDateTime.getMillisOfSecond should equal(millis)
    jodaDateTime.getZone.getID should equal(tz)

    val newJavaDateTime = jodaDateTime.asJava
    newJavaDateTime.getYear should equal(year)
    newJavaDateTime.getMonthValue should equal(month)
    newJavaDateTime.getDayOfMonth should equal(day)
    newJavaDateTime.getHour should equal(hour)
    newJavaDateTime.getMinute should equal(minute)
    newJavaDateTime.getSecond should equal(second)
    newJavaDateTime.getNano should equal(nano)
    newJavaDateTime.getZone.getId should equal(tz)
  }

  it("should convert Instant") {
    val epochMillis = 3141592L
    val javaInstant = java.time.Instant.ofEpochMilli(epochMillis)

    val jodaInstant = javaInstant.asJoda
    jodaInstant.getMillis should equal(epochMillis)

    val newJavaInstant = jodaInstant.asJava
    newJavaInstant.toEpochMilli should equal(epochMillis)
  }

  it("should convert ZoneId and DateTimeZone") {
    val tz = "Africa/Nairobi"
    val javaTimeZone = java.time.ZoneId.of(tz)

    val jodaTimeZone = javaTimeZone.asJoda
    jodaTimeZone.getID should equal(tz)

    val newJavaTimeZone = jodaTimeZone.asJava
    newJavaTimeZone.getId should equal(tz)
  }

  it("should convert Duration") {
    val durationMillis = 3141592L
    val javaDuration = java.time.Duration.ofMillis(durationMillis)

    val jodaDuration = javaDuration.asJoda
    jodaDuration.getMillis should equal(durationMillis)

    val newJavaDuration = jodaDuration.asJava
    newJavaDuration.toMillis should equal(durationMillis)
  }
}
