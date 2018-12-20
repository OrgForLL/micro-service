package com.nextsgo.common.tools;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
}
