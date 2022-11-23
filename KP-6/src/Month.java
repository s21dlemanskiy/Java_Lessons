public enum Month {
    JAN("Январь", 1),
    FEB("Февраль", 2),
    MAR("Март", 3),
    APR("Апрель", 4),
    MAY("Май",5 ),
    JUNE("Июнь",6 ),
    JULY("Июль", 7),
    AUG("Август", 8),
    SEP("Сентябрь",9),
    OCT("Октябрь", 10),
    NOV("Ноябрь",11),
    DEC("Декабрь",12);

    final String name;
    final int index;

    Month(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }
}
