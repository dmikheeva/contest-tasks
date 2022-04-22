import java.util.Scanner;

//если школа стоит между городами то суммарное расстояние либо нарастает либо убывает  -> можно смотреть в точках где школы

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        long curSum = 0L;
        long minSum = 0L;
        int minPoint;
        int k = 0; //сколько домов находятся строго до текущей позиции
        int first = sc.nextInt();
        data[0] = first;

        for (int i = 1; i < n; i++) {
            data[i] = sc.nextInt();
            curSum += (data[i] - first);
        }

        minSum = curSum;
        minPoint = first;
        k = 1;
        /*for (int i = first + 1; i <= data[n - 1]; i++) {
            curSum += (2 * k - n);
            if (curSum < minSum) {
                minSum = curSum;
                minPoint = i;
            }
            if (data[k] == i) {
                k++;
            }

        }*/
        //1 2 5
        //5
        //5 + (2 -3)*1=4
        //4 + (4-3) * 3=7

        for (int j = 1; j < n; j++) {
            curSum += (2*k - n) * (data[j] - data[j-1]);
            if (curSum < minSum) {
                minSum = curSum;
                minPoint = data[j];
            }
            k++;
        }

        System.out.println(minPoint);
    }

}
