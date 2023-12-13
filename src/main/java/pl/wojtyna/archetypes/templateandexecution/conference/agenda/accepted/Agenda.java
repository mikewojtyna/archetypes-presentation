package pl.wojtyna.archetypes.templateandexecution.conference.agenda.accepted;

import pl.wojtyna.common.DomainEvents;
import pl.wojtyna.common.DomainResult;
import pl.wojtyna.archetypes.templateandexecution.conference.agenda.finalized.AgendaCancelled;
import pl.wojtyna.archetypes.templateandexecution.conference.agenda.finalized.AgendaFinalized;
import pl.wojtyna.archetypes.templateandexecution.conference.agenda.finalized.FinalizedAgenda;

public class Agenda {

    private Agenda() {
    }

    public static DomainResult<Agenda> create(Sessions sessions) {
        return new DomainResult<>(new Agenda(), DomainEvents.of(new AgendaCreated()));
    }

    public DomainResult<FinalizedAgenda> finalizeAgenda() {
        return new DomainResult<>(new FinalizedAgenda(), DomainEvents.of(new AgendaFinalized()));
    }

    public DomainEvents cancelAgenda() {
        return DomainEvents.of(new AgendaCancelled());
    }

    public Sessions sessionsAtDay(Day day) {
        throw new UnsupportedOperationException("Implement this method");
    }
}
