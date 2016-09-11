/**
 * Domain classes used to produce studentList and grade.
 *
 * @since 1.0
 * @author somebody
 * @version 1.0
 */
package datamanagement;

import java.util.Map;

/**
 * Class ListStudentsCTL.
 */
public class ListStudentsCTL {
    /**
     *Import StudentManager Class for get/set domain student.
     */
    private StudentManager sm;
    /**
     *StudentManager.get() returns itself
     */
    public ListStudentsCTL() {
        sm = StudentManager.get();
    }
    /**
     * @param lister **IStudentLister**
     * @param unitCode The unitCode
     */
    public final void listStudents(final IStudentLister lister, final String unitCode) {
        lister.clearStudents();
        StudentMap students = sm.getStudentsByUnit(unitCode);
        for (Map.Entry<Integer, IStudent> entry : students.entrySet()) {
            lister.addStudent(entry.getValue());
        }
    }
}
