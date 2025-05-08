import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class JawaStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("marketplace.persons.Jawa", withInterface("marketplace.persons.Seller"))
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldDroidsInStorage() {
        it.hasField("droidsInStorage: java.util.List of marketplace.droids.Droid")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
          .thatHasNo(GETTER, SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(1_01)
    public void fieldPartsInStorage() {
        it.hasField("partsInStorage: java.util.Map of marketplace.droids.DroidPart to Integer")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
          .thatHasNo(GETTER, SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(1_02)
    public void fieldName() {
        it.hasField("name: String")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
          .thatHasNo(GETTER, SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor() {
        it.hasConstructor(withParams("name: String"))
          .thatIs(VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodSellDroid() {
        it.hasMethod("sellDroid", withParams("buyList: java.util.List of marketplace.droids.Droid"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("int");
    }

    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodSellDroidParts() {
        it.hasMethod("sellDroidParts", withParams("buyList: java.util.List of marketplace.droids.DroidPart"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("int");
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodApplyDiscount() {
        it.hasMethod("applyDiscount", withParams("totalPrice: int"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
          .thatReturns("int");
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodHaggle() {
        it.hasMethod("haggle", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
          .thatReturns("double");
    }

    @Test @DisabledIf(notApplicable) @Order(3_04)
    public void methodBrowseDroids() {
        it.hasMethod("browseDroids", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("java.util.List of marketplace.droids.Droid");
    }

    @Test @DisabledIf(notApplicable) @Order(3_05)
    public void methodBrowserDroidParts() {
        it.hasMethod("browserDroidParts", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("java.util.Map of marketplace.droids.DroidPart to Integer");
    }

    @Test @DisabledIf(notApplicable) @Order(3_06)
    public void methodAddDroidToInventory() {
        it.hasMethod("addDroidToInventory", withParams("droid: marketplace.droids.Droid"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_07)
    public void methodRestockPart() {
        it.hasMethod("restockPart", withParams("partType: marketplace.droids.DroidPart", "quantity: int"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_08)
    public void methodCheckPartAvailability() {
        it.hasMethod("checkPartAvailability", withParams("partType: marketplace.droids.DroidPart", "quantity: int"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("boolean");
    }

    @Test @DisabledIf(notApplicable)
    public void eq() {
        it.has(EQUALITY_CHECK);
    }

}

