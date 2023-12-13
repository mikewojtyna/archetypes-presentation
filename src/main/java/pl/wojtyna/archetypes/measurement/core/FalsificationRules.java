package pl.wojtyna.archetypes.measurement.core;

import pl.wojtyna.common.DomainEvents;

public interface FalsificationRules {

    boolean isFalsifiedBy(DomainEvents facts);
}
