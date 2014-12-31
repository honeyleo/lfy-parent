package cn.lfy.auth.controller.system;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.lfy.auth.pojo.Role;
import cn.lfy.auth.service.RoleService;
import cn.lfy.common.utils.ConstantsUtils;


@Component
public class InitComponent {
	
	@Autowired
	private RoleService roleService;
	
/*	@Autowired
	private AppService appService;*/
	
/*	@Autowired
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
		//this.initPayChannelAction();
		
		/*
		 * 初始化渠道列表缓存
		 */
		//this.initChannelAction();
	}
	
/*	public void initChannelAction(){
		List<Channel> channelList = this.channelService.findAll();
		ConstantsUtils.CHANNEL_MAP.clear();
		for (Channel channel : channelList) {
			ConstantsUtils.CHANNEL_MAP.put(channel.getId(), channel.getName());
		}
	}
	
	public void initPayChannelAction(){
		List<PayChannel> payChannelList = this.payChannelService.getPayChannel();
		ConstantsUtils.PAY_CHANNEL_MAP.clear();
		for (PayChannel payChannel : payChannelList) {
			ConstantsUtils.PAY_CHANNEL_MAP.put(payChannel.getId(), payChannel.getName());
		}
	}*/
	
/*	public void initAppAction(){
		List<App> appList = this.appService.findAll();
		ConstantsUtils.APP_MAP.clear();
		for (App app : appList) {
			ConstantsUtils.APP_MAP.put(app.getId(), app.getName());
		}
	}*/
	
	public void initRoleAction() {
		List<Role> roleList = this.roleService.findAll();
		ConstantsUtils.ROLE_MAP.clear();
		for (Role role : roleList) {
			ConstantsUtils.ROLE_MAP.put(role.getId(), role.getName());
		}
	}

}
