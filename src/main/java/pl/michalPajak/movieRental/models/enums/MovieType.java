package pl.michalPajak.movieRental.models.enums;

public enum MovieType {
    ACTION("ACTION", "Akcja"),
    COMEDY("COMEDY", "Komedia"),
    ROMANCE("ROMANCE", "Romans"),
    DRAMA("DRAMA", "Dramat"),
    DOCUMENTARY("DOCUMENTARY", "Dokumentalny"),
    SCIFI("SCIFI", "Sci-Fi"),
    FANTASY("FANTASY", "Fantastyka");

    String name;
    String description;

    MovieType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "MovieType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
