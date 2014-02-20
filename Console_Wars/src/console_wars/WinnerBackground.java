package console_wars;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WinnerBackground extends JPanel {
	private Image winnerImage;
	
	public WinnerBackground() throws IOException{
		winnerImage = ImageIO.read(new File("src/winner.jpg"));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(winnerImage, 100, 100, this);
	}
}
