package Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Represents a result of  SELECT SQL query.
 * @author Karashchuk Stanislav
 * @version 27 Nov 2022
 * @since 21 Nov 2022
 */
public class TablePrinter {
    /**
     * Default maximum width for text columns
     * (like a VARCHAR) column.
     */
    private static final int DEFAULT_MAX_TEXT_COL_WIDTH = 150;
    /**
     * Column type category for CHAR, VARCHAR
     * and similar text columns.
     */
    public static final int CATEGORY_STRING = 1;

    /**
     * Column type category for TINYINT, SMALLINT,
     * INT and BIGINT columns.
     */
    public static final int CATEGORY_INTEGER = 2;
    /**
     * Column type category for REAL, DOUBLE,
     * and DECIMAL columns.
     */

    public static final int CATEGORY_DOUBLE = 3;
    /**
     * Column type category for date and time related columns like
     * DATE, TIME, TIMESTAMP.
     */
    public static final int CATEGORY_DATETIME = 4;

    /**
     * Column type category for BOOLEAN columns.
     */
    public static final int CATEGORY_BOOLEAN = 5;

    /**
     * Column type category for types for which the type name
     * will be printed instead of the content, like BLOB,
     * BINARY, ARRAY.
     */
    public static final int CATEGORY_OTHER = 0;


    /**
     * Represents a database table column.
     */
    private static class Column {

        /**
         * Column label.
         */
        private final String label;

        /**
         * Generic SQL type of the column as defined in java.sql.Types
         */
        private final int type;

        /**
         * Generic SQL type name of the column as defined in java.sql.Types
         */
        private final String typeName;
        /**
         * Width of the column that will be adjusted according to column label
         * and values to be printed.
         */
        private int width = 0;

        /**
         * Column values from each row of a ResultSet.
         */
        private final List<String> values = new ArrayList<>();

        /**
         * Flag for text justification using String.format.
         */
        private String justifyFlag = "";

        /**
         * Column type category. The columns will be categorised according
         * to their column types.
         */
        private int typeCategory = 0;

        /**
         * @param label Column label or name
         * @param type Generic SQL type
         * @param typeName Generic SQL type name
         */
        public Column (String label, int type, String typeName) {
            this.label = label;
            this.type = type;
            this.typeName = typeName;
        }

        /**
         * Returns the column label
         * @return Column label
         */
        public String getLabel() {
            return label;
        }

        /**
         * Returns the generic SQL type of the column
         * @return Generic SQL type
         */
        public int getType() {
            return type;
        }

        /**
         * Returns the generic SQL type name of the column
         * @return Generic SQL type name
         */
        public String getTypeName() {
            return typeName;
        }

        /**
         * Returns the width of the column
         * @return Column width
         */
        public int getWidth() {
            return width;
        }


        /**
         * Sets the width of the column to width.
         * @param width Width of the column
         */
        public void setWidth(int width) {
            this.width = width;
        }

        /**
         * Adds a String representation value
         * of a value to this column object's list.
         * These values will come from each row of a
         * @param value The column value to add to values
         */
        public void addValue(String value) {
            values.add(value);
        }


        /**
         * Returns the column value at row index i.
         * Note that the index starts at 0 so that getValue(0)
         * will get the value for this column from the first row
         * ResultSet.
         * @param i The index of the column value to get
         * @return The String representation of the value
         */
        public String getValue(int i) {
            return values.get(i);
        }

        /**
         * Returns the value of the justifyFlag. The column
         * values will be printed using format and
         * this flag will be used to right or left justify the text.
         * @return The justifyFlag of this column
         * @see #justifyLeft()
         */
        public String getJustifyFlag() {
            return justifyFlag;
        }


        /**
         * Sets justifyFlag to "-" so that
         * the column value will be left justified when printed with
         * String.format.
         */
        public void justifyLeft() {
            this.justifyFlag = "-";
        }

        /**
         * Returns the generic SQL type category of the column
         * @return The  typeCategory of the column
         */
        public int getTypeCategory() {
            return typeCategory;
        }


        /**
         * Sets the typeCategory of the column
         * @param typeCategory The type category
         */
        public void setTypeCategory(int typeCategory) {
            this.typeCategory = typeCategory;
        }
    }


    /**
     * Overloaded method to print rows of a
     * ResultSet to standard out
     * to limit the width of text columns.
     * @param rs The <code>ResultSet</code> to print
     */
    public static void printResultSet(ResultSet rs) {
        printResultSet(rs, DEFAULT_MAX_TEXT_COL_WIDTH);
    }

    /**
     * Overloaded method to print rows
     * to limit the width of text columns.
     * @param rs The ResultSet to print
     * @param maxStringColWidth Max. width of text columns
     */
    public static void printResultSet(ResultSet rs, int maxStringColWidth) {
        try {
            if (rs == null) {
                System.err.println("DBTablePrinter Error: Result set is null!");
                return;
            }
            if (rs.isClosed()) {
                System.err.println("DBTablePrinter Error: Result Set is closed!");
                return;
            }
            if (maxStringColWidth < 1) {
                System.err.println("DBTablePrinter Info: Invalid max. varchar column width. Using default!");
                maxStringColWidth = DEFAULT_MAX_TEXT_COL_WIDTH;
            }

            // Get the metadata object of this ResultSet.
            ResultSetMetaData resultSetMetaData;
            resultSetMetaData = rs.getMetaData();

            // Total number of columns in this ResultSet
            int columnCount = resultSetMetaData.getColumnCount();
            List<Column> columns = new ArrayList<>(columnCount);
            List<String> tableNames = new ArrayList<>(columnCount);

            // Get the columns and their metadata.
            //columnIndex  starts at 1
            for (int i = 1; i <= columnCount; i++) {
                Column c = new Column(resultSetMetaData.getColumnLabel(i),
                        resultSetMetaData.getColumnType(i), resultSetMetaData.getColumnTypeName(i));
                c.setWidth(c.getLabel().length());
                c.setTypeCategory(whichCategory(c.getType()));
                columns.add(c);

                if (!tableNames.contains(resultSetMetaData.getTableName(i))) {
                    tableNames.add(resultSetMetaData.getTableName(i));
                }
            }

            // Go through each row, get values of each column and adjust
            // column widths.
            int rowCount = 0;
            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    Column c = columns.get(i);
                    String value;
                    int category = c.getTypeCategory();

                    if (category == CATEGORY_OTHER) {
                        // for column types BLOB, BINARY etc.
                        value = "(" + c.getTypeName() + ")";

                    } else {
                        value = rs.getString(i + 1) == null ? "NULL" : rs.getString(i+1);
                    }
                    switch (category) {
                        case CATEGORY_DOUBLE:
                            if (!value.equals("NULL")) {
                                Double dValue = rs.getDouble(i+1);
                                value = String.format("%.3f", dValue);
                            }
                            break;

                        case CATEGORY_STRING:
                            c.justifyLeft();
                            if (value.length() > maxStringColWidth) {
                                value = value.substring(0, maxStringColWidth - 3) + "...";
                            }
                            break;
                    }
                    c.setWidth(Math.max(value.length(), c.getWidth()));
                    c.addValue(value);
                }
                rowCount++;

            }
            StringBuilder strToPrint = new StringBuilder();
            StringBuilder rowSeparator = new StringBuilder();

            // Iterate over columns
            for (Column c : columns) {
                int width = c.getWidth();
                // Center the column label
                String toPrint;
                String name = c.getLabel();
                int diff = width - name.length();

                // diff is not divisible by 2, add 1 to width (and diff)
                // so that we can have equal padding to the left and right
                // of the column label.
                if ((diff % 2) == 1) {
                    width++;
                    diff++;
                    c.setWidth(width);
                }
                int paddingSize = diff/2;
                String padding = new String(new char[paddingSize]).replace("\0", " ");
                toPrint = "| " + padding + name + padding + " ";
                strToPrint.append(toPrint);
                rowSeparator.append("+");
                rowSeparator.append(new String(new char[width + 2]).replace("\0", "-"));
            }

            String lineSeparator = System.getProperty("line.separator");
            lineSeparator = lineSeparator == null ? "\n" : lineSeparator;
            rowSeparator.append("+").append(lineSeparator);
            strToPrint.append("|").append(lineSeparator);

            StringJoiner sj = new StringJoiner(", ");
            for (String name : tableNames) {
                sj.add(name);
            }
            String info = "Printing " + rowCount;
            info += rowCount > 1 ? " rows from " : " row from ";
            info += tableNames.size() > 1 ? "tables " : "table ";
            info += sj.toString();
            System.out.println(info);
            System.out.print(strToPrint);
            String format;

            // Print out the rows
            for (int i = 0; i < rowCount; i++) {
                for (Column c : columns) {

                    format = String.format("| %%%s%ds ", c.getJustifyFlag(), c.getWidth());
                    System.out.printf(format, c.getValue(i));
                }

                System.out.println("|");
                System.out.print(rowSeparator);
            }

            System.out.println();

        } catch (SQLException e) {
            System.err.println("SQL exception in DBTablePrinter. Message:");
            System.err.println(e.getMessage());
        }
    }

    /**
     * Takes a generic SQL type and returns the category this type
     * belongs to. Types are categorized according to print formatting
     * needs:
     * Integers should not be truncated so column widths should
     * be adjusted without a column width limit. Text columns should be
     * left justified and can be truncated to a max. column width
     * @param type Generic SQL type
     * @return The category this type belongs to
     */
    private static int whichCategory(int type) {
        switch (type) {
            case Types.BIGINT:
            case Types.TINYINT:
            case Types.SMALLINT:
            case Types.INTEGER:
                return CATEGORY_INTEGER;

            case Types.REAL:
            case Types.DOUBLE:
            case Types.DECIMAL:
                return CATEGORY_DOUBLE;

            case Types.DATE:
            case Types.TIME:
            case Types.TIME_WITH_TIMEZONE:
            case Types.TIMESTAMP:
            case Types.TIMESTAMP_WITH_TIMEZONE:
                return CATEGORY_DATETIME;

            case Types.BOOLEAN:
                return CATEGORY_BOOLEAN;

            case Types.VARCHAR:
            case Types.NVARCHAR:
            case Types.LONGVARCHAR:
            case Types.LONGNVARCHAR:
            case Types.CHAR:
            case Types.NCHAR:
                return CATEGORY_STRING;

            default:
                return CATEGORY_OTHER;
        }
    }
}