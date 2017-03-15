package Storage;

import java.awt.Color;

public class Cell
{
	private Color c1;
	private Color c2;
	private int x;
	private int y;
	private String net;
	
	public Cell(int col1, int col2, int x, int y, String net)
	{
		c1 = new Color(col1, col1, col1);
		c2 = new Color(col2, col2, col2);
		this.x = x;
		this.y = y;
		this.net = net;
	}
	
	public Color getC1()
	{
		return c1;
	}
	public Color getC2()
	{
		return c2;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public String getNet()
	{
		return net;
	}
}
