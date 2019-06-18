package com.carlme.ddns.util;

import com.carlme.ddns.vo.AliyunVo;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsRequest;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsResponse;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsResponse.Record;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordRequest;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
public class DDNSTask {
	@Autowired
	private AliyunVo aliyunVo;
	private static IAcsClient client;

	@PostConstruct
	public void init() {
		IClientProfile profile = DefaultProfile.getProfile(aliyunVo.getRegionId(), aliyunVo.getAccessKeyId(), aliyunVo.getAccessKeySecret());
		client = new DefaultAcsClient(profile);
		log.info("初始化client完成{}", client);
	}

	@Scheduled(cron = "0 */5 * * * *")  //每5分钟执行一次
	public void aliyunDomain() {
		DescribeDomainRecordsRequest request = new DescribeDomainRecordsRequest();
		request.setDomainName(aliyunVo.getDomain());
		DescribeDomainRecordsResponse response;
		try {
			//获取此时外网的ip
			String cur_ip = getV4IP();
			//获取当前域名的二级域名
			response = client.getAcsResponse(request);
			List<Record> domainRecords = response.getDomainRecords();
			for (String rr : aliyunVo.getRr()) {
				for (Record domainRecord : domainRecords) {
					if (rr.equals(domainRecord.getRR())) {
						Record record = domainRecord;
						//获取当前ip 域名的ip
						String old_ip = record.getValue();

						//获取当前的记录类型
						String type = record.getType();
						// 获取的当前ip 不为空  并且是A记录  且公网ip和域名ip不一样时执行
						if (!"".equals(cur_ip) && "A".equals(type) && !old_ip.equals(cur_ip)) {
							UpdateDomainRecordRequest udr_req = new UpdateDomainRecordRequest();
							udr_req.setValue(cur_ip);
							udr_req.setType(type);
							udr_req.setTTL(record.getTTL());
							udr_req.setPriority(record.getPriority());
							udr_req.setLine(record.getLine());
							udr_req.setRecordId(record.getRecordId());
							udr_req.setRR(rr);

							@SuppressWarnings("unused")
							UpdateDomainRecordResponse udr_resp = client.getAcsResponse(udr_req);
							log.info("二级域名为 : {} , 域名对应ip修改为 : {} ", rr, cur_ip);
						} else if (!"A".equals(type)) {
							log.info("二级域名为 : {} , 当前记录是 : {} 类型,不是A记录不用修改", rr, type);
						} else {
							log.info("二级域名为 : {} , 无需修改,域名ip为 : {} , 外网ip为 : {}", rr, old_ip, cur_ip);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * 获取外网IPV4地址
	 *
	 * @return
	 */
	public String getV4IP() {
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(aliyunVo.getPath()).build();
			Response response = client.newCall(request).execute();
			String ip = response.body().string();
			log.info("当前ip为 : {}", ip);
			return ip;
		} catch (Exception e) {
			log.error("获取ip失败");
			log.error(e.getMessage());
		}
		return "";
	}

}
