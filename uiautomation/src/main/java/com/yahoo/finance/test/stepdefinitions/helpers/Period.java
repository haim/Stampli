package com.yahoo.finance.test.stepdefinitions.helpers;

public enum  Period {

    ONE_DAY("1D"),
    FIVE_DAY("5D"),
    TREE_MONTH("3M"),
    SIX_MONTH("6M"),
    YTD("YTD"),
    ONE_Y("1Y"),
    FIVE_Y("5Y"),
    MAX_PERIOD("MAX");

    public final String period;

    Period(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }
}
