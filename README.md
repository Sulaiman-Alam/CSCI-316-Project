# CSCI-316-Project

The first part of this project is to design and implement a Lexical Analyzer for a subset of the Pascal Programming Language. Your program should be able to accept as input a file containing statements in Pascal and correctly perform a lexical analysis of each statement. YOU JUST NEED TO USE THE WORDS INCLUDED IN THE TEXT FILE. YOU CAN NAME YOUR OWN “TOKENS” FOR THE “LEXEMES”.

Samples of the output and sample C code for a lexical analyzer for tokens and lexemes can be found in the textbook Chapter 4.2. You don’t have to use the numeric codes from the book; you can use your own “tokens”.

## Part 1

1. You will need to create a list (some structure to store) of the reserved words for Java that will be needed for an “if-else” type of conditional branch statement. (We worked on the BNF/EBNF in class.)
2. You will need to create a list of various operators used in Java by category, for example <i>token ASSIGN_OP lexeme =</i>
3. You will need to create a list of acceptable characters for variables and constants.(Again, just for the code given to you, including a couple of identifiers that don’t work!)
4. You will need to write code to test the validity of identifiers (like the state diagrams from class). If a string does not match any of the categories, you should indicate that as UNKNOWN.

## Part 2

5. You should write a method for each grammar rule and use a “recursive-descent” style in your program.

Your program only has to recognize (accept/reject) the types of statements in the input.txt file, not an entire program. You do not have to do “type-checking” (attribute grammar) rules – just simple lexicon and syntax.

I am setting up 2 submission files, one for each part. You can submit it all as one project or at 2 separate times. If you submit separately, it will still receive the grade for both parts (a total of 20% of your grade).

### Note

YOU ARE NOT WORRIED ABOUT FIXING THE ERRORS – YOU ARE JUST BREAKING DOWN THE INDIVIDUAL LINES BY LEXEME AND THEN SEEING IF THE LINES MATCH BASIC STATEMENT TYPES (ARITH_EXP, IF_EXP, etc.)
