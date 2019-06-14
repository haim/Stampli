package com.yahoo.finance.test;

import com.yahoo.finance.test.stepdefinitions.HistoricalData;
import com.yahoo.finance.test.stepdefinitions.TimePeriod;
import com.yahoo.finance.test.stepdefinitions.helpers.Period;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class HistoricalDataTest {


    @Test(dataProvider="test_that_csv_contains_same_size_of_records_like_in_historical_data_grid", dataProviderClass = HistoricalDataDataProvider.class)
    public void test_that_csv_contains_same_size_of_records_like_in_historical_data_grid_according_selected_time_period(Period period) throws Exception {
        open("https://finance.yahoo.com/quote/AMZN/history?p=AMZN");
        new TimePeriod().setTimePeriodAndApplyFilter(period);
        HistoricalData historicalData = new HistoricalData();
        assertThat(historicalData.getHistoricalDataFromGrid()).hasSameSizeAs(historicalData.getHistoricalDataFromCSV());
    }
}
