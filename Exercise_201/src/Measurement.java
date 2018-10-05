
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Matthias
 */
public class Measurement implements Serializable{
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

    public String getDate() {
        return datetime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public String getTime() {
        return datetime.format(DateTimeFormatter.ofPattern("HH:mm"));
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
