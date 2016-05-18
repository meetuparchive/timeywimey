package com.meetup.timeywimey;

import java.sql.Timestamp;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class LegacyConverters {
	private static int milliToNanoConst = 1000000;

	public static ZonedDateTime toZonedDateTime( Date date ) {
		return toZonedDateTime( date, ZoneId.systemDefault() );
	}

	public static ZonedDateTime toZonedDateTime( Date date, ZoneId zoneId ) {
		return ZonedDateTime.ofInstant( date.toInstant(), zoneId );
	}

	public static LocalDateTime toLocalDateTime( Date date ) {
		Calendar c = Calendar.getInstance();
		c.setTime( date );
		int year = c.get( Calendar.YEAR );
		int month = c.get( Calendar.MONTH );
		int day = c.get( Calendar.DAY_OF_MONTH );
		int hour = c.get( Calendar.HOUR_OF_DAY );
		int minute = c.get( Calendar.MINUTE );
		int second = c.get( Calendar.SECOND );
		int millis = c.get( Calendar.MILLISECOND );
		return LocalDateTime.of( year, month, day, hour, minute, second, millis * milliToNanoConst );
	}

	public static LocalDate toLocalDate( Date date ) {
		Calendar c = Calendar.getInstance();
		c.setTime( date );
		int year = c.get( Calendar.YEAR );
		int month = c.get( Calendar.MONTH );
		int day = c.get( Calendar.DAY_OF_MONTH );
		return LocalDate.of( year, month, day );
	}

	public static LocalTime toLocalTime( Date date ) {
		Calendar c = Calendar.getInstance();
		c.setTime( date );
		int hour = c.get( Calendar.HOUR_OF_DAY );
		int minute = c.get( Calendar.MINUTE );
		int second = c.get( Calendar.SECOND );
		int millis = c.get( Calendar.MILLISECOND );
		return LocalTime.of( hour, minute, second, millis * milliToNanoConst );
	}

	public static Date toDate( ZonedDateTime dateTime ) {
		return toDate( dateTime.toInstant() );
	}

	public static Date toDate( Instant instant ) {
		return new Date( instant.toEpochMilli() );
	}

	public static Timestamp toTimestamp( ZonedDateTime dateTime ) {
		return toTimestamp( dateTime.toInstant() );
	}

	public static Timestamp toTimestamp( Instant instant ) {
		return new Timestamp( instant.toEpochMilli() );
	}
}
