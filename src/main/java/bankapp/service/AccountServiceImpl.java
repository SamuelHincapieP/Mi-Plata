package bankapp.service;

import bankapp.domain.Account;
import bankapp.domain.Movement;
import bankapp.domain.enums.AccountTypeEnum;
import bankapp.domain.enums.MovementTypeEnum;

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













































    // ── MP-9: Compra credito ───────────────────────────────────────────────
    @Override
    public boolean creditPurchase(int clientId, double amount, String description) {
        Account account = validarCuentaActiva(clientId);
        if (account == null) return false;

        if (account.getAccountType() != AccountTypeEnum.CUENTA_CREDITO) {
            System.out.println("  [!] Solo aplica para cuentas de credito.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("  [!] El monto debe ser mayor a 0.");
            return false;
        }

        double nuevaDeuda = account.getBalance() - amount;
        if (nuevaDeuda < -10000000) {
            System.out.println("  [!] Cupo insuficiente. Disponible: $"
                    + String.format("%.2f", account.getBalance() + 10000000));
            return false;
        }

        account.setBalance(nuevaDeuda);
        accountRepository.updateAccount(account);
        registrarMovimiento(account, MovementTypeEnum.COMPRA_CREDITO,
                amount, "Compra: " + description);

        System.out.println("  [OK] Compra realizada!");
        System.out.println("  Cupo usado: $" + String.format("%.2f", Math.abs(account.getBalance())));
        System.out.println("  Cupo disponible: $"
                + String.format("%.2f", 10000000 + account.getBalance()));
        return true;
    }
}
