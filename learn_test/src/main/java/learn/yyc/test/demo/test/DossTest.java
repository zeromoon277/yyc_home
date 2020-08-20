package learn.yyc.test.demo.test;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/8/3 0003 下午 17:20
 */
public class DossTest {
    public String index(){

        String jsonStr = "";

        try
        {
            FileReader fr = new FileReader("D://t.log");//需要读取的文件路径
            BufferedReader br = new BufferedReader(fr);
            jsonStr = br.readLine();
            br.close();
            fr.close();		//关闭文件流
        }catch(IOException e)
        {
            System.out.println("指定文件不存在");//处理异常
        }

        Map<String, Object> map = new HashMap<String, Object>();

        map = JSONObject.parseObject(jsonStr);
        return "Hash Collision ~";
    }

    public static void main(String[] args) {
        DossTest dossTest = new DossTest();
        dossTest.index();
        System.out.println(123);
        System.out.println(123);
    }

}
