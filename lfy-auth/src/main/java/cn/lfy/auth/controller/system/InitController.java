package cn.lfy.auth.controller.system;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.lfy.auth.pojo.Role;
import cn.lfy.auth.service.RoleService;
import cn.lfy.common.utils.ConstantsUtils;

@Component
public class InitController {
	
	@Autowired
	private RoleService roleService;
	
	/*@Autowired
	private AppService appService;*/
	
	/*@Autowired
	private PayChannelService payChannelService;
	
	@Autowired
	private ChannelService channelService;*/
	
	@PostConstruct
	public void init(){
		
		/*
		 * 初始化用户角色缓存
		 */
		this.initRoleAction();
		
		/*
		 * 初始化应用列表缓存
		 */
		//this.initAppAction();
		
		/*
		 * 初始化支付渠道列表缓存
		 */
	//	this.initPayChannelAction();
		
		/*
		 * 初始化渠道列表缓存
		 */
		//this.initChannelAction();
	}
	
/*	private void initChannelAction(){
		List<Channel> channelList = this.channelService.findAll();
		for (Channel channel : channelList) {
			ConstantsUtils.CHANNEL_MAP.put(channel.getId(), channel.getName());
		}
	}
	
	private void initPayChannelAction(){
		List<PayChannel> payChannelList = this.payChannelService.findAll();
		for (PayChannel payChannel : payChannelList) {
			ConstantsUtils.PAY_CHANNEL_MAP.put(payChannel.getId(), payChannel.getName());
		}
	}*/
/*	
	private void initAppAction(){
		List<App> appList = this.appService.findAll();
		for (App app : appList) {
			ConstantsUtils.APP_MAP.put(app.getId(), app.getName());
		}
	}*/
	
	private void initRoleAction() {
		List<Role> roleList = this.roleService.findAll();
		for (Role role : roleList) {
			ConstantsUtils.ROLE_MAP.put(role.getId(), role.getName());
		}
	}

}
