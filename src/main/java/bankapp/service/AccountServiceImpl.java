package bankapp.service;

public class AccountServiceImpl {
}

































































// ── MP-4: Consultar saldo ──────────────────────────────────────────────
@Override
public Account getAccountByClientId(int clientId) {
    Account account = accountRepository.findAccountByClientId(clientId);
    if (account == null) {
        System.out.println("  [!] No tiene cuenta registrada.");
        return null;
    }
    if (account.getAccountState() == AccountState.BLOQUEADA) {
        System.out.println("  [!] Su cuenta esta BLOQUEADA. Contacte soporte.");
        return account;
    }
    System.out.println("\n--- Su cuenta ---");
    System.out.println(account);
    return account;
}