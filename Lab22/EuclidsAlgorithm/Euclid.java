public class Euclid {
        public static void main(String[] args) {
                try {
                        System.out.println(greatestCommonFactor(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
                } catch(NumberFormatException exception) {
                        System.err.println(exception);
                }
        }
        private static int greatestCommonFactor(int x, int y) {
                if(x == 0)
                        return y;
                return greatestCommonFactor(y % x, x);
        }
}
