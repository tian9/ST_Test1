package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Time;

public class TimeTest {

	@Test
	public void testTime() {
		//
		// Default time should be the start of the week: Sunday, 00:00
		//
		Time defaultTime = new Time();
		assertEquals(0, defaultTime.getMinsOfWeek());
		assertEquals(0, defaultTime.getHour());
		assertEquals(0, defaultTime.getMin());
		assertEquals("Sunday", defaultTime.getDay());
		assertEquals("Sunday, 00:00", defaultTime.toString());
	}

	@Test
	public void testTimeInt() {
		//
		// Error message should be issued if #mins < 0, all values should be set
		// as default value
		//
		Time negativeTime = new Time(-1);
		assertEquals(0, negativeTime.getMinsOfWeek());
		assertEquals(0, negativeTime.getHour());
		assertEquals(0, negativeTime.getMin());
		assertEquals("Sunday", negativeTime.getDay());
		assertEquals("Sunday, 00:00", negativeTime.toString());
		
		//
		// Error message should be issued if #mins > MINS_PER_WEEK
		//
		Time largeTime = new Time(Time.MINS_PER_WEEK + 1);
		assertEquals(0, largeTime.getMinsOfWeek());
		assertEquals(0, largeTime.getHour());
		assertEquals(0, largeTime.getMin());
		assertEquals("Sunday", largeTime.getDay());
		assertEquals("Sunday, 00:00", largeTime.toString());
		
		//
		// Boundary check
		//
		Time zeroTime = new Time(0);
		assertEquals(0, zeroTime.getMinsOfWeek());
		assertEquals(0, zeroTime.getHour());
		assertEquals(0, zeroTime.getMin());
		assertEquals("Sunday", zeroTime.getDay());
		assertEquals("Sunday, 00:00", zeroTime.toString());		
		
		Time maxTime = new Time(Time.MINS_PER_WEEK);
		assertEquals(0, maxTime.getMinsOfWeek());
		assertEquals(0, maxTime.getHour());
		assertEquals(0, maxTime.getMin());
		assertEquals("Sunday", maxTime.getDay());
		assertEquals("Sunday, 00:00", maxTime.toString());		
		
		//
		// Normal case
		//
		Time Monday_8_30 = new Time(1950);
		assertEquals(1950, Monday_8_30.getMinsOfWeek());
		assertEquals(8, Monday_8_30.getHour());
		assertEquals(30, Monday_8_30.getMin());
		assertEquals("Monday", Monday_8_30.getDay());
		assertEquals("Monday, 08:30", Monday_8_30.toString());			
		
		Time Thursday_13_23 = new Time(6563);
		assertEquals(6563, Thursday_13_23.getMinsOfWeek());
		assertEquals(13, Thursday_13_23.getHour());
		assertEquals(23, Thursday_13_23.getMin());
		assertEquals("Thursday", Thursday_13_23.getDay());
		assertEquals("Thursday, 13:23", Thursday_13_23.toString());			
	}

	@Test
	public void testGetDay() {
		//
		// Default case
		//
		Time defaultTime = new Time();
		assertEquals("Sunday", defaultTime.getDay());
		
		//
		// Error case, days should be set as default: Sunday
		//
		Time negativeTime = new Time(-1);
		assertEquals("Sunday", negativeTime.getDay());
		
		Time largeTime = new Time(Time.MINS_PER_WEEK + 1);
		assertEquals("Sunday", largeTime.getDay());
		
		//
		// Boundary check
		//
		Time zeroTime = new Time(0);
		assertEquals("Sunday", zeroTime.getDay());
		
		Time maxTime = new Time(Time.MINS_PER_WEEK);
		assertEquals("Sunday", maxTime.getDay());
		
		//
		// Normal case, from Monday to Sunday
		//
		Time Monday = new Time(1440);
		assertEquals("Monday", Monday.getDay());
		
		Time Tuesday = new Time(2880);
		assertEquals("Tuesday", Tuesday.getDay());
		
		Time Wednesday = new Time(4320);
		assertEquals("Wednesday", Wednesday.getDay());
		
		Time Thursday = new Time(5760);
		assertEquals("Thursday", Thursday.getDay());
		
		Time Friday = new Time(7200);
		assertEquals("Friday", Friday.getDay());
		
		Time Saturday = new Time(8640);
		assertEquals("Saturday", Saturday.getDay());
		
		Time Sunday = new Time(0);
		assertEquals("Sunday", Sunday.getDay());
	}

	@Test
	public void testGetTimeOfDay() {
		//
		// Default case
		//
		Time defaultTime = new Time();
		assertEquals("00:00", defaultTime.getTimeOfDay());
		
		//
		// Error case
		//
		Time negativeTime = new Time(-1);
		assertEquals("00:00", negativeTime.getTimeOfDay());
		
		Time largeTime = new Time(Time.MINS_PER_WEEK + 1);
		assertEquals("00:00", largeTime.getTimeOfDay());		
		
		//
		// Boundary check
		//
		Time zeroTime = new Time(0);
		assertEquals("00:00", zeroTime.getTimeOfDay());
		
		Time maxTime = new Time(Time.MINS_PER_WEEK);
		assertEquals("00:00", maxTime.getTimeOfDay());		
		
		//
		// Normal case
		//
		Time time_01_30 = new Time(90);
		assertEquals("01:30", time_01_30.getTimeOfDay());
		
		Time time_02_13 = new Time(133);
		assertEquals("02:13", time_02_13.getTimeOfDay());
		
		Time time_08_45 = new Time(525);
		assertEquals("08:45", time_08_45.getTimeOfDay());
		
		Time time_12_00 = new Time(720);
		assertEquals("12:00", time_12_00.getTimeOfDay());
		
		Time time_23_59 = new Time(1439);
		assertEquals("23:59", time_23_59.getTimeOfDay());
		
	}

}
