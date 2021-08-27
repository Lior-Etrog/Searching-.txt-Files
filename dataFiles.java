package Intreview;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FilenameFilter;

public class dataFiles {
static  File currDir;
	public static void main(String[] args) {
		searching("C:\\Users\\etrog\\Desktop\\Data");
		}
		


	public static void changeDir(String dirName)
	{
		if(currDir == null) {
		currDir = new File(dirName);
		}
		else {
			currDir = new File (currDir, dirName);
		}
		
}
	public static List<String> listFiles() {
		String contents[] = currDir.list();
		List<String> listFiles = new ArrayList<String>();
		for(String name : contents) {
			if(name.endsWith(".txt")) {
				listFiles.add(name);
			}
		}
		return listFiles;
		
	}
	public static String[] dirList()
	{
		String[] directories = currDir.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		return directories;
	}
	
	public static void searching(String dirName) {
		changeDir(dirName);
		List<String> files =listFiles();
		String[] dir = dirList();
		for(String name : files) {
			System.out.println(name);
		}
		for(String name : dir) {
			System.out.println(name);
			searching(name);
			
		}
		
		
	}
}
	