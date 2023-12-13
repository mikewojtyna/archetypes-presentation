package pl.wojtyna.common;

public record DomainResult<R>(R result, DomainEvents events) {
}
