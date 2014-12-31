package cn.lfy.auth.controller.manage;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;

@Controller
@RequestMapping("/test")
public class Test {

	@RequestMapping("/test2")
	@ResponseBody
	public Object test1() {
		Map<String, Object> map = Maps.newHashMap();
		map.put("name", "liaopeng");
		return map;
	}
}
