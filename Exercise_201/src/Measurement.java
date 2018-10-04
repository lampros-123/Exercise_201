
import java.time.LocalDateTime;

/**
 *
 * @author Matthias
 */
public class Measurement {
    private LocalDateTime datetime;
    private String kennzeichen;
    private double measured;
    private double legal;

    public Measurement(LocalDateTime datetime, String kennzeichen, double measured, double legal) {
        this.datetime = datetime;
        this.kennzeichen = kennzeichen;
        this.measured = measured;
        this.legal = legal;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public double getLegal() {
        return legal;
    }

    public double getMeasured() {
        return measured;
    }
    
    public double getExceedence() {
        return measured - legal;
    }
    
    
}
