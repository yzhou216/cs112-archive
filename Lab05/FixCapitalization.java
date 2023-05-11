public class FixCapitalization {
        public static void main(String[] args) {
                int i = 0;
                while(i <= args[0].length()-1) {
                        switch(i) {
                                case 0:
                                        args[0] = immuteString(args[0], i, charOfStrToUpperCase(args[0], i));
                                        /* convert to lower case if index 1 is not a space and is a unicode letter */
                                        if(args[0].charAt(i+1) != ' ' && Character.isLetter(args[0].charAt(i+1)))
                                                args[0] = immuteString(args[0], i+1, charOfStrToLowerCase(args[0], i+1));
                                        i+=2;
                                        break;
                                default:
                                        /* convert to uppercase if the one previous index is a space and two index before dertermines as a complete sentence */
                                        if(args[0].charAt(i-1) == ' ' && isASentence(args[0].charAt(i-2)) && Character.isLetter(args[0].charAt(i)))
                                                args[0] = immuteString(args[0], i, charOfStrToUpperCase(args[0], i));
                                        else
                                                args[0] = immuteString(args[0], i, charOfStrToLowerCase(args[0], i));
                                        
                                        i++;
                                        break;
                        }
                }
                System.out.println(args[0]);
        }
        public static String immuteString(String str, int i, char ch) {
                return str.substring(0, i) + ch + str.substring(i+1);
        }
        public static char charOfStrToUpperCase(String str, int i) {
                String oneCharStr = Character.toString(str.charAt(i));
                String upperCaseOneCharStr = oneCharStr.toUpperCase();
                return upperCaseOneCharStr.charAt(0);
        }
        public static char charOfStrToLowerCase(String str, int i) {
                String oneCharStr = Character.toString(str.charAt(i));
                String lowerCaseOneCharStr = oneCharStr.toLowerCase();
                return lowerCaseOneCharStr.charAt(0);
        }
        public static boolean isASentence(char ch) {
                return ch == '.' || ch == '!' || ch == '?';
        }
}
