package com.meetup.timeywimey

import com.meetup.timeywimey.JodaConverters._

/**
 * Implicits directly wrapping converter logic in java for syntactic sugar
 * Very little moving parts here, update `timeywimey-core` for changing logic.
 */
object JodaConverterImplicits {
  implicit class JodaToJavaLocalDate(localDate: org.joda.time.LocalDate) {
    def asJava: java.time.LocalDate = jodaToJavaLocalDate(localDate)
  }

  implicit class JavaToJodaLocalDate(localDate: java.time.LocalDate) {
    def asJoda: org.joda.time.LocalDate = javaToJodaLocalDate(localDate)
  }

  implicit class JodaToJavaLocalTime(localTime: org.joda.time.LocalTime) {
    def asJava: java.time.LocalTime = jodaToJavaLocalTime(localTime)
  }

  implicit class JavaToJodaLocalTime(localTime: java.time.LocalTime) {
    def asJoda: org.joda.time.LocalTime = javaToJodaLocalTime(localTime)
  }

  implicit class JodaToJavaLocalDateTime(localDateTime: org.joda.time.LocalDateTime) {
    def asJava: java.time.LocalDateTime = jodaToJavaLocalDateTime(localDateTime)
  }

  implicit class JavaToJodaLocalDateTime(localDateTime: java.time.LocalDateTime) {
    def asJoda: org.joda.time.LocalDateTime = javaToJodaLocalDateTime(localDateTime)
  }

  implicit class JodaToJavaMonthDay(monthDay: org.joda.time.MonthDay) {
    def asJava: java.time.MonthDay = jodaToJavaMonthDay(monthDay)
  }

  implicit class JavaToJodaMonthDay(monthDay: java.time.MonthDay) {
    def asJoda: org.joda.time.MonthDay = javaToJodaMonthDay(monthDay)
  }

  implicit class JodaToJavaYearMonth(yearMonth: org.joda.time.YearMonth) {
    def asJava: java.time.YearMonth = jodaToJavaYearMonth(yearMonth)
  }

  implicit class JavaToJodaYearMonth(yearMonth: java.time.YearMonth) {
    def asJoda: org.joda.time.YearMonth = javaToJodaYearMonth(yearMonth)
  }

  implicit class JodaToJavaDateTime(dateTime: org.joda.time.DateTime) {
    def asJava: java.time.ZonedDateTime = jodaToJavaDateTime(dateTime)
  }

  implicit class JavaToJodaDateTime(dateTime: java.time.ZonedDateTime) {
    def asJoda: org.joda.time.DateTime = javaToJodaDateTime(dateTime)
  }

  implicit class JodaToJavaInstant(instant: org.joda.time.Instant) {
    def asJava: java.time.Instant = jodaToJavaInstant(instant)
  }

  implicit class JavaToJodaInstant(instant: java.time.Instant) {
    def asJoda: org.joda.time.Instant = javaToJodaInstant(instant)
  }

  implicit class JodaToJavaTimeZone(timeZone: org.joda.time.DateTimeZone) {
    def asJava: java.time.ZoneId = jodaToJavaTimeZone(timeZone)
  }

  implicit class JavaToJodaTimeZone(timeZone: java.time.ZoneId) {
    def asJoda: org.joda.time.DateTimeZone = javaToJodaTimeZone(timeZone)
  }

  implicit class JodaToJavaDuration(duration: org.joda.time.Duration) {
    def asJava: java.time.Duration = jodaToJavaDuration(duration)
  }

  implicit class JavaToJodaDuration(duration: java.time.Duration) {
    def asJoda: org.joda.time.Duration = javaToJodaDuration(duration)
  }

  implicit class JodaToJavaPeriod(period: org.joda.time.Period) {
    def asJava: java.time.Period = jodaToJavaPeriod(period)
  }

  implicit class JavaToJodaPeriod(Period: java.time.Period) {
    def asJoda: org.joda.time.Period = javaToJodaPeriod(Period)
  }
}
