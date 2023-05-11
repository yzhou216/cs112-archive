class Program07 {
	public static void main(String[] args) {
		double secondsPerMinute = 60;
		double minutesPerHour = 60;
		double secondsPerHour = secondsPerMinute * minutesPerHour;
		double hoursPerDay = 24;
		double secondsPerDay = secondsPerHour * hoursPerDay;
		double daysPerYear = 365;
		double secondsPerYear = secondsPerDay * daysPerYear;
		
		System.out.println("There are " + secondsPerYear + " seconds in a year.");
		double PI = 3.14159265;
		double approx = PI * (10^7);
		System.out.println("A good approximation is " + approx);
	}
}
