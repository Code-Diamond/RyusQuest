import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Explosion extends JLabel
{
	public Explosion(int x, int y, int animationCounter) throws IOException
	{
		String path = "";
		switch(animationCounter)
		{
			case 1:
				path = "images/explosion01.png";
				break;
			case 2:
				path = "images/explosion02.png";
				break;
			case 3:
				path = "images/explosion03.png";
				break;
			case 4:
				path = "images/explosion04.png";
				break;
			case 5:
				path = "images/explosion05.png";
				break;
			case 6:
				path = "images/explosion06.png";
				break;
			default:
				path = "images/explosion06.png";
				break;
		}
        
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
		setIcon(new ImageIcon(image));
		setBounds(x,y,50,50);
	}
}
