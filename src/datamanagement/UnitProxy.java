package datamanagement;

/**
 * Class UnitProxy.
 */
public class UnitProxy implements IUnit {
    private String unitCode;
    private String unitName;

    private UnitManager unitManager;

    /**
     * @param uc ** new unitCode **
     * @param un ** new uc **
     */
    public UnitProxy(final String uc, final String un) {
        this.unitCode = uc;
        this.unitName = un;
        unitManager = UnitManager.UM();
    }

    /**
     * getter & setter
     */
    public final String getUnitCode() {
        return this.unitCode;
    }

    public final String getUnitName() {
        return this.unitName;
    }

    public final void setPsCutoff1(final float cutoff) {
        unitManager.getUnit(unitCode).setPsCutoff1(cutoff);
    }

    public final float getPsCutoff() {
        return unitManager.getUnit(unitCode).getPsCutoff();
    }

    public final void setCrCutoff(final float cutoff) {
        unitManager.getUnit(unitCode).setCrCutoff(cutoff);
    }

    public final float getCrCutoff() {
        return unitManager.getUnit(unitCode).getCrCutoff();
    }

    public final void setDiCutoff(final float cutoff) {
        unitManager.getUnit(unitCode).setDiCutoff(cutoff);
    }

    public final float getDiCutoff() {
        return unitManager.getUnit(unitCode).getDiCutoff();
    }

    public final void setHdCutoff(final float cutoff) {
        unitManager.getUnit(unitCode).setHdCutoff(cutoff);
    }

    public final float getHdCutoff() {

        return unitManager.getUnit(unitCode).getHdCutoff();
    }

    public final void setAeCutoff(final float cutoff) {
        unitManager.getUnit(unitCode).setAeCutoff(cutoff);
    }

    public final float getAeCutoff() {
        return unitManager.getUnit(unitCode).getAeCutoff();
    }

    public final String getGrade(final float f1, final float f2, final float f3) {
        return unitManager.getUnit(unitCode).getGrade(f1, f2, f3);
    }

    public final void addStudentRecord(final IStudentUnitRecord record) {
        unitManager.getUnit(unitCode).addStudentRecord(record);
    }

    public final IStudentUnitRecord getStudentRecord(final int s) {
        return unitManager.getUnit(unitCode).getStudentRecord(s);
    }

    public final StudentUnitRecordList listStudentRecords() {
        return unitManager.getUnit(unitCode).listStudentRecords();
    }

    public final int getAsg1Weight() {
        return unitManager.getUnit(unitCode).getAsg1Weight();
    }

    public final int getAsg2Weight() {
        return unitManager.getUnit(unitCode).getAsg2Weight();
    }

    public final int getExamWeight() {
        return unitManager.getUnit(unitCode).getExamWeight();
    }

    public final void setAssessmentWeights(final int asg1Wgt, final int asg2Wgt, final int examWgt) {
        unitManager.getUnit(unitCode).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);

    }
}
