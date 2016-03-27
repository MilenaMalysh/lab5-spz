import com.sun.scenario.effect.Flood;

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

        //BigDecimal amount = new BigDecimal(650.87);
        //InsuranceEntry insurance = new InsuranceEntry("gold", 45, amount);
        //derivativ.insertValue(insurance);
        //System.out.println(derivativ.getInsurances());

        InsuranceEntry insurance = new InsuranceEntry(9);
        derivativ.deleteValue(insurance);
        System.out.println(derivativ.getInsurances());


        worker.closeConnetion();

    }

}
