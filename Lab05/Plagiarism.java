public class Plagiarism {
        public static void main(String[] args) {
                WordCounter words = new WordCounter(args[0]);
                double percentageOfTheWords = (double) words.getNumberOfThe() / words.getNumberOfWords() * 100;
                double percentageOfAOrAnWords = (double) words.getNumberOfAOrAn() / words.getNumberOfWords() * 100;
                /* round the percentages to integers from double */
                System.out.println("Percentage of THE words is " + (int) Math.round(percentageOfTheWords));
                System.out.println("Percentage of A or AN words is " + (int) Math.round(percentageOfAOrAnWords));
        }
}
