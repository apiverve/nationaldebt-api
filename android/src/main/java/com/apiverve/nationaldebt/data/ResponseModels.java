// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     NationalDebtData data = Converter.fromJsonString(jsonString);

package com.apiverve.nationaldebt.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static NationalDebtData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(NationalDebtData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(NationalDebtData.class);
        writer = mapper.writerFor(NationalDebtData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// NationalDebtData.java

package com.apiverve.nationaldebt.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class NationalDebtData {
    private LocalDate date;
    private double totalDebt;
    private String totalDebtFormatted;
    private double publicDebt;
    private String publicDebtFormatted;
    private double intragovernmentalDebt;
    private String intragovernmentalDebtFormatted;
    private long perCapita;
    private String perCapitaFormatted;
    private long population;

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("totalDebt")
    public double getTotalDebt() { return totalDebt; }
    @JsonProperty("totalDebt")
    public void setTotalDebt(double value) { this.totalDebt = value; }

    @JsonProperty("totalDebtFormatted")
    public String getTotalDebtFormatted() { return totalDebtFormatted; }
    @JsonProperty("totalDebtFormatted")
    public void setTotalDebtFormatted(String value) { this.totalDebtFormatted = value; }

    @JsonProperty("publicDebt")
    public double getPublicDebt() { return publicDebt; }
    @JsonProperty("publicDebt")
    public void setPublicDebt(double value) { this.publicDebt = value; }

    @JsonProperty("publicDebtFormatted")
    public String getPublicDebtFormatted() { return publicDebtFormatted; }
    @JsonProperty("publicDebtFormatted")
    public void setPublicDebtFormatted(String value) { this.publicDebtFormatted = value; }

    @JsonProperty("intragovernmentalDebt")
    public double getIntragovernmentalDebt() { return intragovernmentalDebt; }
    @JsonProperty("intragovernmentalDebt")
    public void setIntragovernmentalDebt(double value) { this.intragovernmentalDebt = value; }

    @JsonProperty("intragovernmentalDebtFormatted")
    public String getIntragovernmentalDebtFormatted() { return intragovernmentalDebtFormatted; }
    @JsonProperty("intragovernmentalDebtFormatted")
    public void setIntragovernmentalDebtFormatted(String value) { this.intragovernmentalDebtFormatted = value; }

    @JsonProperty("perCapita")
    public long getPerCapita() { return perCapita; }
    @JsonProperty("perCapita")
    public void setPerCapita(long value) { this.perCapita = value; }

    @JsonProperty("perCapitaFormatted")
    public String getPerCapitaFormatted() { return perCapitaFormatted; }
    @JsonProperty("perCapitaFormatted")
    public void setPerCapitaFormatted(String value) { this.perCapitaFormatted = value; }

    @JsonProperty("population")
    public long getPopulation() { return population; }
    @JsonProperty("population")
    public void setPopulation(long value) { this.population = value; }
}