package pl.wojtyna.archetypes.templateandexecution.conference.agenda.draft;

import java.time.LocalDate;
import java.util.List;

public class AgendaDraftDay {

    private LocalDate date;
    private List<AgendaDraftItem> items;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<AgendaDraftItem> getItems() {
        return items;
    }

    public void setItems(List<AgendaDraftItem> items) {
        this.items = items;
    }
}
