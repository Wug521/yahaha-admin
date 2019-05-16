package com.example.system.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;

/**
 * OSSClient 工具类
 * @author Mr.Wug
 *
 */
public class OSSUtils {
	
	private static Logger logger = LoggerFactory.getLogger(OSSUtils.class);
	
	/**
	 * 创建OSSClient实例
	 * @return
	 */
	private static synchronized OSSClient getInstance(String endpoint, String accessKeyId,
			String accessKeySecret, ClientConfiguration conf) {
		return new OSSClient(endpoint, accessKeyId, accessKeySecret, conf); 
	}
	
	/**
	 * 上传Byte数组到OSS
	 * @param bucketName       		存储空间
	 * @param objectName	                           存储对象名称
	 * @param endpoint         	             访问域名
	 * @param accessKeyId			账号KEY
	 * @param accessKeySecret		账号密钥
	 * @param conf					客户端配置
	 * @param bytes					baty数组
	 */
	public static void uploadFile(String bucketName, String objectName, String endpoint, String accessKeyId,
			String accessKeySecret, ClientConfiguration conf,ByteArrayInputStream bytes){
		OSSClient ossClient = null;
		try {
			ossClient  = getInstance(endpoint, accessKeyId, accessKeySecret, conf);
			PutObjectResult result = ossClient.putObject(bucketName, objectName, bytes);
			logger.info("oss上传返回值[{}]:\n",result);
		} catch (Exception e) {
			logger.error("oss上传文件[{}]失败", e);
			throw e;
		} finally {
			closeOSSClient(ossClient);
		}
	}
	
	/**
	 * 上传文件流到OSS
	 * @param bucketName       		存储空间
	 * @param objectName	                           存储对象名称
	 * @param endpoint         	             访问域名
	 * @param accessKeyId			账号KEY
	 * @param accessKeySecret		账号密钥
	 * @param conf					客户端配置
	 * @param inputStream			上传文件流
	 */
	public static void uploadFile(String bucketName, String objectName, String endpoint, String accessKeyId,
			String accessKeySecret, ClientConfiguration conf, InputStream inputStream){
		OSSClient ossClient = null;
		try {
			ossClient  = getInstance(endpoint, accessKeyId, accessKeySecret, conf);
			PutObjectResult result = ossClient.putObject(bucketName, objectName, inputStream);
			logger.info("oss上传返回值[{}]:\n",result);
		} catch (Exception e) {
			logger.error("oss上传文件[{}]失败", e);
			throw e;
		} finally {
			closeOSSClient(ossClient);
		}
	}
	
	/**
	 * OSS文件下载
	 * @param bucketName       		存储空间
	 * @param objectName	                           存储对象名称
	 * @param endpoint         	             访问域名
	 * @param accessKeyId			账号KEY
	 * @param accessKeySecret		账号密钥
	 * @param conf					客户端配置
	 */
	public static void downloadFile(String bucketName, String objectName, String endpoint, String accessKeyId,
			String accessKeySecret, ClientConfiguration conf){
		OSSClient ossClient = null;
		try {
			ossClient  = getInstance(endpoint, accessKeyId, accessKeySecret, conf);
			OSSObject ossObject = ossClient.getObject(bucketName, objectName);
			logger.info("oss上传返回值[{}]:\n",ossObject);
			BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
			while (true) {
				String line = reader.readLine();
			    if (line == null) break;
			    System.out.println("\n" + line);
			    // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
				reader.close();
			}
		} catch (IOException e) {
			logger.error("oss下载文件[{}]失败", e);
		} finally {
			closeOSSClient(ossClient);
		} 
	}
	
	/**
	 * 关闭OSSClient
	 * @param ossClient
	 */
	private static void closeOSSClient(OSSClient ossClient){
		if (ossClient != null){
			ossClient.shutdown();
			ossClient = null;
		}
	}
}
