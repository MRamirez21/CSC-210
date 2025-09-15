public class Creature {    
    private String name;
    private String species;
    private double size; 
    private int age;

     public Creature(String name, String species, double size, int age) {
        this.name = name;
        this.species = species;
        this.size = size;
        this.age = age;
    }

    public void eat(String food) {
        System.out.println(name + " the " + species + " is eating " + food + ".");
    }

    public void talk() {
        System.out.println(name + " the " + species + " growls.");
    }

    public void move(String direction) {
        System.out.println(name + " the " + species + " prowls to the " + direction + ".");
    }

    public void sleep() {
        System.out.println(name + " the " + species + " is sleeping under a tree.");
    }

    public void describe() {
        System.out.println("=== Creature Info ===");
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Size: " + size + " meters");
        System.out.println("Age: " + age + " years");
    }
}
