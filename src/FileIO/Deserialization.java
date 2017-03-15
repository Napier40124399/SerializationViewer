package FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Storage.Cell;
import Storage.Generation;

public class Deserialization
{
	public ArrayList<ArrayList<String>> readIN(String path)
	{
		File folder = new File(path);
		File[] files = folder.listFiles();
		ArrayList<ArrayList<String>> des = new ArrayList<ArrayList<String>>();
		for (File ff : files)
		{
			if (ff.getPath().endsWith(".ser"))
			{
				try
				{
					FileInputStream fis = new FileInputStream(ff);
					ObjectInputStream ois = new ObjectInputStream(fis);
					des.add((ArrayList) ois.readObject());
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return des;
	}
	
	public ArrayList<Generation> makeCells(ArrayList<ArrayList<String>> des)
	{
		ArrayList<Generation> gens = new ArrayList<Generation>();
		for(ArrayList<String> gen : des)
		{
			ArrayList<Cell> cells = new ArrayList<Cell>();
			for(String s : gen)
			{
				String[] temp = s.split("/");
				cells.add(new Cell(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),temp[4]));
			}
			gens.add(new Generation(cells));
		}
		
		return gens;
	}
}
