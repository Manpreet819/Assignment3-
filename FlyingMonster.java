package Assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class FlyingMonster extends Monster {
    private int wingSpan;

    public FlyingMonster(String name, String color, int strength, int speed, int wingSpan) {
        super(name, color, strength, speed);
        this.wingSpan = wingSpan;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " soars through the sky with a wingspan of " + wingSpan + " meters!");
    }

    @Override
    public void saveToFile(BufferedWriter writer) throws IOException {
        super.saveToFile(writer);
        writer.write("," + wingSpan);
    }

    public static FlyingMonster loadFromFile(BufferedReader reader) throws IOException {
        Monster monster = Monster.loadFromFile(reader);
        String line = reader.readLine();
        String[] data = line.split(",");
        return new FlyingMonster(monster.name, monster.color, monster.strength, monster.speed, Integer.parseInt(data[4]));
    }

    @Override
    public String toString() {
        return super.toString() + ", Wingspan: " + wingSpan;
    }
}

