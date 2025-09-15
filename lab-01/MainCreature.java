public class MainCreature {
    public static void main(String[] args) {
        Creature tiger = new Creature("Rajah", "Tiger", 2.8, 5);

        tiger.describe();
        tiger.talk();
        tiger.move("south");
        tiger.eat("a deer");
        tiger.sleep();
    }
}
