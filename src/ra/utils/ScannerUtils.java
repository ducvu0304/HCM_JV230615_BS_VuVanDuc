package ra.utils;

import java.util.Scanner;

public class ScannerUtils {

    public static int inputInteger(Scanner scanner) {
        while (true) {
         try {
             return Integer.parseInt(scanner.nextLine().trim());
         }catch (Exception e){
             System.err.println("Nhập sai định dạng số nguyên. Xin mời nhập lại");
         }
        }
    }
}
