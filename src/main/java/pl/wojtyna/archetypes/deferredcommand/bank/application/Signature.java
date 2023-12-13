package pl.wojtyna.archetypes.deferredcommand.bank.application;

public record Signature(String username) {

    public boolean isSignedBy(Signatory signatory) {
        return username.equals(signatory.username());
    }

    public boolean isSignedByAnyOf(Signatory... signatories) {
        for (Signatory signatory : signatories) {
            if (isSignedBy(signatory)) {
                return true;
            }
        }
        return false;
    }
}
