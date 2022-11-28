package Project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


/**
 * Parser class which parse data from web-site
 * @author Karashchuk Stanislav
 * @version 27 Nov 2022
 * @since 21 Nov 2022
 */
public  class Parser implements Callable<List<List<String>>> {

    /** Override a call function that parses data from site using Jsoup and then using future to await data .
     * NOTE: User must be able to connect web-site;
     */
    @Override
    public List<List<String>> call() throws Exception {
        long t0 = System.currentTimeMillis();
        try {
            String html = "https://www.ffiec.gov/census/report.aspx?year=2011&state=01&report=demographic&msa=11500";
            List<String> headers = new ArrayList<>();
            Document doc = Jsoup.connect(html).get();

            //finding table in html structure
            Elements tableElements = doc.select("tbody").get(1).select("tr").select("th");
            //get headers of table
            for (org.jsoup.nodes.Element row : tableElements) {
                headers.add(row.text());
            }
            List<String> elements = new ArrayList<>();
            List<List<String>> parsedElements = new ArrayList<>();
            parsedElements.add(headers);
            tableElements = doc.select("form").select("tr");
            //adding values from table to list
            for (org.jsoup.nodes.Element row : tableElements) {
                org.jsoup.select.Elements columns = row.select("td");
                for (org.jsoup.nodes.Element element : columns) {
                    elements.add(element.text());
                }
                parsedElements.add(elements);
                elements = new ArrayList<>();
            }
            return parsedElements;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("interrupted after " + (System.currentTimeMillis() - t0) / 1000d + "s: " + e);
            return null;
        }
    }
}