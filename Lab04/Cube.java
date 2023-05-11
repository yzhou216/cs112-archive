public class Cube {
	public static void main(String[] args) {
		int i = 1;
		double cube = 0;
		while(cube <= 2000) {
			cube = Math.pow(i, 3);
			if(cube <= 2000)
				System.out.println((int) cube);
			i++;
		}
	}
}
