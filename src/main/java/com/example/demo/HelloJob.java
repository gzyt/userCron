package com.example.demo;

//import com.example.demo.mapper.user_infoMapper;
import org.json.JSONException;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class HelloJob implements BaseJob{
    private static Logger log = LoggerFactory.getLogger(HelloJob.class);
//    @Autowired
//    private user_infoMapper user_infoMapper;

    /**
     * 调用对方接口方法
     *
     * @param path 对方或第三方提供的路径
     * @return
     */
    public static String interfaceUtil(String path) {
        try {
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;
            //请求方式
            conn.setRequestMethod("POST");
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();

            System.out.println("查询结束");
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
    //json数据解析
    public  void JsonAnalysis(String Jsondata) throws JSONException {
//        JSONObject jsonObjects = new JSONObject(Jsondata);
//        System.out.println(jsonObjects.getString("username"));
//        user_info user_info = new user_info();
//        user_info.setUsername(jsonObjects.getString("username"));
//        user_info.setUsercode(jsonObjects.getString("usercode"));
//        user_info.setApartment(jsonObjects.getString("department"));
//        user_info.setStation(jsonObjects.getString("station"));
//        user_infoMapper.insert(user_info);

//        user_info user_info = new user_info();
//        user_info.setUsername("admin");
//        user_info.setUsercode("111");
//        user_info.setDepartment("研发部");
//        user_info.setStationCode("开发");
//        System.out.println("=============================");
//        user_infoMapper.insert(user_info);
//        System.out.println(user_infoMapper.selectByUsercode(str));
//        if(user_infoMapper.selectByUsercode(jsonObjects.getString("usercode"))==null){
//                user_infoMapper.insert(user_info);
//            }
//        JSONArray jsonArray = new JSONArray(Jsondata);
//        user_info user_info = new user_info();
//        List<user_info> user_infoList = new ArrayList<user_info>();
//        for (int i = 0; i <jsonArray.length() ; i++) {
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            System.out.println(jsonObject);
//            user_info.setUsername(jsonObject.getString("username"));
//            user_info.setUsercode(jsonObject.getString("usercode"));
//            user_info.setApartment(jsonObject.getString("department"));
//            user_info.setStation(jsonObject.getString("station"));
//            user_infoList.add(user_info);
//            if(user_infoMapper.selectByUsercode(jsonObject.getString("usercode")).equals(" ")){
//                user_infoMapper.insert(user_info);
//            }
//            else{
//                System.out.println("数据已存在");
//                return ;
//            }
//        }
//        System.out.println(user_infoList);
    }
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String data = usercronController.interfaceUtil("http://192.168.51.159:80/userInfos");
        try {
            JsonAnalysis(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        log.info("Hello Job执行时间: " + new Date());
    }
}


