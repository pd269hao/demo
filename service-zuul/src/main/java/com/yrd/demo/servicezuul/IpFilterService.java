package com.yrd.demo.servicezuul;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/9
 * Time:16:22
 */
@Service
public class IpFilterService {

    @Value("${demo.valid-ips}")
    private String ips;


    private Set<String> validIps = new HashSet<>();
    private Set<String> validIpRegulars = new HashSet<>();

    /**
     * 判断ip是否在白名单中
     *
     * @param ip
     * @return
     */
    public boolean isValidIp(String ip) {
        if (validIps.contains(ip)) {
            return true;
        } else {
            for (String reg : validIpRegulars) {
                Pattern pattern = Pattern.compile(reg);
                boolean res = pattern.matcher(ip).find();
                if (res)
                    return true;
            }
        }
        return false;
    }

    /**
     * 将纯ip和带匹配的ip区分存储
     */
    @PostConstruct
    private void initRegular() {
        if (StringUtils.isBlank(ips))
            return;
        String[] fields = ips.split(",");
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].contains("*")) {
                validIpRegulars.add(fields[i]);
            } else {
                validIps.add(fields[i]);
            }
        }
    }
}
