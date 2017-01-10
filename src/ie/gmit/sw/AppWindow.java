package ie.gmit.sw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

/**
 * @author Dara Starr - G00209787
 * 
 *GUI application window for running the Java program using JFrame.
 */
public class AppWindow {
	private JFrame frame;
	private String name;
	private AppSummary ap;
	private JTable table = new JTable();

	public AppWindow(){
		/**
		 * Create a window for the application
		 */
		frame = new JFrame();
		frame.setTitle("B.Sc. in Software Development - GMIT");
		frame.setSize(750, 600);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		
		JarReader jr = new JarReader();
		
        /**
         * This file panel will contain the file chooser
         */
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEADING));
        top.setBorder(new javax.swing.border.TitledBorder("Select Jar File"));
        top.setPreferredSize(new java.awt.Dimension(725, 150));
        top.setMaximumSize(new java.awt.Dimension(725, 150));
        top.setMinimumSize(new java.awt.Dimension(725, 150));
        
        final JTextField txtFileName =  new JTextField(20);
		txtFileName.setPreferredSize(new java.awt.Dimension(100, 30));
		txtFileName.setMaximumSize(new java.awt.Dimension(100, 30));
		txtFileName.setMargin(new java.awt.Insets(2, 2, 2, 2));
		txtFileName.setMinimumSize(new java.awt.Dimension(100, 30));
		/**
		 * Button to open file explorer
		 */
		JButton btnChooseFile = new JButton("Browse...");
		btnChooseFile.setToolTipText("Select Jar File");
        btnChooseFile.setPreferredSize(new java.awt.Dimension(90, 30));
        btnChooseFile.setMaximumSize(new java.awt.Dimension(90, 30));
        btnChooseFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnChooseFile.setMinimumSize(new java.awt.Dimension(90, 30));
		btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            
			public void actionPerformed(ActionEvent evt) {
        		JFileChooser fc = new JFileChooser("./");
        		int returnVal = fc.showOpenDialog(frame);
            	if (returnVal == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile().getAbsoluteFile();
                	name = file.getAbsolutePath(); 
                	txtFileName.setText(name);
                	System.out.println("You selected the following file: " + name);
            	}
			}
        });
		
		JButton btnOther = new JButton("Calculate Stability");
		
		top.add(txtFileName);
        top.add(btnChooseFile);
        top.add(btnOther);
        frame.getContentPane().add(top); //Add the panel to the window
        
        JPanel mid = new JPanel(new FlowLayout(FlowLayout.LEADING));
        mid.add(table);
        table.setPreferredSize(new java.awt.Dimension(690, 300));
        table.setMaximumSize(new java.awt.Dimension(690, 300));
        table.setMinimumSize(new java.awt.Dimension(690, 300));
        
        mid.setBorder(new BevelBorder(BevelBorder.RAISED));
        mid.setPreferredSize(new java.awt.Dimension(730, 300));
        mid.setMaximumSize(new java.awt.Dimension(730, 300));
        mid.setMinimumSize(new java.awt.Dimension(730, 300));
        
		frame.getContentPane().add(mid);
		
		
		btnOther.setToolTipText("Calculate Stability");
		btnOther.setPreferredSize(new java.awt.Dimension(150, 30));
		btnOther.setMaximumSize(new java.awt.Dimension(150, 30));
		btnOther.setMargin(new java.awt.Insets(2, 2, 2, 2));
		btnOther.setMinimumSize(new java.awt.Dimension(150, 30));

				btnOther.addActionListener(new ActionListener() {


				public void actionPerformed(ActionEvent evt) {

					// check if their is something entered in the filepath
					if(txtFileName.getText().length() > 1){
						MetricCalculator metric;
						try {
							metric = new MetricCalculator(name);
							
							ap = new AppSummary();
							// get handle on summary table model
							TypeSummaryTableModel tm = ap.getTableModel();

							// add metric data into table model
							tm.setTableData(metric.getData());
							table.setModel(tm);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else {

						System.out.println("No jar selected");
					} 
				}
			});
		
        
		
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setPreferredSize(new java.awt.Dimension(500, 50));
        bottom.setMaximumSize(new java.awt.Dimension(500, 50));
        bottom.setMinimumSize(new java.awt.Dimension(500, 50));
        
        
        JButton btnQuit = new JButton("Quit"); //Create Quit button
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.exit(0);
			}
        });
        
        bottom.add(btnQuit);

        frame.getContentPane().add(bottom);       
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AppWindow();
	}
}
