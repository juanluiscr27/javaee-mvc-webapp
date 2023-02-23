
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;


@SuiteDisplayName("All Tests")
@Suite
@SelectPackages("repository")
public class TestSuite {
}
