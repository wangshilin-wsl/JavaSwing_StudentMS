package pojo;

public class Student {
    private Integer studentNum;//学号
    private String name;//姓名
    private String sex;//性别
    private String grade;//年级
    private Integer age;//年龄
    private String clas;//班级
    private String major;//专业
    private String dept;//学院
    private String password;//密碼

    @Override
    public String toString() {
        return "Student{" +
                "studentNum='" + studentNum + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                ", age=" + age +
                ", clas='" + clas + '\'' +
                ", major='" + major + '\'' +
                ", dept='" + dept + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Student() {
    }

    public Student(Integer studentNum, String name, String sex, String grade, Integer age, String clas, String major, String dept, String password) {
        this.studentNum = studentNum;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.age = age;
        this.clas = clas;
        this.major = major;
        this.dept = dept;
        this.password = password;
    }
}
