package assets.operations;

//Importing our assets...
import assets.users.*;
import assets.books.*;

//Importing Java packages...
import java.io.*;
import java.util.*;
import java.time.*;


public class rent extends operations{
    String nameaux;
    String titleaux;
    String delim;
    int day,mon,year;

   	user Usr;
	books Bk;

	public String get_NameAux(){
		return this.nameaux;
	}

	public String get_TitleAux(){
		return this.titleaux;
	}

	public void register_rent(String csv) throws IOException{
    	this.delim = ",";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(csv,true));
		buffWrite.append(this.nameaux + delim + this.titleaux + delim + day + delim + mon + delim + year + "\n");
		buffWrite.close();
	} 
		        
	public int[] read_rent(String csv, String name, String title) throws IOException{
		int[] ok = new int[2];
		String teste, parts[];
		BufferedReader reading = new BufferedReader(new FileReader(csv));

		ok[1]--; //contador da posição começa em -1
		while(reading.ready() && ok[0] == 0){
			teste = reading.readLine();
			parts = teste.split(",");

			if(parts[0].equals(name) && parts[1].equals(title)){
				this.nameaux = parts[0];
				this.titleaux = parts[1];
				this.day = Integer.parseInt(parts[2]);
				this.mon = Integer.parseInt(parts[3]);
				this.year = Integer.parseInt(parts[4]);

				ok[0] = 1;
			}

			ok[1]++; //incrementa contador para verificar offset
		}

		reading.close();
		return ok;
	}

	public void print_rent(){
		System.out.println("[Usuário]: " + this.nameaux);	
		System.out.println("[Livro]: " + this.titleaux);
		System.out.println("[Data]: " + this.day + "/" + this.mon + "/" + this. year + "\n");
	}
	
	public void rent_elements(user Usr, books Bk) throws IOException{
		this.nameaux = Usr.get_UserName();
		this.titleaux = Bk.get_BookTitle();

		Usr.read_user("users.csv", this.nameaux);

		if(Usr.has_ReachedLimit()){
			System.out.println("\n\tO usuário atingiu o limite de empréstimos D:\n");
			return;
		}

		if(Usr.is_Suspended()){
			System.out.println("\n\tO usuário está suspenso e não pode alugar agora D:\n");
			return;
		}

		Bk.read_book("books.csv", this.titleaux);

		//Verifica se está alugado
		if(!Bk.get_isRent()){
			//Verifica se é global
			if(!Bk.get_isGlobal()){
				//Verifica se há conflito de permissão
				if(Usr.get_UserType() == 0){
					System.out.println("\n\tO usuário não pode alugar esse livro D:\n");
					return;
				}
			}

			LocalDate today = LocalDate.now();
			this.day = today.getDayOfMonth();
			this.mon = today.getMonthValue();
			this.year = today.getYear();

			Bk.set_isRent(true);
			Usr.set_UserRents(Usr.get_UserRents() + 1);
			this.register_rent("rents.csv");
			System.out.println("\n\tOK! O livro pôde ser alugado :D\n");

			return;

		}
		else System.out.println("\n\tO livro está alugado D:\n");

	}
}
