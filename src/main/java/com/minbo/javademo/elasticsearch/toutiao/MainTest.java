package com.minbo.javademo.elasticsearch.toutiao;

import org.apache.log4j.Logger;

/**
 * 程序入口
 * 
 * @author Minbo
 */
public class MainTest {
	
	protected static final Logger logger = Logger.getLogger(MainTest.class);

	// 循环次数
	public static int LOOP_COUNT = 1;
	// 并发请求数
	public static int CONCURRENCY_REQ_COUNT = 10;
	// 处理线程数
	public static int THREAD_COUNT = 5;

	public static void main(String[] args) {
		logger.info("======================");
		logger.info("======================");
		logger.info("开始跑批...");
		logger.info("======================");
		logger.info("======================");
		// 获取开始时间
		long start = System.currentTimeMillis();
		logger.info("跑前半部分标签...");
		for (int i = 0; i < Tags.tagList.length/2; i++) {
			ThreadBatch mainClass = new ThreadBatch(Tags.tagList[i].toString());
			mainClass.start();
		}
		
		try {
			logger.info("休息十五秒");
			Thread.sleep(15 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("跑后半部分标签...");
		for (int i = Tags.tagList.length/2; i < Tags.tagList.length; i++) {
			ThreadBatch mainClass = new ThreadBatch(Tags.tagList[i].toString());
			mainClass.start();
		}
		// 获取结束时间
		long end = System.currentTimeMillis();
		logger.info("======================");
		logger.info("======================");
		logger.info("程序总运行时间： " + (end - start) + " ms");
		logger.info("======================");
		logger.info("======================");
		
	}
}