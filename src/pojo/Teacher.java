package pojo;

public class Teacher {
    private Integer teacherNum;//工号
    private String name;//姓名
    private String sex;//性别
    private Integer age;//年龄
    private String dept;//学院
    private String work;//职位
    private String password;//密碼


    @Override
    public String toString() {
        return "Teacher{" +
                "teacherNum='" + teacherNum + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                ", work='" + work + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(Integer teacherNum) {
        this.teacherNum = teacherNum;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Teacher() {
    }

    public Teacher(Integer teacherNum, String name, String sex, Integer age, String dept, String work, String password) {
        this.teacherNum = teacherNum;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
        this.work = work;
        this.password = password;
    }
}
