import java.util.Objects;

public class University {
    String name;
    int student_amount;
    int teacher_amount;
    int avg_passing_score;

    public University(String name, int student_amount, int teacher_amount, int avg_passing_score) {
        this.name = name;
        this.student_amount = student_amount;
        this.teacher_amount = teacher_amount;
        this.avg_passing_score = avg_passing_score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || this.getClass() != o.getClass()) return false;
        University that = (University) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", student_amount=" + student_amount +
                ", teacher_amount=" + teacher_amount +
                ", avg_passing_score=" + avg_passing_score +
                '}';
    }
}
