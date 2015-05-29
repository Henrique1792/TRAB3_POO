package assets.users;

import java.io.*;
import java.util.*;

/*
classe professor , tipo 1, limite 60 dias, numero de livros permitidos 6
*/
public class teacher extends user{
	public teacher(){
		this.set_UserName();
		this.set_UserType(1);
		this.set_UserLimit(60);
		this.set_UserNbooks(6);
	}
}