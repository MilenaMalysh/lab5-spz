/**
 * Created by Milena on 28.03.2016.
 */

import Controller.Controller;
import Model.DBworker;
import Model.Derivativ;
import View.Screen;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    private DBworker worker;

    @Override public void start(Stage stage) {
        worker = new DBworker();
        Derivativ derivativ = new Derivativ(worker);
        stage.setTitle("Derivativ");

        Controller controller = new Controller(worker, derivativ);
        Screen screen = new Screen(stage, controller);
        stage.setWidth(650);
        stage.setHeight(600);
        stage.show();

    }
    @Override

    public void stop(){

        worker.closeConnetion();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}

