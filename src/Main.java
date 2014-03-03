/*
 * Author : Ahemd Fathy Aly
 * This program tries to get the combination with the least error that is the result of combining a set of input resistances
 * The algorithm used is a greedy heuristic 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{

		JFrame mainFrame = new MainFrame();
		mainFrame.setSize(600, 350);
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e)
		{
		}
		mainFrame.show();

	}

}
