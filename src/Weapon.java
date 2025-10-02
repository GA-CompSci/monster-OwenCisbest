public class Weapon {
    //Instance variables
    private int damage;
    private String name;


    //constructor
    public Weapon(int damage, String name){
        this.damage = damage;
        this.name = name;
    }


    //accessir
    public String getName() {
        return this.name;
    }
    
    public int getDamage() {
        return this.damage;
    }
}
