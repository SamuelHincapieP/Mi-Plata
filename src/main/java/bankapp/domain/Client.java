package bankapp.domain;

public class Client extends Users{

    private String clientType;

    //constructores
    public Client(int id, String name, String email, String password, int attemptsFailed, boolean accountBlocked, String clientType) {
        super(id, name, email, password, attemptsFailed, accountBlocked);
        this.clientType = clientType;
    }

    // get y set
    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
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
