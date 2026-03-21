package budgetplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BudgetApp extends Application { //sier at dete er en javaFX app
    
    @Override
    public void start(Stage stage) throws Exception { //start starter vinduet mitt (hvis noe går galt, kast exception)
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("App.fxml")); //laster GUI fra filen app.fxml
        Scene scene = new Scene(fxmlLoader.load()); //loader innholdet til vinduet

        stage.setTitle("Budsjettplanlegger");
        stage.setScene(scene);
        stage.show(); //viser vinduet

    }

    public static void main(String[] args) {
        launch(args); //starter hele appen
    }


}
