public class Fractions {
        public static void main(String[] args) {
                for(int i = 0; i <= args.length-1; i++) {
                        String substrings[] = args[i].split("/", 2);
                        double substringNums[] = new double[2];
                        for(int v = 0; v <= 1; v++) {
                                try {
                                        substringNums[v] = Double.parseDouble(substrings[v]);
                                } catch (NumberFormatException exception) {
                                        System.err.println("ERROR. Input format.");
                                        return;
                                }
                        }
                        System.out.println(substringNums[0] / substringNums[1]);
                }
        }
}
