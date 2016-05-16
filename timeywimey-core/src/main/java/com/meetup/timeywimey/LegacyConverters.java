package com.meetup.timeywimey;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * The LegacyConverters class contains static methods for java.util.Date and java.time.* conversion.
 *
 * @author Sak Lee
 * @version 0.1.0
 * @since 2016-05-16
 */
public class LegacyConverters {
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
