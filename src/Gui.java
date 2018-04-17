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
	private int brickX = 325, brickY = 800;
	private int tick = 0;
	
	private static RoboNinja roboNinja;
	private final int MOVEMENTSPEED = 10;
	
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
		//Going left
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			if(playerX>MOVEMENTSPEED)
			{
				if(roboNinja.getLeft()-MOVEMENTSPEED > brick.getRight() || roboNinja.getLeft()-MOVEMENTSPEED < brick.getLeft() || roboNinja.getTop() > brick.getBottom() || roboNinja.getBottom() < brick.getTop())
				{
					playerX-=MOVEMENTSPEED;
				}
					
			}
		}
		//Going Right
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			if(playerX<1200)
			{
				if(roboNinja.getLeft()+MOVEMENTSPEED > brick.getRight() || roboNinja.getRight()+MOVEMENTSPEED < brick.getLeft() || roboNinja.getTop() > brick.getBottom() || roboNinja.getBottom() < brick.getTop())
				{
					playerX+=MOVEMENTSPEED;	
				}
				

			}	
		}
		//Going Down
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			if(playerY<950)
			{
				if(roboNinja.getBottom()+MOVEMENTSPEED < brick.getTop() || roboNinja.getTop()+MOVEMENTSPEED > brick.getBottom() || roboNinja.getLeft() > brick.getRight() || roboNinja.getRight() < brick.getLeft())
				{
					playerY+=MOVEMENTSPEED;
				}
	
			}	
		}
		//Going Up
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			if(playerY > MOVEMENTSPEED)
			{
				if(roboNinja.getBottom()-MOVEMENTSPEED < brick.getTop() || roboNinja.getTop()-MOVEMENTSPEED > brick.getBottom() || roboNinja.getLeft() > brick.getRight() || roboNinja.getRight() < brick.getLeft())
				{
					playerY-=MOVEMENTSPEED;
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
