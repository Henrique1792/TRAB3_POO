package assets.users;

//Importing our assets...
import assets.users.user;

//Importing Java packages..
import java.io.*;
import java.util.*;


public class common implements user{
	String name;
	int limit, type, nbooks;
	Scanner sc;

	void register(){

	}

	public common(){
		this.set_UserName();
		this.set_UserType(0);
		this.set_UserLimit(15);
		this.set_UserNbooks(2);
	}

	void set_UserName(){
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
