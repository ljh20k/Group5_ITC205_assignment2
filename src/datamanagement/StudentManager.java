package datamanagement;

import org.jdom.Element;
import java.util.List;

/**
 * Class StudentManager.
 * used to handle student data and table
 */
public final class StudentManager {
    /**
     * Prepare to import StudentManager.
     */
    private static StudentManager self;
    /**
     * StudentMap = HashMap<String, IStudentUnitRecord>.
     */
    private StudentMap studentMap;
    /**
     * Import HashMap.
     */
    private java.util.HashMap<String, StudentMap> um;

    /**
     * @return StudentManager
     * StudentManager self = new StudentManager();
     */
    public static StudentManager get() {
        self = new StudentManager();
        return self;
    }

    /**
     * Generating HashMaps.
     */
    private StudentManager() {

        studentMap = new StudentMap();
        um = new java.util.HashMap<>();
    }

    /**
     * @param id studentId.
     * @return is != null ? is : createStudent(id);
     */
    public IStudent getStudent(final Integer id) {
        IStudent is = studentMap.get(id);
        if (is != null) {
            return is;
        }
        return createStudent(id);
    }

    /**
     * @param id studentId.
     * @return el Element.
     */
    private Element getStudentElement(final Integer id) {
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student")) {
            if (id.toString().equals(el.getAttributeValue("sid"))) {
                return el;
            }
        }
        return null;
    }

    /**
     * @param id studentId.
     * @return IStudent
     */
    private IStudent createStudent(final Integer id) {
        IStudent is;
        Element el = getStudentElement(id);
        if (el != null) {
            StudentUnitRecordList rlist = StudentUnitRecordManager.instance().getRecordsByStudent(id);
            is = new Student(Integer.valueOf(el.getAttributeValue("sid")), el.getAttributeValue("fname"), el.getAttributeValue("lname"), rlist);
            studentMap.put(is.getID(), is);
            return is;
        }
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }

    /**
     * @param id id.
     * @return IStudent.
     */
    private IStudent createStudentProxy(final Integer id) {
        Element el = getStudentElement(id);
        if (el != null) {
            return new StudentProxy(id, el.getAttributeValue("fname"), el.getAttributeValue("lname"));
        }
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }

    /**
     * @param uc uc.
     * @return StudentMap s
     */
    public StudentMap getStudentsByUnit(final String uc) {
        StudentMap sm = um.get(uc);
        if (sm != null) {
            return sm;
        }
        sm = new StudentMap();
        IStudent is;
        StudentUnitRecordList ur = StudentUnitRecordManager.instance().getRecordsByUnit(uc);
        for (IStudentUnitRecord studentUnitRecord : ur) {
            is = createStudentProxy(studentUnitRecord.getStudentID());
            sm.put(is.getID(), is);
        }
        um.put(uc, sm);
        return sm;
    }
}
