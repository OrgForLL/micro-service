package com.nextsgo.papy.service.impl;

 

import java.util.Calendar;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nextsgo.common.entity.Result;
import com.nextsgo.common.tools.HttpRequest;
import com.nextsgo.common.tools.ResultUtil;
import com.nextsgo.papy.dto.PapyData;
import com.nextsgo.papy.service.PapyService;


@Service
public class PapyServiceImpl implements PapyService{
	
	// @Autowired
	// private UserRepository userRepository;
	// @Autowired
	// private JwtProperties jwtProperties;

	public Result<?> time(String name)  {
		String action="http://webt.lilang.com:8900/svr-personmanager/HKPersonalInfoManagerController/hikRedirectInter";	
		PapyData papyData=new PapyData();
		papyData.setPageNo(1);
		papyData.setPageSize(20);
		papyData.setPersonName(name);
		Map<String, String> propertyMap = new HashMap<String, String>();		
		 propertyMap.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		// Date sd= new java.util.Date();//simpledataformat
		// SimpleDateFormat sdf= new SimpleDateFormat("yyy-MM-dd HH:mm:ss Z");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,-1);		
		papyData.setStartTime(cal.getTime());
		papyData.setEndTime(new java.util.Date());
		// propertyMap.put("data", JSON.toJSONString(papyData));
		// propertyMap.put("interName", "/api/acs/v1/door/events");
		String prtCnt = String.format("data=%s&interName=%s", JSON.toJSONString(papyData), "/api/acs/v1/door/events");
		Result<?> tmp = HttpRequest.post(action, prtCnt,propertyMap,"utf-8");
		if(tmp.getErrcode()==0){
		 	Result ret=	JSON.parseObject(tmp.getData().toString(), Result.class);
			if(ret.getErrcode()==0){
				JSONObject json=	JSON.parseObject(ret.getData().toString());
				JSONArray list= json.getJSONObject("data").getJSONArray("list");
				JSONArray returList= new JSONArray();
				for(int i=0;i<list.size();i++){
					JSONObject jo = new JSONObject();
					jo.put("doorName", list.getJSONObject(i).getString("doorName"));
					jo.put("eventTime", list.getJSONObject(i).getString("eventTime"));
					returList.add(jo);
				}
				return ResultUtil.success(returList);
			}
		}
		return tmp;
	}
 
}
