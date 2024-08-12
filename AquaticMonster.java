package Assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class AquaticMonster extends Monster {
    private int swimSpeed;

    public AquaticMonster(String name, String color, int strength, int speed, int swimSpeed) {
        super(name, color, strength, speed);
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " swims swiftly with a speed of " + swimSpeed + " km/h!");
    }

    @Override
    public void saveToFile(BufferedWriter writer) throws IOException {
        super.saveToFile(writer);
        writer.write("," + swimSpeed);
    }

    public static AquaticMonster loadFromFile(BufferedReader reader) throws IOException {
        Monster monster = Monster.loadFromFile(reader);
        String line = reader.readLine();
        String[] data = line.split(",");
        return new AquaticMonster(monster.name, monster.color, monster.strength, monster.speed, Integer.parseInt(data[4]));
    }

    @Override
    public String toString() {
        return super.toString() + ", Swim Speed: " + swimSpeed;
    }
}

