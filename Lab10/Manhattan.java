public class Manhattan {
        public static void main(String[] args) {
                final double INITIAL_DEPOSIT = 24;
                final double INTEREST = 0.08;
                double total = INITIAL_DEPOSIT;
                for(int i = 0; i <= 398; i++) {
                        total = (1 + INTEREST) * total;
                }
                System.out.println(total);
        }
}
