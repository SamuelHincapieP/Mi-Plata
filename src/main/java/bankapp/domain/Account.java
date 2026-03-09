package bankapp.domain;

import java.util.List;

public class Account {

    int id;
    String countNumber;
    double salary;
    boolean state;
    String createDate;
    List<Movement> movements;

    //constructos
    public Account(int id, String countNumber, double salary, boolean state, String createDate, List<Movement> movements) {
        this.id = id;
        this.countNumber = countNumber;
        this.salary = salary;
        this.state = state;
        this.createDate = createDate;
        this.movements = movements;
    }

    //get y set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(String countNumber) {
        this.countNumber = countNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    //metodos

    public <T> void createAccount(T account) {

    }

    public Account createAccount(Account account) {
        return account;
    }


    public Account updateAccount(Account account) {
        return account;
    }


    public List<Account> getAllAccounts() {
        return null;
    }

    public Account getAccountById(int id, Account account) {
        return null;
    }


    public void deleteAccount(int id) {

    }
}
