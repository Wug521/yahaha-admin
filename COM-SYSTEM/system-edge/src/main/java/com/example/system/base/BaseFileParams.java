package com.example.system.base;

import org.springframework.beans.factory.annotation.Value;

public class BaseFileParams {
	//存放系统下的路径
	@Value("#{configProperties['sys.file.preAppName']}")
	protected String preAppName;
	@Value("#{configProperties['sys.file.preWebAccessName']}")
	protected String preWebAccessName;
	//访问url路径前缀
	@Value("#{configProperties['sys.file.preUrlPath']}")
	protected String preUrlPath;
	@Value("#{configProperties['sys.file.ftp.ip']}")
	protected String ftpIp;
	@Value("#{configProperties['sys.file.ftp.port']}")
	protected Integer ftpPort;
	@Value("#{configProperties['sys.file.ftp.userName']}")
	protected String ftpUserName;
	@Value("#{configProperties['sys.file.ftp.password']}")
	protected String ftpPassword;
}
