package pl.wojtyna.archetypes.measurement.core;

import pl.wojtyna.common.DomainEvents;

public interface ConfirmationRules {

    boolean isConfirmedBy(DomainEvents facts);
}
