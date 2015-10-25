import java.io.File;
import java.io.FileNotFoundException;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//import java.util.ArrayList;
import java.util.*;

public class footballParse {

public static void main(String[] args) {

    File file = new File("football.dat");
    Integer max_scorediff = 0;
    String max_club = "" ;

    try {

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
//            System.out.println(s);


	    String[] fields = s.split(" +");
	if ( Character.isDigit(fields[1].charAt(0)) )
	{	String club = fields[2];
    		String scorefor = fields[7];
    		String scoreagainst = fields[9];
		Integer scorediff = Integer.parseInt(scoreagainst) - Integer.parseInt(scorefor);
		if (scorediff < 0) { scorediff *= -1; }

		if (scorediff > max_scorediff ) 
			{max_scorediff=scorediff;
			max_club=club;
			}
	}

        }
        sc.close();
	System.out.print("Club with a smallest goal difference: ");
	System.out.println(max_club);
	System.out.print("Goal difference: ");
	System.out.println(max_scorediff);
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
 }
}
