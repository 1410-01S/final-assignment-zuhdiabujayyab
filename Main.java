import java.lang.ref.Cleaner;
import java.util.List;
import java.util.Random;
public class Main {
    static World world = new World(25, 0.7f, 0.8f);
    public static void main(String[] args) {
        world.generateRandomCreatures();
        world.generateRandomFoodSources();

        List<Creature> creatures = world.getCreatures();
        for (Creature obj:creatures) {
            obj.printName();
        }
        System.out.println("Creatures Created !! ==================================================");

        List<Food> foodSources = world.getFoods();
        for (Food obj:foodSources) {
            obj.printName();
        }
        System.out.println("Food Sources Created !! ===============================================");
        int number_of_lives = creatures.size();
        while (number_of_lives > 0) {
            for (Creature creature:creatures) {
                if (creature.getHealth() <= 0f) {
                    continue;
                }
                if ((creatures.size() == 5) || (((creatures.size() == 3 || creatures.size() == 4) && (foodSources.size() >= 10 && foodSources.size() <= 15)))) {
                    Random rand = new Random();
                    int reduceHealth = rand.nextInt(6) + 5;
                    creature.reproduce(reduceHealth);
                } else if (((creatures.size() == 3 || creatures.size() == 4) && (foodSources.size() >= 5 && foodSources.size() <= 10))) {
                    Random rand = new Random();
                    int reduceHealth = rand.nextInt(4) + 3;
                    creature.reproduce(reduceHealth);
                } else if (((creatures.size() == 3 || creatures.size() == 4) && (foodSources.size() > 15)) || (creatures.size() == 1 || creatures.size() == 2)) {
                    Random rand = new Random();
                    int reduceHealth = rand.nextInt(5);
                    creature.reproduce(reduceHealth);
                } else {
                    Random rand = new Random();
                    int reduceHealth = rand.nextInt(10);
                    creature.reproduce(reduceHealth);
                }
                if (creature.getHealth() <= 0f) {
                    creature.die();
                    number_of_lives -= 1;

                }
            }
        }
        System.out.println("all died !! ========================================================");
    }
}