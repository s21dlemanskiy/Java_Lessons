public class Answer {
    Question question;
    int user_answer_num;

    public Answer(Question question, int user_answer_num) {
        this.question = question;
        this.user_answer_num = user_answer_num;
    }

    @Override
    public String toString() {
        if (this.user_answer_num != question.right_answer()) {
            return "Вопрос " + question.getQuestion() + "\n" + "Ваш ответ:" + question.getAnswer(this.user_answer_num).replace(";", "") + "\n" + "Правильный ответ: " + question.getAnswer(question.right_answer()).replace(";", "") + "\n";
        }
        else{
            return "[Passed]\n";
        }
    }
}
