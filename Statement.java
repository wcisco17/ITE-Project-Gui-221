import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Statement {
public static void income(String filename) throws FileNotFoundException {
		
		//variable
		int inputno;
		String catein;
		double ininput;
		//double total = 0.0;
		
		//menu
		System.out.println("How many income do you want to insert?");
		inputno = Helper.scan.nextInt();
		
		//create array
		double[] aincome = new double[inputno];
		String[] category = new String[inputno];
		
		//input section
		for (int i = 0; i < inputno; i++) {
			System.out.println(i + 1 + " - Please input income");
			ininput = Helper.scan.nextDouble();
			Helper.scan.nextLine();
			do {
				System.out.println(i + 1 + " - What type of income?");
				System.out.println("Retail Sale (RS), Whole Sale (WS), or Other (OT)");
				catein = Helper.scan.nextLine();
			} while (!(catein.equalsIgnoreCase("RS") || catein.equalsIgnoreCase("WS") || catein.equalsIgnoreCase("OT")));
			category[i] = catein;
			aincome[i] = ininput;
		}
		
							/* File output */
		
		// Call make directory
		String fullpath = Helper.makedir(filename, Helper.INCOME);
		PrintStream writefile = new PrintStream (new File (fullpath));

		
		for (int j = 0; j < aincome.length; j++) {
			writefile.println(category[j]+aincome[j]);
		}
		
		// Return to the menu message
		System.out.println("=====================");
		System.out.println("Finished file output please check");
		System.out.println(fullpath);
		System.out.println("=====================");
		System.out.println("Returning to main menu");
		System.out.println();
		System.out.println();
	}


	
	
	// Method for expense
	
	public static void expense(String filename) throws FileNotFoundException {

		//variable
		int exputno;
		String cateex;
		double exinput;
		//double extotal = 0.0;
		
		//menu
		System.out.println("How many expense do you want to insert?");
		exputno = Helper.scan.nextInt();
		
		//create array
		double[] aexpense = new double[exputno];
		String[] excategory = new String[exputno];
		
		//input section
		for (int i = 0; i < exputno; i++) {
			System.out.println(i + 1 + " - Please input expense");
			exinput = Helper.scan.nextDouble();
			Helper.scan.nextLine();
			do {
				System.out.println(i + 1 + " - What type of expense?");
				System.out.println("Inventory (IV), Salary (SL), Utilities (UT), or Other (OT)");
				cateex = Helper.scan.nextLine();
			} while (!(cateex.equalsIgnoreCase("IV") || cateex.equalsIgnoreCase("SL") || cateex.equalsIgnoreCase("UT") || cateex.equalsIgnoreCase("OT")));
			excategory[i] = cateex;
			aexpense[i] = exinput;
			//extotal += aexpense[i];
		}
		
		//file output
		String fullpath = Helper.makedir(filename, Helper.EXPENSE);
		PrintStream writefile = new PrintStream (new File (fullpath));
		
		
		//printstream array
		for (int j = 0; j < aexpense.length; j++) {
			writefile.println(excategory[j]+aexpense[j]);
		}

		//return to menu message
		System.out.println("=====================");
		System.out.println("Finished file output please check");
		System.out.println(fullpath);
		System.out.println("=====================");
		System.out.println("Returning to main menu");
		System.out.println();
		System.out.println();
	}
	
}
