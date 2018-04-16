import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Gui extends JFrame implements KeyListener
{
	private JPanel panel = new JPanel();
	public Gui()
	{
		setTitle("RYU'S QUEST!");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1280, 1024);
		setLocationRelativeTo(null);
		
		
		panel.setLayout(null);
		
		add(panel);
		
		setVisible(true);
	}
	
	
	
	public void addProgressBar()
	{
		JProgressBar pb = new JProgressBar();
		//75% of the way
		pb.setValue(75);
		pb.setBounds(250,125, 120,35);
		this.panel.add(pb);
	}
	
	public void addButton()
	{
		JButton button = new JButton("Compile");
		button.setBounds(250,250,120,35);
		this.panel.add(button);
	}
	
	public void addImage() throws IOException
	{
        String path = "images/Brick01.png";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
		this.panel.add(label);
		label.setBounds(250, 800,50,50);
	}
	
	
	public void keyPressed(KeyEvent arg0) 
	{
		
	}


	public void keyReleased(KeyEvent arg0) 
	{
		
	}


	public void keyTyped(KeyEvent arg0) 
	{
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException
	{
		Gui gui = new Gui();
		//gui.addButton();
		//gui.addProgressBar();
		gui.addImage();
		
		
	}
	
	
	
}
