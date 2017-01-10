package ie.gmit.sw;

import javax.swing.table.AbstractTableModel;

public class TypeSummaryTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 777L;
	private String[] cols = {"Class Name", "Stability", "Out Degree", "In Degree"};
	private Object[][] data = {
		{"Stuff 1", "Other Stuff 1", "Even More Stuff 1", "even more more stuff"}
	};
	
	public void setTableData(Object[][] data){

	    this.data = data;
    }
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}
	
	public String getColumnName(int col) {
    	return cols[col];
    }

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return data[row][col];
	}
	
	 public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
	}

}
