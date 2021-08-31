package backend.qualification2019;

import java.io.IOException;
import java.io.InputStream;

/* https://contest.yandex.ru/contest/12870/problems/E/
 */
public class EDecodingRecursion {
    private InputStream sysIn = System.in;
    private int count = 0;

    public static void main(String[] args) throws IOException {
        EDecodingRecursion eDecodingRecursion = new EDecodingRecursion();
        System.out.println(eDecodingRecursion.getCount(false).depth);
    }

    private Pair getCount(boolean recursionFlag) throws IOException {
        char c, x = '!';
        int step = recursionFlag ? 1 : 0, currentCount = 0;
        while ((c = (char) sysIn.read()) != '\n') {
            step++;
            switch (step) {
                case 1:
                    if (c != 'H') {
                        currentCount = 0;
                        if (recursionFlag) {
                            return new Pair('!', 0);
                        } else {
                            step = 0;
                        }
                    }
                    break;
                case 2:
                    if (c == 'H') {
                        Pair p = getCount(true);
                        currentCount += p.depth;
                        /*if (recursionFlag) {
                            return p;
                        } else {
                            currentCount += p.depth;
                        }*/
                        if (!checkChar(p.getChar())) {
                            if (recursionFlag) {
                                return new Pair('!', currentCount);
                            } else {
                                step = 0;
                                currentCount = 0;
                            }
                        }

                    } else if (checkChar(c)) {
                        x = c;
                    } else {
                        if (recursionFlag) {
                            return new Pair('!', 0);
                        } else {
                            currentCount = 0;
                            step = 0;
                        }
                    }
                    break;
                case 3:
                    if (c == 'H') {
                        Pair p = getCount(true);
                        currentCount += p.depth;
                        /*if (recursionFlag) {
                            return p;
                        } else {
                            currentCount += p.depth;
                        }*/
                    } else if (c != '+') {
                        if (recursionFlag) {
                            return new Pair('!', 0);
                        } else {
                            currentCount = 0;
                            step = 0;
                        }
                    }
                    break;
                case 4:
                    if (c == 'H') {
                        //H0+3H
                        Pair p = getCount(true);
                        if (recursionFlag) {
                            return new Pair('H', currentCount + p.depth);
                        } else {
                            currentCount += p.depth;
                        }
                    } else if (checkChar(c)) {
                        if (recursionFlag) {
                            return new Pair(getNumber(x, c), 1);
                        } else {
                            step = 0;
                            currentCount = 0;
                            count = Math.max(count, currentCount);
                        }
                    } else {
                        if (recursionFlag) {
                            return new Pair('!', 0);
                        } else {
                            step = 0;
                            currentCount = 0;
                        }
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Wrong step!");
            }
        }
        return new Pair('!', Math.max(count, currentCount));
    }

    private static Character getNumber(char c1, char c2) {
        return (char) (16 * getAsciCode(c1) + getAsciCode(c2));
    }

    private static int getAsciCode(Character ch) {
        if (Character.isDigit(ch)) {
            return Character.getNumericValue(ch);
        }
        return 10 + (Character.toUpperCase(ch) - 'A');
    }

    private static boolean checkChar(char c) {
        return (c >= '0' && c <= '9') ||
                (c >= 'a' && c <= 'f') ||
                (c >= 'A' && c <= 'F');
    }

    class Pair {
        char c;
        int depth;

        Pair(char c, int depth) {
            this.c = c;
            this.depth = depth;
        }

        private int getDepth() {
            return this.depth;
        }

        private char getChar() {
            return this.c;
        }
    }

}
