package leetcode;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("ABC", 1));
    }

    public static String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int l = s.length();
        int stepUp = 0, stepDown = 2 * numRows - 2;
        if (l <= numRows || numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < l) {
                if (stepDown != 0) {
                    sb.append(s.charAt(j));
                    j += stepDown;
                }
                if (j < l) {
                    if (stepUp != 0) {
                        sb.append(s.charAt(j));
                        j += stepUp;
                    }
                }
            }
            stepUp += 2;
            stepDown -= 2;
        }
        return sb.toString();
    }
}
