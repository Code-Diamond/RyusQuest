import javax.swing.JLabel;

public abstract class Entity extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	public int getLeft()
	{
		return x;
	}
	public int getRight()
	{
		return x+50;
	}
	public int getTop()
	{
		return y;
	}
	public int getBottom()
	{
		return y+50;
	}
	
}
