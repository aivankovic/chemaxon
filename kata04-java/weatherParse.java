import java.io.File;
import java.io.FileNotFoundException;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//import java.util.ArrayList;
import java.util.*;


public class weatherParse {

public static boolean isNumeric(String s) {  
    return s.matches("[-+]?\\d*\\.?\\d+");  
}  
public static void main(String[] args) {

    File file = new File("weather.dat");
    Integer min_tempspread = 2147483647;
    String min_day = "" ;
    String day = "";
    String tempmin = "";
    String tempmax = "";
    Integer tempdiff = 0;


    try {

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
//            System.out.println(s);

	if(s != null && !s.isEmpty())	
	{

	    String[] fields = s.split(" +");
//            System.out.println(fields[1]);
	if ( Character.isDigit(fields[1].charAt(0)) == true )
	{	day = fields[1];
    		tempmin = fields[3];
    		tempmax = fields[2];
		if (isNumeric(tempmin) && isNumeric(tempmax))
		{
		tempdiff =  Integer.parseInt(tempmax) -  Integer.parseInt(tempmin);
		} 	
		else {tempdiff =2147483647;}
		if (tempdiff < min_tempspread ) 
			{min_tempspread=tempdiff;
			min_day=day;
//			 System.out.print(" Uj min  ");
			}
	}




        }
        }
        sc.close();
	System.out.print("Day number     : ");
	System.out.println(min_day);
	System.out.print("Smallest spread: ");
	System.out.println(min_tempspread);
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
 }
}
