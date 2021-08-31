package backend.qualification2019;

import java.io.IOException;
import java.io.InputStream;

/* https://contest.yandex.ru/contest/12870/problems/E/
 */
public class EDecodingRecursion2 {
    private InputStream sysIn = System.in;
    private int count = 0;

    public static void main(String[] args) throws IOException {
        EDecodingRecursion2 eDecodingRecursion = new EDecodingRecursion2();
        System.out.println(eDecodingRecursion.getCount(false).depth);
    }

    private Pair getCount(boolean recursionFlag) throws IOException {
        char c, x = '!';
        int step = recursionFlag ? 1 : 0, currentCount = 0;
        while ((c = (char) sysIn.read()) != '\n') {
            step++;
            if (c == 'H') {
                if (step == 1) {
                    continue;
                }
                Pair p = getCount(true);
                currentCount += p.getDepth();
                while (p.getChar() == 'H') {
                    currentCount += p.getDepth();
                    p = getCount(true);
                }
                if (step == 2) {
                    if (!checkChar(p.getChar())) {
                        if (recursionFlag) {
                            return new Pair('!', currentCount);
                        } else {
                            step = 0;
                            count = Math.max(count, currentCount);
                            currentCount = 0;
                        }
                    } else {
                        x = p.getChar();
                    }
                } else if (step == 3) {
                    if (!(p.getChar() == '+')) {
                        if (recursionFlag) {
                            return new Pair('!', currentCount);
                        } else {
                            step = 0;
                            count = Math.max(count, currentCount);
                            currentCount = 0;
                        }
                    }
                } else if (step == 4) {
                    if (checkChar(p.getChar())) {
                        if (recursionFlag) {
                            return new Pair(getNumber(x, p.getChar()), currentCount + 1);
                        } else {
                            currentCount ++;
                            if (getNumber(x, p.getChar()) == 'H') {
                                step = 1;
                            } else {
                                step = 0;
                                count = Math.max(count,currentCount);
                                currentCount = 0;
                            }
                        }

                    } else {
                        if (recursionFlag) {
                            return new Pair('!', currentCount);
                        } else {
                            step = 0;
                            count = Math.max(count, currentCount);
                            currentCount = 0;
                        }
                    }
                }
            } else if (c == '+') {
                if (step != 3) {
                    if (recursionFlag) {
                        return new Pair('!', 0);
                    } else {
                        step = 0;
                        currentCount = 0;
                    }
                }
            } else if (checkChar(c)) {
                if (step == 2) {
                    x = c;
                } else if (step == 4) {
                    if (recursionFlag) {
                        return new Pair(getNumber(x, c), currentCount + 1);
                    } else {
                        currentCount ++;
                        if (getNumber(x, c) == 'H') {
                            step = 1;
                            count = Math.max(count,currentCount);
                        } else {
                            step = 0;
                            count = Math.max(count,currentCount);
                            currentCount = 0;
                        }
                    }
                } else {
                    if (recursionFlag) {
                        return new Pair('!', 0);
                    } else {
                        step = 0;
                        currentCount = 0;
                    }
                }
            } else {
                if (recursionFlag) {
                    return new Pair('!', 0);
                } else {
                    step = 0;
                    currentCount = 0;
                }
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
