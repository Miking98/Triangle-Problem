import java.io.*;
import java.util.*;

public class triangle_prob {
	public static void main ( String [] args ) throws IOException {
        
        //Calc number of rows for initializing triangle_array
        
        BufferedReader prelim_f = new BufferedReader(new FileReader("triangle_input.txt")); //Read every row to find total num of rows
        int num_rows = 0;
        while ((file_line = prelim_f.readLine()) != null) {
            num_rows++
        }
        BufferedReader f = new BufferedReader(new FileReader("triangle_input.txt")); //Read actual line content
        
        int [] [] triangle_array = new int [num_rows] [num_rows];
        
        String line;
        
        while ((line = f.readLine()) != null) {
            String [] linecontent = line.split("\\s+"); //Content of line- each element is an Integer
            for (int g=0; g<linecontent.length; g++) {
                triangle_array[i][g]=Integer.parseInt(linecontent[g]);
            }
        }
        
        //Start at second to last row- add up each nodes children- this ensures maximum path weight
        //Progress till top of tree is reached
        //That value will be maximum weight possible
        for (int i=triangle_array.length-2; i>=0; i--) { //Every row, repeat minification -- start at second to last row
            for (int g=0; g<=i; g++) {
                int greatestnode=0;
                if (triangle_array[i+1][g]>triangle_array[i+1][g+1]) {
                    greatestnode=triangle_array[i+1][g];
                }
                else {
                    greatestnode=triangle_array[i+1][g+1];
                }
                triangle_array[i][g]+=greatestnode;  //Add greatest node to the row column's value
            }
        }
        
        System.out.println("Highest possible total: "+triangle_array[0][0]);
    }
}
