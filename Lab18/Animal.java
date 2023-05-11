abstract class Animal {
        public abstract String sound();
	public abstract String toString();
	public void writeVerse() {
		System.out.println("Old McDonald had a farm, EIEIO,");
		System.out.print("And on his farm he had a " + this.toString());
		System.out.println(", EIEIO,");
		String s = this.sound();
		System.out.print("With a " + s + ", " + s + " here, ");
		System.out.println("a " + s + ", " + s + " there...");
	}
}
