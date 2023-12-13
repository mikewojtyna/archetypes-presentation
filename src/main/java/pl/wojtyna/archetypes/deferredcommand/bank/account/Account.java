package pl.wojtyna.archetypes.deferredcommand.bank.account;

public class Account {

    public static Account open() {
        return new Account();
    }

    public void makeDeposit() {
        throw new UnsupportedOperationException("Implement this method");
    }

    public void withdraw() {
        throw new UnsupportedOperationException("Implement this method");
    }
}
