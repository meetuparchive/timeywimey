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
		assertEquals(jodaLocalDate.getYear(), year);
		assertEquals(jodaLocalDate.getMonthOfYear(), month);
		assertEquals(jodaLocalDate.getDayOfMonth(), day);

		java.time.LocalDate newJavaLocalDate = jodaToJavaLocalDate( jodaLocalDate );
		assertEquals(newJavaLocalDate.getYear(), year);
		assertEquals(newJavaLocalDate.getMonthValue(), month);
		assertEquals(newJavaLocalDate.getDayOfMonth(), day);
	}
}
