public class Taylor{
	public static void main(String[] args) {
		System.out.println(Math.log(2));
		double result = 0;
		int i = 1;
		while(i <= 11) {
			if(i%2 == 0)
				result = i + Math.pow(i, i + 1);
			else
				result = i - Math.pow(i, i + 1);
		i++;
		} 
		System.out.println(result);
	}
}
