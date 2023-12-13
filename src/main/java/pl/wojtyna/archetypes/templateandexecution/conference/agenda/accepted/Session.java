package pl.wojtyna.archetypes.templateandexecution.conference.agenda.accepted;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record Session(LocalDate day, LocalTime start, LocalTime end) {
}
