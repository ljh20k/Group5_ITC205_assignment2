package datamanagement;

import org.jdom.Element;

import java.util.List;

/**
 * Class StudentUnitRecordManager.
 */
public final class StudentUnitRecordManager {

    private static StudentUnitRecordManager studentUnitRecordManager = null;
    private StudentUnitRecordMap studentUnitRecordMap;
    private java.util.HashMap<String, StudentUnitRecordList> stringStudentUnitRecordListHashMap;
    private java.util.HashMap<Integer, StudentUnitRecordList> integerStudentUnitRecordListHashMap;

    /**
     * studentUnitRecordManager returns itself if it is not null.
     * @return
     */
    public static StudentUnitRecordManager instance() {
        if (studentUnitRecordManager == null) {
            studentUnitRecordManager = new StudentUnitRecordManager();
        }
        return studentUnitRecordManager;
    }

    /**
     * Import hashmap into
     * stringStudentUnitRecordListHashMap
     * integerStudentUnitRecordListHashMap
     * Inject StudentUnitRecordMap into studentUnitRecordMap
     */
    private StudentUnitRecordManager() {
        studentUnitRecordMap = new StudentUnitRecordMap();
        stringStudentUnitRecordListHashMap = new java.util.HashMap<>();
        integerStudentUnitRecordListHashMap = new java.util.HashMap<>();
    }

    /**
     * Method getStudentUnitRecord checks if parameters matches to existing studentUnitRecordMap.
     * If it is not null, return itself.
     * If it does not match it will create a new StudentUnitRecord with given parameters.
     * @param studentID studentID
     * @param unitCode unitCode
     * @return IStudentUnitRecord
     */
    public IStudentUnitRecord getStudentUnitRecord(final Integer studentID, final String unitCode) {
        IStudentUnitRecord ir = studentUnitRecordMap.get(studentID.toString() + unitCode);
        if (ir != null) {
            return ir;
        }
        return createStudentUnitRecord(studentID, unitCode);
    }

    /**
     * Method createStudentUnitRecord creates new studentUnitRecord with given parameters below.
     * @param uid unitId
     * @param sid studentId
     * @return
     */
    private IStudentUnitRecord createStudentUnitRecord(final Integer uid, final String sid) {
        IStudentUnitRecord ir;
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            if (uid.toString().equals(el.getAttributeValue("sid")) && sid.equals(el.getAttributeValue("uid"))) {
                ir = new StudentUnitRecord(Integer.valueOf(el.getAttributeValue("sid")), el.getAttributeValue("uid"),
                        new Float(el.getAttributeValue("asg1")).floatValue(),
                        new Float(el.getAttributeValue("asg2")).floatValue(),
                        new Float(el.getAttributeValue("exam")).floatValue());
                studentUnitRecordMap.put(ir.getStudentID().toString() + ir.getUnitCode(), ir);
                return ir;
            }
        }
        throw new RuntimeException("DBMD: createStudent : student unit record not in file");
    }

    /**
     * Method getRecordsByUnit used to get records by given unitCode parameter.
     * @param unitCode unitCode
     * @return recs studentUnitRecordList
     */
    public StudentUnitRecordList getRecordsByUnit(final String unitCode) {
        StudentUnitRecordList recs = stringStudentUnitRecordListHashMap.get(unitCode);
        if (recs != null) {
            return recs;
        }
        recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            if (unitCode.equals(el.getAttributeValue("uid"))) {
                recs.add(new StudentUnitRecordProxy(Integer.valueOf(el.getAttributeValue("sid")), el.getAttributeValue("uid")));
            }
        }
        if (recs.size() > 0) {
            stringStudentUnitRecordListHashMap.put(unitCode, recs); // be careful - this could be empty
        }
        return recs;
    }

    /**
     * Method StudentUnitRecordList used to get StudentUnitRecordList by given studentId parameter.
     * @param studentID studentId
     * @return recs StudentUnitRecordList
     */
    public StudentUnitRecordList getRecordsByStudent(final Integer studentID) {
        StudentUnitRecordList recs = integerStudentUnitRecordListHashMap.get(studentID);
        if (recs != null) {
            return recs;
        }
        recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            if (studentID.toString().equals(el.getAttributeValue("sid"))) {
                recs.add(new StudentUnitRecordProxy(Integer.valueOf(el.getAttributeValue("sid")), el.getAttributeValue("uid")));
            }
        }
        if (recs.size() > 0) {
            integerStudentUnitRecordListHashMap.put(studentID, recs); // be careful - this could be empty
        }
        return recs;
    }

    /**
     * Methods saveRecord used to save record by given StudentUnitRecord.
     * @param irec IStudentUnitRecord
     */
    public void saveRecord(final IStudentUnitRecord irec) {
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            if (irec.getStudentID().toString().equals(el.getAttributeValue("sid")) && irec.getUnitCode().equals(el.getAttributeValue("uid"))) {
                el.setAttribute("asg1", Float.toString(irec.getAsg1()));
                el.setAttribute("asg2",Float.toString(irec.getAsg2()));
                el.setAttribute("exam", Float.toString(irec.getExam()));
                XMLManager.getXML().saveDocument(); //write out the XML file for continuous save
                return;
            }
        }
        throw new RuntimeException("DBMD: saveRecord : no such student record in data");
    }
}
