package assets.users;

import java.io.*;
import java.util.*;
/*
classe user 
*/
public class user{
	String name;
	int limit, type, nbooks;
	Scanner sc;
        
        /*
        Grava no arquivo de usuários
        */
	public void register_user()throws IOException{
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter("users.csv",true));
		buffWrite.append(this.name + " "+this.type+" "+this.nbooks+" "+this.limit+"\n");
		buffWrite.close();
	}
      
        /*
        Leitura do arquivo
        */
	public void read_user(String csv)throws IOException{
		String teste;
		BufferedReader buffRead = new BufferedReader(new FileReader(csv));
		teste=buffRead.readLine();
		System.out.println(teste);
		buffRead.close();
	}
        /*
        setter User name
        */
	void set_UserName(){
		sc = new Scanner(System.in);
		this.name = sc.nextLine();
	}
        
        /*
        setter User type
        */
	void set_UserType(int type){
		this.type = type;
	}

        /*
        setter User nbooks
        */
	void set_UserNbooks(int nb){
		this.nbooks = nb;
	}

        /*
        setter User limit
        */
	void set_UserLimit(int limit){
		this.limit = limit;	
	}
        
        /*
        getter User name
        */
        String get_UserName(){
            return this.name;
        }
        
        /*
        getter User nbooks
        */
        int get_UserNbooks(){
            return this.nbooks;
        }
        
        /*
        getter User limit
        */
        int get_UserLimit(){
            return this.limit;
        }
}