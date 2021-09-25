package pojo;


public class TeacherCourse extends MyCourse{
    private Integer scID;
    private Integer studentNum;
    private String studentName;

    public TeacherCourse() {
    }

    public Integer getScID() {
        return scID;
    }

    public void setScID(Integer scID) {
        this.scID = scID;
    }

    @Override
    public String toString() {
        return "TeacherCourse{" +
                "studentNum=" + studentNum +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public TeacherCourse(Integer studentNum, String studentName) {
        this.studentNum = studentNum;
        this.studentName = studentName;
    }

    public TeacherCourse(String term, Integer score, Integer studentNum, String studentName) {
        super(term, score);
        this.studentNum = studentNum;
        this.studentName = studentName;
    }

    public TeacherCourse(Integer courseNum, Teacher teacher, String name, String time, String local, String type, String term, Integer score, Integer studentNum, String studentName) {
        super(courseNum, teacher, name, time, local, type, term, score);
        this.studentNum = studentNum;
        this.studentName = studentName;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
