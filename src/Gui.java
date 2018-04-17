import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	private int playerX = 250, playerY = 800;
	private int brickX = 250, brickY = 250;
	private int tick = 0;
	
	private static RoboNinja roboNinja;
	private Brick brick;
	private JLabel ticker;
	
	private List<List<JLabel>> map = new ArrayList<List<JLabel>>();
	
	public Gui()
	{
		super();
		setTitle("                                                                                                                                                                                                RYU'S QUEST!");
		
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
		try 
		{
			this.panel.removeAll();
			this.addRoboNinja();
			this.addBrick();
			this.addTick();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		this.repaint();
		this.revalidate();		
	}

	
	public void addRoboNinja() throws IOException
	{
		roboNinja = new RoboNinja(playerX,playerY);
		this.panel.add(roboNinja);
	}
	public void addBrick() throws IOException
	{
		brick = new Brick(brickX, brickY);
		this.panel.add(brick);
	}
	public void addTick() throws IOException
	{
        ticker = new JLabel("Tick: "+tick);
		this.panel.add(ticker);
		ticker.setBounds(0, 0,5000,50);
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
			if(playerX>16)
			{
				if(playerX-15 > brickX+50 || playerX-15 < brickX || playerY > brickY+50 || playerY < brickY-50)
				{
					playerX-=15;
				}
					
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			if(playerX<1200)
			{
				if(playerX+15 > brickX+50 || playerX+65 < brickX || playerY > brickY+50 || playerY < brickY-50)
				{
					playerX+=15;	
				}
				

			}	
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			if(playerY<950)
			{
				if(playerY+15 > brickY+50 || playerY+65 < brickY || playerX > brickX+50 || playerX < brickX-50)
				{
					playerY+=15;
				}
	
			}	
		}
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			if(playerY > 16)
			{
				if(playerY-15 > brickY+50 || playerY-15 < brickY || playerX > brickX+50 || playerX < brickX-50)
				{
					playerY-=15;
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
				gui.tick++;
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.println("entity method:"+roboNinja.getLeft());
		}
		
		
		
		
	}
}
