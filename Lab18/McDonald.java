public class McDonald {
        private static int randomIntFromZeroThroughFour() {
                return (int) (5 * Math.random());

        }
        private static Animal randomAnimal() {
                switch(randomIntFromZeroThroughFour()) {
                        case 0:
                                return new Dog();
                        case 1:
                                return new Bee();
                        case 2:
                                return new Pig();
                        case 3:
                                return new Sheep();
                        case 4:
                                return new Cow();
                }
                return null;
        }
	public static void main(String[] args) {
                for(int i = 0; i <= 9; i++) {
                        randomAnimal().writeVerse();
                        System.out.println();
                }
        }
}
