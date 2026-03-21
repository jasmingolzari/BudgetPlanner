package budgetplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BudgetController {

    @FXML //betyr at denne variablen er kobla til GUI
    private TextField nameField;

    @FXML 
    private TextField beløpField;

    @FXML
    private ListView<String> expenseList;

    private BudgetManager manager = new BudgetManager(1000);

    @FXML
    private void handleAddExpense() {
        try {
            String name = nameField.getText(); //henter det brukeren skrev
            double beløp = Double.parseDouble(beløpField.getText());

            Expense expense = new Expense(name, beløp);
            manager.addExpense(expense); 

            expenseList.getItems().add(name + " - " + beløp); //legger til i lista i GUI

            totalLabel.setText("Totalt brukt : " + manager.getTotalSpent());
            remainingLabel.setText("Gjenstår : " + manager.getRemainingBudget());

            nameField.clear();
            beløpField.clear();

        } catch (NumberFormatException e) {
            System.out.println("Ugyldig beløp!");
        }

    }

    @FXML
    private Label totalLabel;

    @FXML
    private Label remainingLabel;

}
