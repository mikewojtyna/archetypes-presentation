package pl.wojtyna.archetypes.measurement.core;

import pl.wojtyna.common.DomainEvent;
import pl.wojtyna.common.DomainEvents;

public abstract class Hypothesis {

    private final ConfirmationRules confirmationRules;
    private final FalsificationRules falsificationRules;
    private DomainEvents recordedFacts;

    public Hypothesis(ConfirmationRules confirmationRules, FalsificationRules falsificationRules) {
        this.confirmationRules = confirmationRules;
        this.falsificationRules = falsificationRules;
        recordedFacts = DomainEvents.empty();
    }

    public DomainEvents record(DomainEvent event) {
        recordedFacts = recordedFacts.following(event);
        if (confirmationRules.isConfirmedBy(recordedFacts)) {
            return DomainEvents.of(new HypothesisConfirmed());
        }
        else if (falsificationRules.isFalsifiedBy(recordedFacts)) {
            return DomainEvents.of(new HypothesisFalsified());
        }
        return DomainEvents.empty();
    }
}
