import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] names = "РУТ, МФТИ, МГУ, ДВГУПС, СПбГУ, ВШЭ, МГИМО".split(", ");  // для начала забьем все названия в массив что бы создавать обьекты University в цикле
        Map<String, University> dict = new HashMap<>();                                  // создадим словарь содержащий названия унивеситетов как ключи и сами уневерситеты как значения
        Random rand = new Random();                                                      // данные об университете будем вбивать рандомно ( парсить на java я пока не умею а парсить руками... нет уж, увольте)
        for (String name:
             names) {                                                                    // для каждого названия создаем обьект-университет с рандомными значениями
            dict.put(      name,
                           new University(  name,
                                            rand.nextInt(500),
                                            rand.nextInt(150),
                                            rand.nextInt(100)));
        }
        Set<University> texUniversity =                               // создаем из строки содержащий нозвания университетов множество этих университетов ( для технических институтов)
                Arrays.stream("РУТ,МФТИ,МГУ,ДВГУПС,СПбГУ".split(","))
                        .map(dict::get).collect(Collectors.toUnmodifiableSet());
        Set<University> gumUniversity =                                // аналогично для гуманитарных институтов
                Arrays.stream("ВШЭ,МГИМО,МГУ,СПбГУ".split(","))
                        .map(dict::get).collect(Collectors.toUnmodifiableSet());
        Set<University> allUniversity = new HashSet<>();              // создаем требуемый в задаче множк=ество всех университов при помощи методов множеств ( как и требоволось в задаче хотя можно было просто из хеш таблицы достать все значения)
        allUniversity.addAll(texUniversity);
        allUniversity.addAll(gumUniversity);
        Set<University> mixedUniversity = new HashSet<>(texUniversity); // создаем множество университетов которые относятся к гуманитарным и техническим
        mixedUniversity.retainAll(gumUniversity);
        Set<University> specTexUniversity = new HashSet<>(texUniversity); // создаем множество университетов которые относятся только к техническим
        specTexUniversity.removeAll(gumUniversity);
        Set<University> specGumUniversity = new HashSet<>(gumUniversity); // создаем множество университетов которые относятся только к гуманитарным
        specGumUniversity.removeAll(texUniversity);
        Map<String, Set<University>> universitySets = new HashMap<>();    // создаем словарь содержащий названия множеств как ключи и сами множества как значения и наполняем его
        universitySets.put("texUniversity", texUniversity);
        universitySets.put("gumUniversity", gumUniversity);
        universitySets.put("allUniversity", allUniversity);
        universitySets.put("mixedUniversity", mixedUniversity);
        universitySets.put("specTexUniversity", specTexUniversity);
        universitySets.put("specGumUniversity", specGumUniversity);
        for (String set_name:                                             // проходимся по всем множествам(их названиям) и формируем для них требуемое описание
             universitySets.keySet()) {
            System.out.println(String.format("Description of %s.\n", set_name));
            System.out.println(universitySets.get(set_name));             // тут будут распечатаны множества посредством метода toString что значит что тут будет полное описание
            System.out.print("Set{");
            int studets_amount = 0;
            int teacher_amount = 0;
            for (University u:
                 universitySets.get(set_name)) {
                System.out.print(u.name + ", ");                         // тут мы печатаем множества только с названиями университетов ( так читаемей для человека)
                studets_amount += u.student_amount;
                teacher_amount += u.teacher_amount;
            }
            System.out.println("}\n");
            System.out.println(String.format("Студентов в сумме %d.\n", studets_amount));
            System.out.println(String.format("В среднем професоров %f.\n\n\n", (float) teacher_amount / universitySets.get(set_name).size()));

        }
        System.out.println("_".repeat(100));                         // печатаем отделяющие символы что бы разделить 1-ое и 2-ое задание
        System.out.println("task 2");
        String[] names2= "Москва, Санкт-Петербург, Хабаровск, Долгопрудный".split(", ");   // формируем список городов
        Map<String, City> dict2 = new HashMap<>();                         // создаем хеш таблицу для сопоставлений названий городов и обьектов City
        rand = new Random();
        for (String name:                                                  // наполняем словарь попутно создавая эти обьекты City для кажждого горада из списка наполняя их случайными значениями
                names2) {
            dict2.put(name, new City(name, rand.nextInt(100000) + 500000));
        }
        Map<University, City> some_dict = new HashMap<>();                // создаем тот самый словарь где в ключах лежит университете а в значениях лежит город в котором распологается университет
        some_dict.put(dict.get(names[0]), dict2.get(names2[0]));          // и заполняем его почти в ручную
        some_dict.put(dict.get(names[1]), dict2.get(names2[0]));
        some_dict.put(dict.get(names[2]), dict2.get(names2[0]));
        some_dict.put(dict.get(names[3]), dict2.get(names2[2]));
        some_dict.put(dict.get(names[4]), dict2.get(names2[1]));
        some_dict.put(dict.get(names[5]), dict2.get(names2[0]));

        for (University u:                                                // для каждого университета считаем сколько горожан приходится на одного студента
             some_dict.keySet()) {
            System.out.println(String.format("%f on 1 student in %s", (float) some_dict.get(u).population / u.student_amount, u.name));
        }
    }
}