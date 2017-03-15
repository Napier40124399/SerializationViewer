package Storage;

import java.util.ArrayList;

public class Generation
{
	private ArrayList<Cell> cells;
	public Generation(ArrayList<Cell> cells)
	{
		this.cells = (ArrayList<Cell>) cells.clone();
	}
	public ArrayList<Cell> getCells()
	{
		return cells;
	}
}
