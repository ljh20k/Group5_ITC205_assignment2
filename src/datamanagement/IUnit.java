package datamanagement;

/**
 * declared IUnit as an interface.
 */
public interface IUnit {
    /**
     * @return unit code as string.
     */
    String getUnitCode();

    /**
     * @return unit name as string.
     */
    String getUnitName();

    /**
     * @return parameter cutoff  as float.
     */
    float getPsCutoff();

    /**
     * set PsCutoff1.
     * @param cutoff **Cutoff1**
     */
    void setPsCutoff1(float cutoff);

    /**
     *
     * @return CrCutoff.
     */
    float getCrCutoff();

    /**
     *set CrCutoff.
     * @param cutoff **CrCutoff**
     */
    void setCrCutoff(float cutoff);

    /**
     * @return DiCutoff.
     */
    float getDiCutoff();

    /**
     * set DiCutoff.
     * @param cutoff **DiCutoff**.
     */
    void setDiCutoff(float cutoff);

    /**
     * @return HDCutOff.
     */
    float getHdCutoff();

    /**
     * set HdCutoff.
     * @param cutoff **HdCutoff**
     */
    void setHdCutoff(float cutoff);

    /**
     * @return AeCutoff.
     */
    float getAeCutoff();

    /**
     * set AeCutoff.
     * @param cutoff **AeCutoff**
     */
    void setAeCutoff(float cutoff);

    /**
     * @return Assignment1 Weight.
     */
    int getAsg1Weight();
    /**
     * @return Assignment2 Weight.
     */
    int getAsg2Weight();
    /**
     * @return Exam Weight.
     */
    int getExamWeight();

    /**
     * set the parameter for AssessmentWeights.
     * @param asg1Wgt int
     * @param asg2Wgt int
     * @param examWgt int
     */
    void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt);

    /**
     * @param asg1  float
     * @param asg2   float
     * @param exam   float
     * @return the Grade.
     */
    String getGrade(float asg1, float asg2, float exam);

    /**
     * add the record.
     * @param record **IStudentUnitRecord**
     */
    void addStudentRecord(IStudentUnitRecord record);

    /**
     * @param studentID int
     * @return StudentRecord
     */
    IStudentUnitRecord getStudentRecord(int studentID);

    /**
     * @return ArrayList of IStudentUnitRecord
     */
    StudentUnitRecordList listStudentRecords();
}
