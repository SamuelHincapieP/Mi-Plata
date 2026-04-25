package bankapp.service;

import bankapp.domain.Account;

public interface AccountService {

// MP-4: Consultar saldo
public Account getAccountByClientId(int clientId);

    // MP-5: Consignar dinero
    public Account deposit(int clientId, double amount);