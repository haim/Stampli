package util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.yahoo.finance.test.data.HistoricalPricesData;

import java.io.File;
import java.util.List;

public class ReadCVSData {

    //   ({"Date", "Open", "High", "Low", "Close", "Adj Close", "Volume"})
    public static List<HistoricalPricesData> readFile(File csvFile) throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.builder()
                .addColumn("Date")
                .addColumn("Open")
                .addColumn("High")
                .addColumn("Low")
                .addColumn("Close")
                .addColumn("Adj Close")
                .addColumn("Volume").setSkipFirstDataRow(true).build();
        MappingIterator<HistoricalPricesData> pricesDataMappingIterator = csvMapper.readerWithTypedSchemaFor(HistoricalPricesData.class).with(csvSchema).readValues(csvFile);

        return pricesDataMappingIterator.readAll();
    }
}
