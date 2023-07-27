import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./teste/rainhas.txt"));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // Imprimir o exemplo sem a modelagem
            for (int i = 1; i < lines.size(); i++) {
                String[] tokens = lines.get(i).split(" ");
                for (int j = 1; j < tokens.length; j++) {
                    int value = Integer.parseInt(tokens[j]);
                    System.out.print(value < 0 ? "1 " : "0 ");
                }
                System.out.println();
            }

            List<int[]> cnf = new ArrayList<>();
            for (int i = 1; i < lines.size(); i++) {
                String[] tokens = lines.get(i).split(" ");
                int[] clause = new int[tokens.length - 1];
                for (int j = 1; j < tokens.length; j++) {
                    clause[j - 1] = Integer.parseInt(tokens[j]);
                }
                cnf.add(clause);
            }

            DPLL dpll = new DPLL();
            for (int[] clause : cnf) {
            }

            System.out.println(dpll.solve());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}