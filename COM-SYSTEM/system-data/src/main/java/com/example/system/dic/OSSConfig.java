package com.example.system.dic;

//@Component("ossConfig")
public class OSSConfig {/*
	
	*//**
	 * 设置OSSClient访问域名
	 *//*
	@Value("#{configProperties['oss.endpoint']}")
	private String endpoint;
	
	*//**
	 * 设置OSSClient账号ID
	 *//*
	@Value("#{configProperties['oss.accessKeyId']}")
	private String accessKeyId;
	
	*//**
	 * 设置OSSClient账号密钥
	 *//*
	@Value("#{configProperties['oss.accessKeySecret']}")
	private String accessKeySecret;
	
	*//**
	 * OSS 存储空间
	 *//*
	@Value("#{configProperties['oss.bucketName']}")
	private String bucketName;
	
	*//**
	 * 设置OSSClient允许打开的最大HTTP连接数，默认为1024个
	 *//*
	@Value("#{configProperties['oss.maxConnections']}")
	private Integer maxConnections;
	
	*//**
	 * 设置Socket层传输数据的超时时间，默认为50000毫秒
	 *//*
	@Value("#{configProperties['oss.socketTimeout']}")
	private Integer socketTimeout;
	
	*//**
	 * 设置建立连接的超时时间，默认为50000毫秒
	 *//*
	@Value("#{configProperties['oss.connectionTimeout']}")
	private Integer connectionTimeout;
	
	*//**
	 * 设置从连接池中获取连接的超时时间（单位：毫秒），默认不超时
	 *//*
	@Value("#{configProperties['oss.connectionRequestTimeout']}")
	private Integer connectionRequestTimeout;
	
	*//** 
	 * 设置连接空闲超时时间超时则关闭连接，默认为60000毫秒
	 *//*
	@Value("#{configProperties['oss.idleConnectionTime']}")
	private Integer idleConnectionTime;
	
	*//**
	 * 设置失败请求重试次数，默认为3次
	 *//*
	@Value("#{configProperties['oss.maxErrorRetry']}")
	private Integer maxErrorRetry;
	
	*//** 
	 * 设置是否支持将自定义域名作为Endpoint，默认支持
	 *//*
	@Value("#{configProperties['oss.supportCname']}")
	private Boolean supportCname;
	
	*//** 
	 * 设置是否开启二级域名的访问方式，默认不开启
	 *//*
	@Value("#{configProperties['oss.SLDEnabled']}")
	private Boolean SLDEnabled;
	
	*//** 
	 * 设置连接OSS所使用的协议（HTTP/HTTPS），默认为HTTP
	 *//*
	@Value("#{configProperties['oss.protocol']}")
	private Protocol protocol;

	public String getEndpoint() {
		return endpoint;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	
	*//**
	 * 初始化OSS客户端配置
	 * @return
	 *//*
	public ClientConfiguration getClientConf() {
		ClientConfiguration conf = new ClientConfiguration();
		if(this.maxConnections != null){
			conf.setMaxConnections(this.maxConnections);
		}
		if(this.socketTimeout != null){
			conf.setSocketTimeout(this.socketTimeout);
		}
		if(this.connectionTimeout != null){
			conf.setConnectionTimeout(this.connectionTimeout);
		}
		if(this.connectionRequestTimeout != null ){
			conf.setConnectionRequestTimeout(this.connectionRequestTimeout);
		}
		if(this.idleConnectionTime != null){
			conf.setIdleConnectionTime(this.idleConnectionTime);
		}
		if(this.maxErrorRetry != null){
			conf.setMaxErrorRetry(this.maxErrorRetry);
		}
		if(this.supportCname != null){
			conf.setSupportCname(this.supportCname);
		}
		if(this.SLDEnabled != null){
			conf.setSLDEnabled(this.SLDEnabled);
		}
		if(this.protocol != null){
			conf.setProtocol(this.protocol);
		}
		return conf;
	}
*/}
