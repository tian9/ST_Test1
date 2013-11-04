package main;

/**
 * Time is the class to describe #mins of the week. The start point is Sunday midnight.
 * Sunday, 00:00.
 * 
 * @author  Jing Tian, tian9@email.sc.edu
 * @version 1.0
 */
public class Time {

	//
	// Constant
	//
	public static final String[] weekName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	
	public static final int MINS_PER_WEEK = 10080; // 60mins * 24hours * 7days
	public static final int MINS_PER_DAY  = 1440;  // 60mins * 24hours
	public static final int MINS_PER_HOUR = 60;    // 60mins

	//
	// Member field
	//
	private int minsOfWeek = 0;
	private int day        = 0;
	private int hour       = 0;
	private int min        = 0;

	//
	// Constructor
	//
	
	/**
	 * Construct the default Time, all the member fields are initialized as zero
	 * 
	 */	
	public Time() {
		this.minsOfWeek = 0;
		this.day        = 0;
		this.hour       = 0;
		this.min        = 0;
	}

	/**
	 * Construct the Time
	 * 
	 * @param minsOfWeek    minutes from the start point of the week
	 */		
	public Time(int minsOfWeek) {
		if (minsOfWeek < 0) {
			System.out.println("ERROR: #mins of the week should be equal to or greater than ZERO");
			return;
		}
		
		if (minsOfWeek >= MINS_PER_WEEK) {
			System.out.println("ERROR: #mins of the week cannot be greater than or equal to 10080 (MINS_PER_WEEK)");
			return;
		}
		
		this.minsOfWeek = minsOfWeek;
		day  = this.minsOfWeek / MINS_PER_DAY;
		hour = (this.minsOfWeek % MINS_PER_DAY) / MINS_PER_HOUR;
		min  = this.minsOfWeek - day * MINS_PER_DAY - hour * MINS_PER_HOUR;
	}
	
	//
	// Method
	//
	
	/**
	 * Convert Time object to String: <Week>:HH:MM
	 * 
	 * @return String format of the Time object
	 */		
	public String toString() {
		String strTime = String.format("%s, %02d:%02d", this.weekName[day], hour, min);
		
		return strTime;
	}
	
	/**
	 * Get #mins of the week
	 * 
	 * @return minutes of the week from Sunday midnight.
	 */	
	public int getMinsOfWeek() {
		return minsOfWeek;
	}
	
	/**
	 * Get day of the week
	 * 
	 * @return Name of the day in the week, e.g. Sunday
	 */		
	public String getDay() {
		return weekName[day];
	}
	
	/**
	 * Get time of the week, HH:MM format.
	 * 
	 * @return Time of the week in HH:MM format
	 */		
	public String getTimeOfDay() {
		return String.format("%02d:%02d", hour, min);
	}
	
	/**
	 * Get hour of the day
	 * 
	 * @return Hour of the day
	 */		
	public int getHour() {
		return hour;
	}
	
	/**
	 * Get minutes of the hour
	 * 
	 * @return Minutes of the hour
	 */		
	public int getMin() {
		return min;
	}

	//
	// Main
	//
	public static void main(String[] args) {
		Time zeroTime = new Time();
		Time startTime = new Time(61);
		Time endTime = new Time(121);
		
		System.out.println(zeroTime);
		System.out.println(startTime);
		System.out.println(endTime);
		
		Time Monday_8_30 = new Time(1950);
		System.out.println(Monday_8_30);
		
		Time Thursday_13_23 = new Time(6563);
		System.out.println(Thursday_13_23);
		System.out.println(Thursday_13_23.getDay());
		System.out.println(Thursday_13_23.getMinsOfWeek());
		System.out.println(Thursday_13_23.getTimeOfDay());
		
		Time wrongTime = new Time(10080);
		System.out.println(wrongTime);
		
		Time beginOfTheWeek = new Time(0);
		System.out.println(beginOfTheWeek);
		
		Time negativeTime = new Time(-1);
		System.out.println(negativeTime);
	}

}
