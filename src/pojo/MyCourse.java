package pojo;

public class MyCourse extends Course{
    private String term;//学期
    private Integer score;//分数

    public MyCourse() {
    }

    public MyCourse(String term, Integer score) {
        this.term = term;
        this.score = score;
    }

    @Override
    public String toString() {
        return "MyCourse{" +
                "term='" + term + '\'' +
                ", score=" + score +
                '}';
    }

    public MyCourse(Integer courseNum, Teacher teacher, String name, String time, String local, String type, String term, Integer score) {
        super(courseNum, teacher, name, time, local, type);
        this.term = term;
        this.score = score;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
