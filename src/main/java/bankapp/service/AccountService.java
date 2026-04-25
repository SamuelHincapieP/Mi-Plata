package bankapp.service;

import bankapp.domain.Account;

public interface AccountService {

// MP-4: Consultar saldo
public Account getAccountByClientId(int clientId);