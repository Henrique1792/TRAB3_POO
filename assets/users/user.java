package assets.users;

//Importing Java packages...
import java.io.*;
import java.util.*;

public class user{
	String name;
	int limit, type, nbooks;
	Scanner sc;

	 public void register_user() throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("users.csv",true));
		buffWrite.append(this.name + " " + this.type + " " + this.nbooks + " " + this.limit + "\n");
		buffWrite.close();
	}

	public void read_user(String csv) throws IOException{
		String teste;
		BufferedReader buffRead = new BufferedReader(new FileReader(csv));
		teste = buffRead.readLine();
		buffRead.close();
	}

	public void print_User(){
		this.print_Name();
		this.print_Type();
	}

	void print_Name(){
		System.out.println("\n[Nome]: " + this.name);
	}

	void print_Type(){
		System.out.println("[Tipo]: Usuário");
	}

	void set_UserName(){
		System.out.printf("	>Digite o nome de usuário: ");
		sc = new Scanner(System.in);
		this.name = sc.nextLine();
	}

	void set_UserType(int type){
		this.type = type;
	}

	void set_UserNbooks(int nb){
		this.nbooks = nb;
	}

	void set_UserLimit(int limit){
		this.limit = limit;	
	}
}
