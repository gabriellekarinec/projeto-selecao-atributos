/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Book;
import model.Resultado;

/**
 *
 * @author AJFGC
 */
public class TableModelBook extends AbstractTableModel {
    
    private Resultado result;
    
    public TableModelBook(){
        
    }
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
