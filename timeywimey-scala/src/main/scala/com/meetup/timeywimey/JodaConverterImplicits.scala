package com.meetup.timeywimey

import com.meetup.timeywimey.JodaConverters._

/**
 * Implicits directly wrapping converter logic in java for syntactic sugar
 * Very little moving parts here, update `timeywimey-core` for changing logic.
 */
object JodaConverterImplicits {

  /**
    * Converts Joda-Time LocalDate to Java 8 equivalent.
    *
    * @param localDate Joda-Time LocalDate
    * @return Java 8 LocalDate
    */
  implicit class JodaToJavaLocalDate(localDate: org.joda.time.LocalDate) {
    def asJava: java.time.LocalDate = jodaToJavaLocalDate(localDate)
  }

  /**
    * Converts Java 8 LocalDate to Joda-Time equivalent.
    *
    * @param localDate Java 8 LocalDate
    * @return Joda-Time LocalDate
    */
  implicit class JavaToJodaLocalDate(localDate: java.time.LocalDate) {
    def asJoda: org.joda.time.LocalDate = javaToJodaLocalDate(localDate)
  }

  /**
    * Converts Joda-Time LocalTime to Java 8 equivalent.
    *
    * @param localTime Joda-Time LocalTime
    * @return Java 8 LocalTime
    */
  implicit class JodaToJavaLocalTime(localTime: org.joda.time.LocalTime) {
    def asJava: java.time.LocalTime = jodaToJavaLocalTime(localTime)
  }

  /**
    * Converts Java 8 LocalTime to Joda-Time equivalent.
    * <p>
    * This is a potentially lossy operation. Any time info below millis unit are deleted.
    *
    * @param localTime Java 8 LocalTime
    * @return Joda-Time LocalTime
    */
  implicit class JavaToJodaLocalTime(localTime: java.time.LocalTime) {
    def asJoda: org.joda.time.LocalTime = javaToJodaLocalTime(localTime)
  }

  /**
    * Converts Joda-Time LocalDateTime to Java 8 equivalent.
    *
    * @param localDateTime Joda-Time LocalDateTime
    * @return Java 8 LocalDateTime
    */
  implicit class JodaToJavaLocalDateTime(localDateTime: org.joda.time.LocalDateTime) {
    def asJava: java.time.LocalDateTime = jodaToJavaLocalDateTime(localDateTime)
  }

  /**
    * Converts Java 8 LocalDateTime to Joda-Time equivalent.
    * <p>
    * This is a potentially lossy operation. Any time info below millis unit are lost.
    *
    * @param localDateTime Java 8 LocalDateTime
    * @return Joda-Time LocalDateTime
    */
  implicit class JavaToJodaLocalDateTime(localDateTime: java.time.LocalDateTime) {
    def asJoda: org.joda.time.LocalDateTime = javaToJodaLocalDateTime(localDateTime)
  }

  /**
    * Converts Joda-Time MonthDay to Java 8 equivalent.
    *
    * @param monthDay Joda-Time MonthDay
    * @return Java 8 MonthDay
    */
  implicit class JodaToJavaMonthDay(monthDay: org.joda.time.MonthDay) {
    def asJava: java.time.MonthDay = jodaToJavaMonthDay(monthDay)
  }

  /**
    * Converts Java 8 MonthDay to Joda-Time equivalent.
    *
    * @param monthDay Java 8 MonthDay
    * @return Joda-Time MonthDay
    */
  implicit class JavaToJodaMonthDay(monthDay: java.time.MonthDay) {
    def asJoda: org.joda.time.MonthDay = javaToJodaMonthDay(monthDay)
  }

  /**
    * Converts Joda-Time YearMonth to Java 8 equivalent.
    *
    * @param yearMonth Joda-Time YearMonth
    * @return Java 8 YearMonth
    */
  implicit class JodaToJavaYearMonth(yearMonth: org.joda.time.YearMonth) {
    def asJava: java.time.YearMonth = jodaToJavaYearMonth(yearMonth)
  }

  /**
    * Converts Java 8 YearMonth to Joda-Time equivalent.
    *
    * @param yearMonth Java 8 YearMonth
    * @return Joda-Time YearMonth
    */
  implicit class JavaToJodaYearMonth(yearMonth: java.time.YearMonth) {
    def asJoda: org.joda.time.YearMonth = javaToJodaYearMonth(yearMonth)
  }

  /**
    * Converts Joda-Time DateTime to Java 8 equivalent.
    *
    * @param dateTime Joda-Time DateTime
    * @return Java 8 ZonedDateTime
    */
  implicit class JodaToJavaDateTime(dateTime: org.joda.time.DateTime) {
    def asJava: java.time.ZonedDateTime = jodaToJavaDateTime(dateTime)
  }

  /**
    * Converts Java 8 ZonedDateTime to Joda-Time equivalent.
    *
    * @param dateTime Java 8 ZonedDateTime
    * @return Joda-Time DateTime
    */
  implicit class JavaToJodaDateTime(dateTime: java.time.ZonedDateTime) {
    def asJoda: org.joda.time.DateTime = javaToJodaDateTime(dateTime)
  }

  /**
    * Converts Joda-Time Instant to Java 8 equivalent.
    *
    * @param instant Joda-Time Instant
    * @return Java 8 Instant
    */
  implicit class JodaToJavaInstant(instant: org.joda.time.Instant) {
    def asJava: java.time.Instant = jodaToJavaInstant(instant)
  }

  /**
    * Converts Java 8 Instant to Joda-Time equivalent.
    *
    * @param instant Java 8 Instant
    * @return Joda-Time Instant
    */
  implicit class JavaToJodaInstant(instant: java.time.Instant) {
    def asJoda: org.joda.time.Instant = javaToJodaInstant(instant)
  }

  /**
    * Converts Joda-Time DateTimeZone to Java 8 equivalent.
    *
    * @param timeZone Joda-Time DateTimeZone
    * @return Java 8 ZoneId
    */
  implicit class JodaToJavaTimeZone(timeZone: org.joda.time.DateTimeZone) {
    def asJava: java.time.ZoneId = jodaToJavaTimeZone(timeZone)
  }

  /**
    * Converts Java 8 ZoneId to Joda-Time equivalent.
    *
    * @param timeZone Java 8 ZoneId
    * @return Joda-Time DateTimeZone
    */
  implicit class JavaToJodaTimeZone(timeZone: java.time.ZoneId) {
    def asJoda: org.joda.time.DateTimeZone = javaToJodaTimeZone(timeZone)
  }

  /**
    * Converts Joda-Time Duration to Java 8 equivalent.
    *
    * @param duration Joda-Time Duration
    * @return Java 8 Duration
    */
  implicit class JodaToJavaDuration(duration: org.joda.time.Duration) {
    def asJava: java.time.Duration = jodaToJavaDuration(duration)
  }

  /**
    * Converts Java 8 Duration to Joda-Time equivalent.
    *
    * @param duration Java 8 Duration
    * @return Joda-Time Duration
    */
  implicit class JavaToJodaDuration(duration: java.time.Duration) {
    def asJoda: org.joda.time.Duration = javaToJodaDuration(duration)
  }

  /**
    * Converts Joda-Time Period to Java 8 equivalent.
    * <p>
    * This is a potentially lossy operation. Any time info below day unit are lost.
    *
    * @param period Joda-Time Period
    * @return Java 8 Period
    */
  implicit class JodaToJavaPeriod(period: org.joda.time.Period) {
    def asJava: java.time.Period = jodaToJavaPeriod(period)
  }

  /**
    * Converts Java 8 Period to Joda-Time equivalent.
    *
    * @param period Java 8 Period
    * @return Joda-Time Period
    */
  implicit class JavaToJodaPeriod(period: java.time.Period) {
    def asJoda: org.joda.time.Period = javaToJodaPeriod(period)
  }
}
