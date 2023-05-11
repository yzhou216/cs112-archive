public class BackAlley {
        public static void main(String[] args) {
                Dice twoDices = new Dice(2);
                Player player = new Player();
                int point;
                do {
                        player.placeBet();
                        twoDices.roll();
                        switch(twoDices.getScore()) {
                                case 7:
                                case 11:
                                        player.setBalance(2 * player.getBetAmount() + player.getBalance());
                                        System.out.println("$" + player.getBalance() + " win");
                                        break;
                                case 2:
                                case 3:
                                case 12:
                                        System.out.println("$" + player.getBalance() + " lose");
                                        break;
                                default:
                                        point = twoDices.getScore();
                                        do {
                                                twoDices.roll();
                                                if(twoDices.getScore() == 7) {
                                                                System.out.println("$" + player.getBalance() + " lose");
                                                                break;
                                                } else if(twoDices.getScore() == point) {
                                                                player.setBalance(2 * player.getBetAmount() + player.getBalance());
                                                                System.out.println("$" + player.getBalance() + " win");
                                                                break;
                                                }
                                        } while(true);
                        }
                } while(player.getBalance() > 0);
        }
}
