import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	private int playerX = 250,
				playerY = 800;
	private static RoboNinja roboNinja;
	private final int MOVEMENTSPEED = 10;
	private Random random = new Random();
	
	private JLabel ticker;	
	private int tick = 0;
	
	private static int explosionAnimationCounter = 1;
	public static List<Brick> brickList = new ArrayList<Brick>();

	private List<List<JLabel>> map = new ArrayList<List<JLabel>>();
	
	
	private static Explosion explosion;
	
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
			for(int i = 0; i < brickList.size(); i++)
			{
				this.addBrick(brickList.get(i));	
			}
			
			this.addTick();
			this.addExplosion(500,20,explosionAnimationCounter);
			if(tick%10==0)
			{
				if(explosionAnimationCounter < 7)
				{
					explosionAnimationCounter++;
				}
				else
				{
					explosionAnimationCounter  = 1;
				}				
			}

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
	public void addBrick(int xCor, int yCor) throws IOException
	{
		Brick brick = new Brick(xCor,yCor);
		brickList.add(brick);
		this.panel.add(brick);
	}
	
	public void addBrick(Brick brick) throws IOException
	{
		this.panel.add(brick);
	}
	
	public void addExplosion(int x, int y, int animationCounter) throws IOException
	{
		explosion = new Explosion(x,y,animationCounter);
		this.panel.add(explosion);
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
			boolean collided = false;
			for(int i = 0; i < brickList.size(); i++)
			{
				if(playerX>MOVEMENTSPEED)
				{
					if(roboNinja.getLeft()-MOVEMENTSPEED > brickList.get(i).getRight() || roboNinja.getLeft()-MOVEMENTSPEED <  brickList.get(i).getLeft() || roboNinja.getTop() >  brickList.get(i).getBottom() || roboNinja.getBottom() <  brickList.get(i).getTop())
					{
						//Purposely blank
					}
					else
					{
						collided = true;
					}
				}
				else
				{
					collided = true;
				}
			}
			if(!collided)
			{
				playerX-=MOVEMENTSPEED;	
			}
			

		}
		//Going Right
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			boolean collided = false;
			for(int i = 0; i < brickList.size(); i++)
			{
				if(playerX<1200)
				{
					if(roboNinja.getLeft()+MOVEMENTSPEED >  brickList.get(i).getRight() || roboNinja.getRight()+MOVEMENTSPEED <  brickList.get(i).getLeft() || roboNinja.getTop() >  brickList.get(i).getBottom() || roboNinja.getBottom() <  brickList.get(i).getTop())
					{
						//Purposely blank
					}
					else
					{
						collided = true;
					}
				}
				else
				{
					collided = true;
				}
			}
			if(!collided)
			{
				playerX+=MOVEMENTSPEED;		
			}
	
		}
		//Going Down
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			boolean collided = false;
			for(int i = 0; i < brickList.size(); i++)
			{
				if(playerY<950)
				{
					if(roboNinja.getBottom()+MOVEMENTSPEED <  brickList.get(i).getTop() || roboNinja.getTop()+MOVEMENTSPEED >  brickList.get(i).getBottom() || roboNinja.getLeft() >  brickList.get(i).getRight() || roboNinja.getRight() <  brickList.get(i).getLeft())
					{
						//Purposely Blank
					}
					else
					{
						collided = true;
					}
				}	
				else
				{
					collided = true;
				}
			}
			if(!collided)
			{
				playerY+=MOVEMENTSPEED;
			}

		}
		//Going Up
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			boolean collided = false;
			for(int i = 0; i < brickList.size(); i++)
			{
				if(playerY > MOVEMENTSPEED)
				{
					if(roboNinja.getBottom()-MOVEMENTSPEED <  brickList.get(i).getTop() || roboNinja.getTop()-MOVEMENTSPEED >  brickList.get(i).getBottom() || roboNinja.getLeft() >  brickList.get(i).getRight() || roboNinja.getRight() <  brickList.get(i).getLeft())
					{
						//Purposely Blank
					}
					else
					{
						collided = true;
					}
				}	
				else
				{
					collided = true;
				}				
			}
			if(!collided)
			{
				playerY-=MOVEMENTSPEED;
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
		for(int i = 150; i <= 900; i+=150)
		{
			gui.addBrick(i,i);
		}
		
		explosion = new Explosion(500,20,explosionAnimationCounter);
		gui.add(explosion);
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
//			System.out.println("entity method:"+roboNinja.getLeft());
		}
		
		
		
		
	}
}

