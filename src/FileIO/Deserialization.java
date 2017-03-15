package FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import Storage.Cell;
import Storage.Generation;

public class Deserialization
{
	public ArrayList<ArrayList<String>> readIN(String path)
	{
		File folder = new File(path);
		File[] files = folder.listFiles();
		ArrayList<ArrayList<String>> des = new ArrayList<ArrayList<String>>();
		ArrayList<File> ffiles = new ArrayList<File>();
		for(File ff : files)
		{
			if(ff.getName().matches("\\d+"))
			{
				ffiles.add(ff);
			}
		}
		files = new File[ffiles.size()];
		for(int i = 0; i < files.length; i++)
		{
			files[i] = ffiles.get(i);
		}
		
		Arrays.sort(files, new Comparator<File>() {
		    public int compare(File f1, File f2) {
		        try {
		            int i1 = Integer.parseInt(numOnly(f1.getName()));
		            int i2 = Integer.parseInt(numOnly(f2.getName()));
		            return i1 - i2;
		        } catch(NumberFormatException e) {
		            throw new AssertionError(e);
		        }
		    }
		});
		
		
		for (File ff : files)
		{
			System.out.println(""+ff.getName());
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
	
	private String numOnly(String name)
	{
		return name.replaceAll("[^\\d]", "");
	}
}
