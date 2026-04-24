package bankapp.userinterface;

public class MenuApp {
}


























































































































































// ── MP-3: Administracion de usuarios ──────────────────────────────────
public void customerMenuAdmin() {
    while (true) {
        System.out.println("\n=== GESTION DE CLIENTES ===");
        System.out.println("1. Ver todos los clientes");
        System.out.println("2. Buscar cliente por ID");
        System.out.println("3. Crear cliente");
        System.out.println("4. Modificar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("6. Volver");

        int option = ClientFormValidation.validateInt("Seleccione una opcion");

        switch (option) {
            case 1:
                adminView.getAllClients();
                break;
            case 2:
                int id = ClientFormValidation.validateInt("Ingrese el ID del cliente");
                clientView.getClientById(id);
                break;
            case 3:
                clientView.createClient();
                break;
            case 4:
                clientView.updateClient();
                break;
            case 5:
                clientView.deleteClient();
                break;
            case 6:
                return;
            default:
                System.out.println("  [!] Opcion no valida. Elija entre 1 y 6.");
        }
    }
}
}