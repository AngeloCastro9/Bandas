package bandasgrails

enum BandaEnum {
    ROCK("ROCK"),
    FORRO("FORRO"),
    AXE("AXE"),

    final String value

    BandaEnum(String value) {this.value = value}

    String toString() {value}
    String getKey() {name()}
}
