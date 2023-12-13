package pl.wojtyna.archetypes.deferredcommand.bank.application;

public interface CancellationPolicy {

    boolean canBeCancelledBy(Signatory signatory);
}
