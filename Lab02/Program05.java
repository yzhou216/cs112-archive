class Program05 {
	public static void main(String[] args) {
		double radius = 5;
		double height = 10;
		double baseArea = 3.15 * (radius * radius);
		double coneVolume = (1/3) * baseArea * height;
		System.out.println("The volume of our cone is " + coneVolume);
	}
}
