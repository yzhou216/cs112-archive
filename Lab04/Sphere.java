public class Sphere {
	private double diameter;
	private double radius;
	public void setDiameter(double diameter) {
		this.diameter = diameter;
		this.radius = diameter / (double) 2;
	}
	public double diameter() {
		return diameter;
	}
	public double radius() {
		return radius;
	}
	public double surfaceArea() {
		return (double) 4 * Math.PI * Math.pow(radius, 2); // sphere surface area formula
	}
	public double volume() {
		return (double) 4 * Math.PI * Math.pow(radius, 3) / (double) 3; // sphere volume formula
	}
}
