package pl.wojtyna.archetypes.templateandexecution.conference.agenda.draft;

public class AgendaDraftItem {

        private String title;
        private String description;
        private String speaker;
        private String room;
        private String time;
        private String duration;

        public AgendaDraftItem(String title, String description, String speaker, String room, String time, String duration) {
            this.title = title;
            this.description = description;
            this.speaker = speaker;
            this.room = room;
            this.time = time;
            this.duration = duration;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getSpeaker() {
            return speaker;
        }

        public String getRoom() {
            return room;
        }

        public String getTime() {
            return time;
        }

        public String getDuration() {
            return duration;
        }
}
