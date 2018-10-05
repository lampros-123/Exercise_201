
import java.awt.Color;
import javax.swing.JLabel;
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
        JLabel label = new JLabel();
        label.setOpaque(true);
        switch (column) {
            case 0:
                label.setText(m.getDate());
                break;
            case 1:
                label.setText(m.getTime());
                break;
            case 2:
                label.setText(m.getKennzeichen());
                break;
            case 3:
                label.setText(m.getMeasured() + "");
                break;
            case 4:
                label.setText(m.getLegal() + "");
                break;
            case 5:
                label.setText(m.getExceedence() + "");
                break;
            default:
                label.setText("???");
        }
        if (column == 5) {
            if (m.getExceedence() > 30) {
                label.setBackground(Color.RED);
            } else if (m.getExceedence() <= 30 && m.getExceedence() > 20) {
                label.setBackground(Color.ORANGE);
            } else if (m.getExceedence() <= 20 && m.getExceedence() > 10) {
                label.setBackground(Color.YELLOW);
            } else if (m.getExceedence() <= 10) {
                label.setBackground(Color.BLUE);
            }
        }
        return label;
    }

}
