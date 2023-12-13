package pl.wojtyna.common;

public interface DomainEventPublisher {

    void publish(DomainEvents events);

    void publish(DomainEvent event);
}
