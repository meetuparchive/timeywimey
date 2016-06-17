package com.meetup.timeywimey

import java.sql.Timestamp
import java.time._
import java.util.Calendar
import java.util.Date
import org.scalatest._
import LegacyConverterImplicits._

class LegacyConverterImplicitsTest extends FunSpec with Matchers {
  describe("JodaConverterImplicits") {
    it("should convert Date to ZonedDateTime") {
      val epochMillis = 31415926535L
      val tz = "Africa/Nairobi"
      val tzId = ZoneId.of(tz)
      val date = new Date(epochMillis)
      val zdt = date.toZonedDateTime(tzId)
      date.getTime should equal(zdt.toInstant.toEpochMilli)
    }
  }
}
