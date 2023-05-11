public class Root {
        public static void main(String[] args) {
                try {
                        final double ORIGINAL_INPUT = Double.parseDouble(args[0]);
                        checkInput(ORIGINAL_INPUT);
                        double low = 0.0;
                        double high = ORIGINAL_INPUT;
                        double avg = Double.sum(low, high) / 2;
                        while(high - low > Double.MIN_VALUE * low) {
                                if(Math.pow(avg, 2) > ORIGINAL_INPUT) {
                                        high = avg;
                                } else if(Math.pow(avg, 2) < ORIGINAL_INPUT) {
                                        low = avg;
                                } else {
                                        low = avg;
                                        high = avg;
                                }
                                avg = Double.sum(low, high) / 2;
                        }
                        System.out.println(avg);
                } catch (ArrayIndexOutOfBoundsException exception) {
                        System.err.println("ERROR. No argument input.");
                } catch (NumberFormatException exception) {
                        System.err.println("ERROR. Non-numeric input.");
                } catch (InputLessThanZeroException exception) {
                        System.err.println("ERROR. Negative input.");
                }
        }
        static void checkInput(double input)throws InputLessThanZeroException {
                if(input < 0)
                        throw new InputLessThanZeroException();
        }
}
