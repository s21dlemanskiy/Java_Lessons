public enum Mark {
    AUDI("ауди"),
    BMW("бмв"),
    FORD("форд"),
    HONDA("хонда"),
    KIA("киа");

    String name;

    Mark(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "name='" + name + '\'' +
                '}';
    }

}
