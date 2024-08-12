package Assignment3;

import java.io.*;
import java.util.ArrayList;

public class MonsterManager {
    private ArrayList<Monster> monsters = new ArrayList<>();

    public void addMonster(Monster m) {
        monsters.add(m);
    }

    public void breedMonsters(int index1, int index2) {
        if (index1 < 0 || index1 >= monsters.size() || index2 < 0 || index2 >= monsters.size()) {
            System.out.println("Invalid indices for breeding.");
            return;
        }
        Monster parent1 = monsters.get(index1);
        Monster parent2 = monsters.get(index2);

        // Simplified breeding logic: average attributes
        String name = parent1.name + "-" + parent2.name;
        String color = "Mixed"; // Placeholder color
        int strength = (parent1.strength + parent2.strength) / 2;
        int speed = (parent1.speed + parent2.speed) / 2;

        // You can add more sophisticated breeding logic based on specific monster types
        Monster offspring = new Monster(name, color, strength, speed) {
            @Override
            public void performSpecialAbility() {
                // Default ability
            }
        };

        monsters.add(offspring);
        System.out.println("New monster bred: " + offspring);
    }

    public void saveGame() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("monsters_data.txt"))) {
            for (Monster monster : monsters) {
                monster.saveToFile(writer);
            }
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    public void loadGame() {
        monsters.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("monsters_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String type = data[0]; // Placeholder for type
                Monster monster;
                switch (type) {
                    case "FlyingMonster":
                        monster = FlyingMonster.loadFromFile(reader);
                        break;
                    case "AquaticMonster":
                        monster = AquaticMonster.loadFromFile(reader);
                        break;
                    case "MountainMonster":
                        monster = MountainMonster.loadFromFile(reader);
                        break;
                    case "DesertMonster":
                        monster = DesertMonster.loadFromFile(reader);
                        break;
                    default:
                        throw new IOException("Unknown monster type: " + type);
                }
                addMonster(monster);
            }
            System.out.println("Game loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading game: " + e.getMessage());
        }
    }

    public void displayMonsters(boolean detailed) {
        for (Monster monster : monsters) {
            if (detailed) {
                System.out.println(monster);
            } else {
                System.out.println(monster.name);
            }
        }
    }
}
