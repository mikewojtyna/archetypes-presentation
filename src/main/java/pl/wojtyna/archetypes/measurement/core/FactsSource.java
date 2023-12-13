package pl.wojtyna.archetypes.measurement.core;

import pl.wojtyna.common.DomainEvent;

import java.util.concurrent.Flow;

public interface FactsSource {

    Flow.Publisher<DomainEvent> facts();
}
