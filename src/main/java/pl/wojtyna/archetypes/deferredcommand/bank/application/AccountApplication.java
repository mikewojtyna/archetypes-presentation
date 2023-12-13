package pl.wojtyna.archetypes.deferredcommand.bank.application;

import pl.wojtyna.archetypes.deferredcommand.bank.account.Account;
import pl.wojtyna.common.DomainEvents;
import pl.wojtyna.common.DomainResult;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AccountApplication {

    private Set<Signatory> requiredSignatories;
    private Set<Signature> signatures;

    public AccountApplication(Set<Signatory> requiredSignatories) {
        this.requiredSignatories = requiredSignatories;
        this.signatures = new HashSet<>();
    }

    public DomainEvents cancel(CancellationPolicy cancellationPolicy, Signatory signatory) {
        if (cancellationPolicy.canBeCancelledBy(signatory) && signatures.stream()
                                                                        .anyMatch(signature -> signature.isSignedBy(
                                                                            signatory))) {
            return DomainEvents.of(new AccountApplicationCancelled());
        }
        return DomainEvents.empty();
    }

    public DomainResult<Optional<Account>> sign(Signature signature) {
        if (requiredSignatories.stream().anyMatch(signature::isSignedBy)) {
            signatures.add(signature);
        }
        if (isSigned()) {
            return new DomainResult<>(Optional.of(Account.open()), DomainEvents.of(new ApplicationSigned()));
        }
        else {
            return new DomainResult<>(Optional.empty(), DomainEvents.empty());
        }
    }

    public boolean isSigned() {
        return signatures.stream()
                         .allMatch(signature -> signature.isSignedByAnyOf(requiredSignatories.toArray(Signatory[]::new)));
    }
}
