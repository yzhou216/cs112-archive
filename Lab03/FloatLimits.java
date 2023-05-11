/* Determine the smallest floating point data types by using division and comparison with zero. */
public class FloatLimits{
	public static void main(String[] args) {
		float var0 = 1;
		float temp0 = 0;
		while(var0 != 0) {
			temp0 = var0;
			var0 = (float) var0 / (float) 2;
		}
		System.out.println("Smallest positive float is " + temp0);
		
		float var1 = -1;
		float temp1 = 0;
		while(var1 != 0) {
			temp1 = var1;
			var1 = (float) var1 / (float) 2;
		}
		System.out.println("Smallest negative float is " + temp1);

		double var2 = 1;                     
                double temp2 = 0;  
                while(var2 != 0) {
                        temp2 = var2;
                        var2 = (double) var2 / (double) 2;
                }
		System.out.println("Smallest positive double is " + temp2);
	}
}
