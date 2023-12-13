package pl.wojtyna.archetypes.templateandexecution.conference.agenda.draft;

import pl.wojtyna.archetypes.templateandexecution.conference.agenda.accepted.Agenda;
import pl.wojtyna.archetypes.templateandexecution.conference.agenda.accepted.Sessions;
import pl.wojtyna.common.DomainResult;

import java.util.UUID;

public class AgendaService {

    private final AgendaDraftRepository repository;

    public AgendaService(AgendaDraftRepository repository) {
        this.repository = repository;
    }

    public void updateAgenda(AgendaDraft draft) {
        repository.saveAgendaDraft(draft);
    }

    public DomainResult<Agenda> accept(UUID agendaDraftId) {
        return Agenda.create(findSessionsOf(agendaDraftId));
    }

    private Sessions findSessionsOf(UUID agendaDraftId) {
        throw new UnsupportedOperationException("Implement this method");
    }

}
