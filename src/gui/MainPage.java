package gui;

import java.awt.BorderLayout;
import java.awt.Container;


import javax.swing.JFrame;

import config.AppConfiguration;



public class MainPage extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	
	private RightPanel rightPanel=new RightPanel();
	private LeftPanel leftPanl= new LeftPanel(rightPanel);
	private ImagePanel imagePan= this.rightPanel.getImagePanel();
	
	public MainPage(String title) {
		super(title);
		init();
	}
	public void init() {
		// the code for initiating the GUI
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// adding components
		
		contentPane.add(rightPanel, BorderLayout.EAST);
		contentPane.add(leftPanl, BorderLayout.WEST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(false);
		
	}
	@Override
	public void run() {
		// local variables
		int i=200;
		int j=200;
		while (true) {
			
			try {
				Thread.sleep(AppConfiguration.ANALYZE_SPEED);
				
			} catch (InterruptedException e){
				System.out.println(e.getMessage());
			}
			
			// for painting the blocks in imagePanel
			if(i<AppConfiguration.TERRAIN_IMAGE_WIDTH) {
				this.imagePan.setPosX(i);	
				i+=200;
			}else {
				if(j<AppConfiguration.TERRAIN_IMAGE_WIDTH) {
					i=0;
					this.imagePan.setPosY(j);
					this.imagePan.setPosX(i);	
					i+=200;
					j+=200;
				}
				
				
			}
			
			this.rightPanel.getImagePanel().repaint();
		}
	}
}
