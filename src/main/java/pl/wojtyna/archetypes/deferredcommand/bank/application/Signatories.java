package pl.wojtyna.archetypes.deferredcommand.bank.application;

import java.util.Set;

public interface Signatories {

    Set<Signatory> requiredFor(ApplicationType applicationType);
}
