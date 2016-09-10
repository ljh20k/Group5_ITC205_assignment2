package datamanagement;

/**
 * Class StudentUnitRecord.
 */
public class StudentUnitRecord implements IStudentUnitRecord {
    private Integer studentId;
    private String unitCode;
    private float assignment1, assignment2, exam;

    /**
     * Set StudentUnitRecord with getters and setters.
     * @param id studentId
     * @param code unitCode
     * @param asg1 assignment1
     * @param asg2 assignment2
     * @param ex exam
     */
    public StudentUnitRecord(final Integer id, final String code, final float asg1, final float asg2, final float ex) {
        this.studentId = id;
        this.unitCode = code;
        this.setAsg1(asg1);
        this.setAsg2(asg2);
        this.setExam(ex);
    }

    /**
     * Getters & Setters.
     */
    public final Integer getStudentID() {
        return studentId;
    }

    public final String getUnitCode() {
        return unitCode;
    }

    public final void setAsg1(float a1) {
        if (a1 < 0 || a1 > UnitManager.getUnitManager().getUnit(unitCode).getAsg1Weight()) {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
        }
        this.assignment1 = a1;
    }

    public final float getAsg1() {
        return assignment1;
    }

    public final void setAsg2(float a2) {
        if (a2 < 0 || a2 > UnitManager.getUnitManager().getUnit(unitCode).getAsg2Weight()) {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
        }
        this.assignment2 = a2;

    }

    public final float getAsg2() {
        return assignment2;
    }

    public final void setExam(float ex) {
        if (ex < 0 || ex > UnitManager.getUnitManager().getUnit(unitCode).getExamWeight()) {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
        }
        this.exam = ex;
    }

    public final float getExam() {
        return exam;
    }

    public final float getTotal() {
        return assignment1 + assignment2 + exam;

    }
}
