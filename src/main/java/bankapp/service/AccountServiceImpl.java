package bankapp.service;

import bankapp.domain.Account;
import bankapp.domain.enums.AccountTypeEnum;
import bankapp.domain.enums.MovementTypeEnum;

public class AccountServiceImpl {



































































































    // ── MP-6: Retirar ──────────────────────────────────────────────────────
    @Override
    public Account withdraw(int clientId, double amount) {
        Account account = validarCuentaActiva(clientId);
        if (account == null) return null;

        if (amount <= 0) {
            System.out.println("  [!] El monto debe ser mayor a 0.");
            return account;
        }
        if (account.getAccountType() != AccountTypeEnum.CUENTA_CREDITO
                && account.getBalance() < amount) {
            System.out.println("  [!] Saldo insuficiente. Saldo: $"
                    + String.format("%.2f", account.getBalance()));
            return account;
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.updateAccount(account);
        registrarMovimiento(account, MovementTypeEnum.RETIRO, amount, "Retiro");

        System.out.println("  [OK] Retiro exitoso!");
        System.out.println("  Nuevo saldo: $" + String.format("%.2f", account.getBalance()));
        return account;
    }
}
