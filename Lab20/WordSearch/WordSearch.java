import java.util.Scanner;
public class WordSearch {
	static String wordSeek;
	static String[][] puzzle;
	public static void main(String[] args) throws LineLengthException {
		if (args.length == 1) {
			wordSeek = args[0];
			puzzle = getPuzzle();
			System.out.println("Puzzle: ");
			printPuzzle();
			System.out.println("Solution: ");
			if (!forwardSearch(wordSeek) && !backSearch() && !topSearch(wordSeek) && !bottomSearch()) {
				System.out.println("NO MATCH! :()");
			} else {
				printPuzzle();
			}
		} else {
			System.err.println("ERROR! Expected one argument and got " + args.length);
		}
	}
	static String[][] getPuzzle() throws LineLengthException {
		Scanner scan = new Scanner(System.in);
		String[][] tempPuzzle = null;
		String firstLine = scan.nextLine().trim().toLowerCase();
		int size = firstLine.length();
		int count = 0;
		while (count < size - 1) {
			String tempLine = scan.nextLine().trim().toLowerCase();
			if (tempLine.length() != size) {
				throw new LineLengthException("Error! The length of the lines are not the same:()");
			}
			tempPuzzle[count + 1] = tempLine.split(" ");
			count++;
		}
		scan.close();
		return tempPuzzle;
	}
	static void printPuzzle() {
		for (String[] strings : puzzle) {
			for (int j = 0; j < puzzle.length; j++) {
				System.out.print(strings[j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("\n");
	}
	static void ConvertRowtoUpper(int row, int start, int end, boolean convertRows) {
		if (convertRows) {
			for (int i = start; i < end; i++) {
				puzzle[row][i] = puzzle[row][i].toUpperCase();
			}
		} else {
			for (int j = start; j < end; j++) {
				puzzle[j][row] = puzzle[j][row].toUpperCase();
			}
		}
	}
	static boolean forwardSearch(String word) {
		StringBuilder tempAns = new StringBuilder();
		for (int row = 0; row < puzzle.length; row++) {
			for (String x : puzzle[row])
				tempAns.append(x);
			int index = tempAns.indexOf(word);
			if (index >= 0) {
				ConvertRowtoUpper(row, index, index + word.length(), true);
				return true;
			} else {
				tempAns.delete(0, tempAns.length());
			}
		}
		return false;
	}
	static boolean backSearch() {
		StringBuilder sB = new StringBuilder(wordSeek);
		String reverseWord = sB.reverse().toString();
		return forwardSearch(reverseWord);
	}
	static boolean topSearch(String word) {
		StringBuilder tempAns = new StringBuilder();
		for (int col = 0; col < puzzle.length; col++) {
			for (String[] strings : puzzle) {
				tempAns.append(strings[col]);
			}
			int index = tempAns.indexOf(word);
			if (index >= 0) {
				ConvertRowtoUpper(col, index, index + word.length(), false);
				return true;
			} else {
				tempAns.delete(0, tempAns.length());
			}
		}
		return false;
	}
	static boolean bottomSearch() {
		StringBuilder tempAns = new StringBuilder(wordSeek);
		String reverseWord = tempAns.reverse().toString();
		return topSearch(reverseWord);
	}
}
