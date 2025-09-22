import java.util.Scanner;
public class App {

    public static Monster[] monsters;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        Scanner input = new Scanner(System.in);
        System.out.print("How many monsters will you slay: ");
        int num = input.nextInt();
        monsters = new Monster[num]; //TODO: Handle errors if it's not a number
        //Build all the monsters
        for(int i = 0; i < monsters.length; i++){
            monsters[i] = new Monster(); //TODO: Add some specials
        }

        /*Monster m1 = new Monster();
        Monster m2 = new Monster();
        int m1health = m1.health();
        System.out.println("M1 health: " + m1.health());*/
     
     
        int count = 0;

        for(Monster m : monsters){
            if(m.health() > 50) count++;

        }
        System.out.println(count + " of them have more than 50 health");
        
    }
    /**
     * How many monsters have over the given health
     * @param health number to check
     * @return number of monsters above that health
     */
    public static int monsterCount(int health){
        int count = 0;

        for (Monster m : monsters){
            if(m.health() > health) count++;
        }
        return count;
    }


    public static Monster getNextMonster() {

        for(int i = 0; i < monsters.length; i++){
            if(monsters[i].health() > 0) return monsters[i];
        }
        return null;
    }
}
