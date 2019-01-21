import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Output {
	
	
	public static String getPath(String fileName) {
		return fileName.substring(5, 9)+File.separator+fileName.substring(2, 5)+File.separator;
	}
	
	//change file name for
	public static String padLeft(String s, int n) {
		return String.format("%"+n+"s", s).replace(' ', '0');
	}
	
	//method for get all file //list file = array of file
	public static List<File> getAllFiles(String directory) {
		List<File> arrayfile = new ArrayList<>();
		File filterdir = new File(directory);
		if(filterdir.exists()) {	
		if(filterdir.isFile()) { //filter see file
			arrayfile.add(filterdir); //then put in arrayfile
		} else {
			//create subfilter for recursive
			for(File subF : filterdir.listFiles()) {
				if(subF.isFile()) { //subfilter see file then put in array file
					arrayfile.add(subF);
				} else {
					arrayfile.addAll(getAllFiles(subF.getAbsolutePath())); //if subfilter see folder then go inside folder
				}
			}
		}
		}
		//return everything that has been added to arrayfile
		return arrayfile;
	}
	
	    // Make folder if not exist

		
		// Method to separate category
		public static String getCategory(String line) {
			return line.substring(0, 2);
		}
		
		// Method to get value
		public static double getValue(String line) {
			return Double.parseDouble(line.substring(2, line.length()-1)); //check first 2 character to identify category
		}
	
		// Method to get value for daily report
		public static double getValuedaily(String line) {
			return Double.parseDouble(line.substring(2, line.length())); //check first 2 character to identify category
		}
		

	
}

	
