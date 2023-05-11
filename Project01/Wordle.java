import java.io.IOException;
import java.util.Scanner;
public class Wordle {
        private static Word targetWord;
        public static void main(String[] args) throws IOException {
                targetWord = new Word();
                String wordGuess;
                Scanner scan = new Scanner(System.in);
                startGameUserPrompt();
                for(int guess = 0; guess <= 5; guess++) {
                        do {
                                System.out.print("guess " + (guess+1) + ": ");
                                wordGuess = scan.nextLine().toLowerCase();
                                if(wordGuess.contains(" ") || !isAlpha(wordGuess))
                                        System.out.println("Your guess can not contain space(s) and/or non-Unicode letter(s).");
                                else if(wordGuess.length() != 5)
                                        System.out.println("Your guess must be 5 letters long.");
                        } while(wordGuess.contains(" ") || wordGuess.length() != 5 || !isAlpha(wordGuess));
                        if(isMatched(wordGuess)) {
                                System.out.println(Color.highlightInGreen(wordGuess));
                                scan.close();
                                System.out.println("Congrats! You guessed it!");
                                System.exit(0);
                        } else if(isCheatCode(wordGuess)) {
                                System.out.println(targetWord.getWord());
                                guess--;
                        } else {
                                for(int i = 0; i <= 4; i++) {
                                        if(isCorrectPlace(wordGuess.charAt(i), i))
                                                System.out.print(Color.highlightInGreen(Character.toString(wordGuess.charAt(i))));
                                        else if(isMisplaced(wordGuess.charAt(i)) && duplicatedCaseCheck(i, wordGuess))
                                                System.out.print(Color.highlightInYellow(Character.toString(wordGuess.charAt(i))));
                                        else
                                                System.out.print(Color.highlightInRed(Character.toString(wordGuess.charAt(i))));
                                }
                                System.out.println();
                        }
                }
                scan.close();
                System.out.println("Sorry! Better luck next time!");
                System.out.println("The answers is " + targetWord.getWord() + ".");
        }
        private static void startGameUserPrompt() {
                System.out.print("\033[H\033[2J"); /* clear screen */
                System.out.flush();
                System.out.println("Welcome to Wordle!");
                System.out.println("The mystery word is a 5-letter English word.\n");
                System.out.println("A correct letter turns " + Color.highlightInGreen("  ") + ".");
                System.out.println("A correct letter in the wrong place turns " + Color.highlightInYellow("  ") + ".");
                System.out.println("An incorrect letter turns " + Color.highlightInRed("  ") + ".");
                System.out.println("You have 6 chances to guess it.\n");
        }
        private static boolean isCheatCode(String word) {
                return word.equals("subbu");
        }
        private static boolean isMatched(String word) {
                return word.equals(targetWord.getWord());
        }
        private static boolean isCorrectPlace(char letter, int index) {
                return letter == targetWord.getWord().charAt(index);
        }
        private static boolean isMisplaced(char letter) {
                return targetWord.getWord().contains(Character.toString(letter));
        }
        private static boolean isAlpha(String word) {
                char[] chars = word.toCharArray();
                for (char c : chars) {
                        if(!Character.isLetter(c))
                                return false;
                }
                return true;
        }
        /* Check if a misplaced letter should be displayed as a
         * misplaced letter or an incorrect letter according to the
         * official rule of wordle. */
        private static boolean duplicatedCaseCheck(int index, String wordGuess) {
                char letter = wordGuess.charAt(index);
                int numOfLetterInTargetWord = 0;
                int numOfLetterInGuessWordUpToIndex = 0;
                int numOfCorrectLetterInTargetWord = 0;
                int numOfCorrectLetterInGuessWordUpToIndex = 0;
                int totalMisplaced;
                for(int i = 0; i <= 4; i++) {
                        if(targetWord.getWord().charAt(i) == letter)
                                numOfLetterInTargetWord++;
                        if(targetWord.getWord().charAt(i) == wordGuess.charAt(i) && wordGuess.charAt(i) == letter)
                                numOfCorrectLetterInTargetWord++;
                }
                for(int i = 0; i <= index; i++) {
                        if(wordGuess.charAt(i) == letter)
                                numOfLetterInGuessWordUpToIndex++;
                        if(targetWord.getWord().charAt(i) == wordGuess.charAt(i) && wordGuess.charAt(i) == letter)
                                numOfCorrectLetterInGuessWordUpToIndex++;
                }
                totalMisplaced = numOfLetterInGuessWordUpToIndex - numOfCorrectLetterInGuessWordUpToIndex;
                return totalMisplaced + numOfCorrectLetterInTargetWord <= numOfLetterInTargetWord;
        }
}
