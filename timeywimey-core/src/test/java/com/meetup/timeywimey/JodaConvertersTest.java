package com.meetup.timeywimey;

import static org.junit.Assert.*;
import org.junit.Test;

import static com.meetup.timeywimey.JodaConverters.*;

public class JodaConvertersTest {
	@Test
	public void localDateTest() {
		int year = 2000;
		int month = 3;
		int day = 14;
		java.time.LocalDate javaLocalDate = java.time.LocalDate.of( year, month, day );

		org.joda.time.LocalDate jodaLocalDate = javaToJodaLocalDate( javaLocalDate );
		assertEquals( jodaLocalDate.getYear(), year );
		assertEquals( jodaLocalDate.getMonthOfYear(), month );
		assertEquals( jodaLocalDate.getDayOfMonth(), day );

		java.time.LocalDate newJavaLocalDate = jodaToJavaLocalDate( jodaLocalDate );
		assertEquals( newJavaLocalDate.getYear(), year );
		assertEquals( newJavaLocalDate.getMonthValue(), month );
		assertEquals( newJavaLocalDate.getDayOfMonth(), day );
	}

	@Test
	public void localTimeTest() {
		int hour = 11;
		int minute = 22;
		int second = 33;
		int millis = 44;
		int nano = millis * 1000000;
		java.time.LocalTime javaLocalTime = java.time.LocalTime.of( hour, minute, second, nano );

		org.joda.time.LocalTime jodaLocalTime = javaToJodaLocalTime( javaLocalTime );
		assertEquals( jodaLocalTime.getHourOfDay(), hour );
		assertEquals( jodaLocalTime.getMinuteOfHour(), minute );
		assertEquals( jodaLocalTime.getSecondOfMinute(), second );
		assertEquals( jodaLocalTime.getMillisOfSecond(), millis );

		java.time.LocalTime newJavaLocalTime = jodaToJavaLocalTime( jodaLocalTime );
		assertEquals( newJavaLocalTime.getHour(), hour );
		assertEquals( newJavaLocalTime.getMinute(), minute );
		assertEquals( newJavaLocalTime.getSecond(), second );
		assertEquals( newJavaLocalTime.getNano(), nano );
	}

	@Test
	public void localDateTimeTest() {
		int year = 2000;
		int month = 3;
		int day = 14;
		int hour = 11;
		int minute = 22;
		int second = 33;
		int millis = 44;
		int nano = millis * 1000000;
		java.time.LocalDateTime javaLocalDateTime = java.time.LocalDateTime.of( year, month, day, hour, minute, second, nano );

		org.joda.time.LocalDateTime jodaLocalDateTime = javaToJodaLocalDateTime( javaLocalDateTime );
		assertEquals( jodaLocalDateTime.getYear(), year );
		assertEquals( jodaLocalDateTime.getMonthOfYear(), month );
		assertEquals( jodaLocalDateTime.getDayOfMonth(), day );
		assertEquals( jodaLocalDateTime.getHourOfDay(), hour );
		assertEquals( jodaLocalDateTime.getMinuteOfHour(), minute );
		assertEquals( jodaLocalDateTime.getSecondOfMinute(), second );
		assertEquals( jodaLocalDateTime.getMillisOfSecond(), millis );

		java.time.LocalDateTime newJavaLocalDateTime = jodaToJavaLocalDateTime( jodaLocalDateTime );
		assertEquals( newJavaLocalDateTime.getYear(), year );
		assertEquals( newJavaLocalDateTime.getMonthValue(), month );
		assertEquals( newJavaLocalDateTime.getDayOfMonth(), day );
		assertEquals( newJavaLocalDateTime.getHour(), hour );
		assertEquals( newJavaLocalDateTime.getMinute(), minute );
		assertEquals( newJavaLocalDateTime.getSecond(), second );
		assertEquals( newJavaLocalDateTime.getNano(), nano );
	}

	@Test
	public void monthDayTest() {
		int month = 3;
		int day = 14;
		java.time.MonthDay javaMonthDay = java.time.MonthDay.of( month, day );

		org.joda.time.MonthDay jodaMonthDay = javaToJodaMonthDay( javaMonthDay );
		assertEquals( jodaMonthDay.getMonthOfYear(), month );
		assertEquals( jodaMonthDay.getDayOfMonth(), day );

		java.time.MonthDay newJavaMonthDay = jodaToJavaMonthDay( jodaMonthDay );
		assertEquals( newJavaMonthDay.getMonthValue(), month );
		assertEquals( newJavaMonthDay.getDayOfMonth(), day );
	}

	@Test
	public void yearMonthTest() {
		int year = 2000;
		int month = 3;
		java.time.YearMonth javaYearMonth = java.time.YearMonth.of( year, month );

		org.joda.time.YearMonth jodaYearMonth = javaToJodaYearMonth( javaYearMonth );
		assertEquals( jodaYearMonth.getYear(), year );
		assertEquals( jodaYearMonth.getMonthOfYear(), month );

		java.time.YearMonth newJavaYearMonth = jodaToJavaYearMonth( jodaYearMonth );
		assertEquals( newJavaYearMonth.getYear(), year );
		assertEquals( newJavaYearMonth.getMonthValue(), month );
	}

	@Test
	public void dateTimeTest() {
		int year = 2000;
		int month = 3;
		int day = 14;
		int hour = 11;
		int minute = 22;
		int second = 33;
		int millis = 44;
		int nano = millis * 1000000;
		String tz = "Africa/Nairobi";
		java.time.ZoneId tzId = java.time.ZoneId.of( tz );
		java.time.ZonedDateTime javaDateTime = java.time.ZonedDateTime.of( year, month, day, hour, minute, second, nano, tzId );

		org.joda.time.DateTime jodaDateTime = javaToJodaDateTime( javaDateTime );
		assertEquals( jodaDateTime.getYear(), year );
		assertEquals( jodaDateTime.getMonthOfYear(), month );
		assertEquals( jodaDateTime.getDayOfMonth(), day );
		assertEquals( jodaDateTime.getHourOfDay(), hour );
		assertEquals( jodaDateTime.getMinuteOfHour(), minute );
		assertEquals( jodaDateTime.getSecondOfMinute(), second );
		assertEquals( jodaDateTime.getMillisOfSecond(), millis );
		assertEquals( jodaDateTime.getZone().getID(), tz );

		java.time.ZonedDateTime newJavaDateTime = jodaToJavaDateTime( jodaDateTime );
		assertEquals( newJavaDateTime.getYear(), year );
		assertEquals( newJavaDateTime.getMonthValue(), month );
		assertEquals( newJavaDateTime.getDayOfMonth(), day );
		assertEquals( newJavaDateTime.getHour(), hour );
		assertEquals( newJavaDateTime.getMinute(), minute );
		assertEquals( newJavaDateTime.getSecond(), second );
		assertEquals( newJavaDateTime.getNano(), nano );
		assertEquals( newJavaDateTime.getZone().getId(), tz );
	}

	@Test
	public void instantTest() {
		long epochMillis = 3141592;
		java.time.Instant javaInstant = java.time.Instant.ofEpochMilli( epochMillis );

		org.joda.time.Instant jodaInstant = javaToJodaInstant( javaInstant );
		assertEquals( jodaInstant.getMillis(), epochMillis );

		java.time.Instant newJavaInstant = jodaToJavaInstant( jodaInstant );
		assertEquals( newJavaInstant.toEpochMilli(), epochMillis );
	}

	@Test
	public void timeZoneTest() {
		String tz = "Africa/Nairobi";
		java.time.ZoneId javaTimeZone = java.time.ZoneId.of( tz );

		org.joda.time.DateTimeZone jodaTimeZone = javaToJodaTimeZone( javaTimeZone );
		assertEquals( jodaTimeZone.getID(), tz );

		java.time.ZoneId newJavaTimeZone = jodaToJavaTimeZone( jodaTimeZone );
		assertEquals( newJavaTimeZone.getId(), tz );
	}

	@Test
	public void durationTest() {
		long durationMillis = 3141592;
		java.time.Duration javaDuration = java.time.Duration.ofMillis( durationMillis );

		org.joda.time.Duration jodaDuration = javaToJodaDuration( javaDuration );
		assertEquals( jodaDuration.getMillis(), durationMillis );

		java.time.Duration newJavaDuration = jodaToJavaDuration( jodaDuration );
		assertEquals( newJavaDuration.toMillis(), durationMillis );
	}

	@Test
	public void periodTest() {
		int years = 2;
		int months = 3;
		int days = 4;
		java.time.Period javaPeriod = java.time.Period.of( years, months, days );

		org.joda.time.Period jodaPeriod = javaToJodaPeriod( javaPeriod );
		assertEquals( jodaPeriod.getYears(), years );
		assertEquals( jodaPeriod.getMonths(), months );
		assertEquals( jodaPeriod.getDays(), days );

		java.time.Period newJavaPeriod = jodaToJavaPeriod( jodaPeriod );
		assertEquals( newJavaPeriod.getYears(), years );
		assertEquals( newJavaPeriod.getMonths(), months );
		assertEquals( newJavaPeriod.getDays(), days );

		// information loss test
		org.joda.time.Period jodaPeriod2 = new org.joda.time.Period( 1, 1, 0, 1, 0, 0, 1, 0 );
		assertNotEquals( jodaPeriod2.getSeconds(), javaToJodaPeriod( jodaToJavaPeriod( jodaPeriod2 ) ).getSeconds() );
	}
}
