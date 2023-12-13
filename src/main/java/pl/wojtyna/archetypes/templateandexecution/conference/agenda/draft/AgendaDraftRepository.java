package pl.wojtyna.archetypes.templateandexecution.conference.agenda.draft;

public interface AgendaDraftRepository {

    AgendaDraft getAgendaDraft();

    void saveAgendaDraft(AgendaDraft agendaDraft);
}
