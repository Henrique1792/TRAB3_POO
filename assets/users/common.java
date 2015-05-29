package assets.users;

//Importing our assets...
import assets.users.user;

//Importing Java packages..
import java.io.*;
import java.util.*;

/*
classe comunidade , tipo 0, limite 15 dias, numero de livros permitidos 2
*/
public class common extends  user{
	public common(){
		this.set_UserName();
		this.set_UserType(0);
		this.set_UserLimit(15);
		this.set_UserNbooks(2);
	}
}
