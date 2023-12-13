package pl.wojtyna.archetypes.templateandexecution.conference.agenda.draft;

import java.util.List;

public class AgendaDraft {

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
}
