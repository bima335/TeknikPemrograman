package JavaProblems;

import java.util.Arrays;
import java.util.Scanner;

// public class ProblemThree {
//     public static void main(String[] args) {
//         int arr[] = {12, 4, 3, 1, 9, 657};
//         int n = 3;

//         int ans = Arrays.stream(arr)
//                 .boxed()
//                 .sorted((a, b) -> Integer.compare(b, a))
//                 .skip(n - 1)
//                 .findFirst()
//                 .orElse(0);

//         System.out.println("The 3rd largest element is: " + ans);
//     }
// }



public class ProblemThree {
    public static void main(String[] args) {
        int[] arr = {12, 4, 3, 1, 9, 657};
        Scanner scanner = new Scanner(System.in);
        
        int n = 0;
        boolean isValid = false;

        System.out.println("Array saat ini : " + Arrays.toString(arr));
        System.out.println("Jumlah elemen  : " + arr.length);

        while (!isValid) {
            System.out.print("Masukkan nilai N (1 hingga " + arr.length + "): ");
            
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                
                if (n > 0 && n <= arr.length) {
                    isValid = true;
                } else {
                    System.out.println("[Error] N tidak boleh lebih dari " + arr.length + " atau kurang dari 1. Coba lagi!\n");
                }
            } else {
                System.out.println("[Error] Mohon masukkan angka bulat yang valid!\n");
                scanner.next();
            }
        }

        int ans = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(n - 1)
                .findFirst()
                .orElse(0);

        System.out.println("Elemen terbesar ke-" + n + " adalah: " + ans);
        
        scanner.close(); 
    }
}