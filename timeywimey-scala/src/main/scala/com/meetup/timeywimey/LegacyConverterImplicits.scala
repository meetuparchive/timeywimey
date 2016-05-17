package com.meetup.timeywimey

import java.sql.Timestamp
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Date

/** Implicits directly wrapping converter logic in java for syntactic sugar
  * Very little moving parts here, update `timeywimey-core` for changing logic.
  */
object LegacyConverterImplicits {
  implicit class DateToZonedDateTime(date: Date) {
    def toZonedDateTime: ZonedDateTime = LegacyConverters.toZonedDateTime(date)

    def toZonedDateTime(zoneId: ZoneId): ZonedDateTime = LegacyConverters.toZonedDateTime(date, zoneId)
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
