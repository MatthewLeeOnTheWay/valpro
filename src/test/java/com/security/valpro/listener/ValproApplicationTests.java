package com.security.valpro.listener;



import com.security.valpro.ValproApplication;
import com.security.valpro.listener.CacheListener;
import com.security.valpro.service.CacheManager;
import com.security.valpro.utils.ContentEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ValproApplicationTests {
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private CacheListener cacheListener;
	@Autowired
	private ApplicationContext applicationContext;
	private Logger logger=Logger.getLogger(ValproApplication.class.getName());
	@Test
	public void contextLoads() {
	}

	@Test
	public void testCacheManager(){
		cacheManager.putCache("test","9486",10);
		cacheManager.putCache("myTest","5385",10);

		cacheListener.startListen();
		logger.info("test:"+cacheManager.getCacheByKey("test").getDatas());
		logger.info("myTest:"+cacheManager.getCacheByKey("myTest").getDatas());

		try{
			TimeUnit.SECONDS.sleep(20);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testThredSafe(){
		final String key="thread";
		final CacheManager cacheManager=new CacheManager();
		ExecutorService exec= Executors.newCachedThreadPool();

		for(int i=0;i<100;i++){
			exec.execute(new Runnable() {
				@Override
				public void run() {
					if (!cacheManager.isContains(key)){
						cacheManager.putCache(key,1,0);
					}else{
						synchronized (cacheManager){
							int value=(Integer)cacheManager.getCacheDataByKey(key)+1;
							cacheManager.putCache(key,value,0);
						}
					}
				}
			});
		}
		exec.shutdown();
		try{
			exec.awaitTermination(1,TimeUnit.DAYS);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		logger.info(cacheManager.getCacheDataByKey(key).toString());
	}

	@Test
	public void testPublishEvent(){
		applicationContext.publishEvent(new ContentEvent("news is update"));
	}

//	@Test
//	@Transactional
//	@Rollback(false)
//	public void test() {
//		System.out.print("测试工作正在展开");
//		SysUser sysUser = new SysUser();
//		List<SysRole> sysRoles = new ArrayList<SysRole>();
//		sysUser.setPassword("123456");
//		sysUser.setRoles(sysRoles);
//		sysUser.setUsername("matthew");
//	}
}
