package Project;
import static java.lang.System.exit;


/**
 * Represents a tests class.
 * @author Karashchuk Stanislav
 * @version 27 Nov 2022
 * @since 21 Nov 2022
 */
public class SQLTool {

    public static void main(String[] args) throws Exception {
        Test.testSQL("src/Project/Test.txt");
        Test.testReport("src/Project/Test2.txt");
        Test.testAdmin("src/Project/Test3.txt");
        exit(0);
    }
}
