package pojo;


public class StudentCourse {
    private Integer id;
    private Integer studentNum;
    private Integer courseNum;
    private String term;
    private Integer score;

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", studentNum=" + studentNum +
                ", courseNum=" + courseNum +
                ", tertm='" + term + '\'' +
                ", score=" + score +
                '}';
    }

    public StudentCourse() {
    }

    public StudentCourse(Integer id, Integer studentNum, Integer courseNum, String term, Integer score) {
        this.id = id;
        this.studentNum = studentNum;
        this.courseNum = courseNum;
        this.term = term;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
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
