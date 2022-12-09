import java.util.*;
import java.util.stream.Collectors;

public class Question {
    String question;
    HashMap<Integer, String> answers; // впринципе масива тут бы бло достаточно но раз уж кр на колекции..
    int num_of_right_answer = -99;

    public Question(String question) {
        this.question = question;
    }

    public Question(String question, HashMap<Integer, String> answers, int num_of_right_answer) {
        this.question = question;
        this.answers = answers;
        this.num_of_right_answer = num_of_right_answer;
    }
    public Question(String question, List<String> answers, int num_of_right_answer) {
        this.question = question;
        this.answers = (HashMap<Integer, String>) answers.stream().collect(Collectors.toMap(answers::indexOf, i -> i));
        this.num_of_right_answer = num_of_right_answer;
    }

    public Question(String question, String[] answers, int num_of_right_answer) {
        this(question, Arrays.stream(answers).toList(), num_of_right_answer);
    }

    public void add_answer(String answer){
        if (answers.isEmpty()){
            answers.put(0, answer);
            return;
        }
        int max_key = Collections.max(answers.keySet()) + 1;
        answers.put(max_key, answer);
    }

    public void add_right_answer(String answer){

        if (num_of_right_answer != -99){
            throw new IllegalArgumentException("right answer alredy exists");
        }
        int max_key = Collections.max(answers.keySet()) + 1;
        answers.put(max_key, answer);
        num_of_right_answer = max_key;
    }

    @Override
    public String toString() {
        return question + "\n" + this.getAnswers();
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswers() {
        StringBuilder answ = new StringBuilder();
        for (Map.Entry<Integer, String> entry : answers.entrySet()) {
            answ.append(Integer.toString(entry.getKey())).append(". ").append(entry.getValue()).append("\n");
        }
        return answ.toString();
    }

    public String getAnswer(int num) {
        if (! answers.containsKey(num)){
            throw new IllegalArgumentException(Integer.toString(num) + " not in " + answers.toString());
        }
        return answers.get(num);
    }

    public int right_answer() {
        return num_of_right_answer;
    }

    public static Question Parce(String question1, int right_answer){
        String[] a = question1.split("\n");
        assert a.length >= 2;
        String q1 = a[0].trim();
        List<String> answers1 = new ArrayList<String>();
        for (int i = 1; i < a.length; i++) {
            answers1.add(a[i].trim());
        }
        return new Question(q1, answers1, right_answer);
    }
}
