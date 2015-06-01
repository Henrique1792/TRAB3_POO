package assets.operations;


import assets.books.*;


import java.io.*;
import java.util.*;

/*
classe rent, realiza o empréstimo
*/
public class rent extends operations{
    
    
    
    public void process (user novo, books book){
        this.nameaux = novo.get_UserName();
        this.titleaux = book.get_bookname();
        if ((book.get_isRent() == false) && (novo.get_UserNbooks() > 0) && (novo.get_isSuspended() == false)){
            newlimit = novo.get_UserLimit() - 1;
            novo.set_UserLimit(newlimit);
            book.set_isRent(true);
            returned = false;
        }
    }
    /*
        Escreve registro do arquivo.
        obs= adicionar campos data atual e data de devolução
	*/
        public void reg_writer()throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("rents.csv",true));
		buffWrite.append(this.nameaux + " "+this.titleaux+" "+this.returned+"\n");
		buffWrite.close();
	} 
        
        /*
        Leitura de um objeto do arquivo
        ALTERADA
        */
	public void read_rent(String csv)throws IOException{
		String teste;
		BufferedReader buffRead = new BufferedReader(new FileReader(csv));
		teste=buffRead.readLine();
		System.out.println(teste);
		buffRead.close();
	}
        /* função que recupera todos os emprestimos */
	public void recoverRents(String csv)throws IOException{
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
