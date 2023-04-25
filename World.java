import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    private float temperature;
    private float humidity;
    private float light;
    private ArrayList<Creature> creatures;
    private ArrayList<Food> foodSources;

    public World(float temperature, float humidity, float light) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
        creatures = new ArrayList<>();
        foodSources = new ArrayList<>();
    }

    public ArrayList<Creature> getCreatures() {
        return this.creatures;
    }

    public ArrayList<Food> getFoods() {
        return this.foodSources;
    }

    public Creature createCreature() {
        System.out.println("A new creature is born.");
        Creature newCreature = new Creature("Creature " + (creatures.size() + 1), 0, 100, 100);
        creatures.add(newCreature);
        return newCreature;
    }

    public Food spawnFood() {
        System.out.println("New food has spawned.");
        Food newFood = new Food("Food " + (foodSources.size() + 1), 10);
        foodSources.add(newFood);
        return newFood;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getLight() {
        return light;
    }

    public void generateRandomFoodSources() {
        Random rand = new Random();
        int randomNum = rand.nextInt(15) + 5;
        for (int i = 1; i<=randomNum; i++) {
            this.spawnFood();
        }
    }

    public void generateRandomCreatures() {
        Random rand = new Random();
        int randomNum = rand.nextInt(5)+1;
        for (int i = 1; i<=randomNum; i++) {
            Creature creature = this.createCreature();
        }
    }
}
