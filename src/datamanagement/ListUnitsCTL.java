package datamanagement;

import java.util.Map;

/**
 * Class ListUnitsCTL..
 */
public class ListUnitsCTL {
    /**
     * Import UnitManager Class.
     */
    private UnitManager um;
    /**
     * UnitManager.getUnitManager() returns itself when not null.
     */
    public ListUnitsCTL() {
        um = UnitManager.getUnitManager();
    }

    /**
     * @param lister **IUnitList**
     */
    public final void listUnits(final IUnitLister lister) {
        lister.clearUnits();
        UnitMap units = um.getUnits();
        for (Map.Entry<String,IUnit> entry :units.entrySet()) {
            lister.addUnit(entry.getValue());
        }
    }
}
