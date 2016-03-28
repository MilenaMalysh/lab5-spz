package View;

import Model.InsuranceEntry;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Controller.Controller;

import javax.swing.plaf.basic.BasicButtonUI;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

/**
 * Created by Milena on 28.03.2016.
 */
public class Screen {

    private TableView table1 = new TableView();
    private TableView table2 = new TableView();
    private TableView table3 = new TableView();

    public Screen(Stage stage, final Controller controller) {
        Scene scene = new Scene(new Group());

        final Label label1 = new Label("Deriativ");
        label1.setFont(new Font("Arial", 20));

        table1.setEditable(false);

        TableColumn idCol = new TableColumn("id");
        idCol.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("id"));
        TableColumn subjectCol = new TableColumn("Subject");
        subjectCol.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("subject"));
        TableColumn riskCol = new TableColumn("Risk");
        riskCol.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("risk"));
        TableColumn payoutCol = new TableColumn("Payout");
        payoutCol.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("payout"));

        table1.setItems(controller.getData());
        table1.getColumns().addAll(idCol, subjectCol, riskCol, payoutCol);

        table1.setMaxWidth(200);
        final VBox vbox1 = new VBox();
        vbox1.setSpacing(5);
        vbox1.setPadding(new Insets(10, 0, 0, 10));
        vbox1.getChildren().addAll(label1, table1);





        final Label label2 = new Label("Sorted Deriativ");
        label2.setFont(new Font("Arial", 20));

        table2.setEditable(false);

        TableColumn idCol2 = new TableColumn("id");
        idCol2.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("id"));
        TableColumn subjectCol2 = new TableColumn("Subject");
        subjectCol2.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("subject"));
        TableColumn riskCol2 = new TableColumn("Risk");
        riskCol2.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("risk"));
        TableColumn payoutCol2 = new TableColumn("Payout");
        payoutCol2.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("payout"));

        table2.setItems(controller.getSortedData());
        table2.getColumns().addAll(idCol2, subjectCol2, riskCol2, payoutCol2);
        table2.setMaxWidth(200);

        final VBox vbox2 = new VBox();
        vbox2.setSpacing(5);
        vbox2.setPadding(new Insets(10, 0, 0, 10));
        vbox2.getChildren().addAll(label2, table2);




        final Label label3 = new Label("Selected Items");
        label3.setFont(new Font("Arial", 20));

        table3.setEditable(false);

        TableColumn idCol3 = new TableColumn("id");
        idCol3.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("id"));
        TableColumn subjectCol3 = new TableColumn("Subject");
        subjectCol3.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("subject"));
        TableColumn riskCol3 = new TableColumn("Risk");
        riskCol3.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("risk"));
        TableColumn payoutCol3 = new TableColumn("Payout");
        payoutCol3.setCellValueFactory(new PropertyValueFactory<InsuranceEntry, String>("payout"));

        table3.setItems(controller.getSelectedData());
        table3.getColumns().addAll(idCol3, subjectCol3, riskCol3, payoutCol3);
        table3.setMaxWidth(200);

        final VBox vbox3 = new VBox();
        vbox3.setSpacing(5);
        vbox3.setPadding(new Insets(10, 0, 0, 10));
        vbox3.getChildren().addAll(label3, table3);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vbox1, vbox2, vbox3);

        Label costLabel = new Label("Cost");
        costLabel.setFont(new Font("Arial", 20));
        TextArea cost = new TextArea(controller.getCost().toString());
        cost.setMaxHeight(50);
        VBox vBoxmain = new VBox();
        Button refresh = new Button();
        refresh.setText("refresh");
        refresh.setStyle("-fx-font-size: 15pt;");
        refresh.setVisible(true);
        refresh.setOnAction(new EventHandler<ActionEvent>()  {
            public void handle(ActionEvent event) {
                controller.refresh();
            }
        });
        vBoxmain.getChildren().addAll(hBox, costLabel, cost, refresh);
        ((Group) scene.getRoot()).getChildren().addAll(vBoxmain);

        stage.setScene(scene);
    }
}
