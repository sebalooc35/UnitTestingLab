package org.adaschool.Weather.service;

import org.adaschool.Weather.data.WeatherReport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherReportServiceTest {
    @Autowired
    private WeatherReportService weatherReportService;

    @Test
    void getWeatherReport() {
        WeatherReport report = weatherReportService.getWeatherReport(100,100);
        assertNotNull(report);
    }
}