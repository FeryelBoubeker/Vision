package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import config.AppConfiguration;

public class RightPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private RightPanel instance=this;
	//private Dimension preferedSize=new Dimension(AppConfiguration.RIGHT_PANEL_WIDTH, AppConfiguration.RIGHT_AND_LEFT_PANEL_HEIGHT);
	private JLabel imageName= new JLabel("no image selected");
	private ImagePanel imagePanel= new ImagePanel();
	

	public RightPanel() {
		//instance.setPreferredSize(preferedSize);
		instance.setBackground(Color.LIGHT_GRAY);
		imageName.setPreferredSize(new Dimension(300, 50));
		instance.setLayout(new BoxLayout(instance, BoxLayout.Y_AXIS));
		instance.add(imageName);
		instance.add(imagePanel);
		
	}
	
	public JLabel getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName.setText(imageName);
	}

	public void setImage(File img) {
		this.imagePanel.setImage(img);
	}
	

	
	public ImagePanel getImagePanel() {
		return imagePanel;
	}

	public void setImagePanel(ImagePanel imagePanel) {
		this.imagePanel = imagePanel;
	}
}
