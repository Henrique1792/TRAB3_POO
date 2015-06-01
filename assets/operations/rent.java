package assets.operations;


import assets.books.*;
import java.io.*;
import java.util.*;


public class rent extends operations{
    String nameaux;
    String titleaux;
    int newlimit;
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
}
