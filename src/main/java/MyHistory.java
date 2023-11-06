import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class MyHistory {
    private String fileName;
    private LinkedHashSet<String> lines;

    public MyHistory(String fileName) {
        this.fileName = fileName;
        this.lines = new LinkedHashSet<>();
    }

    public void read() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
    }

    public void save() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public void addLine(String str) {
        lines.add(str);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHistory history = new MyHistory("history.txt");

        try {
            history.read();
        } catch (IOException e) {
            System.err.println("Chyba při čtení souboru.");
            e.printStackTrace();
        }

        history.addLine("První řádek");
        history.addLine("Druhý řádek");
        history.addLine("Třetí řádek");

        try {
            history.save();
        } catch (IOException e) {
            System.err.println("Chyba při ukládání do souboru.");
            e.printStackTrace();
        }

        System.out.println(history);
    }
}