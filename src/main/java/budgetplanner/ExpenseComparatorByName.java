package budgetplanner;

import java.util.Comparator;

public class ExpenseComparatorByName implements Comparator<Expense> {

    @Override
    public int compare(Expense e1, Expense e2) {
        return e1.getNavn().compareTo(e2.getNavn());
    }
}
