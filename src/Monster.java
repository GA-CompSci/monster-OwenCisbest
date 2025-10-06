public class Monster {
    // INSTANCE VARIABLES
    private int health;
    private double damage;
    private int speed;
    private String special;

    // CONSTRUCTOR
    public Monster(){
        // Randomly generate health, damage, and speed
        health = (int)(Math.random() * 80 + 1) + 20;
        // Random 10 - 50
        damage = (Math.random() * 41 ) + 10;
        // Speed 1 - 10
        speed = (int)(Math.random() * 10) + 1;

        //Monsters dont have special move by default
        special = "";
    }
    // OVERLOADED CONSTRUCTOR
    public Monster(String special){
        this();
        this.special = special;
    }

    //ACCESSOR METHODS
    public int health(){return health; }
    public double damage() {return Math.round(damage * 100) / 100;}
    public int speed() {return this.speed;}
    public String special() {return this.special;}

    //MUTATOR METHODS
    public void takeDamage(int dmg){
        health -= dmg;
    }
    
}

