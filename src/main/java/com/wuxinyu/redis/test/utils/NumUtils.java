package com.wuxinyu.redis.test.utils;

import com.wuxinyu.common.utils.RandomUtil;
import com.wuxinyu.common.utils.StringUtil;

/**
 * 
 * @ClassName: NumUtils 
 * @Description: 随机工具类
 * @author:武鑫宇 
 * @date: 2019年8月12日 上午9:02:22
 */
public class NumUtils {
	
	/**
	 * 
	 * @Title: num 
	 * @Description: 9位随机数
	 * @return
	 * @return: String
	 */
	public static String num() {
		String str = "";
		for (int i = 0; i < 9; i++) {
			int j = RandomUtil.random(0, 9);
			str += j;
		}
		return str;
	}
	
	/**
	 * 
	 * @Title: sex 
	 * @Description: 随机产生性别男 女
	 * @return
	 * @return: String
	 */
	public static String sex() {
		String[] sexs = {"男","女"};
		int i = RandomUtil.random(0, 1);
		return sexs[i];
		
	}
	
	/**
	 * 
	 * @Title: email 
	 * @Description: 随机产生邮箱 以3-20个随机字母+@qq.com、@163.com、@sian.com、@gmail.com、@sohu.com、@hotmail.com模拟
	 * @return
	 * @return: String
	 */
	public static String email() {
		String[] emails = {"@qq.com","@163.com","@sian.com","@gmail.com","@sohu.com","@hotmail.com"};
		int i = RandomUtil.random(0, emails.length-1);
		String email = "";
		int j = RandomUtil.random(3, 20);
		email += RandomUtil.randomString(j)+emails[i];
		return email;
		
	}

}
