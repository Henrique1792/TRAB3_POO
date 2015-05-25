import java.io.*;
import java.util.*;


public class common implements user{
	String name;
	int limit, type, nbooks;
	Scanner sc;

//	void register() 

	public student(){
		this.set_UserName();
		this.set_UserType(0);
		this.set_UserLimit(15);
		this.set_Nbooks(2);
	}

	void set_UserName(){
		sc = new Scanner(System.in);
		this.name=sc.nextLine();
	}
	void set_UserType(int Type){
		this.type=Type;
	}
	void set_Nbooks(int nb){
		this.nbooks=nb;
	}
	void set_UserLimit(int Limit){
		this.limit=Limit;	
	}

}
