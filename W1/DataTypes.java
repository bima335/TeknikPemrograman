import java.lang.NumberFormatException;
import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args){
        Scanner berapa = new Scanner(System.in);
        System.out.println("Masukkan Jumlah Angka yang ingin dimasukkan");
        while(!berapa.hasNextInt()){
                System.out.println("Masukkan angka!");
                berapa.nextLine();
            }
        String angka;
        int loop = berapa.nextInt();
        String[] arr = new String[loop];
        
        // Loop Input
        for(int i = 0; i < loop; i++){
            Scanner a = new Scanner(System.in);
            System.out.println("Masukkan angka ke-" + (i+1));
            while(!a.hasNextBigInteger()){
                System.err.println("Masukkan angka!");
                a.nextLine();
            }
            angka = a.nextLine();
            arr[i] = angka;
        }
        berapa.close();
        
        // Loop output
        for(int i = 0; i < loop; i++){
            try{
            long cek_angka = Long.parseLong(arr[i]);
            if(cek_angka >= Long.MIN_VALUE && cek_angka <= Long.MAX_VALUE){
                System.err.println("\n"+arr[i] + " Can be fitted in:");
            }
            if(cek_angka >= Byte.MIN_VALUE && cek_angka <= Byte.MAX_VALUE){
                System.out.println("* byte");
            }
            if(cek_angka >= Short.MIN_VALUE && cek_angka <= Short.MAX_VALUE){
                System.out.println("* short");
            }
            if(cek_angka >= Integer.MIN_VALUE && cek_angka <= Integer.MAX_VALUE){
                System.out.println("* int");
            }
            if(cek_angka >= Long.MIN_VALUE && cek_angka <= Long.MAX_VALUE){
                System.out.println("* long");
            }
            } catch(NumberFormatException e){
                System.out.println("\n"+arr[i] + " Can't be fitted anywhere");
            }
        }
    }
}