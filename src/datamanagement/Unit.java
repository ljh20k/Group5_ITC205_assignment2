package datamanagement;

/**
 * Class Unit used to manage unit variables.
 */
public class Unit implements IUnit {
    private String unitCode;
    private String unitName;
    private float cutOff1;
    private float cutOff2;
    private float cutOff3;
    private float cutOff4;
    private float cutOff5;
    private int assignment1, assignment2, exam;

    /**
     * import StudentUnitRecordList.
     */
    private StudentUnitRecordList studentUnitRecordList;

    /**
     * Constructor Unit used to set given parameters below.
     * @param uc unitCode
     * @param un unitName
     * @param f1 cutOff2
     * @param f2 cutOff1
     * @param f3 cutOff4
     * @param f4 cutOff3
     * @param f5 cutOff5
     * @param i1 assignment1
     * @param i2 assignment2
     * @param i3 assignment3
     * @param rl studentUnitRecordList
     */

    public Unit(final String uc, final String un, final float f1, final float f2, final float f3, final float f4,
                final float f5, final int i1, final int i2, final int i3, final StudentUnitRecordList rl) {

        unitCode = uc;
        unitName = un;
        cutOff2 = f1;
        cutOff1 = f2;
        this.cutOff4 = f3;
        cutOff3 = f4;
        this.cutOff5 = f5;
        this.setAssessmentWeights(i1, i2, i3);
        if (rl == null) {
           studentUnitRecordList = new StudentUnitRecordList();
        }
        studentUnitRecordList = rl;
    }

    /**
     * Getters & Setters
     */
    public final String getUnitCode() {
        return this.unitCode;
    }

    public final String getUnitName() {

        return this.unitName;
    }

    public final void setPsCutoff1(final float cutoff) {
        this.cutOff2 = cutoff;
    }

    public final float getPsCutoff() {
        return this.cutOff2;
    }

    public final void setCrCutoff(final float cutoff) {
        this.cutOff1 = cutoff;
    }

    public final float getCrCutoff() {
        return this.cutOff1;
    }

    public final void setDiCutoff(final float cutoff) {
        this.cutOff4 = cutoff;
    }

    public final float getDiCutoff() {
        return this.cutOff4;
    }

    public final void hdCutOff(final float cutoff) {
        this.cutOff3 = cutoff;
    }

    public final void setHdCutOff(final float cutoff) {
        this.cutOff3 = cutoff;
    }

    public final float getHdCutoff() {
        return this.cutOff3;
    }

    public final void setAeCutoff(final float cutoff) {
        this.cutOff5 = cutoff;
    }

    public final float getAeCutoff() {
        return this.cutOff5;
    }

    public final void addStudentRecord(final IStudentUnitRecord record) {
        studentUnitRecordList.add(record);
    }

    public final IStudentUnitRecord getStudentRecord(final int studentID) {
        for (IStudentUnitRecord r : studentUnitRecordList) {
            if (r.getStudentID() == studentID) {
                return r;
            }
        }
        return null;
    }

    public final StudentUnitRecordList listStudentRecords() {
        return studentUnitRecordList;
    }

    /**
     * Override from IUnit Interface.
     */

    @Override
    public final int getAsg1Weight() {
        return assignment1;
    }

    @Override
    public final int getAsg2Weight() {
        return assignment2;
    }

    @Override
    public final int getExamWeight() {
        return exam;
    }

    @Override
    public final void setAssessmentWeights(final int a1, final int a2, final int ex) {
        if (a1 < 0 || a1 > 100
                || a2 < 0 || a2 > 100
                || ex < 0 || ex > 100) {
            throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
        }
        if (a1 + a2 + ex != 100) {
            throw new RuntimeException("Assessment weights must add to 100");
        }
        this.assignment1 = a1;
        this.assignment2 = a2;
        this.exam = ex;
    }

    /**
     * Method setCutOffs that sets CutOffs(StudentGrade).
     * @param ps pass
     * @param cr credit
     * @param di distinction
     * @param hd high distinction
     * @param ae additional exam
     */
    private void setCutoffs(final float ps, final float cr, final float di, final float hd, final float ae) {
        if (ps < 0 || ps > 100
                || cr < 0 || cr > 100
                || di < 0 || di > 100
                || hd < 0 || hd > 100
                || ae < 0 || ae > 100) {
            throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
        }
        if (ae >= ps) {
            throw new RuntimeException("AE cutoff must be less than PS cutoff");
        }
        if (ps >= cr) {
            throw new RuntimeException("PS cutoff must be less than CR cutoff");
        }
        if (cr >= di) {
            throw new RuntimeException("CR cutoff must be less than DI cutoff");
        }
        if (di >= hd) {
            throw new RuntimeException("DI cutoff must be less than HD cutoff");
        }
    }

    /**
     * Method getGrade that returns String type of studentGrade.
     * @param f1 assignment1 marks
     * @param f2 assignment2 marks
     * @param f3 exam marks
     * @return String studentGrade
     */
    public final String getGrade(final float f1, final float f2, final float f3) {
        float t = f1 + f2 + f3;

        if (f1 < 0 || f1 > assignment1
                || f2 < 0 || f2 > assignment2
                || f3 < 0 || f3 > exam) {
            throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
        }

        if (t < cutOff5) {
            return "FL";
        } else if (t < cutOff2) {
            return "AE";
        } else if (t < cutOff1) {
            return "PS";
        } else if (t < cutOff4) {
            return "CR";
        } else if (t < cutOff3) {
            return "DI";
        } else {
            return "HD";
        }
    }
}