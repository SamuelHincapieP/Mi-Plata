package bankapp.service;

import bankapp.domain.Account;

public interface AccountService {







    // MP-6: Retirar dinero
    public Account withdraw(int clientId, double amount);




    // MP-8: Transferencia
    public boolean transfer(int fromClientId, String toAccountNumber, double amount);
}
