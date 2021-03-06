package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * 
 * @author Dara Starr - G00209787
 * Class used to create the table in which the data will be displayed.
 * Extends JTable.
 *
 */
public class AppSummary extends JTable{
	private static final long serialVersionUID = 777L;	
	private TypeSummaryTableModel tm = null;
	private JTable table = null;
	private JScrollPane tableScroller = null;	
	
	public AppSummary (){
        createTable();
	}
	
	public TypeSummaryTableModel getTableModel(){

	    return tm;
    }
	
	/**
	 * Method to create a Table.
	 */
	private void createTable(){
		tm = new TypeSummaryTableModel();
		table = new JTable(tm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionBackground(Color.YELLOW);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
		TableColumn column = null;
		for (int i = 0; i < table.getColumnCount(); i++){
			
			column = table.getColumnModel().getColumn(i);
			if (i == 0){
				column.setPreferredWidth(100);
				column.setMaxWidth(100);
				column.setMinWidth(100);
			}else{
				column.setPreferredWidth(100);
				column.setMaxWidth(100);
				column.setMinWidth(100);
			}
		}

        tableScroller = new JScrollPane(table);
				
		
	}
	
}
