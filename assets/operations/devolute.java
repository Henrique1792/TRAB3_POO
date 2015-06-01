package assets.operations;


import assets.books.*;
import java.io.*;
import java.util.*;


/*
classe devolute, realiza a devolução
*/
public class devolute extends operations{
    
        public void process (user novo, books book){
            this.returned = true; // "remoção logica"
            if (searchBook("rents.csv") == 1){
                book.set_isRent(false);
                int auxnbooks = novo.get_UserNbooks();
                novo.set_UserNbooks(auxnbooks+1);
                returned = true;
            }
            
        }

            
 
} 