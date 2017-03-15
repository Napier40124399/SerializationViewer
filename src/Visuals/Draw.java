package Visuals;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Storage.Cell;
import Storage.Generation;

public class Draw
{
	private ArrayList<Generation> gens;
	public void draw(Graphics g, int generation, int scale)
	{
		for(Cell c : gens.get(generation).getCells())
		{
			g.setColor(c.getC2());
			g.fillRect(c.getX()*scale, c.getY()*scale, scale, scale);
		}
	}
	
	public void setGen(ArrayList<Generation> gens)
	{
		this.gens = gens;
	}
}
