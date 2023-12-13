package pl.wojtyna.archetypes.templateandexecution.conference.agenda.draft;

import pl.wojtyna.archetypes.templateandexecution.conference.agenda.accepted.Agenda;

public class AgendaService {

    public AgendaService(AgendaDraftRepository repository) {
        this.repository = repository;
    }

    private AgendaDraftRepository repository;

    public void updateAgenda(AgendaDraft draft) {
        repository.saveAgendaDraft(draft);
    }

    public Agenda accept() {
        throw new UnsupportedOperationException("Implement this method");
    }
}
