package bankapp.service;



public interface AccountService {










    // MP-7: Consultar movimientos
    public void getMovements(int clientId);


    // MP-9: Compra con tarjeta de credito
    public boolean creditPurchase(int clientId, double amount, String description);
}
