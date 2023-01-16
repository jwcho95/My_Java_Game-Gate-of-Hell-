package fourth_week_project;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Monster_village_image extends JFrame{
	Image background;
	
	Monster_village_image(){
		this.background = new ImageIcon("./image/monster_village.jpeg").getImage();
		this.pack();
		setTitle("괴물들의 마을");
		setSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setPreferredSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setLocation(955,450);
		setVisible(false);
	}	
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
