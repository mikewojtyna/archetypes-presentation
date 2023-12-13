package pl.wojtyna.archetypes.templateandexecution.conference.agenda.draft;

import java.util.List;
import java.util.UUID;

public class AgendaDraft {

    private UUID id;
    private String title;
    private String description;
    private List<AgendaDraftDay> days;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AgendaDraftDay> getDays() {
        return days;
    }

    public void setDays(List<AgendaDraftDay> days) {
        this.days = days;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
