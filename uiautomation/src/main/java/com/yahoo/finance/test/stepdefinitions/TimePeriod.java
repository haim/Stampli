package com.yahoo.finance.test.stepdefinitions;

import com.yahoo.finance.test.stepdefinitions.helpers.Period;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TimePeriod {


    private Period period;
    private String StartDate;
    private String EndDate;

    @Step
    public void done() {
        $(By.xpath("//*[@id='Col1-1-HistoricalDataTable-Proxy']//button[1]/span[text()='Done']")).click();
    }

    @Step
    public void cancel() {
        $(By.xpath("//*[@id='Col1-1-HistoricalDataTable-Proxy']//span[text()='Cancel']")).click();
    }

    @Step
    public void open(){
        $(By.xpath("//*[@id='Col1-1-HistoricalDataTable-Proxy']//input")).click();
    }

    @Step
    public void setTimePeriodAndApplyFilter(Period period){
        open();
        $(By.xpath("//*[@id='Col1-1-HistoricalDataTable-Proxy']//span[text()='"+period.getPeriod()+"']")).click();
        done();
        applyFilter();

    }

    @Step
    public HistoricalData applyFilter(){
        $( By.xpath("//*[@id='Col1-1-HistoricalDataTable-Proxy']//span[text()='Apply']")).click();
        return page(HistoricalData.class);
    }

}
