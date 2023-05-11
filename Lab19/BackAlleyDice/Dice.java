public class Dice {
        private int randomIntFromOneThroughSeven() {
                return (int) (Math.random() * 6 + 1);
        }
        private int score;
        private int numOfDice;
        public Dice() {
                this.numOfDice = 1;
        }
        public Dice(int numOfDice) {
                this.numOfDice = numOfDice;
        }
        public void roll() {
                score = 0;
                for(int i = 0; i <= numOfDice-1; i++) {
                        score += randomIntFromOneThroughSeven();
                }
        }
        public int getScore() {
                return score;
        }
}
