package fourth_week_project;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Hell_gate_2_image extends JFrame{
	Image background;
	
	Hell_gate_2_image(){
		this.background = new ImageIcon("./image/hell_gate_2.jpeg").getImage();
		this.pack();
		setTitle("´ÝÇô°¡´Â Áö¿Á¹®");
		setSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setPreferredSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setLocation(771,215);
		setVisible(false);
	}	
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
