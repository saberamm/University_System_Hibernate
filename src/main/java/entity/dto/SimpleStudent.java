package entity.dto;

public class SimpleStudent extends SimpleUser{
    private String studentNumber;

    public SimpleStudent() {
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "SimpleStudent{" +
                "studentNumber='" + studentNumber + '\'' +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}
