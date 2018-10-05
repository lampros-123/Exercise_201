
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Matthias
 */
public class VelocityTableModel extends AbstractTableModel {

    ArrayList<Measurement> measurements = new ArrayList<>();
    private static String[] names = {"Datum", "Zeit", "Kennzeichen", "Gemessen", "Erlaubt", "Übertretung"};

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
        return m;
    }

    public void add(Measurement m) {
        measurements.add(m);
        fireTableRowsInserted(measurements.size() - 1, measurements.size() - 1);
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }

}
