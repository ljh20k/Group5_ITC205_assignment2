package datamanagement;

/**
 * Domain Class.
 */
public class Student implements IStudent {
    /**
     * Integer type studentId.
     */
    private Integer id;
    /**
     * String type firstName.
     */
    private String fn;
    /**
     * String type lastName.
     */
    private String ln;
    /**
     * List<IStudetnUnitRecord>.
     */
    private StudentUnitRecordList su;

    /**
     * @param id ** studentId **
     * @param fn ** student's firstName **
     * @param ln ** student's lastName **
     * @param su ** IStudentUnitRecordList **
     */
    public Student(final Integer id, final String fn, final String ln, final StudentUnitRecordList su) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.su =
                su == null ? new StudentUnitRecordList() : su;
    }

    /**
     * @return id.
     */
    public final Integer getID() {
        return this.id;
    }
    /**
     * @return fn.
     */
    public final String getFirstName() {
        return fn;
    }

    /**
     * @param firstName firstName
     */
    public final void setFirstName(final String firstName) {
        this.fn = firstName;
    }

    /**
     * @return lastName
     */
    public final String getLastName() {
        return ln;
    }

    /**
     * @param lastName lastName
     */
    public final void setLastName(final String lastName) {
        this.ln = lastName;
    }

    /**
     * @param record the record
     */
    public final void addUnitRecord(final IStudentUnitRecord record) {
        su.add(record);
    }

    /**
     * @param unitCode unitCode
     * @return IStudentUnitRecord if @param UnitCode equals to IStudentUnitRecord.getUnitCode()
     */
    public IStudentUnitRecord getUnitRecord(final String unitCode) {
        for (IStudentUnitRecord r : su) {
            if (r.getUnitCode().equals(unitCode)) {
                return r;
            }
        }
        return null;
    }

    /**
     * @return unitRecordList
     */
    public StudentUnitRecordList getUnitRecords() {
        return su;
    }
}
