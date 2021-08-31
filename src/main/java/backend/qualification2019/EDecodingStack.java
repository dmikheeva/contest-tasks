package backend.qualification2019;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://contest.yandex.ru/contest/12870/problems/E/
 */
public class EDecodingStack {
    private static int currentCount = 0;
    private static int count = 0;

    public static void main(String[] args) {
        EDecodingStack decodingStack = new EDecodingStack();
        System.out.println(decodingStack.countDecode());
    }

    private int countDecode() {
        List<Pair> charStack = new ArrayList<>();
        int step = 0;
        char charBuffer = 'H', c, newValue;
        try {
            while ((c = (char) System.in.read()) != '\n') {
                step++;
                switch (step) {
                    case 1:
                        charBuffer = 'H';
                        if (c != 'H') {
                            step = 0;
                            emptyStack(charStack);
                        }
                        break;
                    case 2:
                        if (checkChar(c)) {
                            charBuffer = c;
                        } else if (c == 'H') {
                            charStack.add(new Pair("H", currentCount));
                            step = 1;
                            charBuffer = 'H';
                        } else {
                            step = 0;
                            charBuffer = 'H';
                            emptyStack(charStack);
                            saveTotalAndZeroCurrentCount();
                        }
                        break;
                    case 3:
                        if (c == 'H') {
                            charStack.add(new Pair("H" + charBuffer, currentCount));
                            step = 1;
                            charBuffer = 'H';
                        } else if (c != '+') {
                            step = 0;
                            charBuffer = 'H';
                            emptyStack(charStack);
                            saveTotalAndZeroCurrentCount();
                        }
                        break;
                    case 4:
                        while (step == 4) {
                            if (checkChar(c)) {
                                newValue = getNumber(charBuffer, c);
                                currentCount++;
                                if (charStack.size() == 0) {
                                    if (newValue == 'H') {
                                        step = 1;
                                        charBuffer = 'H';
                                    } else {
                                        step = 0;
                                        charBuffer = 'H';
                                        saveTotalAndZeroCurrentCount();
                                    }
                                } else {
                                    if (checkChar(newValue)) {
                                        Pair last = charStack.remove(charStack.size() - 1);
                                        if (last.s.length() == 1) {
                                            charBuffer = newValue;
                                            currentCount += last.depth;
                                            step = 2;
                                        } else if (last.s.length() == 2) {
                                            step = 0;
                                            charBuffer = 'H';
                                            emptyStack(charStack);
                                            saveTotalAndZeroCurrentCount();
                                        } else {
                                            charBuffer = last.s.charAt(1);
                                            currentCount += last.depth;
                                            c = newValue;
                                            step = 4;
                                            saveTotalAndZeroCurrentCount();
                                        }
                                    } else if (newValue == 'H') {
                                        step = 1;
                                        charBuffer = 'H';
                                    } else if (newValue == '+') {
                                        Pair last = charStack.remove(charStack.size() - 1);
                                        if (last.s.length() == 2) {
                                            step = 3;
                                            currentCount += last.depth;
                                            charBuffer = last.s.charAt(1);
                                        } else {
                                            step = 0;
                                            charBuffer = 'H';
                                            emptyStack(charStack);
                                            saveTotalAndZeroCurrentCount();
                                        }
                                    } else {
                                        step = 0;
                                        charBuffer = 'H';
                                        emptyStack(charStack);
                                        saveTotalAndZeroCurrentCount();
                                    }
                                }
                            } else if (c == 'H') {
                                charStack.add(new Pair("H" + charBuffer + "+", currentCount));
                                step = 1;
                                charBuffer = 'H';
                                saveTotalAndZeroCurrentCount();
                            } else {
                                step = 0;
                                charBuffer = 'H';
                                emptyStack(charStack);
                                saveTotalAndZeroCurrentCount();
                            }
                        }
                        break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Math.max(count, currentCount);
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

    private static void saveTotalAndZeroCurrentCount() {
        count = Math.max(currentCount, count);
        currentCount = 0;
    }

    private void emptyStack(List<Pair> stack) {
        int maxInStack = stack.stream().max(Comparator.comparing(Pair::getDepth)).orElse(new Pair("H", 0)).getDepth();
        count = Math.max(count, maxInStack);
        stack.clear();
    }

    private void flush() {

    }

    class Pair {
        String s;
        int depth;

        Pair(String s, int depth) {
            this.s = s;
            this.depth = depth;
        }

        private int getDepth() {
            return this.depth;
        }
    }

}

