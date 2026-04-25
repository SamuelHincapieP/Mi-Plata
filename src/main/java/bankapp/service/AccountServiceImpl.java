package bankapp.service;

import bankapp.domain.Account;
import bankapp.domain.Movement;

import java.util.List;

public class AccountServiceImpl {
}



























































































































// ── MP-7: Movimientos ──────────────────────────────────────────────────
@Override
public void getMovements(int clientId) {
    Account account = accountRepository.findAccountByClientId(clientId);
    if (account == null) {
        System.out.println("  [!] No tiene cuenta registrada.");
        return;
    }
    List<Movement> movements = account.getMovements();
    if (movements.isEmpty()) {
        System.out.println("  No hay movimientos registrados.");
        return;
    }
    System.out.println("\n--- Movimientos de " + account.getAccountNumber() + " ---");
    for (Movement m : movements) {
        System.out.println(m);
    }
    System.out.println("  Saldo actual: $" + String.format("%.2f", account.getBalance()));
}
