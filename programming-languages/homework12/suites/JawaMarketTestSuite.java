import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@SelectClasses({
    JawaMarketTestSuite.StructuralTests.class,
    JawaMarketTestSuite.FunctionalTests.class,
})
@Suite public class JawaMarketTestSuite {
    @SelectClasses({
          DroidPartTypesStructureTest.class
        , DroidPartStructureTest.class
        , DroidStructureTest.class

        , RepairDroidStructureTest.class
        , TranslatorDroidStructureTest.class

        , SellerStructureTest.class
        , JawaStructureTest.class

        , MarketStructureTest.class
    })
    @Suite public static class StructuralTests {}

    @SelectClasses({
        JawaMarketPart1TestSuite.class,
        JawaMarketPart2TestSuite.class,
    })
    @Suite public class FunctionalTests {}
}

