
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    public void delete(int idx) {
        measurements.remove(idx);
        fireTableRowsDeleted(idx, idx);
    }
    
    public double getAverage() {
        if(measurements.isEmpty()) {
            return 0;
        }
        double avg = 0;
        for (Measurement measurement : measurements) {
            avg += measurement.getExceedence();
        }
        return avg / measurements.size();
    }
    
    public void saveData(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

        for (Measurement measurement : measurements) {
            oos.writeObject(measurement);
        }
        
        oos.close();
    }
    
    public void loadData(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        
        try {
            Object measurement;
            while((measurement = ois.readObject()) != null) {
                measurements.add((Measurement) measurement);
            }
        } catch (EOFException e) {
        }
        
        ois.close();
    }
}
