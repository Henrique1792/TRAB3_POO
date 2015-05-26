//Importing our assets...
import assets.books.*;
import assets.users.*;
//Importing Java packages...
import java.io.*;
import java.util.*;

public class app{
	public static void main(String[] args){
		books novo= new books();
		String tmp = "books.csv";
		try{
		
			novo.reg_book(tmp);
		
		}catch(IOException openfile){
			System.out.println("Cannot open file");
		}
	}
}
