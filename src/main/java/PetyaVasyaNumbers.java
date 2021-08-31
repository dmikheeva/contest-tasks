import java.util.Scanner;

public class PetyaVasyaNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int iAdd, i = 0;
        long sPetya = 0L, sVasya = 0L;
        int iPetya, iVasya;
        while (i < n) {
            iPetya = sc.nextInt();
            iVasya = sc.nextInt();
            iAdd = sc.nextInt();
            sPetya += iPetya;
            sVasya += iVasya;
            if (iPetya < iVasya) {
                sPetya += iAdd;
            } else {
                sVasya += iAdd;
            }
            i += 3;
        }
        System.out.println(sPetya > sVasya ? "Petya" : "Vasya");
    }

}
