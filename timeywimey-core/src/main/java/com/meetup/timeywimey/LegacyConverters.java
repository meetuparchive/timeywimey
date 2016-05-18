package com.meetup.timeywimey;

import java.sql.Timestamp;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * The LegacyConverters class contains static methods for java.util.Date and java.time.* conversion.
 *
 * @author Sak Lee
 * @version 0.1.0
 * @since 2016-05-16
 */
public class LegacyConverters {
	private static int milliToNanoConst = 1000000;

	/**
	 * Converts legacy java.util.Date (or java.sql.Timestamp) class to ZonedDateTime with system default timezone
	 * @param date a java.util.Date object
	 * @return a ZonedDateTime object with equivalent epoch millis and system default timezone
	 */
	public static ZonedDateTime toZonedDateTime( Date date ) {
		return toZonedDateTime( date, ZoneId.systemDefault() );
	}

	/**
	 * Converts legacy java.util.Date (or java.sql.Timestamp) class to ZonedDateTime with given timezone
	 * @param date a java.util.Date object
	 * @param zoneId a timezone to apply
	 * @return a ZonedDateTime object with equivalent epoch millis and given timezone
	 */
	public static ZonedDateTime toZonedDateTime( Date date, ZoneId zoneId ) {
		return ZonedDateTime.ofInstant( date.toInstant(), zoneId );
	}

	/**
	 * Converts legacy java.util.Date (or java.sql.Timestamp) class to LocalDateTime
	 * @param date a java.util.Date object
	 * @return a LocalDateTime object
	 */
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

	/**
	 * Converts legacy java.util.Date (or java.sql.Timestamp) class to LocalDate
	 * @param date a java.util.Date object
	 * @return a LocalDate object
	 */
	public static LocalDate toLocalDate( Date date ) {
		Calendar c = Calendar.getInstance();
		c.setTime( date );
		int year = c.get( Calendar.YEAR );
		int month = c.get( Calendar.MONTH );
		int day = c.get( Calendar.DAY_OF_MONTH );
		return LocalDate.of( year, month, day );
	}

	/**
	 * Converts legacy java.util.Date (or java.sql.Timestamp) class to LocalTime
	 * @param date a java.util.Date object
	 * @return a LocalTime object
	 */
	public static LocalTime toLocalTime( Date date ) {
		Calendar c = Calendar.getInstance();
		c.setTime( date );
		int hour = c.get( Calendar.HOUR_OF_DAY );
		int minute = c.get( Calendar.MINUTE );
		int second = c.get( Calendar.SECOND );
		int millis = c.get( Calendar.MILLISECOND );
		return LocalTime.of( hour, minute, second, millis * milliToNanoConst );
	}

	/**
	 * Converts ZonedDateTime into Date
	 * @param dateTime a ZonedDateTime object
	 * @return a Date object with equivalent epoch millis
	 */
	public static Date toDate( ZonedDateTime dateTime ) {
		return toDate( dateTime.toInstant() );
	}

	/**
	 * Converts ZonedDateTime into Date
	 * @param instant a ZonedDateTime object
	 * @return a Date object with equivalent epoch millis
	 */
	public static Date toDate( Instant instant ) {
		return new Date( instant.toEpochMilli() );
	}

	/**
	 * Converts ZonedDateTime into java.sql.Timestamp
	 * @param dateTime a ZonedDateTime object
	 * @return a Timestamp object with equivalent epoch millis
	 */
	public static Timestamp toTimestamp( ZonedDateTime dateTime ) {
		return toTimestamp( dateTime.toInstant() );
	}

	/**
	 * Converts ZonedDateTime into java.sql.Timestamp
	 * @param instant a ZonedDateTime object
	 * @return a Timestamp object with equivalent epoch millis
	 */
	public static Timestamp toTimestamp( Instant instant ) {
		return new Timestamp( instant.toEpochMilli() );
	}
}
