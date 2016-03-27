import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Milena on 27.03.2016.
 */
public class InsuranceEntry {
    private int id;
    private String subject;
    private int risk;
    private BigDecimal payout;

    public InsuranceEntry(int id, String subject, int risk, BigDecimal payout) {
        this.id = id;
        this.subject = subject;
        this.risk = risk;
        this.payout = payout;
    }

    public InsuranceEntry(int id) {
        this.id = id;
    }

    public InsuranceEntry(String subject, int risk, BigDecimal payout) {
        this.subject = subject;
        this.risk = risk;
        this.payout = payout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public BigDecimal getPayout() {
        return payout;
    }

    public void setPayout(BigDecimal payout) {
        this.payout = payout;
    }

    @Override
    public String toString() {
        return "InsuranceEntry{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", risk=" + risk +
                ", payout=" + payout +
                '}';
    }
}
