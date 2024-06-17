package org.adaschool.Weather.controller;

import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = { WeatherReportController.class })
class WeatherReportControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WeatherReportService weatherReportService;
    @Test
    public void testGetWeatherReport() throws Exception {
        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setHumidity(40);
        weatherReport.setTemperature(30);

        given(weatherReportService.getWeatherReport(any(Double.class),any(Double.class)))
                .willReturn(weatherReport);

        mockMvc.perform(get("/v1/api/weather-report?latitude=37.8267&longitude=-122.4233"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.humidity").value(40))
                .andExpect(jsonPath("$.temperature").value(30));
    }
}