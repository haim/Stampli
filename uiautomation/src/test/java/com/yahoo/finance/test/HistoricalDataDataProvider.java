package com.yahoo.finance.test;

import com.yahoo.finance.test.stepdefinitions.helpers.Period;
import org.testng.annotations.DataProvider;

public class HistoricalDataDataProvider {

    @DataProvider(name = "test_that_csv_contains_same_size_of_records_like_in_historical_data_grid")
    public static Object[] test_that_csv_contains_same_size_of_records_like_in_historical_data_grid() {
        return Period.values();
    }
}
