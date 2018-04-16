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
	private int x = 250, y = 800;
	private int brickX = 250, brickY = 250;
	public Gui()
	{
		super();
		setTitle("RYU'S QUEST!");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1280, 1024);
		setLocationRelativeTo(null);
		
		this.addKeyListener(this);
		panel.setLayout(null);
		add(panel);
		setVisible(true);
	}	
	public void render()
	{
		try {
			this.panel.removeAll();
			this.addRoboNinja();
			this.addBrick();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.repaint();
		this.revalidate();		
	}
	public void addRoboNinja() throws IOException
	{
        String path = "images/roboNinja01.png";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
		this.panel.add(label);
		label.setBounds(x, y,50,50);
	}
	public void addBrick() throws IOException
	{
        String path = "images/Brick01.png";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(image));
		this.panel.add(label);
		label.setBounds(brickX, brickY,50,50);
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
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			if(x>16)
			{
				if(x-15 > brickX+50 || x-15 < brickX || y > brickY+50 || y < brickY-50)
				{
					x-=15;
				}
					
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			if(x<1200)
			{
				if(x+15 > brickX+50 || x+65 < brickX || y > brickY+50 || y < brickY-50)
				{
					x+=15;	
				}
				

			}	
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			if(y<950)
			{
				if(y+15 > brickY+50 || y+65 < brickY || x > brickX+50 || x < brickX-50)
				{
					y+=15;
				}
	
			}	
		}
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			if(y > 16)
			{
				if(y-15 > brickY+50 || y-15 < brickY || x > brickX+50 || x < brickX-50)
				{
					y-=15;
				}		
	
			}
		}
	}


	public void keyReleased(KeyEvent e) 
	{
		
	}


	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException
	{
		Gui gui = new Gui();

		gui.addRoboNinja();
		gui.addBrick();
		while(true)
		{
			gui.render();
			
			try 
			{
				Thread.sleep(10);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}	
	}
}
