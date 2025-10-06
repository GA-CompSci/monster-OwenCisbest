import java.util.Scanner;
public class App {
    //CLASS VARIABGLE
    //private static Monster[] monsters;
    //PLAYER STATS
    private static int health = 100;
    private static int speed = 10;
    private static int shield = 50;
    private static int damage = 50;
    private static int heal = 50;

    private static boolean isDefending = false;


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
   
        //Pick your build
        System.out.println("--PICK YOUR BUILD--");
        System.out.println("1) Fighter");
        System.out.println("2) Tank");
        System.out.println("3) Healer");
        System.out.println("4) Ninja");  
        int choice = input.nextInt(); //TODO: Error handle on bad input     
        if(choice == 1) {
            shield -= (int)(Math.random() * 46) + 5;
            heal -= (int)(Math.random() * 46) + 5;
        }
        else if(choice == 2){
            speed -= (int)(Math.random() * 9) + 1;
            damage -= (int)(Math.random() * 21) + 5;
        }
        else if(choice == 3){
            damage -= (int)(Math.random() * 26) + 5;
            shield -= (int)(Math.random() * 46) + 5;
        }
        else{
            heal -= (int)(Math.random() * 46) + 5;
            health -= (int)(Math.random() * 21) + 5;   
        }
        
        Monster currentMonster = getNextMonster();
        while(monsterCount(0) > 0){
            System.out.println("--OPTIONS--");
            System.out.println("1) Attack");
            System.out.println("2) Defend");
            System.out.println("3) Heal");
            System.out.println("4) Pass");
            System.out.print("Choice: ");
            int choice2 = input.nextInt();
            //ACTIONS
            if(choice2 == 1) {
                int dmg = (int)(Math.random() * damage + 1);
                System.out.println("You dealt " + dmg + " damage");
                if(dmg == damage) dmg = currentMonster.health();
                else if(dmg == 0){
                    System.out.println("--- CRITICAL FAIL! ---");
                    System.out.println("Your attacked missed so badly that you hit yourself.");
                    health -= 10;
                }
                else currentMonster.takeDamage(dmg);
                System.out.println("The monster has " + currentMonster.health() + " left.");
            }
            else if(choice2 == 2){
                isDefending = true;
                System.out.println("SHIELD UP!");
            }
            else if(choice2== 3){
                int h = (int)(Math.random() + heal + 1);
                health += h;
                System.out.println("You healed for " + h + " points");
            }
            else{
                speed++;
                System.out.println("Your speed has increased. Current speed: " + speed);
            }
            if(currentMonster.health() <= 0){
                System.out.println("YOU HAVE SLAIN A MONSTER!");
                currentMonster = getNextMonster();
                reportMonsters();
                continue;
            }
            
            int speedCheck = (int)(Math.random() * 100);
            if(speedCheck >= speed) {
                System.out.println("BONUS TURN!");
                continue;
            }
            else{
                int incomingDamage = (int)(Math.random() * currentMonster.damage() + 1);
                if(isDefending){
                    incomingDamage -= shield;
                    if(incomingDamage < 0) incomingDamage = 0;
                    System.out.println("CLANG! Your shield absorbed " + shield + " damage.");
                }
                health -= incomingDamage;
            }

            //IS OUR PLAYER DEFEATED?
            if(health <= 0){
                reportMonsters();
                System.out.println("\n\n--------- YOU LOSE --------\n\n");
                break;
            }
        }   
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
        int i = 1;
        for(Monster m : monsters){
            if(m.health() <= 0){
                i++;
            }
            else{
            System.out.println("Monster " + i + " has " + m.health() + " health.");
            System.out.println("Monster " + i + " has " + m.damage() + " damage.");
            System.out.println("Monster " + i + " has " + m.speed() + " speed.");
            System.out.println("Monster " + i + " has " + m.special() + " special.");
            i++;                
            }

        }

 
    }
    
}