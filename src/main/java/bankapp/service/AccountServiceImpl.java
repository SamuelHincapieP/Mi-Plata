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






















    // ── MP-8: Transferencia ────────────────────────────────────────────────
    @Override
    public boolean transfer(int fromClientId, String toAccountNumber, double amount) {
        Account origin = validarCuentaActiva(fromClientId);
        if (origin == null) return false;

        if (amount <= 0) {
            System.out.println("  [!] El monto debe ser mayor a 0.");
            return false;
        }
        if (origin.getAccountNumber().equals(toAccountNumber)) {
            System.out.println("  [!] No puede transferir a la misma cuenta.");
            return false;
        }

        Account destination = accountRepository.findAccountByNumber(toAccountNumber);
        if (destination == null) {
            System.out.println("  [!] Cuenta destino no encontrada: " + toAccountNumber);
            return false;
        }
        if (destination.getAccountState() == AccountState.BLOQUEADA) {
            System.out.println("  [!] La cuenta destino esta bloqueada.");
            return false;
        }
        if (origin.getBalance() < amount) {
            System.out.println("  [!] Saldo insuficiente. Saldo: $"
                    + String.format("%.2f", origin.getBalance()));
            return false;
        }

        origin.setBalance(origin.getBalance() - amount);
        destination.setBalance(destination.getBalance() + amount);
        accountRepository.updateAccount(origin);
        accountRepository.updateAccount(destination);

        registrarMovimiento(origin, MovementTypeEnum.TRANSFERENCIA_ENVIADA,
                amount, "Transferencia a " + toAccountNumber);
        registrarMovimiento(destination, MovementTypeEnum.TRANSFERENCIA_RECIBIDA,
                amount, "Transferencia desde " + origin.getAccountNumber());

        System.out.println("  [OK] Transferencia exitosa!");
        System.out.println("  Nuevo saldo: $" + String.format("%.2f", origin.getBalance()));
        return true;
    }


