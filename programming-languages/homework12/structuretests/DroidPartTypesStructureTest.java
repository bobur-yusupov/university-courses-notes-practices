package structuretests;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class DroidPartTypesStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theEnum("marketplace.droids.DroidPartTypes")
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
                 .hasEnumElements("DROID_HEAD", "DROID_TORSO", "DROID_ARM", "DROID_LEG", "DROID_WHEEL")
                 ;
    }

}

