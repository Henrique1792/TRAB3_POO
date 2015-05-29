package assets.users;

//Importing Java packages...
import java.io.*;
import java.util.*;

public class teacher extends user{
	public teacher(){
		this.set_UserName();
		this.set_UserType(1);
		this.set_UserLimit(15);
		this.set_UserNbooks(4);
	}
}
