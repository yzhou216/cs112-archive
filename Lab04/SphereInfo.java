public class SphereInfo {
	public static void main(String[] args) {
		Sphere sphere0 = new Sphere();
		Sphere sphere1 = new Sphere();
		Sphere sphere2 = new Sphere();
		sphere0.setDiameter(0.0); // 0.0 radius
		sphere1.setDiameter(1.0); // 0.5 radius
		sphere2.setDiameter(7.5); // 3.75 radius
		System.out.println("A sphere of radius 0.0 has surface area " + sphere0.surfaceArea() + " and volume " + sphere0.volume());
		System.out.println("A sphere of radius 0.5 has surface area " + sphere1.surfaceArea() + " and volume " + sphere1.volume());
		System.out.println("A sphere of radius 3.75 has surface area " + sphere2.surfaceArea() + " and volume " + sphere2.volume());
	}
}
