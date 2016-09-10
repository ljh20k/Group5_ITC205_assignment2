package datamanagement;

/**
 * Class StudentUnitRecordProxy used to set studentID and unitCode
 * into StudentUnitRecordManager.
 */
public class StudentUnitRecordProxy implements IStudentUnitRecord {
    private Integer studentID;
    private String unitCode;
    private StudentUnitRecordManager mngr;

    /**
     * Constructor to set studentId and unitCode to its' class.
     * @param id studentId
     * @param code unitCode
     */
    public StudentUnitRecordProxy(final Integer id, final String code) {
        this.studentID = id;
        this.unitCode = code;
        this.mngr = StudentUnitRecordManager.instance();
    }

    /**
     * Getters & Setters.
     */

    public final Integer getStudentID() {
        return studentID;
    }

    public final String getUnitCode() {
        return unitCode;

    }

    public final void setAsg1(final float mark) {
        mngr.getStudentUnitRecord(studentID, unitCode).setAsg1(mark);
    }

    public final float getAsg1() {
        return mngr.getStudentUnitRecord(studentID, unitCode).getAsg1();
    }

    public final void setAsg2(final float mark) {
        mngr.getStudentUnitRecord(studentID, unitCode).setAsg2(mark);
    }

    public final float getAsg2() {
        return mngr.getStudentUnitRecord(studentID, unitCode).getAsg2();
    }

    public final void setExam(final float mark) {
        mngr.getStudentUnitRecord(studentID, unitCode).setExam(mark);
    }

    public final float getExam() {
        return mngr.getStudentUnitRecord(studentID, unitCode).getExam();
    }

    public final float getTotal() {
        return mngr.getStudentUnitRecord(studentID, unitCode).getTotal();
    }
}
