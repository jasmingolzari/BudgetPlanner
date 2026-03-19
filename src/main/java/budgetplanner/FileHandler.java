package budgetplanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    
    //skrive til fil
    public void saveToFile(List<Expense> utgifter, String filename) {
        try {
            FileWriter writer = new FileWriter(filename); //åpner filen for å skrive

            for (Expense e : utgifter) { //går gjennom alle utgifter en etter en
                writer.write(e.getNavn() + ";" + e.getBeløp() + "\n"); //skriver linja til fil
            }

            writer.close(); //lagrer ferdig og lukker

        } catch (IOException e) { //hvis noe går galt krasjer ikke programmet
            System.err.println("Feil ved skriving til fil");
        }
    }


    //lese fra fil 
    public List<Expense> loadFromFile(String filename) { //skal returnere en liste med utgifter
        List<Expense> utgifter = new ArrayList<>(); //lager en tom liste

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename)); //åpne dokument for å lese

            String line; 

            while ((line = reader.readLine()) != null) { //leser en linje fra fil
                try {
                    String[] parts = line.split(";"); //deler strengen

                    String navn = parts[0]; //henter ut data
                    double beløp = Double.parseDouble(parts[1]); //gjør om tekst til tall igjen så det er double

                    utgifter.add(new Expense(navn, beløp)); //lager objektet igjen
                    
                } catch (Exception e) {
                    System.out.println("Skipper ugyldig linje: " + line);
                }
                
            }

            reader.close(); //lukker fil

        } catch (IOException e) {
            System.err.println("Error reading file");
        }

        return utgifter; //returnerer utgifter
    }
}
