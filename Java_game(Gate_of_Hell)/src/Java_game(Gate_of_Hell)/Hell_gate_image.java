package fourth_week_project;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Hell_gate_image extends JFrame{
	Image background;
	
	Hell_gate_image(){
		this.background = new ImageIcon("./image/hell_gate.jpeg").getImage();
		this.pack();
		setTitle("�������� ������");
		setSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setPreferredSize(new Dimension(background.getWidth(null),background.getHeight(null)));
		setLocation(902,202);
		setVisible(false);
	}	
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
