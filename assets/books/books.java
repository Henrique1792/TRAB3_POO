package assets.books;

import java.io.*;
import java.util.*;

/*
classe books , isglobal para texto ou geral, isrent para disponibilidade
*/
public class books{
	boolean isGlobal = false;
	boolean isRent = false;
	String title;
	Scanner reading;
	
        /*
        construtor
        */
	public books(){
		this.set_bookname();
		this.set_isGlobal();
		this.set_Rent(false);
	}
       
        /*
        escrita no arquivo books
        */
	public void reg_book(String csv)throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(csv,true));
		buffWrite.append(this.title+" "+this.isGlobal+" "+this.isRent+"\n");
		buffWrite.close();
	}
        
        /*
        leitura do arquivo
        */
	public void read_book(String csv)throws IOException{
		String teste;
		BufferedReader buffRead = new BufferedReader(new FileReader(csv));
		teste=buffRead.readLine();
		System.out.println(teste);
		buffRead.close();
	}
	
        /*
        setter book name
        */
	void set_bookname(){
		this.reading=new Scanner(System.in);
		this.title=this.reading.nextLine();
	}
        
        /*
        getter book name
        */
        String get_bookname(){
            return this.title;
        }
	
        /*
        setter is global
        */
	void set_isGlobal(){
		String receiver;
		System.out.println("It's a general book? <YES/NO>");
		this.reading=new Scanner(System.in);
		receiver=reading.nextLine();
		if(receiver.equals("YES"))
			this.isGlobal=true;
		else
			this.isGlobal=false;

	}
        
        /*
        getter is global
        */
        boolean get_isGlobal(){
		return this.isGlobal;
	}
        
        /* 
        setter is rent
        */
        void set_Rent(boolean check){
		check=this.isRent;
	}
        /*
        getter is rent
        */
	boolean get_isRent(){
		return this.isRent;
	}
	
	
}
