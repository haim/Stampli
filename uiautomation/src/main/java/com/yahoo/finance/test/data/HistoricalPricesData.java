package com.yahoo.finance.test.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.Objects;

@JsonPropertyOrder({"Date", "Open", "High", "Low", "Close", "Adj Close", "Volume"})
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonDeserialize(builder = HistoricalPricesData.HistoricalPricesDataBuilder.class)
@Builder(builderClassName = "HistoricalPricesDataBuilder", toBuilder = true)
@Value
@Data
@AllArgsConstructor

public class HistoricalPricesData {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("Open")
    private String open;
    @JsonProperty("High")
    private String high;
    @JsonProperty("Low")
    private String low;
    @JsonProperty("Close")
    private String close;
    @JsonProperty("Adj Close")
    private String adjClose;
    @JsonProperty("Volume")
    private String volume;

    @JsonPOJOBuilder(withPrefix = "")
    public static class HistoricalPricesDataBuilder {
        @JsonProperty("Date")
        String date;
        @JsonProperty("Open")
        String open;
        @JsonProperty("High")
        String high;
        @JsonProperty("Low")
        String low;
        @JsonProperty("Close")
        String close;
        @JsonProperty("Adj Close")
        String adjClose;
        @JsonProperty("Volume")
        String volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricalPricesData that = (HistoricalPricesData) o;
        return date.equals(that.date) &&
                open.equals(that.open) &&
                high.equals(that.high) &&
                low.equals(that.low) &&
                close.equals(that.close) &&
                adjClose.equals(that.adjClose) &&
                volume.equals(that.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, open, high, low, close, adjClose, volume);
    }
}
