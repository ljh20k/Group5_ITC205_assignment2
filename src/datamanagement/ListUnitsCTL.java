package datamanagement;
/**
 * Class ListUnitsCTL..
 */
public class ListUnitsCTL {
    /**
     * Import UnitManager Class.
     */
    private UnitManager um;
    /**
     * UnitManager.UM() returns itself when not null.
     */
    public ListUnitsCTL() {
        um = UnitManager.UM();
    }

    /**
     * @param lister **IUnitList**
     */
    public final void listUnits(final IUnitLister lister) {
        lister.clearUnits();
        UnitMap units = um.getUnits();
        for (String s : units.keySet()) {
            lister.addUnit(units.get(s));
        }
    }
}
