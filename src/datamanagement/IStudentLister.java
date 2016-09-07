package datamanagement;

/**
 * @author jtulip
 */

public interface IStudentLister {
    /**
     * call method ClearStudents return nothing.
     */
     void clearStudents();

    /**
     * @param student **IStudent**
     */
     void addStudent(IStudent student);
}
