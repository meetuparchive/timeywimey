package com.meetup.timeywimey;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class LegacyConverters {
	public static ZonedDateTime toZonedDateTime( Date date ) {
		return toZonedDateTime( date, ZoneId.systemDefault() );
	}

	public static ZonedDateTime toZonedDateTime( Date date, ZoneId zoneId ) {
		return ZonedDateTime.ofInstant( date.toInstant(), zoneId );
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
