package structuretests;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class DroidPartStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("marketplace.droids.DroidPart")
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldBasePrice() {
        it.hasField("basePrice: int")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
          .thatHasNo(GETTER, SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(1_01)
    public void fieldDamage() {
        it.hasField("damage: int")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
          .thatHas(GETTER, SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(1_02)
    public void fieldType() {
        it.hasField("type: DroidPartTypes")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
          .thatHas(GETTER)
          .thatHasNo(SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor() {
        it.hasConstructor(withParams("basePrice: int", "damage: int", "type: DroidPartTypes"))
          .thatIs(VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodGetPrice() {
        it.hasMethod("getPrice", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("int");
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodGetRepairCost() {
        it.hasMethod("getRepairCost", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("int");
    }

    @Test @DisabledIf(notApplicable) @Order(3_04)
    public void methodUpgrade() {
        it.hasMethod("upgrade", withParams("priceIncrease: int"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable)
    public void text() {
        it.has(TEXTUAL_REPRESENTATION);
    }

}

