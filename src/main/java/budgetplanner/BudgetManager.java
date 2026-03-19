package budgetplanner;

import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    
    private List<Expense> utgifter;
    private double budsjett;

    
    public BudgetManager(double budsjett) {
        if (budsjett < 0) {
            throw new IllegalArgumentException("Budsjettet kan ikke være negativt!");
        }
        this.budsjett = budsjett;
        this.utgifter = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        if (expense == null) {
            throw new IllegalArgumentException("Expense kan ikke være null!");
        }
        utgifter.add(expense);
    }

    public double getTotalSpent() {
        double total = 0;
        for (Expense e : utgifter ) {
            total += e.getBeløp();
        }
        return total;
    }

    public double getRemainingBudget() {
        return budsjett - getTotalSpent();
    }

    public List<Expense> getUtgifter() {
        return utgifter;
    }

    public double getBudsjett() {
        return budsjett;
    }


}

