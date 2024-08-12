package Assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Monster {
    protected String name;
    protected String color;
    protected int strength;
    protected int speed;

    public Monster(String name, String color, int strength, int speed) {
        this.name = name;
        this.color = color;
        this.strength = strength;
        this.speed = speed;
    }

    public abstract void performSpecialAbility();

    public void saveToFile(BufferedWriter writer) throws IOException {
        writer.write(name + "," + color + "," + strength + "," + speed);
        writer.newLine();
    }

    @Override
    public String toString() {
        return name + " (" + color + ") - Strength: " + strength + ", Speed: " + speed;
    }

    public static Monster loadFromFile(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null) return null;
        String[] data = line.split(",");
        return new Monster(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])) {
            @Override
            public void performSpecialAbility() {
                // Default implementation
            }
        };
    }
}
