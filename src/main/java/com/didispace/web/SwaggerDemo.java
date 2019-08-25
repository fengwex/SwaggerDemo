package com.didispace.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author fw
 *
 */
@RestController
public class SwaggerDemo {
    @ApiOperation(value="测试API",notes = "get请求demo")
    @ResponseBody
	@RequestMapping(value="/getDemo",method = RequestMethod.GET)
	public String getDemo(@RequestParam("name") String name,@RequestParam("")int age) {
		return "name:"+name+",age:"+age;
	}
    @ApiOperation(value="测试API",notes = "post请求demo")
    @ResponseBody
	@RequestMapping(value="/postDemo",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public String postDemo(@RequestBody JSONObject jsonParam) {
        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "json");
        result.put("data", jsonParam);
        return result.toJSONString();
	}
}
