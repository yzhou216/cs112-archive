public class ReverseString {
	public static void main(String[] args) {
                char[] reversedStrArr = reverseString(args[0]);
                for(int i = 0; i <= reversedStrArr.length-1; i++) {
                        System.out.println(reversedStrArr[i]);
                }
	}
        private static char[] reverseString(String str) {
                String reversedStr = new StringBuffer(str).reverse().toString();
                char[] reversedStrArr = new char[str.length()];
                for(int i = 0; i <= str.length()-1; i++) {
                        reversedStrArr[i] = reversedStr.charAt(i);
                }
                return reversedStrArr;
        }
}
