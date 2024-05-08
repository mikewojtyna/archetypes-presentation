package pl.wojtyna.archetypes.deferredcommand.bank.application;

public record Signature(String username) {

    public boolean isSignedBy(Signatory signatory) {
        return username.equals(signatory.username());
    }
}
