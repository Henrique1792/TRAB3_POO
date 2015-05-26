package assets.users;

import java.io.*;
import java.util.*;

public class student extends user{
	public student(){
		this.set_UserName();
		this.set_UserType(1);
		this.set_UserLimit(15);
		this.set_UserNbooks(4);
	}
}
