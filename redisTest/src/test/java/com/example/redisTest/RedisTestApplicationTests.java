package com.example.redisTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisTestApplicationTests {

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {

	}


	@Test
	public void testStringSetAndGet(){

		stringRedisTemplate.opsForValue().set("db","Redis",60, TimeUnit.SECONDS);
		String v = stringRedisTemplate.opsForValue().get("db");
		Assert.assertTrue("Redis".equals(v));
	}


	//测试字符串形式缓存的设置和获取，对缓存过期的情况进行测试
	@Test
	public void testStringSetAndGetStringForTimeout() throws Exception{
		stringRedisTemplate.opsForValue().set("cache","mysql",10, TimeUnit.SECONDS);
		//延时10秒，使缓存过期
		TimeUnit.SECONDS.sleep(11);
		String v = stringRedisTemplate.opsForValue().get("cache");
		Assert.assertTrue(v == null);
	}

	// 测试字符串形式缓存的设置和删除
	@Test
	public void testStringSetAndDeleteCache(){

		stringRedisTemplate.opsForValue().set("cache","mysql",10, TimeUnit.SECONDS);
		String v = stringRedisTemplate.opsForValue().get("cache");
		Assert.assertTrue("mysql".equals(v));

		//删除缓存
		stringRedisTemplate.delete("cache");
		v = stringRedisTemplate.opsForValue().get("cache");
		Assert.assertTrue(v == null);
	}


	// 测试set

	@Test
	public void  testSet(){
		stringRedisTemplate.opsForSet().add("a","huazai","b");

		Set<String> members= stringRedisTemplate.opsForSet().members("a");

		System.out.println(members);

		stringRedisTemplate.opsForSet().remove("a","b");
		members = stringRedisTemplate.opsForSet().members("a");

		System.out.println(members);

	}

	//测试List
	@Test
	public void testList(){

		stringRedisTemplate.opsForList().rightPush("test","1");
		stringRedisTemplate.opsForList().rightPush("test","2");

		List<String> list = stringRedisTemplate.opsForList().range("test",0,-1);
		System.out.println("list" +list);

		stringRedisTemplate.opsForList().rightPop("test");
		list = stringRedisTemplate.opsForList().range("test",0,-1);

		System.out.println(list);

	}


}
