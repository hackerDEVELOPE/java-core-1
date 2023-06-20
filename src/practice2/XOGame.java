package practice2;

import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Human wins");
                break;
            }
            if (mapIsFull()) {
                System.out.println("Draw");
                break;
            }

            aiTurn();
            printMap();
            if ((checkWin(DOT_O))) {
                System.out.println("AI WunderVaffel wins");
                break;
            }
            if (mapIsFull()) {
                System.out.println("Draw");
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("input x, y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        aiAttack();

    }

    public static boolean mapIsFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean checkWin(char c) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (map[i][j] == c) {
                    count++;

                    for (int k = 1; k < DOTS_TO_WIN; k++) {
                        if (j + k < SIZE) {
                            if (map[i][j + k] == c) {
                                count++;
                                if (count == DOTS_TO_WIN) {
                                    return true;
                                }
                            }
                        }
                    }
                    count = 1;
                    for (int k = 1; k < DOTS_TO_WIN; k++) {
                        if (i + k < SIZE) {
                            if (map[i + k][j] == c) {
                                count++;
                                if (count == DOTS_TO_WIN) {
                                    return true;
                                }
                            }
                        }
                    }
                    count = 1;
                    for (int k = 1; k < DOTS_TO_WIN; k++) {
                        if (i + k < SIZE && j + k < SIZE) {
                            if (map[i + k][j + k] == c) {
                                count++;
                                if (count == DOTS_TO_WIN) {
                                    return true;
                                }
                            }
                        }
                    }
                    count = 1;
                    for (int k = 1; k < DOTS_TO_WIN; k++) {
                        if (i - k >= 0 && j + k < SIZE) {
                            if (map[i - k][j + k] == c) {
                                count++;
                                if (count == DOTS_TO_WIN) {
                                    return true;
                                }
                            }
                        }
                    }
                    count = 0;
                }
            }
        }
        return false;
    }

    public static void aiAttack() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        return;
                    }
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    } else map[i][j] = DOT_EMPTY;

                }
            }
        }
        aiRandomTurn();
    }

    public static void aiRandomTurn() {
        int x, y;
        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean aiDefenseTurn() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        return true;
                    } else map[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    public static boolean checkLine(int cy, int cx, int vy, int vx, char dot, int dotsToWin) {
        if (cx + vx * (dotsToWin - 1) > SIZE - 1 || cy + vy * (dotsToWin - 1) > SIZE - 1 || cy + vy * (dotsToWin - 1) < 0) {
            return false;
        }
        for (int i = 0; i < dotsToWin; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWinLines(char dot, int dotsToWin) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot, dotsToWin) ||
                        checkLine(i, j, 1, 0, dot, dotsToWin) ||
                        checkLine(i, j, 1, 1, dot, dotsToWin) ||
                        checkLine(i, j, -1, 1, dot, dotsToWin)) {
                    return true;
                }

            }
        }
        return false;
    }
}