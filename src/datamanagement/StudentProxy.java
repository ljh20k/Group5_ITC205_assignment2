package datamanagement;

/**
 * Class StudentProxy.
 */
public class StudentProxy implements IStudent {
    /** Integer for studentId. */
    private Integer studentId;
    /** String for firstName. */
    private String firstName;
    /** String for lastName. */
    private String lastName;
    /** Object StudentManager. */
    private StudentManager studentManager;

    /**
     * @param id studentId
     * @param fn firstName
     * @param ln lastName
     */
    public StudentProxy(final Integer id, final String fn, final String ln) {
        this.studentId = id;
        this.firstName = fn;
        this.lastName = ln;
        this.studentManager = StudentManager.get();
    }

    /**
     * Getters & Setters
     */
    public final Integer getID() {
        return studentId;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setFirstName(final String fn) {
        studentManager.getStudent(studentId).setFirstName(fn);
    }

    public final void setLastName(final String ln) {
        studentManager.getStudent(studentId).setLastName(ln);
    }

    public final void addUnitRecord(final IStudentUnitRecord record) {
        studentManager.getStudent(studentId).addUnitRecord(record);
    }

    public final IStudentUnitRecord getUnitRecord(final String unitCode) {
        return studentManager.getStudent(studentId).getUnitRecord(unitCode);
    }

    public final StudentUnitRecordList getUnitRecords() {
        return studentManager.getStudent(studentId).getUnitRecords();
    }
}
