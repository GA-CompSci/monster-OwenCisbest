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
        // PERCENTAGE OF DEFEATED MONSTERS
        double result = percentComplete();
        System.out.println("You have defeated " + result + "%");
        int count = 0;

        for(Monster m : monsters){
            if(m.health() > 50) count++;
        }
        System.out.println(count + " of them have more than 50 health");
        reportMonsters();
    
    
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

    public static double percentComplete() {
        return monsterCount(0) /monsters.length * 100;
    }
    public static void reportMonsters(){
        for(Monster m : monsters){
            System.out.println("Monster " + m + " has " + m.health() + " health.");
            System.out.println("Monster " + m + " has " + m.damage() + " damage.");
            System.out.println("Monster " + m + " has " + m.speed() + " speed.");
            System.out.println("Monster " + m + " has " + m.special() + " special.");
        }

 
    }
    
}