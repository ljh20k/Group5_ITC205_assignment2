package datamanagement;

/**
 * Declared IStudent as an interface.
 */
public interface IStudent {
    /**
     * @return ID as an integer.
     */
    Integer getID();

    /**
     * @return FirstName as String.
     */
    String getFirstName();

    /**
     * @param firstName **FirstName**
     */
    void setFirstName(String firstName);

    /**
     * @return LastName as String
     */
    String getLastName();

    /**
     * @param lastName **LastName**
     */
    void setLastName(String lastName);

    /**
     * @param record **IStudentUnitRecord**
     */
    void addUnitRecord(IStudentUnitRecord record);

    /**
     * @param unitCode **IStudentUnitRecord**
     * @return UnitRecord.
     */
    IStudentUnitRecord getUnitRecord(String unitCode);

    /**
     * @return StudentUnitRecordList.
     */
    StudentUnitRecordList getUnitRecords();

}
