
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
    
    public void add(Measurement m) {
        measurements.add(m);
        fireTableRowsInserted(measurements.size()-1, measurements.size()-1);
    }
    
    public void delete(int idx) {
        measurements.remove(idx);
        fireTableRowsDeleted(idx, idx);
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
