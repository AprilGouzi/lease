package com.atguigu.lease.common.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 囍崽
 * version 1.0
 */
@Data
@ConfigurationProperties(prefix = "aliyun.sms")
public class AliyunSMSProperties {
    private String accessKeyId;

    private String accessKeySecret;

    private String endpoint;

}
