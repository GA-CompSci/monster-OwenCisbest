import java.util.ArrayList;
import java.util.Scanner;

public class Nums {
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<>();
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter name: ");
        String input = s.nextLine();
        while(!input.equals("")){
            names.add(input);
            System.out.print("Enter next name: ");
            input = s.nextLine();
        }

        while(!input.equals("exit") || names.isEmpty()){
            int r = (int)(Math.random() * names.size());
            System.out.println("RANDOM SELECTION: " +names.get(r));
            names.remove(r);
            System.out.print("Enter next name, exit to quit ");         
        }
    }
}
