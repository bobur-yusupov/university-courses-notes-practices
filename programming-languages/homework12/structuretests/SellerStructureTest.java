import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class SellerStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theInterface("marketplace.persons.Seller")
                 .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 ;
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodSellDroid() {
        it.hasMethod("sellDroid", withParams("buyList: java.util.List of marketplace.droids.Droid"))
          .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("int");
    }

    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodSellDroidParts() {
        it.hasMethod("sellDroidParts", withParams("buyList: java.util.List of marketplace.droids.DroidPart"))
          .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
          .thatReturns("int");
    }

}

