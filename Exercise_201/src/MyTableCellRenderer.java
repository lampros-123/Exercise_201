
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import javax.swing.JTable;

/**
 * @author Konstantin
 */
public class MyTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Measurement m = (Measurement) value;
        JLabel label=new JLabel();
        label.setOpaque(true);
        if(m.getMeasured()>30){
            
        }
        else if(m.getExceedence()<=30&&m.getExceedence()>20){
            
        }esle if(m.getExceedence())
            
    }

}
