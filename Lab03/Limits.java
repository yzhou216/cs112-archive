/* Determine the smallest value of a data type by assigning a larger memory
 * size data type to a smaller memory size data type and reassigning it back
 * to its original data type. */
public class Limits {
	public static void main(String[] args) {
		short var0 = 0;
		byte temp0 = (byte) var0;
		short var1 = temp0;
		while(var0 == var1) {
			var0++;
			temp0 = (byte) var0;
			var1 = temp0;
		}
		var0--; // adjust the maxmium byte value
		System.out.println("Maximum byte value is " + var0);
		System.out.println("Minimum byte value is " + var1);

		int var2 = 0;
                short temp1 = (short) var2;
                int var3 = temp1;  
                while(var2 == var3) {
                        var2++;                                         
                        temp1 = (short) var2;
                        var3 = temp1;
                }
		var2--; // adjust the maxmium short value
		System.out.println("Maximum shot value is " + var2);
		System.out.println("Minimum shot value is " + var3);

		long var4 = 0;
                int temp2 = (int) var4;
                long var5 = temp2;
                while(var4 == var5) {
                        var4++;
                        temp2 = (int) var4;
                        var5 = temp2;
                }
		var4--; // adjust the maxmium int value
		System.out.println("Maximum int value is " + var4);
		System.out.println("Minimum int value is " + var5);
	}
}
