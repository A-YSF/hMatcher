package sim;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
 
public class Match {
	
 
  private JFrame frame = new JFrame("hMatcher | Holistic Schema Matching");
  //frame.setBounds(100, 100, 450, 300);
  JPanel panel = new JPanel();
  private JTextField txtPathFst;
  private JTextField txtPathSd;
  private JTextField txtPathTd;
  
  void setNWalignment(JLabel b) {
	    b.setHorizontalAlignment(JLabel.LEFT);
	    b.setVerticalAlignment(JLabel.TOP);
	  }
 
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
       try {
    	   Match window = new Match();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
 
  /**
   * Create the application.
   */
  public Match() {
    initialize();
  }
 
  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
	  frame.setBounds(200, 200, 600, 400);
	  frame.setVisible(true);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.getContentPane().setBackground(Color.white);
    //frame.getContentPane().setLayout(null);
	  
	    FlowLayout fl = new FlowLayout();
	      panel.setLayout(fl);
	      panel.setBackground(Color.white);
	      panel.setAlignmentX(FlowLayout.TRAILING);
	      //  JPanel controls = new JPanel();
	       // controls.setLayout(new FlowLayout());
	      
	    GridBagConstraints gbc= new GridBagConstraints();
	    final GridBagConstraints gbcTwo= new GridBagConstraints();
	    JPanel scrollpane2 = new JPanel();
	    scrollpane2.setBackground(Color.white);
	    //JScrollPane scrollpane2 = new JScrollPane();
	    //scrollpane2.setPreferredSize(new Dimension(480, 150));
	    scrollpane2.setLayout(new GridBagLayout());
	    

	    final JPanel scrollpane3 = new JPanel();
	    scrollpane3.setBackground(Color.white);
	    //JScrollPane scrollpane2 = new JScrollPane();
	    //scrollpane2.setPreferredSize(new Dimension(480, 150));
	    scrollpane3.setLayout(new GridBagLayout());
	    
	    //panel.setLayout(new FlowLayout()); 
	   // panel.setLayout(new GridBagLayout()); 
	   // panel.setBackground(Color.white);
	     
	    gbc.insets = new Insets(10, 10, 10, 10);
	    gbcTwo.insets = new Insets(10, 10, 10, 10);
	    
	   // JLabel label = new JLabel("Choose the schemas to be matched");
	    gbc.gridx=0;
	    gbc.gridy=0;
	    
	    gbcTwo.gridx=0;
	    gbcTwo.gridy=0;
	   // scrollpane2.add(label, gbc);
	    
	    
	    ImageIcon icon = new ImageIcon("D:\\MyThesis\\Backup files\\Logos\\MyLogo.png");
	    //Image newImage = ((Image) icon).getScaledInstance(50, 100, Image.SCALE_DEFAULT);
	    JLabel labelicon = new JLabel(icon);
	  //  labelicon.setBounds(10,11,414,86);
	//    Image img = icon.getImage();
	   // Image newImg = img.getScaledInstance(labelicon.getWidth(), labelicon.getHeight(), Image.SCALE_SMOOTH);
	   // ImageIcon image = new ImageIcon(newImg);
	   // labelicon.setIcon(image);
	    gbc.gridx=0;
	    gbc.gridy=1;
	    scrollpane2.add(labelicon, gbc);
	    
	    JLabel labelFst = new JLabel("Schema #1");
	    setNWalignment(labelFst);
	    gbc.gridx=1;
	    gbc.gridy=2;
	    scrollpane2.add(labelFst, gbc);
	    
	    txtPathFst = new JTextField("Schema file path");
	    txtPathFst.setBounds(10, 10, 414, 21);
	    //frame.getContentPane().add(txtPathFst);
	    txtPathFst.setColumns(25);
        Font fieldFont = new Font("Arial", Font.ITALIC, 12);
        txtPathFst.setFont(fieldFont);
        txtPathFst.setBackground(Color.white);
        txtPathFst.setForeground(Color.black.brighter());
        //textField.setColumns(30);
      /*  txtPathFst.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));*/
	    gbc.gridx=2;
	    gbc.gridy=2;
	    scrollpane2.add(txtPathFst, gbc);
	    

	    JButton btnBrowseFst = new JButton("Browse");
	    btnBrowseFst.setBounds(10, 41, 87, 23);
	    gbc.gridx=3;
	    gbc.gridy=2;
	    btnBrowseFst.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnBrowseFst.setBackground(new Color(0x79BDE0));
	    btnBrowseFst.setForeground(Color.white);
	    btnBrowseFst.setUI(new StyledButtonUI());
        // customize the button with your own look
	    //btnBrowseFst.setUI(new StyledButtonUI());
	    scrollpane2.add(btnBrowseFst, gbc);
	    //frame.getContentPane().add(btnBrowseFst);
	    
	    
	    JLabel labelSd = new JLabel("Schema #2");
	    gbc.gridx=1;
	    gbc.gridy=3;
	    scrollpane2.add(labelSd, gbc);
	    //frame.getContentPane().add(label);
	    
	    
	    txtPathSd = new JTextField("Schema file path");
	    txtPathSd.setBounds(10, 10, 414, 21);
	    //frame.getContentPane().add(txtPathFst);
	    txtPathSd.setColumns(25);
        Font fieldFontSd = new Font("Arial", Font.ITALIC, 12);
        txtPathSd.setFont(fieldFontSd);
        txtPathSd.setBackground(Color.white);
        txtPathSd.setForeground(Color.black.brighter());
	    gbc.gridx=2;
	    gbc.gridy=3;
	    scrollpane2.add(txtPathSd, gbc);
	    
	    
	    JButton btnBrowseSd = new JButton("Browse");
	    btnBrowseSd.setBounds(10, 41, 87, 23);
	    gbc.gridx=3;
	    gbc.gridy=3;
	    btnBrowseSd.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnBrowseSd.setBackground(new Color(0x79BDE0));
	    btnBrowseSd.setForeground(Color.white);
	    btnBrowseSd.setUI(new StyledButtonUI());
	    scrollpane2.add(btnBrowseSd, gbc);
	    
	    JLabel labelTd = new JLabel("Schema #3");
	    gbc.gridx=1;
	    gbc.gridy=4;
	    scrollpane2.add(labelTd, gbc);
	    //frame.getContentPane().add(label);
	    
	    txtPathTd = new JTextField("Schema file path");
	    txtPathTd.setBounds(10, 10, 414, 21);
	    //frame.getContentPane().add(txtPathFst);
	    txtPathTd.setColumns(25);
        Font fieldFontTd = new Font("Arial", Font.ITALIC, 12);
        txtPathTd.setFont(fieldFontTd);
        txtPathTd.setBackground(Color.white);
        txtPathTd.setForeground(Color.black.brighter());
	    gbc.gridx=2;
	    gbc.gridy=4;
	    scrollpane2.add(txtPathTd, gbc);
	    
	    
	    JButton btnBrowseTd = new JButton("Browse");
	    btnBrowseTd.setBounds(10, 41, 87, 23);
	    gbc.gridx=3;
	    gbc.gridy=4;
	    btnBrowseTd.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnBrowseTd.setBackground(new Color(0x79BDE0));
	    btnBrowseTd.setForeground(Color.white);
	    btnBrowseTd.setUI(new StyledButtonUI());    
	    scrollpane2.add(btnBrowseTd, gbc);
	    
	    JButton btnPlus = new JButton("+");
	    btnPlus.setBounds(10, 41, 87, 23);
	    btnPlus.setPreferredSize(new Dimension(100, 40));
	    gbc.gridx=2;
	    gbc.gridy=5;
	    btnPlus.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnPlus.setBackground(new Color(0x79BDE0));
	    btnPlus.setForeground(Color.white);
	    btnPlus.setUI(new StyledButtonUI());
	  //  gbc.gridwidth=2;
	   // gbc.fill=GridBagConstraints.HORIZONTAL;
	    scrollpane2.add(btnPlus, gbc);
		
	    JButton btnGenerate = new JButton("Run");
	    btnGenerate.setBounds(10, 41, 87, 23);
	    btnGenerate.setPreferredSize(new Dimension(100, 40));
	    gbc.gridx=2;
	    gbc.gridy=6;
	    btnGenerate.setFont(new Font("Calibri", Font.PLAIN, 14));
	    btnGenerate.setBackground(new Color(0x79BDE0));
	    btnGenerate.setForeground(Color.white);
	    btnGenerate.setUI(new StyledButtonUI());
	  //  gbc.gridwidth=2;
	   // gbc.fill=GridBagConstraints.HORIZONTAL;
	    scrollpane2.add(btnGenerate, gbc);
	    
	    
	    //gbc.gridx=0;
	   // gbc.gridy=0;

	    panel.add(scrollpane2);
	    //frame.getContentPane().add(btnBrowseSd);
	    
	    
	/*	TextArea tasFst = new TextArea("",5,50); 
	    gbc.gridx=0;
	    gbc.gridy=2;
	    panel.add(tasFst, gbc);
	    
	    
		TextArea tasSd = new TextArea("",5,50);
	    gbc.gridx=3;
	    gbc.gridy=2;
		panel.add(tasSd, gbc);*/
	    
	   
	    

	    
	    
	   /* JLabel labelMts = new JLabel("Final matches generated by SMXSM:");
	    gbc.gridx=0;
	    gbc.gridy=7;
	    panel.add(labelMts, gbc);*/
	 /*    JLabel labelMts = new JLabel(" ");
	    gbcTwo.gridx=2;
	    gbcTwo.gridy=2;
	    scrollpane3.add(labelMts, gbcTwo);

	    JLabel labelMts2 = new JLabel(" ");
	    gbcTwo.gridx=2;
	    gbcTwo.gridy=3;
	    scrollpane3.add(labelMts2, gbcTwo);
	    
	    JLabel labelMts3 = new JLabel(" ");
	    gbcTwo.gridx=2;
	    gbcTwo.gridy=4;
	    scrollpane3.add(labelMts3, gbcTwo);
	    
	    JLabel labelMts4 = new JLabel(" ");
	    gbcTwo.gridx=2;
	    gbcTwo.gridy=5;
	    scrollpane3.add(labelMts4, gbcTwo);*/
	    
	    String[] columns = new String[] {
	            "Schema #1", "Schema #2", "Schema #3"
	        };
	         State sta = new State();
	        //actual data for the table in a 2d array
	        	        //create table with data
	        final JTable table = new JTable(sta.data, columns);
	        
	        btnGenerate.addActionListener(

                    new ActionListener()

{
                    	public void actionPerformed(ActionEvent event)

                        {
                	        
                	        TableColumnModel columnModel = table.getColumnModel();
                	        columnModel.getColumn(0).setPreferredWidth(210);
                	        columnModel.getColumn(1).setPreferredWidth(210);
                	        columnModel.getColumn(2).setPreferredWidth(210);
                	        table.setRowHeight(15);
                	       // table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                	        //add the table to the frame
                	        //this.add(new JScrollPane(table));
                	        gbcTwo.gridx=0;
                	        gbcTwo.gridy=6;
                	        //gbc.gridwidth=2;
                	        //gbc.fill=GridBagConstraints.HORIZONTAL;
                	        JScrollPane scrollpane = new JScrollPane(table);
                	        scrollpane.setPreferredSize(new Dimension(630, 300));
                	       // scrollpane2.add(btnGenerate, gbc);
                	        scrollpane3.add(scrollpane, gbcTwo);
                	        
                    	    TextArea taMatches = new TextArea(" SCHEMA MATCHING PROCESS COMPLETE."
                    	    		+ "\n FIRST SCHEMA. Total elements: 1589; Elements matched: 1586."
                    	    		+ "\n SECOND SCHEMA. Total elements: 3000; Elements matched: 2991."
                    	    		+ "\n THIRD SCHEMA. Total elements: 3010; Elements matched: 3000."
                    	    		+ "\n ",4,87);
                    	    gbcTwo.gridx=0;
                    	    gbcTwo.gridy=7;
                    	  //  gbc.gridwidth=2;
                    	   // gbc.fill=GridBagConstraints.HORIZONTAL;
                    	   scrollpane3.add(taMatches, gbcTwo);
                           panel.add(scrollpane3);
                	        //panel.add(scrollpane3);
                	        
                	        //table.setFillsViewportHeight(true);
                	        

                	    
                	  /*  JLabel labelMts = new JLabel("Final matches generated by SMXSM:");
                	    gbc.gridx=0;
                	    gbc.gridy=7;
                	    panel.add(labelMts, gbc);*/
                	    
                        }
}
);

    	    panel.setComponentOrientation(
                    ComponentOrientation.LEFT_TO_RIGHT);

    	    
    	    frame.add(panel);
	         
	    btnBrowseFst.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        JFileChooser fileChooser = new JFileChooser();
	 
	        // For Directory
	        //fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	 
	        // For File
	        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	 
	        fileChooser.setAcceptAllFileFilterUsed(false);
	 
	        int rVal = fileChooser.showOpenDialog(null);
	        if (rVal == JFileChooser.APPROVE_OPTION) {
	          txtPathFst.setText(fileChooser.getSelectedFile().toString());
	        }
	      }
	    });
	    
	    btnBrowseSd.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          JFileChooser fileChooser = new JFileChooser();
	   
	          // For Directory
	          //fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	   
	          // For File
	          fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	   
	          fileChooser.setAcceptAllFileFilterUsed(false);
	   
	          int rVal = fileChooser.showOpenDialog(null);
	          if (rVal == JFileChooser.APPROVE_OPTION) {
	            txtPathSd.setText(fileChooser.getSelectedFile().toString());
	          }
	        }
	      });
	    
	    btnBrowseTd.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          JFileChooser fileChooser = new JFileChooser();
	   
	          // For Directory
	          //fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	   
	          // For File
	          fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	   
	          fileChooser.setAcceptAllFileFilterUsed(false);
	   
	          int rVal = fileChooser.showOpenDialog(null);
	          if (rVal == JFileChooser.APPROVE_OPTION) {
	            txtPathTd.setText(fileChooser.getSelectedFile().toString());
	          }
	        }
	      });
	    
    
  }
  
  @SuppressWarnings("serial")
  class CustomeBorder extends AbstractBorder{
      @Override
      public void paintBorder(Component c, Graphics g, int x, int y,
              int width, int height) {
          // TODO Auto-generated method stubs
          super.paintBorder(c, g, x, y, width, height);
          Graphics2D g2d = (Graphics2D)g;
          g2d.setStroke(new BasicStroke(2));
          g2d.setColor(Color.gray);
          g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
      }   
  }

}
