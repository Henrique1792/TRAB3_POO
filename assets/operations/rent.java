package assets.operations;


import assets.books.*;
import java.io.*;
import java.util.*;

/*
classe rent, realiza o empréstimo
*/
public class rent extends operations{
    
    
    public void process (user novo, books book){
        this.nameaux = novo.get_UserName();
        this.titleaux = book.get_bookname();
        if ((book.get_isRent() == false) && (novo.get_UserNbooks() > 0)){
            newlimit = novo.get_UserLimit() - 1;
            novo.set_UserLimit(newlimit);
            book.set_Rent(true);
        }
    }

} 
