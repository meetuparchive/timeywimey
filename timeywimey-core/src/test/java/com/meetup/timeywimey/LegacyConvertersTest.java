package com.meetup.timeywimey;

import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

import static com.meetup.timeywimey.LegacyConverters.*;

public class LegacyConvertersTest {
	@Test
	public void dateToZonedDateTimeTest() {
		long epochMillis = 31415926535L;
		String tz = "Africa/Nairobi";
		ZoneId tzId = ZoneId.of( tz );
		Date date = new Date( epochMillis );
		ZonedDateTime zdt = toZonedDateTime( date, tzId );
		assertEquals( date.getTime(), zdt.toInstant().toEpochMilli() );
	}

	@Test
	public void dateToLocalDateTimeTest() {
		long epochMillis = 31415926535L;
		Date date = new Date( epochMillis );
		Calendar c = Calendar.getInstance();
		c.setTime( date );
		int year = c.get( Calendar.YEAR );
		int month = c.get( Calendar.MONTH );
		int day = c.get( Calendar.DAY_OF_MONTH );
		int hour = c.get( Calendar.HOUR_OF_DAY );
		int minute = c.get( Calendar.MINUTE );
		int second = c.get( Calendar.SECOND );
		int millis = c.get( Calendar.MILLISECOND );
		LocalDateTime localDateTime = toLocalDateTime( date );
		assertEquals( localDateTime.getYear(), year );
		assertEquals( localDateTime.getMonthValue(), month );
		assertEquals( localDateTime.getDayOfMonth(), day );
		assertEquals( localDateTime.getHour(), hour );
		assertEquals( localDateTime.getMinute(), minute );
		assertEquals( localDateTime.getSecond(), second );
		assertEquals( localDateTime.getNano(), millis * 1000000 );
	}

	@Test
	public void dateToLocalDateTest() {
		long epochMillis = 31415926535L;
		Date date = new Date( epochMillis );
		Calendar c = Calendar.getInstance();
		c.setTime( date );
		int year = c.get( Calendar.YEAR );
		int month = c.get( Calendar.MONTH );
		int day = c.get( Calendar.DAY_OF_MONTH );
		LocalDate localDate = toLocalDate( date );
		assertEquals( localDate.getYear(), year );
		assertEquals( localDate.getMonthValue(), month );
		assertEquals( localDate.getDayOfMonth(), day );
	}

	@Test
	public void dateToLocalTimeTest() {
		long epochMillis = 31415926535L;
		Date date = new Date( epochMillis );
		Calendar c = Calendar.getInstance();
		c.setTime( date );
		int hour = c.get( Calendar.HOUR_OF_DAY );
		int minute = c.get( Calendar.MINUTE );
		int second = c.get( Calendar.SECOND );
		int millis = c.get( Calendar.MILLISECOND );
		LocalTime localTime = toLocalTime( date );
		assertEquals( localTime.getHour(), hour );
		assertEquals( localTime.getMinute(), minute );
		assertEquals( localTime.getSecond(), second );
		assertEquals( localTime.getNano(), millis * 1000000 );
	}

	@Test
	public void instantToDateTest() {
		long epochMillis = 31415926535L;
		Instant instant = Instant.ofEpochMilli( epochMillis );
		Date date = toDate( instant );
		assertEquals( date.getTime(), instant.toEpochMilli() );
	}

	@Test
	public void instantToTimestampTest() {
		long epochMillis = 31415926535L;
		Instant instant = Instant.ofEpochMilli( epochMillis );
		Timestamp timestamp = toTimestamp( instant );
		assertEquals( timestamp.getTime(), instant.toEpochMilli() );
	}
}
