package datamanagement;

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
     *
     * @param cutoff is a float
     */
    void setPsCutoff1(float cutoff);

    /**
     *
     * @return
     */
    float getCrCutoff();

    /**
     *
     * @param cutoff
     */
    void setCrCutoff(float cutoff);

    /**
     *
     * @return
     */
    float getDiCuttoff();

    void setDiCutoff(float cutoff);

    float getHdCutoff();

    void setHdCutoff(float cutoff);

    float getAeCutoff();

    void setAeCutoff(float cutoff);

    int getAsg1Weight();

    int getAsg2Weight();

    int getExamWeight();

    void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt);

    String getGrade(float asg1, float asg2, float exam);

    void addStudentRecord(IStudentUnitRecord record);

    IStudentUnitRecord getStudentRecord(int studentID);

    StudentUnitRecordList listStudentRecords();
}
