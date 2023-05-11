public class Color {
        /* ANSI escape sequences
         * compatible with UNIX-like systems and Windows 10 version 1511+ */
        public static final String ANSI_WHITE_TEXT = "\u001B[37m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_RESET = "\u001B[0m";
        public static String highlightInRed(String str) {
                return ANSI_RED_BACKGROUND + ANSI_WHITE_TEXT + str + ANSI_RESET;
        }
        public static String highlightInGreen(String str) {
                return ANSI_GREEN_BACKGROUND + ANSI_WHITE_TEXT + str + ANSI_RESET;
        }
        public static String highlightInYellow(String str) {
                return ANSI_YELLOW_BACKGROUND + ANSI_WHITE_TEXT + str + ANSI_RESET;
        }
}
