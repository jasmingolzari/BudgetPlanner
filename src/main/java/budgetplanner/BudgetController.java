package budgetplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BudgetController {
    private double currentBudget = 1000;

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

            if (beløp < 0) {
                System.out.println("Beløp kan ikke være negativ!");
                return;
            }
            
            Expense expense = new Expense(name, beløp);
            manager.addExpense(expense); 

            expenseList.getItems().add("💸 " + name + " - " + beløp); //legger til i lista i GUI

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


    @FXML
    private TextField budgetField;

    @FXML
    private void handleSetBudget() {
        try {
        double budsjett = Double.parseDouble(budgetField.getText());
        
        currentBudget = budsjett;
        manager = new BudgetManager(budsjett);
        
        expenseList.getItems().clear();

        totalLabel.setText("Totalt brukt: 0");
        remainingLabel.setText("Gjenstår: " + budsjett);

        budgetField.clear();

        } catch (NumberFormatException e) {
        System.out.println("Ugyldig budsjett!");
        }
    }





    //filhåndtering
    private FileHandler fileHandler = new FileHandler();


    @FXML
    private void handleSave() {
        try {
            fileHandler.saveToFile(manager.getUtgifter(), "data.txt");
            System.out.println("Lagret!");
        } catch (Exception e) {
            System.out.println("Feil ved lagring");
        }
    }


    @FXML
    private void handleLoad() {
       try {

            manager = new BudgetManager(currentBudget);

            expenseList.getItems().clear();

            for (Expense e : fileHandler.loadFromFile("data.txt")) { //gir liste med expense
                manager.addExpense(e); //legger tilbake i modellen
                expenseList.getItems().add(e.getNavn() + " - " + e.getBeløp());
            }

            totalLabel.setText("Totalt brukt: " + manager.getTotalSpent());
            remainingLabel.setText("Gjenstår: " + manager.getRemainingBudget());

        } catch (Exception e) {
            System.out.println("Feil ved lasting");
        }
    
    }


    //sortering interface
    @FXML
    private void handleSortByPrice() {
        manager.getUtgifter().sort(null);

        expenseList.getItems().clear();

        for (Expense e : manager.getUtgifter()) {
            expenseList.getItems().add(e.getNavn() + " - " + e.getBeløp());
        }
    }

    @FXML
    private void handleSortByName() {
        manager.getUtgifter().sort(new ExpenseComparatorByName());

        expenseList.getItems().clear();

        for (Expense e : manager.getUtgifter()) {
            expenseList.getItems().add(e.getNavn() + " - " + e.getBeløp());
        }
    }

}

