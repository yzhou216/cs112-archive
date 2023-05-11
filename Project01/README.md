# Wordle

Wordle is a clone and reimplementation of the New York Times Wordle
using Java.

## Class Design

- Wordle

    Main logic and algorithm of the program. This is where the program
    handles the user input and compares it with the word grabbed from
    word.txt file.

- Word

    Reads and stores the words from the file for later use in the Wordle
    class.

- Color

    Abstract the color highlighting of the text into methods with the
    ANSI escape sequences.

## Pseudocode

- Wordle

        FOR every try in six total tries

            IF guess_word matches word
                highlight guess_word in green
            ELSE IF the letter in guess_word matches the corresponding letter in word
                highlight letters in green
            ELSE IF the letter in guess_word is not present in word
                highlight letters in red
            ELSE
                highlight letters in yellow
            ENDIF

        ENDFOR

- Word

        LIST words := GET words.txt
        DO
            index := RANDOM in range of words index
        WHILE index ≠ 5
        word := index at words

