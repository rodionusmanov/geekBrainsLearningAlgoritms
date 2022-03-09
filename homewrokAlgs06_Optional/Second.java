package homewrokAlgs06_Optional;

import java.util.Scanner;

public class Second {
    static Scanner in = new Scanner(System.in);
    static final int ROWS = 5;
    static final int COLUMNS = 30;
    static int[][] snailArray = initArray();
    static int currentDirection = 0;

    public static void main(String[] args) {
        boolean validSize = true;
        System.out.printf("%sx%s%n", COLUMNS, ROWS);
        if (ROWS <= 0 || COLUMNS <= 0) {
            System.out.println("Ошибка!");
            validSize = false;
        }

        if (validSize) {
            drawArray(snailArray);
            int arraySize = ROWS * COLUMNS;
            int formatNumber = takeFormat(arraySize);
            int count = 1;
            int[] rowCol = {0, -1};
            while (count < arraySize + 1) {
                nextDirection(rowCol);
                rowCol = insertNumber(rowCol, count);
                count++;
            }
            displayArray(formatNumber);
        }
    }

    private static int[] insertNumber(int[] rowCol, int count) {
        switch (currentDirection % 4) {
            case 0:
                rowCol = toRight(rowCol, count);
                break;
            case 1:
                rowCol = toBottom(rowCol, count);
                break;
            case 2:
                rowCol = toLeft(rowCol, count);
                break;
            case 3:
                rowCol = toTop(rowCol, count);
                break;
        }
        return rowCol;
    }

    private static void nextDirection(int[] rowCol) {
        boolean notCorrectNextDirection = true;
        while (notCorrectNextDirection) {
            switch (currentDirection % 4) {
                case 0:
                    if (rowCol[1] + 1 < COLUMNS) {
                        if (snailArray[rowCol[0]][rowCol[1] + 1] < 1) {
                            notCorrectNextDirection = false;
                            break;
                        }
                    }
                    currentDirection++;
                    break;
                case 1:
                    if (rowCol[0] + 1 < ROWS) {
                        if (snailArray[rowCol[0] + 1][rowCol[1]] < 1) {
                            notCorrectNextDirection = false;
                            break;
                        }
                    }
                    currentDirection++;
                    break;
                case 2:
                    if (rowCol[1] - 1 >= 0) {
                        if (snailArray[rowCol[0]][rowCol[1] - 1] < 1) {
                            notCorrectNextDirection = false;
                            break;
                        }
                    }
                    currentDirection++;
                    break;
                case 3:
                    if (rowCol[0] - 1 >= 0) {
                        if (snailArray[rowCol[0] - 1][rowCol[1]] < 1) {
                            notCorrectNextDirection = false;
                            break;
                        }
                    }
                    currentDirection++;
                    break;
            }
        }
    }


    private static void displayArray(int formatNumber) {
        for (int i = 0; i < ROWS; i++) {
            System.out.println();
            for (int j = 0; j < COLUMNS; j++) {
                int devider = 10;
                for (int k = 1; k < formatNumber; k++) {
                    if (snailArray[i][j] / devider == 0) {
                        System.out.print(" ");
                    }
                    devider *= 10;
                }
                System.out.print(snailArray[i][j] + " ");
            }
        }
    }

    private static int[] toRight(int[] rowCol, int count) {
        rowCol[1]++;
        snailArray[rowCol[0]][rowCol[1]] += count;
        return rowCol;
    }

    private static int[] toBottom(int[] rowCol, int count) {
        rowCol[0]++;
        snailArray[rowCol[0]][rowCol[1]] += count;
        return rowCol;
    }

    private static int[] toLeft(int[] rowCol, int count) {
        rowCol[1]--;
        snailArray[rowCol[0]][rowCol[1]] += count;
        return rowCol;
    }

    private static int[] toTop(int[] rowCol, int count) {
        rowCol[0]--;
        snailArray[rowCol[0]][rowCol[1]] += count;
        return rowCol;
    }

    private static int takeFormat(int arraySize) {
        int formatNumber = 0;
        while (arraySize > 0) {
            arraySize /= 10;
            formatNumber++;
        }
        return formatNumber;
    }

    private static void drawArray(int[][] snailArray) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(snailArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] initArray() {
        int[][] snailArray = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                snailArray[i][j] = 0;
            }
        }
        return snailArray;
    }


}
