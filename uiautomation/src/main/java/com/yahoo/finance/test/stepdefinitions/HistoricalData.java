package com.yahoo.finance.test.stepdefinitions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.yahoo.finance.test.data.HistoricalPricesData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import util.ReadCVSData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class HistoricalData {

    @Step
    public List<HistoricalPricesData> getHistoricalDataFromGrid() {

        List<HistoricalPricesData> pricesDataList = new ArrayList<>();
        SelenideElement table = $(By.xpath("//*[@id='Col1-1-HistoricalDataTable-Proxy']/section/div[2]/table/tbody"));
        ElementsCollection rows = table.$$(By.xpath("tr"));

        for (int row = 0; row < rows.size(); row++) {
            String date = rows.get(row).$$(By.xpath("td")).get(0).scrollTo().text();
            String open = rows.get(row).$$(By.xpath("td")).get(1).text();
            String high = rows.get(row).$$(By.xpath("td")).get(2).text();
            String low = rows.get(row).$$(By.xpath("td")).get(3).text();
            String close = rows.get(row).$$(By.xpath("td")).get(4).text();
            String adjClose = rows.get(row).$$(By.xpath("td")).get(5).text();
            String volume = rows.get(row).$$(By.xpath("td")).get(6).text();

            pricesDataList.add(
                    HistoricalPricesData.builder()
                            .date(date)
                            .open(open)
                            .high(high)
                            .low(low)
                            .close(close)
                            .adjClose(adjClose)
                            .volume(volume)
                            .build());
        }
        return pricesDataList;
    }

    @Step
    public List<HistoricalPricesData> getHistoricalDataFromCSV() throws Exception {
        File testFile = new File(downloadCsvFileData());

        List<HistoricalPricesData> pricesDataList =  ReadCVSData.readFile(testFile);
        return pricesDataList;
    }

    @Step
    public String downloadCsvFileData() throws IOException {
        File file = $(By.xpath("//*[@id='Col1-1-HistoricalDataTable-Proxy']//a")).scrollTo().download();
        return file.getCanonicalPath();
    }
}
