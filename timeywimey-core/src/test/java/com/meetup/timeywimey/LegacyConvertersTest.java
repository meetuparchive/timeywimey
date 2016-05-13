package com.meetup.timeywimey;

import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static com.meetup.timeywimey.LegacyConverters.*;

public class LegacyConvertersTest {
	@Test
	public void dateToZonedDateTimeTest() {
		long epochMillis = 3141592;
		String tz = "Africa/Nairobi";
		ZoneId tzId = ZoneId.of( tz );
		Date date = new Date( epochMillis );
		ZonedDateTime zdt = toZonedDateTime( date, tzId );
		assertEquals( date.getTime(), zdt.toInstant().toEpochMilli() );
	}

	@Test
	public void instantToDateTest() {
		long epochMillis = 3141592;
		Instant instant = Instant.ofEpochMilli( epochMillis );
		Date date = toDate( instant );
		assertEquals( date.getTime(), instant.toEpochMilli() );
	}

	@Test
	public void instantToTimestampTest() {
		long epochMillis = 3141592;
		Instant instant = Instant.ofEpochMilli( epochMillis );
		Timestamp timestamp = toTimestamp( instant );
		assertEquals( timestamp.getTime(), instant.toEpochMilli() );
	}
}
