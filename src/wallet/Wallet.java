package wallet;
public class Wallet {
    private String name;
    private double balance;

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return  name + "\n" + balance;
    }

}
