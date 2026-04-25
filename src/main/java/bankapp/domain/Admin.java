package bankapp.domain;

public class Admin extends Users {

    String rol;
    String permissions;

    // constructores
    public Admin(int id, String name, String email, String password, int attemptsFailed, boolean accountBlocked, String rol, String permissions) {
        super(id, name, email, password, attemptsFailed, accountBlocked);
        this.rol = rol;
        this.permissions = permissions;
    }

    //get y unal
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    //metodos


    @Override
    public Users createUser(Users user) {
        return super.createUser(user);
    }

    @Override
    public Users updateUser(Users user) {
        return super.updateUser(user);
    }

    @Override
    public Users getUserById(int id) {
        return super.getUserById(id);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public int getAttemptsFailed() {
        return super.getAttemptsFailed();
    }

    @Override
    public void deleteUser(int id) {
        super.deleteUser(id);
    }
}

