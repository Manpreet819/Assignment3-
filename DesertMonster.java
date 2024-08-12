package Assignment3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class DesertMonster extends Monster {
    private int heatResistance;

    public DesertMonster(String name, String color, int strength, int speed, int heatResistance) {
        super(name, color, strength, speed);
        this.heatResistance = heatResistance;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " withstands extreme heat with a resistance level of " + heatResistance + "!");
    }

    @Override
    public void saveToFile(BufferedWriter writer) throws IOException {
        super.saveToFile(writer);
        writer.write("," + heatResistance);
    }

    public static DesertMonster loadFromFile(BufferedReader reader) throws IOException {
        Monster monster = Monster.loadFromFile(reader);
        String line = reader.readLine();
        String[] data = line.split(",");
        return new DesertMonster(monster.name, monster.color, monster.strength, monster.speed, Integer.parseInt(data[4]));
    }

    @Override
    public String toString() {
        return super.toString() + ", Heat Resistance: " + heatResistance;
    }
}

