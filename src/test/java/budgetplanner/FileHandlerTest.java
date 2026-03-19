package budgetplanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FileHandlerTest {
    
    @Test
    void testSaveAndLoad() { //test lagring og lesing
        FileHandler handler = new FileHandler(); //lager objekt som kan lagre og lese fil

        //lager en liste med utgifter - dataen vi skal lagre
        List<Expense> original = List.of(new Expense("Mat", 100), new Expense("Transport", 50));

        String filename = "test.txt"; //navn på fila vi lagrer i

        handler.saveToFile(original, filename); //lagrer og skriver til fil


        //ny liste med det vi laster/leser fra filen
        List<Expense> loadedListe = handler.loadFromFile(filename);

        assertEquals(2, loadedListe.size()); //tester om vi har to utgifter
        assertEquals("Mat", loadedListe.get(0).getNavn()); //skjekker første utgift=mat
        assertEquals(100.0, loadedListe.get(0).getBeløp()); //skjekker om beløpet er 100
    }

}
