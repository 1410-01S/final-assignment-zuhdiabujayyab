public class Food {
    private String name;
    private float nutritionalValue;

    public Food(String name, float nutritionalValue) {
        this.name = name;
        this.nutritionalValue = nutritionalValue;
    }

    public void printName(){
        System.out.println(this.name);
    }
    public float getNutritionalValue() {
        return nutritionalValue;
    }
}