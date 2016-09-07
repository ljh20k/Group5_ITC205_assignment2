package datamanagement;

/**
 * Domain Class.
 */
public class Student implements IStudent {
    /**
     * Integer type studentId.
     */
    private Integer studentId;
    /**
     * String type firstName.
     */
    private String firstName;
    /**
     * String type lastName.
     */
    private String lastName;
    /**
     * List<IStudentUnitRecord>.
     */
    private StudentUnitRecordList studentUnitRecordList;

    /**
     * @param id ** studentId **
     * @param fn ** student's firstName **
     * @param ln ** student's lastName **
     * @param su ** IStudentUnitRecordList **
     */
    public Student(final Integer id, final String fn, final String ln, final StudentUnitRecordList su) {
        this.studentId = id;
        this.firstName = fn;
        this.lastName = ln;
        if (su != null) {
            this.studentUnitRecordList = su;
        }
    }

    /**
     * @return studentId.
     */
    public final Integer getID() {
        return this.studentId;
    }
    /**
     * @return firstName.
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * @param fn new firstName
     */
    public final void setFirstName(final String fn) {
        this.firstName = fn;
    }

    /**
     * @return lastName
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * @param ln new lastName
     */
    public final void setLastName(final String ln) {
        this.lastName = ln;
    }

    /**
     * @param record new the record
     */
    public final void addUnitRecord(final IStudentUnitRecord record) {
        studentUnitRecordList.add(record);
    }

    /**
     * @param unitCode new unitCode
     * @return IStudentUnitRecord which matches with given String unitCode
     */
    public final IStudentUnitRecord getUnitRecord(final String unitCode) {
        for (IStudentUnitRecord r : studentUnitRecordList) {
            if (r.getUnitCode().equals(unitCode)) {
                return r;
            }
        }
        return null;
    }

    /**
     * @return studentUnitRecordList
     */
    public final StudentUnitRecordList getUnitRecords() {
        return studentUnitRecordList;
    }
}
