import java.util.ArrayList;
import java.util.List;

class Student
{
    private List<String> header = new ArrayList<>();
    private List<String> student_Names = new ArrayList<>();
    private List<Integer> student_Age = new ArrayList<>();
    private List<Integer> student_Total_Marks = new ArrayList<>();
    public List<String> getHeader() {
        return header;
    }
    public void setHeader(List<String> header) {
        this.header = header;
    }
    public List<String> getStudent_Names() {
        return student_Names;
    }
    public void setStudent_Names(List<String> student_Names) {
        this.student_Names = student_Names;
    }
    public List<Integer> getStudent_Age() {
        return student_Age;
    }
    public void setStudent_Age(List<Integer> student_Age) {
        this.student_Age = student_Age;
    }
    public List<Integer> getStudent_Total_Marks() {
        return student_Total_Marks;
    }
    public void setStudent_Total_Marks(List<Integer> student_Total_Marks) {
        this.student_Total_Marks = student_Total_Marks;
    }


}

