package Controller;

import Model.DBworker;
import Model.Derivativ;
import Model.InsuranceEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Milena on 28.03.2016.
 */
public class Controller {
    private ObservableList<InsuranceEntry> data;
    private ObservableList<InsuranceEntry> sortedData;
    private ObservableList<InsuranceEntry> selectedData;
    private BigDecimal cost;
    private DBworker worker;
    private Derivativ derivativ;

    public Controller(DBworker worker, Derivativ derivativ) {
        this.worker = worker;
        this.derivativ = derivativ;

        cost = derivativ.getSum();

        data = FXCollections.observableArrayList();
        List<InsuranceEntry> insurances = derivativ.getInsurances();
        data.addAll(insurances);

        sortedData = FXCollections.observableArrayList();
        List<InsuranceEntry> sortedInsurances = derivativ.sortEntries();
        sortedData.addAll(sortedInsurances);

        selectedData = FXCollections.observableArrayList();
        List<InsuranceEntry> selectedInsurances = derivativ.getByParameter("WHERE payout>100.00 AND risk<60 ");
        selectedData.addAll(selectedInsurances);
    }

    public void refresh(){
        data.clear();
        data.addAll(derivativ.getInsurances());
        sortedData.clear();
        sortedData.addAll(derivativ.sortEntries());
        selectedData.clear();
        selectedData.addAll(derivativ.getByParameter("WHERE payout>100.00 AND risk<60 "));
        cost = derivativ.getSum();
    }

    public ObservableList<InsuranceEntry> getData() {
        return data;
    }
    public ObservableList<InsuranceEntry> getSortedData() {
        return sortedData;
    }
    public ObservableList<InsuranceEntry> getSelectedData() {
        return selectedData;
    }
    public BigDecimal getCost() {
        return cost;
    }
}
