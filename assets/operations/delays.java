import java.io.*;
import java.util.*;

public class delays {
    
     
    List<rent> rents;
 
    public atrasos(String salefile) {
        rents = new ArrayList<rent>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(salefile));
            String csv;
            while((csv = in.readLine()) != null) {
                rents.add(new rent(csv));
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File " + salefile + " was not found!");
        }
        catch(IOException e) {
            System.out.println("Error reading the file!");
        }
    }
}