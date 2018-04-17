import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Brick extends Entity
{
	
	public Brick(int startX, int startY) throws IOException
	{
		
        String path = "images/Brick01.png";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
		setIcon(new ImageIcon(image));
		setBounds(startX,startY,50,50);
		x=startX;
		y=startY;
	}
	
	
	
	
}
