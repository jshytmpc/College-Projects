

public class Course {
    private int year;
    private int term;
    private  String courseNo;
    private  String courseDesc;
    private  float unit;
    private final String preQ;

    private int grades;



    public Course(int year, int term, String courseNo, String courseDesc, float unit, String preQ, int grades) {
        this.year = year;
        this.term = term;
        this.courseNo = courseNo;
        this.courseDesc = courseDesc;
        this.unit = unit;
        this.preQ = preQ;
        this.grades = grades;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public int getYear() {
        return year;
    }

    public int getTerm() {
        return term;
    }

    public int getGrades() {
        return grades;
    }

    public float getUnit() {
        return unit;
    }

    public String getPreQ() {
        return preQ;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public void setUnit(float unit) {
        this.unit = unit;
    }
    public void setGrade(int grades){
        this.grades=grades;
    }

    @Override
    public String toString() {
        return String.format("| %-15s| %-110s| %-10s| %-20s |",courseNo, courseDesc, unit, preQ);
    }

    public String printGrade() {
        if (grades == 0) {
            return String.format("| %-15s| %-110s| %-10s| %-20s |",courseNo, courseDesc, unit, "Not yet taken");
        }
        return String.format("| %-15s| %-110s| %-10s| %-20s |",courseNo, courseDesc, unit, grades);
    }
}
