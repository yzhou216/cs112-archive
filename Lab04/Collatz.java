public class Collatz {
	public static void main(String[] args) {
		for(int i = 1; i <= 200; i++) {
			int num = i;
			int counter = 0;
			while(num != 1) {
				if(num%2 == 0) {
					num = num / 2;
					counter++;
				} else {
					num = 3 * num + 1;
					counter++;
				}
			}
			System.out.println(i + " " + counter);
		}
	}
}
