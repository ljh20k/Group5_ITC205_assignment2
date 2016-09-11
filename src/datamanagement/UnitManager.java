package datamanagement;

import org.jdom.Element;

import java.util.List;

/**
 * Class UnitManager that creates and get unit related.
 */
public final class UnitManager {

    private static UnitManager self = null;

    private UnitMap unitMap;

    /**
     * Method UnitManager that returns itself when not null.
     * @return self UnitManager
     */
    public static UnitManager getUnitManager() {
        if (self == null) {
            self = new UnitManager();
        }
        return self;
    }

    /**
     * Constructor UnitManager that imports unitMap when this class run.
     */
    private UnitManager() {
        unitMap = new UnitMap();
    }

    /**
     * Method IUnit that getIUnit when exist .
     * or creates IUnit when not exist.
     * @param uc unitCode
     * @return IUnit
     */
    public IUnit getUnit(final String uc) {
        IUnit iu = unitMap.get(uc);
        if (iu != null) {
            return iu;
        }
        return createUnit(uc);
    }

    /**
     * Method IUnit that creates IUnit.
     * @param unitCode unitCode
     * @return iu IUnit
     */
    private IUnit createUnit(final String unitCode) {

        IUnit iu;

        for (Element el : (List<Element>) XMLManager.getXML().getDocument()
                .getRootElement().getChild("unitTable").getChildren("unit")) {
            if (unitCode.equals(el.getAttributeValue("uid"))) {
                StudentUnitRecordList slist;

                slist = null;
                iu = new Unit(el.getAttributeValue("uid"),
                        el.getAttributeValue("name"), Float.valueOf(
                        el.getAttributeValue("ps")).floatValue(), Float
                        .valueOf(el.getAttributeValue("cr"))
                        .floatValue(), Float.valueOf(
                        el.getAttributeValue("di")).floatValue(),
                        Float.valueOf(el.getAttributeValue("hd"))
                        .floatValue(), Float.valueOf(el.getAttributeValue("ae")).floatValue(),
                        Integer.parseInt(el.getAttributeValue("asg1wgt"))
                        , Integer.parseInt(el.getAttributeValue("asg2wgt")),
                        Integer.parseInt(el.getAttributeValue("examwgt")),
                        StudentUnitRecordManager
                        .instance().getRecordsByUnit(unitCode));
                unitMap.put(iu.getUnitCode(), iu);
                return iu;
            }
        }
        throw new RuntimeException("DBMD: createUnit : unit not in file");
    }

    /**
     * getter method that returns UnitMap.
     * @return um UnitMap
     */
    public UnitMap getUnits() {

        UnitMap uM;
        IUnit iu;

        uM = new UnitMap();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument()
                .getRootElement().getChild("unitTable").getChildren("unit")) {
            iu = new UnitProxy(el.getAttributeValue("uid"),
                    el.getAttributeValue("name"));
            uM.put(iu.getUnitCode(), iu);
        } // unit maps are filled with PROXY units
        return uM;
    }

}
