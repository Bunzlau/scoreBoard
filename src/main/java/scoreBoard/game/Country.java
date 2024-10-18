package scoreBoard.game;

public enum Country {
    MEXICO("Mexico"),
    CANADA("Canada"),
    BRAZIL("Brazil"),
    SPAIN("Spain"),
    GERMANY("Germany"),
    FRANCE("France"),
    ITALY("Italy"),
    ARGENTINA("Argentina"),
    AUSTRALIA("Australia"),
    URUGUAY("Uruguay");

    private String country;

    Country(String country) {
        this.country = country;
    }

    public String getCountryName() {
        return country;
    }
}
