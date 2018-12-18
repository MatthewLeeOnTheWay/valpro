package com.security.valpro.base;



import com.security.valpro.BaseTest;
import com.security.valpro.ValproApplication;
import com.security.valpro.dao.UserDao;
import com.security.valpro.entity.SysUser;
import com.security.valpro.service.CacheManager;
import com.security.valpro.utils.ContentEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


/*@ContextConfiguration(locations={"classpath:application.yml"})//加载配置文件*/
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//@Transactional
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//------------
public class ValproApplicationTests extends BaseTest{
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private CacheListener cacheListener;
	@Autowired
	private ApplicationContext applicationContext;
	private Logger logger=Logger.getLogger(ValproApplication.class.getName());

	@Autowired
	private UserDao userDao;

	@Test
	public void testUserDao(){
		String username="maJohn";
		SysUser user=userDao.findByUsername(username);
		System.out.println(user.getMobile());
	}
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
