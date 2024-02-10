package gui;


import java.awt.Color;
import java.awt.Dimension;
 
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import config.AppConfiguration;


// we devid and draw things here
public class ImagePanel extends JPanel{

	
	private static final long serialVersionUID = 1L;
	private Dimension preferedSize= new Dimension(AppConfiguration.TERRAIN_IMAGE_WIDTH, AppConfiguration.TERRAIN_IMAGE_HEIGHT);
	private BufferedImage image;
	private int posX=0;
	private int posY=0;
	
	

	public ImagePanel() {
		this.setPreferredSize(preferedSize);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// draw the image if it's not null
		
		if(image!=null) {
			g.drawImage(image, 0, 0, AppConfiguration.TERRAIN_IMAGE_WIDTH, AppConfiguration.TERRAIN_IMAGE_HEIGHT, this);
		}
		g.setColor(Color.GRAY);
		// vertical lines 
		g.drawLine(200, 0, 200, 600);
		g.drawLine(400, 0, 400, 600);
		g.drawLine(600, 0, 600, 600);
		// horizontal lines
		g.drawLine(0, 200, 800, 200);
		g.drawLine(0, 400, 800, 400);
		// fill the squares  with red  
		g.setColor(Color.red);
		
	
		g.fillRect(posX,posY,200,200);
			
		
	}
	
	public void setImage(File file){
		 try {
	            // load the image from file
	            this.image = ImageIO.read(file);
	            // repaint the panel to update the displayed image
	            repaint();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
