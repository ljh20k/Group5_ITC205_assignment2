package datamanagement;

/**
 * class CgCTL.
 */
public class CgCTL {
    /**
     * import CgUI class.
     */
    private CgUI cgUI;
    /**
     * declare the empty String.
     */
    private String cuc = null;
    /**
     * declare the empty Integer.
     */
    private Integer currentStudentID = null;
    /**
     * declare the base boolean as false.
     */
    private boolean changed = false;

    /**
     * class CgCTL.
     */
    public CgCTL() {
    }

    /**
     * execute the new CgCTL.
     */
    public final void execute() {
        cgUI = new CgUI(this);
        cgUI.setState1(false);

        cgUI.setState2(false);
        cgUI.setState3(false);
        cgUI.setState4(false);
        cgUI.setState5(false);
        cgUI.setState6(false);
        cgUI.refresh3();

        ListUnitsCTL luCTL = new ListUnitsCTL();
        luCTL.listUnits(cgUI);
        cgUI.setVisible(true);
        cgUI.setState1(true);
    }

    /**
     * @param code code
     */
    public final void unitSelected(final String code) {
        if (code.equals("NONE")) {
            cgUI.setState2(false);
        } else {
            ListStudentsCTL lsCTL = new ListStudentsCTL();
            lsCTL.listStudents(cgUI, code);
            cuc = code;
            cgUI.setState2(true);
        }
        cgUI.setState3(false);
    }

    /**
     * @param id studentId
     */
    public final void studentSelected(final Integer id) {
        currentStudentID = id;
        if (currentStudentID.intValue() == 0) {
            cgUI.refresh3();
            cgUI.setState3(false);
            cgUI.setState4(false);
            cgUI.setState5(false);
            cgUI.setState6(false);
        } else {
            IStudent s = StudentManager.get().getStudent(id);

            IStudentUnitRecord r = s.getUnitRecord(cuc);

            cgUI.setRecord(r);
            cgUI.setState3(true);
            cgUI.setState4(true);
            cgUI.setState5(false);
            cgUI.setState6(false);
            changed = false;

        }
    }

    /**
     * @param f value for asg1
     * @param g value for asg2
     * @param h value for exam
     * @return Grade
     */
    public final String checkGrade(final float f, final float g, final float h) {
        IUnit u = UnitManager.getUnitManager().getUnit(cuc);
        String s = u.getGrade(f, g, h);
        cgUI.setState4(true);
        cgUI.setState5(false);
        if (changed) {
            cgUI.setState6(true);
        }
        return s;
    }

    /**
     *checking the changed Marks.
     */
    public final void enableChangeMarks() {
        cgUI.setState4(false);
        cgUI.setState6(false);
        cgUI.setState5(true);
        changed = true;
    }

    /**
     * @param asg1 Asg1
     * @param asg2 Asg2
     * @param exam Exam
     */
    public final void saveGrade(final float asg1, final float asg2, final float exam) {
        IStudent s = StudentManager.get().getStudent(currentStudentID);

        IStudentUnitRecord r = s.getUnitRecord(cuc);
        r.setAsg1(asg1);
        r.setAsg2(asg2);
        r.setExam(exam);
        StudentUnitRecordManager.instance().saveRecord(r);
        cgUI.setState4(true);
        cgUI.setState5(false);
        cgUI.setState6(false);
    }
}
