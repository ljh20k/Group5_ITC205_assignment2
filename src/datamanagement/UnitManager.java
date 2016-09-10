package datamanagement;

import org.jdom.Element;

import java.util.List;

public final class UnitManager {

    private static UnitManager self = null;

    private UnitMap unitMap;

    public static UnitManager getUnitManager() {
        if (self == null) {
            self = new UnitManager();
        }
        return self;
    }

    private UnitManager() {
        unitMap = new UnitMap();
    }

    public IUnit getUnit(final String uc) {
        IUnit iu = unitMap.get(uc);
        if (iu != null) {
            return iu;
        }
        return createUnit(uc);
    }

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
                        el.getAttributeValue("di")).floatValue(), Float
                        .valueOf(el.getAttributeValue("hd"))
                        .floatValue(), Float.valueOf(
                        el.getAttributeValue("ae")).floatValue(),
                        Integer.valueOf(el.getAttributeValue("asg1wgt"))
                                .intValue(), Integer.valueOf(
                        el.getAttributeValue("asg2wgt")).intValue(),
                        Integer.valueOf(el.getAttributeValue("examwgt"))
                                .intValue(), StudentUnitRecordManager
                        .instance().getRecordsByUnit(unitCode));
                unitMap.put(iu.getUnitCode(), iu);
                return iu;
            }
        }
        throw new RuntimeException("DBMD: createUnit : unit not in file");
    }

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
