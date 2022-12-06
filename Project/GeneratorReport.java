package Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Represents a result of parsing table from
 * <a href="https://www.ffiec.gov/census/report.aspx?year=2011&state=01&report=demographic&msa=11500">
 *     FFIEC Census Reports</a>
 * and make report using average of median family income, average of median family income 2000 ,
 * sum of tract population, minority population and owner occupied units.
 * @author Karashchuk Stanislav
 * @version 27 Nov 2022
 * @since 21 Nov 2022
 */
public class GeneratorReport {

    /** Generate a report by table from site.
     * NOTE: User must be able to create table;
     * @param host The hostname of remote SQL server to connect.
     * @param port The port number of remote SQL server to connect.
     * @param username The username for remote SQL server to connect.
     * @param password The username password for remote SQL server to connect.
     */
    public static void generateReport(String host, String port, String username, String password) throws Exception {

        //Await data from parsing using future
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<List<String>>> future = executor.submit(new Parser());
        List<List<String>> elements = null;
        try {
            elements = future.get(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("cancelling future (" + e + ")");
            future.cancel(true);
        } finally {
            executor.shutdownNow();
        }

        //connect to  remote SQL Server
        RemoteDBConnection remoteDBConnection = new RemoteDBConnection(host, port,
                username, password);
        remoteDBConnection.executeUpdateStatement("USE Project;");
        assert elements != null;
        String createTableQuery = "CREATE TABLE IF NOT exists report({0} VARCHAR(255), {1} VARCHAR(255)," +
                            " {2} VARCHAR(255), {3} VARCHAR(255), {4} FLOAT, {5} FLOAT, {6} FLOAT," +
                " {7} FLOAT, {8} INTEGER, {9} FLOAT, {10} INTEGER, {11} INTEGER, {12} INTEGER);";

        //add `` symbols to headers to create table
        elements.set(0, elements.get(0).stream().
                map(e  ->  {
                    StringBuilder str = new StringBuilder(e);
                    str.append("`");
                    str.insert(0, "`");
                    return str.toString();})
                .collect(Collectors.toList()));

        //remove char $ and . for adding values to table
        elements = elements.stream().
                map(e -> e.stream().
                        map(s -> s.replace("$", "")).
                map(s-> s.replace(",", ".")).
                        collect(Collectors.toList())).
                collect(Collectors.toList());
        List<String> tableHeaders = elements.get(0);

        //execute query to create table
        remoteDBConnection.executeUpdateStatement(MessageFormat.format(createTableQuery, tableHeaders.get(0),
                tableHeaders.get(1), tableHeaders.get(2), tableHeaders.get(3), tableHeaders.get(4), tableHeaders.get(5),
                tableHeaders.get(6), tableHeaders.get(7), tableHeaders.get(8), tableHeaders.get(9), tableHeaders.get(10),
                tableHeaders.get(11), tableHeaders.get(12)));

        elements.remove(1);
        int status = 1;
        ResultSet resultSet = remoteDBConnection.executeSelectQuery("select count(1) where exists " +
                "(select * from report)");
        if(resultSet.next()){
            status = resultSet.getInt(1);
        }

        //checking if table is empty either add values
        if(status == 0){
            for(int i = 1; i  < elements.size(); i++){
                String query = "insert into report ({0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}," +
                        " {8}, {9}, {10}, {11}, {12})"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                query = MessageFormat.format(query, elements.get(0).get(0), elements.get(0).get(1),
                        elements.get(0).get(2), elements.get(0).get(3), elements.get(0).get(4), elements.get(0).get(5),
                        elements.get(0).get(6), elements.get(0).get(7), elements.get(0).get(8), elements.get(0).get(9),
                        elements.get(0).get(10), elements.get(0).get(11), elements.get(0).get(12));
                PreparedStatement statement = remoteDBConnection.getConnection().prepareStatement(query);
                statement.setString(1,elements.get(i).get(0));
                statement.setString(2, elements.get(i).get(1));
                statement.setString(3, elements.get(i).get(2));
                statement.setString(4, elements.get(i).get(3));
                statement.setFloat(5, Float.parseFloat(elements.get(i).get(4)));
                statement.setFloat(6, Float.parseFloat(elements.get(i).get(5)));
                statement.setFloat(7, Float.parseFloat(elements.get(i).get(6)));
                statement.setFloat(8, Float.parseFloat(elements.get(i).get(7)));
                statement.setInt(9, Integer.parseInt(elements.get(i).get(8)));
                statement.setFloat(10, Float.parseFloat(elements.get(i).get(9)));
                statement.setInt(11, Integer.parseInt(elements.get(i).get(10)));
                statement.setInt(12, Integer.parseInt(elements.get(i).get(11)));
                statement.setInt(13, Integer.parseInt(elements.get(i).get(12)));
                remoteDBConnection.executeUpdateStatement(statement);
            }
        }

        //generating report and printing output
        resultSet =  remoteDBConnection.executeSelectQuery("select Avg(`2011 Est. Tract Median Family Income`) as " +
                "`Avarage of median family income`, Avg(`2000 Tract Median Family Income`) as " +
                "`Avarage of median family income 2000`, sum(`Tract Population`), sum(`Minority Population`)," +
                " sum(`Owner Occupied Units`)  from report;");
        TablePrinter.printResultSet(resultSet);
    }
}
