import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Milena on 27.03.2016.
 */
public class Derivativ {
    DBworker worker;

    public Derivativ(DBworker worker) {
        this.worker = worker;
    }

    public List<InsuranceEntry> getInsurances(){
        ResultSet resultSet = this.worker.selectEntries("");
        return getEntries(resultSet);
    }

    public List<InsuranceEntry> getEntries(ResultSet resultSet){
        List<InsuranceEntry> entries = new ArrayList<InsuranceEntry>();
        try {
            while (resultSet.next()){
                InsuranceEntry insuranceEntry = new InsuranceEntry(resultSet.getInt("id"), resultSet.getString("subject"), resultSet.getInt("risk"), resultSet.getBigDecimal("payout"));
                entries.add(insuranceEntry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entries;
    }

    public List<InsuranceEntry> sortEntries(){
        ResultSet resultSet = this.worker.selectEntries("ORDER BY risk DESC");
        return getEntries(resultSet);
    }

    public BigDecimal getSum(){
        BigDecimal sum = this.worker.aggrValue("SUM(payout)");
        return sum;
    }

    public List<InsuranceEntry> getByParameter(String param){
        ResultSet resultSet = this.worker.selectEntries(param);
        return getEntries(resultSet);
    }

    public void insertValue(InsuranceEntry insurance){
        this.worker.insertValue(insurance.getSubject(), insurance.getRisk(), insurance.getPayout());
    }

    public void deleteValue(InsuranceEntry insurance){
        this.worker.deleteValue(insurance.getId());
    }

    @Override
    public String toString() {
        return "Derivativ{" +
                "entries=" + this.getInsurances() +
                '}';
    }
}
