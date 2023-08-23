package entity.dto;

public class SimpleTeacher extends SimpleUser{
    private String teacherNumber;

    public SimpleTeacher() {
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    @Override
    public String toString() {
        return "SimpleTeacher{" +
                "teacherNumber='" + teacherNumber + '\'' +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}
