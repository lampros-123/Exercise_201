
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Matthias
 */
public class VelocityTableModel extends AbstractTableModel{
    
    ArrayList<Measurement> measurements = new ArrayList<>();

    @Override
    public int getRowCount() {
        return measurements.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Measurement m = measurements.get(rowIndex);
        switch(columnIndex) {
            case 0: return m.getDate();
            case 1: return m.getTime();
            case 2: return m.getKennzeichen();
            case 3: return m.getMeasured();
            case 4: return m.getLegal();
            case 5: return m.getExceedence();
            default: return "???";
        }
    }
    
}
