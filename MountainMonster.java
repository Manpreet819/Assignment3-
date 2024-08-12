package Assignment3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MountainMonster extends Monster {
    private int climbingSkill;

    public MountainMonster(String name, String color, int strength, int speed, int climbingSkill) {
        super(name, color, strength, speed);
        this.climbingSkill = climbingSkill;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " climbs mountains with a skill level of " + climbingSkill + "!");
    }

    @Override
    public void saveToFile(BufferedWriter writer) throws IOException {
        super.saveToFile(writer);
        writer.write("," + climbingSkill);
    }

    public static MountainMonster loadFromFile(BufferedReader reader) throws IOException {
        Monster monster = Monster.loadFromFile(reader);
        String line = reader.readLine();
        String[] data = line.split(",");
        return new MountainMonster(monster.name, monster.color, monster.strength, monster.speed, Integer.parseInt(data[4]));
    }

    @Override
    public String toString() {
        return super.toString() + ", Climbing Skill: " + climbingSkill;
    }
}
