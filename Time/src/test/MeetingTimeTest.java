package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.MeetingTime;
import main.Time;

public class MeetingTimeTest {

	@Test
	public void testMeetingTimeTimeTime() {
		//
		// Error check, error message should be issued. The internal value should
		// be set as default.
		//
		MeetingTime wrongSchedule = new MeetingTime(new Time(100), new Time(50));
		assertEquals("Sunday, 00:00 --- Sunday, 01:00", wrongSchedule.toString());
		
		MeetingTime zeroTimeMeeting = new MeetingTime(new Time(100), new Time(100));
		assertEquals("Sunday, 00:00 --- Sunday, 01:00", zeroTimeMeeting.toString());
		
		//
		// Normal case
		//
		MeetingTime normalMeeting = new MeetingTime(new Time(4776), new Time(4813));
		assertEquals("Wednesday, 07:36 --- Wednesday, 08:13", normalMeeting.toString());
	}

	@Test
	public void testOverlap() {
		MeetingTime m1 = new MeetingTime(new Time(1200), new Time(1245));
		MeetingTime m2 = new MeetingTime(new Time(1250), new Time(1350));
		assertFalse(m1.overlap(m2));
		
		MeetingTime m3 = new MeetingTime(new Time(1200), new Time(1245));
		MeetingTime m4 = new MeetingTime(new Time(1240), new Time(1250));
		assertTrue(m3.overlap(m4));
		
		MeetingTime m5 = new MeetingTime(new Time(1200), new Time(1245));
		MeetingTime m6 = new MeetingTime(new Time(1100), new Time(1205));
		assertTrue(m5.overlap(m6));
		
		MeetingTime m7 = new MeetingTime(new Time(1200), new Time(1250));
		MeetingTime m8 = new MeetingTime(new Time(1200), new Time(1201));
		assertTrue(m7.overlap(m8));
	}

}
