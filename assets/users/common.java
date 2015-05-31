package assets.users;

//Importing Java packages...
import java.io.*;
import java.util.*;

public class common extends user{

	public common(){
		this.set_UserName();
		this.set_UserType(0);
		this.set_UserLimit(15);
		this.set_UserNbooks(2);
	}

}
