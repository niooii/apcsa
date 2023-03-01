package Sudoku;

import java.util.Scanner;

class sudokuMain {

    public static char numToLetter(int a){
        char letter = 'Z';
        switch(a) {
            case 0:
                letter = 'A';
                break;
            case 1:
                letter = 'B';
                break;
            case 2:
                letter = 'C';
                break;
            case 3:
                letter = 'D';
                break;
            case 4:
                letter = 'E';
                break;
            case 5:
                letter = 'F';
                break;
            case 6:
                letter = 'G';
                break;
            case 7:
                letter = 'H';
                break;
            case 8:
                letter = 'I';
                break;
        }
        return letter;
    }
    public static int charToNum(char a){
        int num = -1;
        switch(a) {
            case 'A':
                num = 0;
                break;
            case 'B':
                num = 1;
                break;
            case 'C':
                num = 2;
                break;
            case 'D':
                num = 3;
                break;
            case 'E':
                num = 4;
                break;
            case 'F':
                num = 5;;
                break;
            case 'G':
                num = 6;
                break;
            case 'H':
                num = 7;
                break;
            case 'I':
                num = 8;
                break;
        }
        return num;
    }
    public static boolean fillBoard(int[][] board) {
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == 0) {
                    for(int num = 0; num < 9; num++) {
                        if(isValid(board, row, col, numbers[num])) {
                            board[row][col] = numbers[num];
                            playingBoard[row][col] = numbers[num];
                            if(fillBoard(board)) { //recursion stops when board filled
                                return true;
                            }else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void printSolvedBoard(int[][] board){
        System.out.println("    A B C   D E F   G H I");
        System.out.println("  ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        int temp = 0;
        char tempChar = numToLetter(temp);
        for(int i = 1; i <= 9; i++){
            System.out.print(tempChar + " | ");
            temp++;
            tempChar = numToLetter(temp);
            for(int j = 1; j <= 9; j++){
                System.out.print(board[i-1][j-1] + " ");
                if(j%3 == 0) System.out.print("| ");
            }
            System.out.println();
            if(i%3 == 0) System.out.println("  ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        }
    }

    public static void printStartingBoard(int[][] board){
        System.out.println("    A B C   D E F   G H I");
        System.out.println("  ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        int temp = 0;
        int isSame = -1;
        int whyisthisabug = 0;
        char tempChar = numToLetter(temp);
        for(int i = 1; i <= 9; i++){
            System.out.print(tempChar + " | ");
            temp++;
            tempChar = numToLetter(temp);
            for(int j = 1; j <= 9; j++){
                if(isSame != j/3){
                    isSame = j/3;
                    scrambleHiddenNumbers();
                }
                if(whyisthisabug < 2) {
                    if (numbersToHide[j % 3] == 0) {
                        System.out.print("  ");
                        playingBoard[i-1][j-1] = 0;
                        whyisthisabug++; //without this, program sometimes makes all three squares blank for no reason sometimes resulting in more than 6 blank squares
                    } else{
                        System.out.print(board[i - 1][j - 1] + " ");
                    }
                } else{
                    System.out.print(board[i - 1][j - 1] + " ");
                }

                if(j%3 == 0) {
                    System.out.print("| ");
                    whyisthisabug = 0;
                }
            }
            System.out.println();
            if(i%3 == 0) System.out.println("  ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        }
    }

    public static void displayBoard(int[][] board){
        System.out.println("    A B C   D E F   G H I");
        System.out.println("  ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        int temp = 0;
        char tempChar = numToLetter(temp);
        for(int i = 1; i <= 9; i++){
            System.out.print(tempChar + " | ");
            temp++;
            tempChar = numToLetter(temp);
            for(int j = 1; j <= 9; j++){
                if (playingBoard[i-1][j-1] == 0) {
                    System.out.print("  ");
                } else{
                    System.out.print(board[i - 1][j - 1] + " ");
                }
                if(j%3 == 0) System.out.print("| ");
            }
            System.out.println();
            if(i%3 == 0) System.out.println("  ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        }
    }

    public static void scrambleBoard(int[][] board){
        for(int i = 0; i < 9; i++){
            numbers[i] = 0;
        }
        int[] taken = new int[9];
        int temp = random();
        for(int i = 0; i < 9; i++){
            while(isTaken(taken, temp)){
                temp = random();
            }
            numbers[i] = temp;
            taken[i] = temp;
        }
        fillBoard(board);
    }

    public static boolean isTaken(int[] taken, int temp){
        for(int element : taken) {
            if(element == temp) {
                return true;
            }
        }
        return false;
    }

    public static int random(){
        return (int)((Math.random() * 9 + 1));
    }
    public static boolean isValid(int[][] board, int row, int col, int num) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == num) {
                return false;
            }
        }
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == num) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i+startRow][j+startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void fillNums(int[][] ogboard, int num){
        for(int i = 0; i < 9; i++){
            if(!(isTaken(playingBoard[i], num))){
                for(int j = 0; j < 9; j++){
                    if(ogboard[i][j] == num){
                        playingBoard[i][j] = num;
                        break;
                    }
                }
            }
        }
    }

    public static int[] numbersToHide = {1, 1, 1};
    public static int[] nth1 = {0, 0, 1};
    public static int[] nth2 = {0, 1, 0};
    public static int[] nth3 = {1, 0, 0};
    public static int[] nth4 = {1, 1, 0};
    public static int[] nth5 = {0, 1, 1};

    public static void resetBoards(int[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                playingBoard[i][j] = 0;
            }
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                board[i][j] = 0;
            }
        }
    }

    public static void scrambleHiddenNumbers(){
        int temp = (int)((Math.random() * 4 + 1));
        switch(temp){
            case 1:
                numbersToHide = nth1;
                break;
            case 2:
                numbersToHide = nth2;
                break;
            case 3:
                numbersToHide = nth3;
                break;
            case 4:
                numbersToHide = nth4;
                break;
            case 5:
                numbersToHide = nth5;
                break;
        }
        return;
    }

    public static int[][] playingBoard = new int[9][9];

    public static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        boolean cont = true;
        int[][] board = new int[9][9];
        int temp = -1;
        boolean isFinished = false;
        int tries = 3;
        boolean breakLoop = false;
        while(cont) {
            scrambleBoard(board);
            printSolvedBoard(board);
            printStartingBoard(board);
            String coords = "";
            char coord1 = 'z';
            char coord2 = 'z';
            Scanner sc = new Scanner(System.in);
            while (!isFinished && tries != 0) {
                coord1 = 'z';
                coord2 = 'z';
                System.out.println("Input the coordinates (row then column): ");
                coords = sc.next().substring(0, 2);
                coord1 = coords.charAt(0);
                coord2 = coords.charAt(1);
                System.out.println("Input your guess (tries remaining: " + tries + "): ");
                int num = sc.nextInt();
                if (board[charToNum(coord1)][charToNum(coord2)] == num) {
                    fillNums(board, num);
                    displayBoard(playingBoard);
                    System.out.println("correct guess!");
                    for (int array[] : playingBoard) {
                        for (int element : array) {
                            if (element == 0) {
                                breakLoop = true;
                                break;
                            }
                        }
                        if (breakLoop == true) break;
                    }
                    if (breakLoop == false) isFinished = true;
                } else {
                    tries -= 1;
                    System.out.println("wrong guess. Try again (tries remaining: " + tries + ").");
                }
                breakLoop = false;
            }
            if (isFinished) {
                System.out.println("You win! Try again? (y)");
            }
            if (tries == 0) {
                System.out.println("You ran out of tries! Try again? (y)");
            }
            if(sc.next().charAt(0) != 'y'){
                cont = false;
                System.out.println("Thanks for playing!");
            }
            tries = 3;
            temp = -1;
            isFinished = false;
            breakLoop = false;
            resetBoards(board);
        }


    }

}