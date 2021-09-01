import java.util.Scanner;
import java.io.*;

public class Hello{
    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       String name;
       boolean nameBool = true;

       do{
            System.out.print("Please input your name: ");
            name = in.nextLine();
            for(int i = 0; i < name.length(); i++){
                char c = name.charAt(i);
                if(c >= 65 && c <= 90)
                    nameBool ^= true;
                if(c >= 97 && c <= 122)
                    nameBool ^= true;
            }
       }while(nameBool);
       
       System.out.println("Hello, " + name);
       

    }
}
