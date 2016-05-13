package com.meetup.timeywimey;

public class JodaConverters {
	private static int milliToNanoConst = 1000000;

	/* ************************ *
	 * Classes without timezone *
	 * ************************ */

	/**
	 * converts JodaTime LocalDate to Java 8 equivalent.
	 *
	 * @param localDate JodaTime LocalDate
	 * @return Java 8 LocalDate
	 */
	public static java.time.LocalDate jodaToJavaLocalDate( org.joda.time.LocalDate localDate ) {
		return java.time.LocalDate.of( localDate.getYear(), localDate.getMonthOfYear(), localDate.getDayOfMonth() );
	}

	public static org.joda.time.LocalDate javaToJodaLocalDate( java.time.LocalDate localDate ) {
		return new org.joda.time.LocalDate( localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth() );
	}

	public static java.time.LocalTime jodaToJavaLocalTime( org.joda.time.LocalTime localTime ) {
		return java.time.LocalTime.of(
				localTime.getHourOfDay(),
				localTime.getMinuteOfHour(),
				localTime.getSecondOfMinute(),
				localTime.getMillisOfSecond() * milliToNanoConst );
	}

	public static org.joda.time.LocalTime javaToJodaLocalTime( java.time.LocalTime localTime ) {
		return new org.joda.time.LocalTime(
				localTime.getHour(),
				localTime.getMinute(),
				localTime.getSecond(),
				localTime.getNano() / milliToNanoConst );
	}

	public static java.time.LocalDateTime jodaToJavaLocalDateTime( org.joda.time.LocalDateTime localDateTime ) {
		return java.time.LocalDateTime.of(
				localDateTime.getYear(),
				localDateTime.getMonthOfYear(),
				localDateTime.getDayOfMonth(),
				localDateTime.getHourOfDay(),
				localDateTime.getMinuteOfHour(),
				localDateTime.getSecondOfMinute(),
				localDateTime.getMillisOfSecond() * milliToNanoConst );
	}

	public static org.joda.time.LocalDateTime javaToJodaLocalDateTime( java.time.LocalDateTime localDateTime ) {
		return new org.joda.time.LocalDateTime(
				localDateTime.getYear(),
				localDateTime.getMonthValue(),
				localDateTime.getDayOfMonth(),
				localDateTime.getHour(),
				localDateTime.getMinute(),
				localDateTime.getSecond(),
				localDateTime.getNano() / milliToNanoConst );
	}

	public static java.time.MonthDay jodaToJavaMonthDay( org.joda.time.MonthDay monthDay ) {
		return java.time.MonthDay.of( monthDay.getMonthOfYear(), monthDay.getDayOfMonth() );
	}

	public static org.joda.time.MonthDay javaToJodaMonthDay( java.time.MonthDay monthDay ) {
		return new org.joda.time.MonthDay( monthDay.getMonthValue(), monthDay.getDayOfMonth() );
	}

	public static java.time.YearMonth jodaToJavaYearMonth( org.joda.time.YearMonth yearMonth ) {
		return java.time.YearMonth.of( yearMonth.getYear(), yearMonth.getMonthOfYear() );
	}

	public static org.joda.time.YearMonth javaToJodaYearMonth( java.time.YearMonth yearMonth ) {
		return new org.joda.time.YearMonth( yearMonth.getYear(), yearMonth.getMonthValue() );
	}


	/* ****************************** *
	 * Class with timezone or instant *
	 * ****************************** */

	public static java.time.ZonedDateTime jodaToJavaDateTime( org.joda.time.DateTime dateTime ) {
		return jodaToJavaInstant( dateTime.toInstant() ).atZone( jodaToJavaTimeZone(dateTime.getZone() ) );
	}

	public static org.joda.time.DateTime javaToJodaDateTime( java.time.ZonedDateTime dateTime ) {
		return new org.joda.time.DateTime( javaToJodaInstant( dateTime.toInstant() ), javaToJodaTimeZone( dateTime.getZone() ) );
	}

	/**
	 * Instant
	 */
	public static java.time.Instant jodaToJavaInstant( org.joda.time.Instant instant ) {
		return java.time.Instant.ofEpochMilli( instant.getMillis() );
	}

	public static org.joda.time.Instant javaToJodaInstant( java.time.Instant instant ) {
		return new org.joda.time.Instant( instant.toEpochMilli() );
	}


	/**
	 * TimeZone
	 */
	public static java.time.ZoneId jodaToJavaTimeZone( org.joda.time.DateTimeZone timeZone ) {
		return java.time.ZoneId.of( timeZone.getID() );
	}

	public static org.joda.time.DateTimeZone javaToJodaTimeZone( java.time.ZoneId timeZone ) {
		return org.joda.time.DateTimeZone.forID( timeZone.getId() );
	}


	/* ************** *
	 * Amount of Time *
	 * ************** */

	/**
	 * Duration
	 */
	public static java.time.Duration jodaToJavaDuration( org.joda.time.Duration duration ) {
		return java.time.Duration.ofMillis( duration.getMillis() );
	}

	public static org.joda.time.Duration javaToJodaDuration( java.time.Duration duration ) {
		return org.joda.time.Duration.millis( duration.toMillis() );
	}

	// Warning: Lossy. Truncates everything under day unit
	public static java.time.Period jodaToJavaPeriod( org.joda.time.Period period ) {
		return java.time.Period.of( period.getYears(), period.getMonths(), period.getDays() );
	}

	public static org.joda.time.Period javaToJodaPeriod( java.time.Period period ) {
		return new org.joda.time.Period( period.getYears(), period.getMonths(), 0, period.getDays(), 0, 0, 0, 0 );
	}
}
