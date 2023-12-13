package pl.wojtyna.archetypes.deferredcommand.bank.application;

public class Applications {

    private final Signatories signatories;

    public Applications(Signatories signatories) {
        this.signatories = signatories;
    }

    public AccountApplication openAccount() {
        return new AccountApplication(signatories.requiredFor(ApplicationType.OPEN_ACCOUNT));
    }
}
