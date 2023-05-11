class Program3 {
	public static void main(String[] args) {
		double daysPerWeek = 7;
		double weeksPerMonth = 365.0/12.0/7.0;
		double monthsPerYear = 12;
		double daysPerYear = daysPerWeek * weeksPerMonth * monthsPerYear;
		System.out.println("There are " + daysPerYear + " days in a year");
	}
}
