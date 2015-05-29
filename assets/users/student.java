package assets.users;

import java.io.*;
import java.util.*;

/*
classe aluno , tipo 2, limite 15 dias, numero de livros permitidos 4
*/
public class student extends user{
	public student(){
		this.set_UserName();
		this.set_UserType(2);
		this.set_UserLimit(15);
		this.set_UserNbooks(4);
	}
}