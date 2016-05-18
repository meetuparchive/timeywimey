package com.meetup.timeywimey

import java.sql.Timestamp
import java.time._
import java.util.Date

/** Implicits directly wrapping converter logic in java for syntactic sugar
  * Very little moving parts here, update `timeywimey-core` for changing logic.
  */
object LegacyConverterImplicits {
  implicit class DateToJava8(date: Date) {
    def toZonedDateTime: ZonedDateTime = LegacyConverters.toZonedDateTime(date)

    def toZonedDateTime(zoneId: ZoneId): ZonedDateTime = LegacyConverters.toZonedDateTime(date, zoneId)

    def toLocalDateTime: LocalDateTime = LegacyConverters.toLocalDateTime(date)

    def toLocalDate: LocalDate = LegacyConverters.toLocalDate(date)

    def toLocalTime: LocalTime = LegacyConverters.toLocalTime(date)
  }

  implicit class ZonedDateTimeToDateLike(dateTime: ZonedDateTime) {
    def toDate: Date = LegacyConverters.toDate(dateTime)

    def toTimestamp: Timestamp = LegacyConverters.toTimestamp(dateTime)
  }

  implicit class InstantToDateLike(instant: Instant) {
    def toDate: Date = LegacyConverters.toDate(instant)

    def toTimestamp: Timestamp = LegacyConverters.toTimestamp(instant)
  }
}
