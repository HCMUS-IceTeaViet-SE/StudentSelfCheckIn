package main.java.utils;

import main.java.model.BaseModel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Genius Doan on 3/12/2017.
 */

public class FileUtils {
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE_SYMBOL = '"';

    /**
     * Write a list of string values to CSV file
     *
     * @param w      a writer attach with the file path
     * @param values the attributes of a Student write in String
     */
    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    private static String formatCSV(String value) {
        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

    /**
     * Write a list of string values to CSV file with custom separator and quote characters
     *
     * @param w           a writer attach with the file path
     * @param values      the attributes of a Student write in String
     * @param separator   the separator of file (default is comma: ",")
     * @param customQuote the custom quote
     */
    public static void writeLine(Writer w, List<String> values, char separator, char customQuote) throws IOException {
        boolean isFirst = true;

        //default customQuote is empty
        if (separator == ' ') {
            separator = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!isFirst) {
                sb.append(separator);
            }
            if (customQuote == ' ') {
                sb.append(formatCSV(value));
            } else {
                sb.append(customQuote).append(formatCSV(value)).append(customQuote);
            }

            isFirst = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }


    /**
     * Read and parse a list of string value from csv file
     *
     * @param cvsLine the line read from csv file
     * @return a list of string value contain attribute for a Student
     */
    public static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE_SYMBOL);
    }

    /**
     * Read and parse a list of string value from csv file
     *
     * @param line        the line read from csv file
     * @param separator   the separator of file (default is comma: ",")
     * @param customQuote the custom quote
     * @return a list of string value contain attribute for a Student
     */
    public static List<String> parseLine(String line, char separator, char customQuote) {
        List<String> result = new ArrayList<>();

        //if empty, return!
        if (line == null && line.isEmpty()) {
            return result;
        }
        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE_SYMBOL;
        }
        if (separator == ' ') {
            separator = DEFAULT_SEPARATOR;
        }

        StringBuffer currValue = new StringBuffer();
        boolean inQuotes = false;
        boolean collectChar = false;
        boolean doubleQuotesInCol = false;

        char[] chars = line.toCharArray();
        for (char c : chars) {

            if (inQuotes) {
                collectChar = true;
                if (c == customQuote) {
                    inQuotes = false;
                    doubleQuotesInCol = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (c == '\"') {
                        if (!doubleQuotesInCol) {
                            currValue.append(c);
                            doubleQuotesInCol = true;
                        }
                    } else {
                        currValue.append(c);
                    }

                }
            } else {
                if (c == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        currValue.append('"');
                    }

                    //double quotes in column will hit this!
                    if (collectChar) {
                        currValue.append('"');
                    }

                } else if (c == separator) {

                    result.add(currValue.toString());

                    currValue = new StringBuffer();
                    collectChar = false;

                } else if (c == '\r') {
                    //ignore LF characters
                    continue;
                } else if (c == '\n') {
                    //the end, break!
                    break;
                } else {
                    currValue.append(c);
                }
            }
        }

        result.add(currValue.toString());
        return result;
    }


    /**
     * Export a list of student to CSV file
     *
     * @param filePath the string path of data file
     */
    public void exportToCSV(String filePath, List<BaseModel> data) throws IOException {
        Writer writer = new FileWriter(filePath);
        for (BaseModel item : data) {
            //FileUtils.writeLine(writer, item.toStringList());
        }

        writer.flush();
        writer.close();
    }
}