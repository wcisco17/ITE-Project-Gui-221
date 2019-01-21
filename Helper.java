import java.io.File;


import java.io.Serializable;
import java.util.Scanner;

public class Helper implements Serializable {
	static Scanner scan = new Scanner (System.in);
	
	// Determine path file
	public static final String EXPENSE_PATH = "."+File.separator+"expense"+File.separator;
	public static final String INCOME_PATH = "."+File.separator+"income"+File.separator;
	
	public static boolean error = false;
	
	public static final byte INCOME = 2;
	public static final byte EXPENSE = 1;
	
	// Create a Directory method
	public static String makedir(String filename, byte mode) {
		String fPath = getPath(filename);
		String modePath = "";
		if(mode == INCOME) {
			modePath = INCOME_PATH;
		} else if(mode == EXPENSE) {
			modePath = EXPENSE_PATH;
		}
		String path = modePath+fPath;
		if(!mkdirs(path)) {
			System.err.println("Create directory "+path+" failed");
			System.exit(1);
		}
		return path+filename+".txt";
	}
	
	public static String getPath(String fileName) {
		return fileName.substring(5, 9)+File.separator+fileName.substring(2, 5)+File.separator;
	}
	
	public static boolean mkdirs(String path) {
		File f = new File(path);
		return f.exists() || f.mkdirs();
	}
	
//	 Helper to print out Values
	public static void out(Object o){
	    System.out.println(o.toString());
	}
	
	
	
}
