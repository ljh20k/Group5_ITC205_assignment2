package datamanagement;

/**
 * IStudentUnitRecord as an declared as an Interface.
 */
public interface IStudentUnitRecord {
    /**
     * @return student id as integer.
     */
     Integer getStudentID();

    /**
     * @return unit code as string.
     */
     String getUnitCode();

    /**
     * @param mark is passed to assignment1 as float.
     */
    void setAsg1(float mark);

    /**
     * @return Assignment1 as float value.
     */
    float getAsg1();

    /**
     * @param mark is passed to Assignment2.
     */
    void setAsg2(float mark);

    /**
     * @return the Assignment2 as float.
     */
    float getAsg2();

    /**
     * @param mark is set for Exam.
     */
    void setExam(float mark);

    /**
     * @return exam .
     */
    float getExam();

    /**
     * @return total marks .
     */
    float getTotal();
}
