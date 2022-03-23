package yandex.cup;

import java.util.*;

public class PlatesTask {
    private static char[][] a;
    private static int n;
    private static int m;
    private static Map<String, Integer> plates;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        plates = new LinkedHashMap<>();
        List<Integer> platesNums = new ArrayList<>();
        String s1, s2, s;
        Plate p;
        for (int i = 0; i < k; i++) {
            s1 = sc.next();
            s2 = sc.next();
            s = s1 + s2;
            if (plates.containsKey(s)) {
                plates.put(s, plates.get(s) + 1);
            } else {
                s = rotate(s);
                if (plates.containsKey(s)) {
                    plates.put(s, plates.get(s) + 1);
                } else {
                    s = rotate(s);
                    if (plates.containsKey(s)) {
                        plates.put(s, plates.get(s) + 1);
                    } else {
                        s = rotate(s);
                        if (plates.containsKey(s)) {
                            plates.put(s, plates.get(s) + 1);
                        } else {
                            plates.put(s, 1);
                        }
                    }
                }
            }
        }
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            s1 = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s1.charAt(j);
            }
        }
        System.out.println(canMatchEverything(0, 0, plates) ? "Yes" : "No");
    }

    private static boolean canMatchEverything(int i, int j, Map<String, Integer> plates) {
        if (i + 2 == n && j + 2 == m) {
            return matchPlates(i, j, plates).size() > 0;
        }
        List<String> matchPlates = matchPlates(i, j, plates);
        if (matchPlates.size() == 0) {
            return false;
        }
        int newI, newJ;
        if (j + 2 < m) {
            newI = i;
            newJ = j + 2;
        } else {
            newI = i + 2;
            newJ = 0;
        }
        for (String plate : matchPlates) {
            plates.put(plate, plates.get(plate) - 1);
            if (canMatchEverything(newI, newJ, plates)) {
                return true;
            }
            plates.put(plate, plates.get(plate) + 1);
        }
        return false;
    }

    private static List<String> matchPlates(int i, int j, Map<String, Integer> plates) {
        List<String> res = new ArrayList<>();
        for (String pNum : plates.keySet()) {
            if (plates.get(pNum) > 0) {
                if (anyMatch(i, j, pNum)) {
                    res.add(pNum);
                }
            }
        }
        return res;
    }

    private static boolean anyMatch(int i, int j, String sPlate) {
        // можно ли установить плитку на квадрат с левым верхним углом в ij
        Plate plate = new Plate(sPlate.charAt(0), sPlate.charAt(1), sPlate.charAt(2), sPlate.charAt(3));
        if (exactMatch(i, j, plate)) {
            return true;
        }
        if (isSimplePlate(plate)) {
            return false;
        }
        if (exactMatch(i, j, rotate(plate))) {
            return true;
        }
        if (isOneRotatePlate(plate)) {
            return false;
        }
        if (exactMatch(i, j, rotate(plate))) {
            return true;
        }
        if (exactMatch(i, j, rotate(plate))) {
            return true;
        }
        return false;
    }

    private static Plate rotate(Plate plate) {
        char tmp = plate.getC1();
        plate.c1 = plate.getC3();
        plate.c3 = plate.getC4();
        plate.c4 = plate.getC2();
        plate.c2 = tmp;
        return plate;
    }

    private static String rotate(String plate) {
        StringBuilder sb = new StringBuilder();
        sb.append(plate.charAt(2)).append(plate.charAt(0)).append(plate.charAt(3)).append(plate.charAt(1));
        return sb.toString();
    }

    private static boolean isSimplePlate(Plate plate) {
        return plate.getC1() == plate.getC2() &&
                plate.getC1() == plate.getC3() &&
                plate.getC1() == plate.getC4();
    }

    private static boolean isOneRotatePlate(Plate plate) {
        return (plate.getC1() == plate.getC4() && plate.getC2() == plate.getC3());
    }

    private static boolean exactMatch(int i, int j, Plate plate) {
        return ((a[i][j] == plate.getC1())
                && (a[i][j + 1] == plate.getC2())
                && (a[i + 1][j] == plate.getC3())
                && (a[i + 1][j + 1] == plate.getC4()));
    }

    private static class Plate {
        char c1;
        char c2;
        char c3;
        char c4;

        Plate(char c1, char c2, char c3, char c4) {
            this.c1 = c1;
            this.c2 = c2;
            this.c3 = c3;
            this.c4 = c4;
        }

        public char getC1() {
            return c1;
        }

        public char getC2() {
            return c2;
        }

        public char getC3() {
            return c3;
        }

        public char getC4() {
            return c4;
        }


    }
}


/*
4
        WW
        WB
        WW
        BW
        BW
        WW
        WB
        WW
        2 2
        BB
        BB*/
