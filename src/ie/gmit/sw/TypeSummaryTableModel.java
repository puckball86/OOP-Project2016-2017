package ie.gmit.sw;

import javax.swing.table.AbstractTableModel;
/**
 * 
 * @author Dara Starr - G00209787
 * Class used to set up the table needed to display Class name,
 * inDegree, outDegree and Stability
 *
 */

public class TypeSummaryTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 777L;
	private String[] cols = {"Class Name", "In-Degree", "Out-Degree", "Stability"};
	private Object[][] data = {
		{"Stuff 1", "Other Stuff 1", "Even More Stuff 1", "even more more stuff"}
		
	};
	/**
	 * Sets the data for the table.
	 * @param data
	 */
	public void setTableData(Object[][] data){

	    this.data = data;
    }
	
	/**
	 * Gets the number of columns.
	 */
	@Override
	public int getColumnCount() {
		
		return cols.length;
	}

	/**
	 * Gets the number of rows.
	 */
	@Override
	public int getRowCount() {
		
		return data.length;
	}
	
	public String getColumnName(int col) {
    	return cols[col];
    }

	@Override
	public Object getValueAt(int row, int col) {
		
		return data[row][col];
	}
	
	 public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
	}

}
