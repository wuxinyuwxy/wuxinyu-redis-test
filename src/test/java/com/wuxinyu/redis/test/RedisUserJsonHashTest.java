package com.wuxinyu.redis.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuxinyu.common.utils.RandomUtil;
import com.wuxinyu.common.utils.StringUtil;
import com.wuxinyu.redis.test.domain.User;
import com.wuxinyu.redis.test.utils.NumUtils;


/**
 * 
 * @ClassName: RedisUserJdkTest 
 * @Description: 测试类  使用Json系列化方式保存十万个user随机对象到Redis  使用方式为hash
 * @author:武鑫宇 
 * @date: 2019年8月12日 上午8:53:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans2.xml")
public class RedisUserJsonHashTest {

	//获取RedisTemplate
	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;
	
	@Test
	public void test() {
		//创建一个map集合
		Map<String,User> map = new HashMap<String,User>();
		
		//使用1-10万序号。（2分）
		for (int i = 1; i <= 100000; i++) {
			map.put("u_"+i,new User(i, StringUtil.randomChineseString(3), NumUtils.sex(), "13"+NumUtils.num(), NumUtils.email(), RandomUtil.random(18, 70)));
			//System.out.println(user);
		}
		
		//开始时间
		long startTimes = System.currentTimeMillis();
		
		//(3)使用RedisTemplate保存上述模拟的十万个user对象到Redis。（4分）
		redisTemplate.opsForHash().putAll("user_keys", map);
		
		//结束时间
		long endTimes = System.currentTimeMillis();
		
		//获取保存的数量
		System.out.println("保存的数量为:"+map.size());
		System.out.println("系列化方式是:key系列化器StringRedisSerializer。value系列化器为Jackson2JsonRedisSerializer");
		System.out.println("所耗时间:"+(endTimes-startTimes));
		
		
	}
}
