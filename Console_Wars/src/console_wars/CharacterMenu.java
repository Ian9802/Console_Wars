package console_wars;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CharacterMenu {
	
	private JFrame frame;
	private ImageIcon image;
	
	
	CharacterMenu(int selection) throws IOException{
		
		generalMenu(selection);
	}


	private void generalMenu(int selection) throws IOException {
		this.frame = new JFrame("General Selection");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		Units[] general = SQLBackend.getUnits();
		//This is Microsoft
		String genString = general[selection].toString();
		this.image = new ImageIcon(ImageIO.read(getClass().getResource(genString + ".jpg")));
		JButton genImageButton = new JButton(genString);
		genImageButton.setIcon(image);
		genImageButton.setHorizontalTextPosition(AbstractButton.CENTER);
		genImageButton.setVerticalTextPosition(AbstractButton.BOTTOM);
		
		contentPane.add(genImageButton);
		
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		
	}
}
