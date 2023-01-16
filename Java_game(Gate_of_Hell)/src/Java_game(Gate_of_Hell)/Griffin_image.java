package fourth_week_project;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Griffin_image extends JFrame{
	Image background;
	
	Griffin_image(){
		this.background = new ImageIcon("./image/griffin.jpeg").getImage();
		this.pack();
		setTitle("±×¸®ÇÉ");
		setSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setPreferredSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setLocation(682,325);
		setVisible(false);
	}	
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
