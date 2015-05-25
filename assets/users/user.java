package assets.users;

public interface user{
	void register(); //register gonna insert this user on csv file.
	void set_UserName(); //register user name.
	void set_UserType (int type); //professor=2 , student=1 & common=0.
	void set_UserLimit(int limit); //Set the limit time for student, professor and common users.
	void set_UserNbooks(int nb); //Set the number of books that a person can take.
}
