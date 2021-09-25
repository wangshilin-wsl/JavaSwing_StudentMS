package pojo;

public class Course {
    private Integer courseNum;
    //Integer teacherNum
    private Teacher teacher;
    private String name;
    private String time;//上课时间1-1-2周一第一节课到第二节课
    private String local;//上课地点
    private String type;//课程性质，选修，必修

    @Override
    public String toString() {
        return "Course{" +
                "courseNum='" + courseNum + '\'' +
                ", teacher=" + teacher +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", local='" + local + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Integer getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Course() {
    }

    public Course(Integer courseNum, Teacher teacher, String name, String time, String local, String type) {
        this.courseNum = courseNum;
        this.teacher = teacher;
        this.name = name;
        this.time = time;
        this.local = local;
        this.type = type;
    }
}
