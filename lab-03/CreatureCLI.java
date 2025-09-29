import java.io.*;

public class CreatureCLI {

    private static void printHelp() {
        System.out.println("Usage:");
        System.out.println("  java CreatureCLI <command> <file> [options]");
        System.out.println();
        System.out.println("Commands:");
        System.out.println("  add <file> <name> <classification> <habitat> <size> <diet> <action>");
        System.out.println("       Add a new creature");
        System.out.println();
        System.out.println("  read <file>");
        System.out.println("       List all creatures in the registry");
        System.out.println();
        System.out.println("  update <file> <index> <name> <classification> <habitat> <size> <diet> <action>");
        System.out.println("       Update creature at given index (0-based)");
        System.out.println();
        System.out.println("  delete <file> <index>");
        System.out.println("       Delete creature at given index (0-based)");
        System.out.println();
        System.out.println("Example:");
        System.out.println("  java CreatureCLI add creatures.csv \"Lion\" \"Mammal\" \"Savannah\" \"8-10\" \"Carnivore\" \"Runs\"");
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            printHelp();
            System.exit(1);
        }

        String command = args[0];
        String filePath = args[1];

        try {
            CreatureRegistry registry = new CreatureRegistry(filePath);

            switch (command.toLowerCase()) {
                case "add":
                    if (args.length != 8) {
                        printHelp();
                        System.exit(1);
                    }
                    registry.addCreature(args[2], args[3], args[4], args[5], args[6], args[7]);
                    registry.saveToFile();
                    System.out.println("Creature added successfully.");
                    break;

                case "read":
                    registry.displayAll();
                    break;

                case "update":
                    if (args.length != 9) {
                        printHelp();
                        System.exit(1);
                    }
                    int updateIndex = Integer.parseInt(args[2]);
                    boolean updated = registry.modifyCreature(updateIndex, args[3], args[4], args[5], args[6], args[7], args[8]);
                    if (!updated) {
                        throw new IndexOutOfBoundsException("Invalid index " + updateIndex);
                    }
                    registry.saveToFile();
                    System.out.println("Creature updated successfully.");
                    break;

                case "delete":
                    if (args.length != 3) {
                        printHelp();
                        System.exit(1);
                    }
                    int deleteIndex = Integer.parseInt(args[2]);
                    boolean deleted = registry.deleteCreature(deleteIndex);
                    if (!deleted) {
                        throw new IndexOutOfBoundsException("Invalid index " + deleteIndex);
                    }
                    registry.saveToFile();
                    System.out.println("Creature deleted successfully.");
                    break;

                default:
                    printHelp();
                    System.exit(1);
            }

        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index error: " + e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            System.exit(1);
        }
    }
}
