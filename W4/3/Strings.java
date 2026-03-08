import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many words do you want to enter? ");
        int size = scan.nextInt();
        scan.nextLine();

        String[] wordList = new String[size];

        System.out.println("Enter " + size + " Word(s) (press Enter after each word:");
        for (int i = 0; i < size; i++) {
            wordList[i] = scan.nextLine();
        }
        Sorting.selectionSort(wordList);
        System.out.println("\nWords after sorting:");
        for (int i = 0; i < size; i++) {
            System.out.print(wordList[i] + "  ");
        }
        System.out.println();
        
        scan.close();
    }
}