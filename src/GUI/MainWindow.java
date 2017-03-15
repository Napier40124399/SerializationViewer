package GUI;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import FileIO.Deserialization;
import Visuals.Draw;

public class MainWindow
{
	private Deserialization deserialization;
	private Draw d;
	private JFrame frame;
	private JPanel panel;
	private String path = "C:\\Users\\hoijf\\Documents\\sims\\Local\\test";

	int i = 0;
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow()
	{
		initialize();
	}

	private void initialize()
	{
		d = new Draw();
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		panel = new JPanel()
		{
			@Override
			protected void paintComponent(Graphics g)
			{
				d.draw(g, i++, 6);
			}
		};
		panel.setBounds(0, 0, 500, 500);
		frame.getContentPane().add(panel);
		
		panel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				panel.repaint();
			}
		});
		
		deserialization = new Deserialization();
		d.setGen(deserialization.makeCells(deserialization.readIN(path)));
		
		panel.repaint();
	}

}
