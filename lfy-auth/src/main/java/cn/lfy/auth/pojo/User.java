package cn.lfy.auth.pojo;

import java.io.Serializable;

import org.apache.commons.lang3.RandomStringUtils;

import cn.lfy.auth.pojo.object.AbstractDO;
import cn.lfy.common.utils.MD5Util;

public class User extends AbstractDO{

	private static final long serialVersionUID = 4179708942537838503L;

	protected String userName;
	
	protected String passwd;
	
	protected String salt;
	
	public User(){}
	
	/**
	 * 密码加密算法
	 */
	public String encrypt(String _passwd){
		String passwdMd5 = MD5Util.getMD5Str(_passwd);
		return MD5Util.getMD5Str(passwdMd5 + this.salt);
	}
	
	/**
	 * 比对密码是否一致
	 */
	public boolean compare(String _passwd){
		String passwdMd5 = MD5Util.getMD5Str(_passwd);
		return MD5Util.getMD5Str(passwdMd5 + this.salt).equals(this.passwd);
	}

	/**
	 * 设置盐值,和密码加密
	 */
	public void buildPasswd(){
		/**
		 * 生成盐值
		 */
		this.salt = RandomStringUtils.randomAlphabetic(6);
		
		/**
		 * 密码加密
		 */
		this.passwd = encrypt(this.passwd);
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setPasswd("123456");
		user.buildPasswd();
		System.out.println("salt=="+user.getSalt());
		System.out.println("password=="+user.getPasswd());
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public Serializable getId() {
		return null;
	}
}
