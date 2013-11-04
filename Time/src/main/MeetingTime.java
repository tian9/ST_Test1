package main;

/**
 * MeetingTime is the class to describe a meeting slot. There will be a start time
 * and end time for each meeting. We assume each meeting cannot across the week.
 * 
 * @author  Jing Tian, tian9@email.sc.edu
 * @version 1.0
 */
public class MeetingTime {
	
	private Time startTime = new Time();
	private Time endTime = new Time(Time.MINS_PER_HOUR);
	
	/**
	 * Construct a meeting slot with a start time and end time
	 * 
	 * @param startTime Meeting start time
	 * @param endTime   Meeting end time
	 */		
	public MeetingTime(Time startTime, Time endTime) {
		if (startTime.getMinsOfWeek() >= endTime.getMinsOfWeek()) {
			System.out.println("ERROR: Meeting start time should be less then end time");
			return;
		}
		
		this.startTime = new Time(startTime.getMinsOfWeek());
		this.endTime = new Time(endTime.getMinsOfWeek());
	}
	
	//
	// Method
	//
	
	/**
	 * Check whether two meetings conflict with each other
	 * 
	 * @param anotherMeeting The other meeting need to be checked.
	 * 
	 * @return true if the two meeting have conflict.
	 */		
	public boolean overlap(MeetingTime anotherMeeting) {
		if (this.startTime.getMinsOfWeek() == anotherMeeting.startTime.getMinsOfWeek()) {
			return true;
		}
		
		if (this.startTime.getMinsOfWeek() < anotherMeeting.startTime.getMinsOfWeek()) {
			if (this.endTime.getMinsOfWeek() > anotherMeeting.startTime.getMinsOfWeek()) {
				return true;
			}
		}
		
		if (this.startTime.getMinsOfWeek() > anotherMeeting.startTime.getMinsOfWeek()) {
			if (this.startTime.getMinsOfWeek() < anotherMeeting.endTime.getMinsOfWeek()) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Convert MeetingTime to string format.
	 * 
	 * e.g. Sunday, 00:00 --- Sunday 00:30
	 *
	 * @return String format of MeetingTime object
	 */		
	public String toString() {
		String strMeetingSlot = startTime.toString() + " --- " + endTime.toString();
		
		return strMeetingSlot;
	}
	
	//
	// Main
	//
	public static void main(String[] args) {
		MeetingTime welcomeMeeting = new MeetingTime(new Time(1200), new Time(1245));
		System.out.println(welcomeMeeting);
		
		MeetingTime roundTable = new MeetingTime(new Time(1180), new Time(1201));
		System.out.println(roundTable);
		
		if (welcomeMeeting.overlap(roundTable)) {
			System.out.println("Welcome meeting conflicts with round table");
		}
		
	}

}
