package Model;

import Model.DBworker;
import Model.Derivativ;
import Model.InsuranceEntry;

import java.math.BigDecimal;

/**
 * Created by Milena on 27.03.2016.
 */
public class Main {

    public static void main(String[] args){
        DBworker worker = new DBworker();
        Derivativ derivativ = new Derivativ(worker);
        //System.out.println(derivativ.getSum());
        //System.out.println(derivativ.sortEntries());
        //System.out.println(derivativ.getByParameter("WHERE payout>100.00 AND risk<60 "));

        //BigDecimal amount = new BigDecimal(6.87);
        //Model.InsuranceEntry insurance = new Model.InsuranceEntry("barby", 55, amount);
        //derivativ.insertValue(insurance);
        //System.out.println(derivativ.getInsurances());

        //InsuranceEntry insurance = new InsuranceEntry(9);
        //derivativ.deleteValue(insurance);
        //System.out.println(derivativ.getInsurances());

        worker.closeConnetion();

    }

}
