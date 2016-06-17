package com.meetup.timeywimey

import java.sql.Timestamp
import java.time._
import java.util.Date

/**
 * Implicits directly wrapping converter logic in java for syntactic sugar
 * Very little moving parts here, update `timeywimey-core` for changing logic.
 */
object LegacyConverterImplicits {
  implicit class DateToJava8(date: Date) {
    /**
      * Converts legacy java.util.Date (or java.sql.Timestamp) class to ZonedDateTime with system default timezone
      * @return a ZonedDateTime object with equivalent epoch millis and system default timezone
      */
    def toZonedDateTime: ZonedDateTime = LegacyConverters.toZonedDateTime(date)

    /**
      * Converts legacy java.util.Date (or java.sql.Timestamp) class to ZonedDateTime with given timezone
      * @param zoneId a timezone to apply
      * @return a ZonedDateTime object with equivalent epoch millis and given timezone
      */
    def toZonedDateTime(zoneId: ZoneId): ZonedDateTime = LegacyConverters.toZonedDateTime(date, zoneId)

    /**
      * Converts legacy java.util.Date (or java.sql.Timestamp) class to LocalDateTime
      * @return a LocalDateTime object
      */
    def toLocalDateTime: LocalDateTime = LegacyConverters.toLocalDateTime(date)

    /**
      * Converts legacy java.util.Date (or java.sql.Timestamp) class to LocalDate
      * @return a LocalDate object
      */
    def toLocalDate: LocalDate = LegacyConverters.toLocalDate(date)

    /**
      * Converts legacy java.util.Date (or java.sql.Timestamp) class to LocalTime
      * @return a LocalTime object
      */
    def toLocalTime: LocalTime = LegacyConverters.toLocalTime(date)

    /**
      * Converts legacy java.util.Date (or java.sql.Timestamp) class to YearMonth
      * @return a YearMonth object
      */
    def toYearMonth: YearMonth = LegacyConverters.toYearMonth(date)

    /**
      * Converts legacy java.util.Date (or java.sql.Timestamp) class to MonthDay
      * @return a MonthDay object
      */
    def toMonthDay: MonthDay = LegacyConverters.toMonthDay(date)
  }

  implicit class ZonedDateTimeToDateLike(dateTime: ZonedDateTime) {
    /**
      * Converts ZonedDateTime into Date
      * @return a Date object with equivalent epoch millis
      */
    def toDate: Date = LegacyConverters.toDate(dateTime)

    /**
      * Converts ZonedDateTime into Date
      * @return a Date object with equivalent epoch millis
      */
    def toTimestamp: Timestamp = LegacyConverters.toTimestamp(dateTime)
  }

  implicit class InstantToDateLike(instant: Instant) {
    /**
      * Converts ZonedDateTime into java.sql.Timestamp
      * @return a Timestamp object with equivalent epoch millis
      */
    def toDate: Date = LegacyConverters.toDate(instant)

    /**
      * Converts ZonedDateTime into java.sql.Timestamp
      * @return a Timestamp object with equivalent epoch millis
      */
    def toTimestamp: Timestamp = LegacyConverters.toTimestamp(instant)
  }
}
