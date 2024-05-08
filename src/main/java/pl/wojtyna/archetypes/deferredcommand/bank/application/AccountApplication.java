package pl.wojtyna.archetypes.deferredcommand.bank.application;

import pl.wojtyna.archetypes.deferredcommand.bank.account.Account;
import pl.wojtyna.common.DomainEvents;
import pl.wojtyna.common.DomainResult;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AccountApplication {

    private final Set<Signatory> requiredSignatories;
    private final Set<Signature> signatures;
    private boolean cancelled = false;

    public AccountApplication(Set<Signatory> requiredSignatories) {
        this.requiredSignatories = new HashSet<>(requiredSignatories);
        this.signatures = new HashSet<>();
    }

    public DomainEvents cancel(CancellationPolicy cancellationPolicy, Signatory signatory) {
        if (!cancelled && cancellationPolicy.canBeCancelledBy(signatory)) {
            cancelled = true;
            return DomainEvents.of(new AccountApplicationCancelled());
        }
        return DomainEvents.empty();
    }

    public DomainResult<Optional<Account>> sign(Signature signature) {
        var events = DomainEvents.empty();
        if (requiredSignatories.removeIf(signature::isSignedBy)) {
            signatures.add(signature);
            events = events.following(new ApplicationSigned());
        }
        if (isSignedByAllSignatories()) {
            events = events.following(new ApplicationSignedByAllSignatories());
            return new DomainResult<>(Optional.of(Account.open()),
                                      events);
        }
        return new DomainResult<>(Optional.empty(), events);
    }

    public boolean isSignedByAllSignatories() {
        return requiredSignatories.isEmpty();
    }
}
