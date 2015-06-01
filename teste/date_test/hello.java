import java.util.*;
import java.io.*;




public class hello{
	public static void main(String[] args){
		write_date wd = new write_date();
		try{
			wd.write();
		}catch(IOException wbug){
			System.out.println("Não rolou");
		}
	}
}
