public class Player {
        private int balance;
        private int betAmount;
        public Player() {
                this.balance = 20;
        }
        public Player(int startingBalance) {
                this.balance = startingBalance;
        }
        public void placeBet() {
                this.betAmount = 1;
                balance--;
        }
        public void placeBet(int betAmount) {
                this.betAmount = betAmount;
                balance = balance - betAmount;
        }
        public int getBalance() {
                return balance;
        }
        public void setBalance(int newBalance) {
                this.balance = newBalance;
        }
        public int getBetAmount() {
                return betAmount;
        }
}
