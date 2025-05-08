import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class MarketStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("marketplace.Market")
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldSellers() {
        it.hasField("sellers: java.util.List of marketplace.persons.Jawa")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
          .thatHasNo(GETTER, SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor() {
        it.hasConstructor(withNoParams())
          .thatIs(VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodAddSeller01() {
        it.hasMethod("addSeller", withParams("seller: marketplace.persons.Jawa"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodBuyDroids02() {
        it.hasMethod("buyDroids", withParams("seller: marketplace.persons.Jawa", "droidsToBuy: java.util.List of marketplace.droids.Droid"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("int");
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodBuyDroidParts03() {
        it.hasMethod("buyDroidParts", withParams("seller: marketplace.persons.Jawa", "partsToBuy: java.util.List of marketplace.droids.DroidPart"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("int");
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodDisplayAvailableDroids04() {
        it.hasMethod("displayAvailableDroids", withParams("seller: marketplace.persons.Jawa"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_04)
    public void methodDisplayAvailableParts05() {
        it.hasMethod("displayAvailableParts", withParams("seller: marketplace.persons.Jawa"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

}

