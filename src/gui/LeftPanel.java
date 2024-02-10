package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import config.AppConfiguration;

public class LeftPanel extends JPanel{

	
	private static final long serialVersionUID = 1L;
	private Dimension prferedSize= new Dimension(AppConfiguration.LEFT_PANEL_WIDTH, AppConfiguration.RIGHT_AND_LEFT_PANEL_HEIGHT);
	private RightPanel rightPanel;
	
	private JButton browse= new JButton("browse");
	private JButton start= new JButton("start");
	private String imagePath = "no image seleted";

	private LeftPanel instance= this;
	
	
	
	public LeftPanel(RightPanel rightPanel) {
		
		this.rightPanel= rightPanel;
		this.setPreferredSize(prferedSize);
		this.setBackground(Color.gray);
		
		browse.addActionListener(new browseAction());
		start.addActionListener(new startAction());
		
		this.add(start);
		this.add(browse);
		
		
	}
	
	private class browseAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			 JFileChooser imageChooser = new JFileChooser();
             // Set filter to show only image files
             FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
             imageChooser.setFileFilter(filter);

             int returnValue = imageChooser.showOpenDialog(null);
             if (returnValue == JFileChooser.APPROVE_OPTION) {
            	 File file=imageChooser.getSelectedFile();
            	 String imagePath =file.getAbsolutePath();
            	 //set the image name and the image display
            	 instance.rightPanel.setImageName(imagePath);
            	 instance.rightPanel.setImage(file);
             }
			
		}
		
	}
	
	private class startAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public JButton getBrowse() {
		return browse;
	}

	public void setBrowse(JButton browse) {
		this.browse = browse;
	}

	
	
	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
