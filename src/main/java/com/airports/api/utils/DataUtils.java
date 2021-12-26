package com.airports.api.utils;


import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DataUtils {

    public static List<Map<String, String>> getCsvData(String csvFileName) throws IOException {
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        File csvFile = new ClassPathResource(csvFileName).getFile();
        MappingIterator<Map<String, String>> readValues = csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvFile);
        return readValues.readAll();
    }

    public static long getLongValue(Map<String, String> map, String key) {
        return Long.parseLong(map.get(key));
    }

    public static String getStringValue(Map<String, String> map, String key) {
        return map.get(key);
    }

}
