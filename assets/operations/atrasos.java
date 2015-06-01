import java.io.*;
import java.util.*;
/**
 *
 * @author 8061452
 */
public class atrasos{    
    List<rent> emprestimos;
    public atrasos(String salefile) {
       this.emprestimos = new ArrayList<rent>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(salefile));
            String csv;
            while((csv = in.readLine()) != null) {
                emprestimos.add(new rent(csv));
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
