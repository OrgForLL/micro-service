package com.nextsgo.common.tools;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.nextsgo.common.entity.Result;




public class HttpRequest {

	/**
	 * 传json数据至指定url并返回为JSONObject对象
	 * 
	 * @param action
	 *            url
	 * @param json
	 *            传入的json数据
	 * @return
	 */
	public static Result<?> post(String action, String json) {
		URL url;
		// JSONObject jo = null;
		try {
			String encoding = "UTF-8";
			url = new URL(action);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type", "application/json; charset=" + encoding);
			http.setDoOutput(true);
			http.setDoInput(true);
			http.setUseCaches(false);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			http.connect();
			OutputStream os = http.getOutputStream();
			os.write(json.getBytes("UTF-8"));// 传入参数
			os.flush();
			os.close();
			// 从连接中读取响应信息
			String jsonObj = "";
			int code = http.getResponseCode();
			if (code == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					jsonObj += line + "\n";
				}
				reader.close();
			}
			// 5. 断开连接
			http.disconnect();
			return ResultUtil.success(jsonObj);			
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(100, e.getMessage());
		}
	}

	public static Result<?> post(String action, String prtCnt, Map<String,String> propertyMap,String encoding) {
		URL url;
		try {
			url = new URL(action);		
			// 打开和URL之间的连接
			HttpURLConnection http = (HttpURLConnection) url.openConnection();		
			for(String key:propertyMap.keySet()) {
				http.addRequestProperty(key, propertyMap.get(key));
			}
			// 发送POST请求必须设置如下两行
			http.setDoOutput(true);
			http.setDoInput(true);
			if(null != prtCnt && !prtCnt.equals("")) {
				 PrintWriter out = new PrintWriter(new OutputStreamWriter(http.getOutputStream(),encoding));//发送乱码20230409
				// 发送请求参数
				out.print(prtCnt);
				// flush输出流的缓冲
				out.flush();
				out.close();
			}
			// 从连接中读取响应信息
			String jsonObj = "";
			int code = http.getResponseCode();
			if (code == 200) {
				// 定义BufferedReader输入流来读取URL的响应
				BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream(),encoding));
				String line;
				while ((line = reader.readLine()) != null) {
					jsonObj += line + "\n";
				}
				reader.close();
			}
			return ResultUtil.success(jsonObj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(100, e.getMessage());
		}
	}
}
