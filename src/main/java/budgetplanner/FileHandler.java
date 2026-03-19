package budgetplanner;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    
    //skrive til fil
    public void saveToFile(List<Expense> utgifter, String filename) {
        try {
            FileWriter writer = new FileWriter(filename); //åpner filen

            for (Expense e : utgifter) { //går gjennom alle utgifter
                writer.write(e.getNavn() + ";" + e.getBeløp() + "\n"); //skriver til fil
            }

            writer.close(); //lagrer ferdig og lukker

        } catch (IOException e) {
            System.err.println("Feil ved skriving til fil");
        }
    }


    //lese fra fil 
    public List<Expense> lodFromFile(String filename) {
        List<Expense> utgifter = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line;

            while ((line = reader.readLine()) != null) { //leser en linje fra fil
                String[] parts = line.split(";"); //deler strengen

                String navn = parts[0];
                double beløp = Double.parseDouble(parts[1]); //gjør om tekst til tall igjen så det er double

                utgifter.add(new Expense(navn, beløp)); //lager objektet igjen
            }

            reader.close();

        } catch (IOException e) {
            System.err.println("Error reading file");
        }

        return utgifter;
    }
}
