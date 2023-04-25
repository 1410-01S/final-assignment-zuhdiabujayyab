import java.util.Random;
public class Creature {
    private int age;
    private String name;
    private float health;
    private float maxHealth;

    public Creature(String name, int age, float health, float maxHealth) {
        this.name = name;
        this.age = age;
        this.health = health;
        this.maxHealth = maxHealth;
    }

    public float getHealth(){
        return health;
    }

    public void die() {
        System.out.println(name + " has died.");
    }
    public void printName(){
        System.out.println(name);
    }
    public Creature reproduce(int reducedHealth) {
        System.out.println(name + " is reproducing. it's age is: " + age + ". and his health is: " + health);
        return new Creature(name + "'s child", age+=1, health -= reducedHealth, maxHealth);
    }
}