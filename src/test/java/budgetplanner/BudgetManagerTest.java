package budgetplanner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BudgetManagerTest {

    @Test
    void testAddExpense() {
        BudgetManager manager = new BudgetManager(1000);
        manager.addExpense(new Expense("Mat", 100));

        assertEquals(1.0, manager.getUtgifter().size());
    }

    @Test
    void testTotalSpent1() {
        BudgetManager manager = new BudgetManager(1000);
        manager.addExpense(new Expense("Mat", 100));

        assertEquals(100.0, manager.getTotalSpent());
    }

    @Test
    void testTotalSpent2() {
        BudgetManager manager = new BudgetManager(1000);
        manager.addExpense(new Expense("Mat", 100));
        manager.addExpense(new Expense("Transport", 50));

        assertEquals(150.0, manager.getTotalSpent());
    }


    @Test
    void testResterendeBudsjett() {
        BudgetManager manager = new BudgetManager(1000);
        manager.addExpense(new Expense("Mat", 200));

        assertEquals(800.0, manager.getRemainingBudget());
    }


    @Test
    void testEmptyExpenses() {
        BudgetManager manager = new BudgetManager(1000);

        assertEquals(0.0, manager.getTotalSpent());
    }

    @Test //tester at negativt budsjett kaster exception
    void testNegativeBudget() {
        try {
            new BudgetManager(-100);

            //hvis vi kommer hit er det feil
            fail("Burde ha kastet exception");
        } catch (IllegalArgumentException e) {
            //dette er riktig -> test er ok
        }
    }
    
}
