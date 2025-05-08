import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class DroidStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("marketplace.droids.Droid")
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldParts() {
        it.hasField("parts: java.util.List of DroidPart")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
          .thatHas(GETTER)
          .thatHasNo(SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(1_01)
    public void fieldPowerLevel() {
        it.hasField("powerLevel: int")
          .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
          .thatHas(GETTER)
          .thatHasNo(SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor() {
        it.hasConstructor(withParams("parts: java.util.List of DroidPart"))
          .thatIs(VISIBLE_TO_ALL);
    }


    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodDamagePart() {
        it.hasMethod("damagePart", withParams("part: DroidPart", "damage: int"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodCharge() {
        it.hasMethod("charge", withParams("chargeAmount: int"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodRunDiagnostics() {
        it.hasMethod("runDiagnostics", withNoParams())
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("String");
    }

    @Test @DisabledIf(notApplicable) @Order(3_04)
    public void methodReducePower() {
        it.hasMethod("reducePower", withParams("amount: int"))
          .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable)
    public void text() {
        it.has(TEXTUAL_REPRESENTATION);
    }

}

