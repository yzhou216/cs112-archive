public class WordCounter {
        private String str = "";
        private String[] words;
        public WordCounter(String str)  {
                /* append all the words in the string to the array and get rid of the punctuations */
                this.str = str.replaceAll("[!?,]", "");
                words = str.split("\\s+");
        }
        public int getNumberOfWords() {
                return words.length; 
        }
        public int getNumberOfThe() {
                int count = 0;
                for(int i = 0; i <= words.length-1; i++) {
                        if(words[i].toLowerCase().equals("the"))
                                count++;
                        
                }
                return count;
        }
        public int getNumberOfAOrAn() {
                int count = 0;
                for(int i = 0; i <= words.length-1; i++) {
                        if(words[i].toLowerCase().equals("a") || words[i].toLowerCase().equals("an"))
                                count++;
                }
                return count;
        }
}
