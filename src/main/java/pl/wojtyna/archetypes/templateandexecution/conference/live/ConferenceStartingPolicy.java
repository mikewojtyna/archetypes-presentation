package pl.wojtyna.archetypes.templateandexecution.conference.live;

import pl.wojtyna.common.DomainEvents;
import pl.wojtyna.archetypes.templateandexecution.conference.agenda.finalized.AgendaFinalized;
import pl.wojtyna.archetypes.templateandexecution.conference.website.WebsiteLaunched;

public class ConferenceStartingPolicy {

    private boolean agendaFinalized;
    private boolean websiteLaunched;

    public void when(AgendaFinalized agendaFinalized) {
        this.agendaFinalized = true;
        if (shouldStart()) {
            start();
        }
    }

    public void when(WebsiteLaunched websiteLaunched) {
        this.websiteLaunched = true;
        if (shouldStart()) {
            start();
        }

    }

    private DomainEvents start() {
        return DomainEvents.of(new ConferenceStarted());
    }

    private boolean shouldStart() {
        return agendaFinalized && websiteLaunched;
    }
}
