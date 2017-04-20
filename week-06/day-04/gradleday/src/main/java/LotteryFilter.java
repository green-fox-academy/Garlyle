import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LotteryFilter {
  public static void main(String[] args) {
    OptionParser parser = new OptionParser();
    parser.accepts("y").withRequiredArg();
    parser.accepts("f").withRequiredArg();
    parser.accepts("o").withRequiredArg();
    OptionSet options = parser.parse(args);

    if (!options.has("y")) {
      System.out.println("Year was not given for filtering");
      return;
    }
    String yearFilter = options.valueOf("y").toString();
    String inputFile = (options.has("f"))? options.valueOf("f").toString() : "otos.csv";
    String outputFile = (options.has("o"))? options.valueOf("o").toString() : "output.csv";

    try {
      CSVReader reader = new CSVReader(new FileReader(inputFile), ';');
      List<String[]> lines = reader.readAll();
      CSVWriter writer = new CSVWriter(new FileWriter(outputFile), ';', CSVWriter.NO_QUOTE_CHARACTER);

      for (String[] line : lines) {
        if (line[0].equals(yearFilter)) {
          writer.writeNext(line);
        }
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
