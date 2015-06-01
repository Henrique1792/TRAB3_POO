package assets.operations;

import assets.users.*;
import assets.books.*;
import java.io.*;
import java.util.*;


public class rent extends operations{
    String nameaux;
    String titleaux;
    int newlimit;
   	user USR;
	books BK;
	boolean returned;
    
    public void process (user novo, books book){
	        this.nameaux = novo.get_UserName();
	        this.titleaux = book.get_bookname();
	        if ((book.get_isRent() == false) && (novo.get_UserNbooks() > 0)){
			            newlimit = novo.get_UserLimit() - 1;
			            novo.set_UserLimit(newlimit);
			            book.set_Rent(true);
			            returned = false;
			        }
	    }
    public void reg_writer()throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("operations.csv",true));
		buffWrite.append(this.nameaux + " "+this.titleaux+" "+this.returned+"\n");
		buffWrite.close();
	} 
		        
	public void read_rent(String csv)throws IOException{
		String teste;
		BufferedReader buffRead = new BufferedReader(new FileReader(csv));
		teste=buffRead.readLine();
		System.out.println(teste);
		buffRead.close();
	}
	public void recoverAllUsers(String csv)throws IOException{
		String teste, parts[];
		BufferedReader reading = new BufferedReader(new FileReader(csv));
						
		while(reading.ready()){
			teste = reading.readLine();
			parts=teste.split(" ");
			this.nameaux=parts[0];
			this.titleaux=parts[1];
			System.out.println("Usuário: "+nameaux);	
			System.out.println("Título: "+this.titleaux);
			this.returned=Boolean.valueOf(parts[2]);
	        if(this.returned)
				System.out.print("devolvido");
			else
				System.out.print("pendente");
		}
		reading.close();
	}
	
	public void rent_elements(String username, String bookname){
		this.USR = new user();
		this.BK = new books();
		int priority;
		Scanner sc = new Scanner(System.in);
		this.USR.set_UserNameString(username);
		this.BK.set_BookTitleString(bookname);
		
		System.out.println("Qual é sua formação?");
		System.out.println("[0] Usuário comum");
		System.out.println("[1] Estudante");
		System.out.println("[0] Professor");
	
		priority = sc.nextInt();
		this.USR.set_UserType(priority);
		switch(priority){
			case '0':
					this.USR.set_UserLimit(15);
					this.USR.set_Nbooks(2);
					break;
			case '1':
					this.USR.set_UserLimit(15);
					this.USR.set_Nbooks(4);
				break;
			case '2':
					this.USR.set_UserLimit(60);
					this.USR.set_Nbooks(6);
				break;
		}
		this.process(this.USR,this.BK);

	}
}
