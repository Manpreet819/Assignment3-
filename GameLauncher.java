package Assignment3;
import java.util.Scanner;

public class GameLauncher {
    private static MonsterManager manager = new MonsterManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Create Monster");
            System.out.println("2. View Monsters");
            System.out.println("3. Breed Monsters");
            System.out.println("4. Save Game");
            System.out.println("5. Load Game");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createMonster();
                    break;
                case 2:
                    viewMonsters();
                    break;
                case 3:
                    breedMonsters();
                    break;
                case 4:
                    manager.saveGame();
                    break;
                case 5:
                    manager.loadGame();
                    break;
                case 6:
                    System.out.print("Do you want to exit without saving? (y/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        System.out.println("Exiting...");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createMonster() {
        System.out.print("Enter monster name: ");
        String name = scanner.nextLine();
        System.out.print("Enter monster color: ");
        String color = scanner.nextLine();
        System.out.print("Enter monster strength: ");
        int strength = scanner.nextInt();
        System.out.print("Enter monster speed: ");
        int speed = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Select monster type:");
        System.out.println("1. FlyingMonster");
        System.out.println("2. AquaticMonster");
        System.out.println("3. MountainMonster");
        System.out.println("4. DesertMonster");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Monster monster = null;
        switch (type) {
            case 1:
                System.out.print("Enter wingspan: ");
                int wingSpan = scanner.nextInt();
                monster = new FlyingMonster(name, color, strength, speed, wingSpan);
                break;
            case 2:
                System.out.print("Enter swim speed: ");
                int swimSpeed = scanner.nextInt();
                monster = new AquaticMonster(name, color, strength, speed, swimSpeed);
                break;
            case 3:
                System.out.print("Enter climbing skill: ");
                int climbingSkill = scanner.nextInt();
                monster = new MountainMonster(name, color, strength, speed, climbingSkill);
                break;
            case 4:
                System.out.print("Enter heat resistance: ");
                int heatResistance = scanner.nextInt();
                monster = new DesertMonster(name, color, strength, speed, heatResistance);
                break;
            default:
                System.out.println("Invalid type. Monster not created.");
                return;
        }
        manager.addMonster(monster);
        System.out.println("Monster created: " + monster);
    }

    private static void viewMonsters() {
        System.out.println("Do you want detailed view? (y/n): ");
        boolean detailed = scanner.nextLine().equalsIgnoreCase("y");
        manager.displayMonsters(detailed);
    }

    private static void breedMonsters() {
        manager.displayMonsters(true);
        System.out.print("Enter index of the first monster: ");
        int index1 = scanner.nextInt();
        System.out.print("Enter index of the second monster: ");
        int index2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        manager.breedMonsters(index1, index2);
    }
}
