package com.example.demo.Controller;

import com.example.demo.dao.Weather;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WeatherController {
    //weather数据请求获取
    public static String getWeather(String url,String city) {
        //参数字符串，如果拼接在请求链接之后，需要对中文进行 URLEncode   字符集 UTF-8
        String param = "key=0a733454b9694f8fa9cbafc36031eb9a&location="+city;
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        BufferedReader br = null;
        PrintWriter out = null;
        try {
            //传入接口地址
            URL uri = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(10000);
            connection.setRequestProperty("accept", "*/*");
            //发送参数
            connection.setDoOutput(true);
            out = new PrintWriter(connection.getOutputStream());
            out.print(param);
            out.flush();
            //接收结果
            is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;

            //缓冲逐行读取
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }
            System.out.println("========================");

            System.out.println(sb.toString());
            return sb.toString();
        } catch (Exception ignored) {
        } finally {
            //关闭流
            try {
                if (is != null) {
                    is.close();
                }
                if (br != null) {
                    br.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception ignored) {
            }
        }
        return url;
    }
    //json数据解析
    public static List<Weather> JsonTest(String Jsondata,String city) throws JSONException {
        JSONObject jsonObject = new JSONObject(Jsondata);
        System.out.println(jsonObject);
        JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
        System.out.println(jsonArray);
        JSONObject jsonObject1 = jsonArray.getJSONObject(0) ;
        System.out.println(jsonObject1);
        JSONArray jsonArray1 = jsonObject1.getJSONArray("daily_forecast");
        System.out.println(jsonArray1);
        List<Weather> weatherList = new ArrayList<Weather>();
        for (int i = 0; i < jsonArray1.length(); i++) {
            JSONObject jsonObject2 = jsonArray1.getJSONObject(i);
            Weather weather = new Weather();
            weather.setCity(city);
            weather.setCond_txt(jsonObject2.getString("cond_txt_d"));
            weather.setDateTime(jsonObject2.getString("date"));
            weather.setHum(jsonObject2.getString("hum"));
            weather.setPres(jsonObject2.getString("pres"));
            weather.setSunStartTime(jsonObject2.getString("sr"));
            weather.setSunEndTime(jsonObject2.getString("ss"));
            weather.setTmp_max(jsonObject2.getString("tmp_max"));
            weather.setTmp_min(jsonObject2.getString("tmp_min"));
            weather.setWind_dir(jsonObject2.getString("wind_dir"));
            weather.setWind_sc(jsonObject2.getString("wind_spd"));
            weatherList.add(weather);

        }
        return weatherList;
    }

    //天气访问接口
    @RequestMapping(value = "/weather",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin

    public static List<Weather> WeatherInfo() throws JSONException {
        String city = "北京";
        String data = getWeather("https://free-api.heweather.net/s6/weather/",city);
        List<Weather> weatherList = JsonTest(data,city);
        return weatherList;
    }

}
