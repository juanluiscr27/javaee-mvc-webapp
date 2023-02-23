
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages("repository")
@SuiteDisplayName(value = "All Tests")
public class TestSuite {
}
