/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.util;

import com.ninehcom.common.enums.ErrorCode;
import com.ninehcom.common.util.HttpUtils;
import com.ninehcom.common.util.HttpsUtil;
import com.ninehcom.common.util.Result;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class WeatherAgent {

    public Result GetWeather() {
        String host = "http://ali-weather.showapi.com";
        String path = "/hour24";
        String method = "GET";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "APPCODE aa306f67158b4c7e89fb4a0f8cfdaa36");
        Map<String, String> querys = new HashMap<>();
        querys.put("area", "北京");
        querys.put("areaid", "101010100");

        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            return Result.Result(ErrorCode.Success, EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            return Result.Fail(ErrorCode.WeatherServiceFail);
        }
    }

    public Result GetAirQuality() {
        String host = "http://ali-weather.showapi.com";
        String path = "/area-to-weather";
        String method = "GET";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "APPCODE aa306f67158b4c7e89fb4a0f8cfdaa36");

        Map<String, String> querys = new HashMap<>();
        querys.put("area", "北京");
        querys.put("areaid", "101010100");
        querys.put("need3HourForcast", "1");
        querys.put("needAlarm", "1");
        querys.put("needHourData", "1");
        querys.put("needIndex", "1");
        querys.put("needMoreDay", "1");

        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            return Result.Result(ErrorCode.Success, EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            return Result.Fail(ErrorCode.AirQuanlityServiceFail);
        }
    }
}
