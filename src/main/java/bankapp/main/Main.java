package bankapp.main;

import bankapp.domain.*;
import java.util.Date;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        Client client = new Client(1,"Samuel Perez","samuel@mail.com","1234",0,false,"Premium");
        client.createUser(client);
        client.getUserById(1);

        Admin admin = new Admin(2,"Hannah Zapata","hmolina@mail.com","admin123",0,false,"Manager","ALL");
        admin.createUser(admin);
        admin.getUserById(2);


        Account account = new Account(1,"ACC001",1000,true,"2026-03-09", new ArrayList<>());
        account.createAccount(account);
        account.getAccountById(1, account);


        Movement movement = new Movement(1,500,new Date(),"Deposito");
        movement.createMovement(movement);
        movement.getMovementById(1, movement);


        TypeMovement type = new TypeMovement(1,"Deposito","Ingreso de dinero");
        type.createTypeMovement(type);
        type.getTypeMovementById(1, type);

    }
}