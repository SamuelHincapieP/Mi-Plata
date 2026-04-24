package bankapp.service;

import bankapp.domain.Client;












































































// ── MP-3: Actualizar cliente ───────────────────────────────────────────
@Override
public Client updateClient(int id) {
    Client client = clientRepository.findClientById(id);

    if (client == null) {
        System.out.println("  [!] Cliente con ID " + id + " no encontrado.");
        return null;
    }

    System.out.println("Que desea actualizar?");
    System.out.println("1. Nombre   2. Correo   3. Clave   4. Tipo cliente");

    int option = ClientFormValidation.validateInt("Opcion");

    switch (option) {
        case 1:
            client.setName(ClientFormValidation.validateString("Nuevo nombre"));
            break;
        case 2:
            while (true) {
                String email = ClientFormValidation.validateString("Nuevo correo");
                if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    System.out.println("  [!] Correo invalido.");
                    continue;
                }
                Client existing = clientRepository.findClientByEmail(email);
                if (existing != null && existing.getId() != id) {
                    System.out.println("  [!] Ese correo ya esta en uso.");
                    continue;
                }
                client.setEmail(email);
                break;
            }
            break;
        case 3:
            while (true) {
                String password = ClientFormValidation.validateString("Nueva clave");
                if (!ClientFormValidation.validatePassword(password)) {
                    System.out.println("  [!] Clave no segura. Ejemplo: Hola123!");
                    continue;
                }
                client.setPassword(password);
                break;
            }
            break;
        case 4:
            client.setClientType(ClientTypeSelector.selectClientType());
            break;
        default:
            System.out.println("  [!] Opcion no valida.");
            return client;
    }

    clientRepository.updateClient(client.getId());
    System.out.println("  [OK] Cliente actualizado exitosamente!");
    return client;
}

// ── MP-3: Eliminar cliente ─────────────────────────────────────────────
@Override
public void deleteClient(int id) {
    Client client = clientRepository.findClientById(id);
    if (client == null) {
        System.out.println("  [!] Cliente con ID " + id + " no encontrado.");
        return;
    }
    clientRepository.deleteClient(id);
    System.out.println("  [OK] Cliente eliminado exitosamente.");
}
}