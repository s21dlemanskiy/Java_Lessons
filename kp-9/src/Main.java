import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] names = "РУТ,МФТИ,МГУ,ДВГУПС,СПбГУ,ВШЭ,МГИМО".split(",");
        Map<String, University> dict = new HashMap<>();
        Random rand = new Random();
        for (String name:
             names) {
            dict.put(name, new University(name, rand.nextInt(500), rand.nextInt(150), rand.nextInt(100)));
        }
        Set<University> texUniversity = Arrays.stream("РУТ,МФТИ,МГУ,ДВГУПС,СПбГУ".split(",")).map(dict::get).collect(Collectors.toUnmodifiableSet());
        Set<University> gumUniversity = Arrays.stream("ВШЭ,МГИМО,МГУ,СПбГУ".split(",")).map(dict::get).collect(Collectors.toUnmodifiableSet());
        Set<University> allUniversity = new HashSet<>();
        allUniversity.addAll(texUniversity);
        allUniversity.addAll(gumUniversity);
        Set<University> mixedUniversity = new HashSet<>(texUniversity);
        mixedUniversity.retainAll(gumUniversity);
        Set<University> specTexUniversity = new HashSet<>(texUniversity);
        specTexUniversity.removeAll(gumUniversity);
        Set<University> specGumUniversity = new HashSet<>(gumUniversity);
        specGumUniversity.removeAll(texUniversity);
        Map<String, Set<University>> universitySets = new HashMap<>();
        universitySets.put("texUniversity", texUniversity);
        universitySets.put("gumUniversity", gumUniversity);
        universitySets.put("allUniversity", allUniversity);
        universitySets.put("mixedUniversity", mixedUniversity);
        universitySets.put("specTexUniversity", specTexUniversity);
        universitySets.put("specGumUniversity", specGumUniversity);
        for (String set_name:
             universitySets.keySet()) {
            System.out.println(String.format("Description of %s.\n", set_name));
            System.out.println(universitySets.get(set_name));
            System.out.print("Set{");
            int studets_amount = 0;
            int teacher_amount = 0;
            for (University u:
                 universitySets.get(set_name)) {
                System.out.print(u.name + ", ");
                studets_amount += u.student_amount;
                teacher_amount += u.teacher_amount;
            }
            System.out.println("}\n");
            System.out.println(String.format("Студентов в сумме %d.\n", studets_amount));
            System.out.println(String.format("В среднем професоров %f.\n\n\n", (float) teacher_amount / universitySets.get(set_name).size()));

        }
        System.out.println("_".repeat(100));
        System.out.println("task 2");
        String[] names2= "Москва, Санкт-Петербург, Хабаровск, Долгопрудный".split(", ");
        Map<String, City> dict2 = new HashMap<>();
        rand = new Random();
        for (String name:
                names2) {
            dict2.put(name, new City(name, rand.nextInt(100000) + 500000));
        }
        Map<University, City> some_dict = new HashMap<>();
        some_dict.put(dict.get(names[0]), dict2.get(names2[0]));
        some_dict.put(dict.get(names[1]), dict2.get(names2[0]));
        some_dict.put(dict.get(names[2]), dict2.get(names2[0]));
        some_dict.put(dict.get(names[3]), dict2.get(names2[2]));
        some_dict.put(dict.get(names[4]), dict2.get(names2[1]));
        some_dict.put(dict.get(names[5]), dict2.get(names2[0]));

        for (University u:
             some_dict.keySet()) {
            System.out.println(String.format("%f on 1 student in %s", (float) some_dict.get(u).population / u.student_amount, u.name));
        }
    }
}