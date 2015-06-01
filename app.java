//Importing our assets...
import assets.books.*;
import assets.users.*;
//Importing Java packages...
import java.io.*;
import java.util.*;

public class app {
	public static void main  (String[] args){
		books novo= new books();
		String tmp = "books.csv";
		//try{
		//    novo.reg_book(tmp);
		//}catch(IOException openfile){
                //System.out.println("Cannot open file");

		delays sr = new delays(args[0]);
        //stream dos livros não devolvidos ainda
        sr.rents 
            .stream()
            .filter(s -> s.getreturned() == false)
            .forEach(s -> System.out.println(s.getnameaux()));
        System.out.println("-------");
        
        //stream dos livros cuja data está atrasada
        
        
		}
        }
	

