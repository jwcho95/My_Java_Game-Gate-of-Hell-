package fourth_week_project;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Dragon_image extends JFrame{
	Image background;
	
	Dragon_image(){
		this.background = new ImageIcon("./image/dragon.jpeg").getImage();
		this.pack();
		setTitle("드래곤 (지옥의 바람을 관장하는 용)");
		setSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setPreferredSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setLocation(786,202);
		setVisible(false);
	}	
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
