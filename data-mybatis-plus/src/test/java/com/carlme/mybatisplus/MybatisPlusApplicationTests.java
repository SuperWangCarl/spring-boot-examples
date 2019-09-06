package com.carlme.mybatisplus;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.carlme.mybatisplus.persistence.po.CommonNotice;
import com.carlme.mybatisplus.service.CommonNoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

	@Autowired
	DataSourceProperties dataSourceProperties;
	@Autowired
	CommonNoticeService commonNoticeService;

	//查询测试
	@Test
	public void contextLoads() {
		List<CommonNotice> commonNotices = commonNoticeService.selectList(new EntityWrapper<>());
		System.out.println(commonNotices);
	}

	/**
	 * 代码生成    示例代码
	 */
	@Test
	public void testGenerator() {
		//1. 全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(true) // 是否支持AR模式
				.setAuthor("carlme") // 作者
				.setOutputDir("E:/") // 生成路径
				.setFileOverride(true)  // 文件覆盖
				.setIdType(IdType.UUID) // 主键策略
				.setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
				.setBaseResultMap(true)    //结果集映射
				.setBaseColumnList(true)    //列片段
				.setEnableCache(false)
		;

		//2. 数据源配置
		DataSourceConfig dsConfig = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
				.setDriverName(dataSourceProperties.getDriverClassName())
				.setUrl(dataSourceProperties.getUrl())
				.setUsername(dataSourceProperties.getUsername())
				.setPassword(dataSourceProperties.getPassword())
		;

		//3. 策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) //全局大写命名
				.setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
				.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
				.setRestControllerStyle(true) //前后端分离生成 restful风格
				.setEntityBuilderModel(true) //构建这模型
				.setEntityLombokModel(true) //lombok
				.setControllerMappingHyphenStyle(true) //驼峰转连字符 controller
				.setTablePrefix("t_")
				.setInclude("t_record_order")
				//		.setLogicDeleteFieldName("use_flag")
				.setSuperControllerClass("com.api.common.base.BaseController")

		;  // 生成的表

		//4. 包名策略配置
		PackageConfig pkConfig = new PackageConfig();
		//pkConfig.setParent("com.hedian.zhenjiang")
		//		.setMapper("persistence.mapper")
		//		.setService("service")
		//		.setController("controller")
		//		.setEntity("persistence.po")
		//		.setXml("persistence.mapper.xml")

		pkConfig.setParent("com.admin.mvc") //总包名
				.setMapper("mapper")    //mapper
				.setService("service")
				.setController("controller")
				.setEntity("bean")
				.setXml("mapper.xml")
		;

		//5.自定义Controller 和 Service  实现了controller和service基本的增删改
		TemplateConfig tc = new TemplateConfig()
		//tc.setController("/templatesMybatis/controller.java.vm")
		//		.setService("/templatesMybatis/service.java.vm")
		//		.setServiceImpl("/templatesMybatis/serviceImpl.java.vm")
		;

		//6. 整合配置
		AutoGenerator ag = new AutoGenerator();

		ag.setGlobalConfig(config)
				.setDataSource(dsConfig)
				.setStrategy(stConfig)
				.setPackageInfo(pkConfig)
				.setTemplate(tc)
		;

		//7. 执行
		ag.execute();
	}
}
