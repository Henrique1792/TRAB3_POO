package assets.users;

//Importing Java packages...
import java.io.*;
import java.util.*;

public class user{

	String name;
	String delim;
	int limit, type, nbooks, rents;
	Scanner sc;

	//"suspended until" variables
	public int sDay, sMon, sYear;

	public boolean has_ReachedLimit(){
		if(this.get_UserRents() < this.get_UserNbooks()){
			return false;
		}
		return true;
	}

	public void register_user(String csv) throws IOException{
		this.delim = ",";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(csv,true));
		buffWrite.append(this.name + delim + this.type + delim + this.nbooks + delim + this.limit + delim + this.rents + delim + this.sDay + delim + this.sMon + delim + this.sYear + "\n");
		buffWrite.close();
	}

	public int[] read_user(String csv, String name) throws IOException{
		int[] ok = new int[2];
		String teste, parts[];
		BufferedReader reading = new BufferedReader(new FileReader(csv));

		ok[1]--; //contador da posição começa em -1
		while(reading.ready() && ok[0] == 0){
			teste = reading.readLine();
			parts = teste.split(",");

			if(parts[0].equals(name)){
				this.set_UserNameString(parts[0]);
				this.set_UserType(Integer.parseInt(parts[1]));
				this.set_UserNbooks(Integer.parseInt(parts[2]));
				this.set_UserLimit(Integer.parseInt(parts[3]));
				this.set_UserRents(Integer.parseInt(parts[4]));
				this.set_UserSuspend(Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),Integer.parseInt(parts[7]));
				ok[0] = 1;
			}

			ok[1]++; //incrementa contador para verificar offset
		}

		reading.close();
		return ok;
	}

	public void set_UserNameString(String name){
		this.name = name;
	}

	public void set_UserType(int type){
		this.type = type;
	}

	public void set_UserNbooks(int nb){
		this.nbooks = nb;
	}

	public void set_UserLimit(int limit){
		this.limit = limit;	
	}

	public void set_UserRents(int rents){
		this.rents = rents;	
	}

	public void set_UserSuspend(int day, int mon, int year){
		this.sDay = day;	
		this.sMon = mon;
		this.sYear = year;
	}

	public String get_UserName(){
		return this.name;
	}

	public int get_UserType(){
		return this.type;
	}

	public int get_UserNbooks(){
		return this.nbooks;
	}

	public int get_UserLimit(){
		return this.limit;	
	}

	public int get_UserRents(){
		return this.rents;
	}

	public void print_User(){
		this.delim = "/";
		System.out.println("\n[Nome]: " + this.name);
		this.print_Type();
		System.out.println("[Limite de Empréstimos]: " + get_UserNbooks());
		System.out.println("[Tempo-Limite Para Devolução]: " + get_UserLimit());
		System.out.println("[Livros Emprestados]: " + get_UserRents());
		if(this.sDay == 0 && this.sMon == 0 && this.sYear == 0)
			System.out.println("[Suspenso]: Não");
		else System.out.println("[Suspenso]: " + this.sDay + delim + this.sMon + delim + this.sYear);
	}

	void print_Type(){
		switch(this.type){
			case 0:
				System.out.println("[Tipo]: Comunidade");
				break;
			case 1:
				System.out.println("[Tipo]: Aluno");
				break;
			case 2:
				System.out.println("[Tipo]: Professor");
				break;
		}
	}

	void set_UserName(){;
		System.out.printf("\t>Digite o nome de usuário: ");
		sc = new Scanner(System.in);
		this.name = sc.nextLine();
	}

}
