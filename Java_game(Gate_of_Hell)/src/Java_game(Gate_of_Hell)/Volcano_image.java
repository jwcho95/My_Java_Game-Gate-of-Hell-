package fourth_week_project;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Volcano_image extends JFrame{
	Image background;
	
	Volcano_image(){
		this.background = new ImageIcon("./image/volcano.jpeg").getImage();
		this.pack();
		setTitle("»≠ªÍ ¡ﬂ≈Œ");
		setSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setPreferredSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setLocation(905,477);
		setVisible(false);
	}	
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
