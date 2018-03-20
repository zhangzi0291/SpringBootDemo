package com.demo.base.api;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 标记版本的实现
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    // 路径中版本的前缀， 这里用 /v[1-9]/的形式
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("/\\d+\\.\\d+\\.+\\d");

    private String apiVersion;

    public ApiVersionCondition(String apiVersion){
        this.apiVersion = apiVersion;
    }

    public ApiVersionCondition combine(ApiVersionCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiVersionCondition(other.getApiVersion());
    }

    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(request.getServletPath());
        if(m.find()){
            String[] version = reverse(m.group(0).substring(1).split("\\."));
            String[] oldVersion = reverse(apiVersion.split("\\."));
            for(int i=0;i<version.length;i++){
                if(Integer.valueOf(version[i]).compareTo(Integer.valueOf(oldVersion[i]))>0){
                    return this;
                }
            }
        }
        if(m.group(0).substring(1).equals(apiVersion)){
            return this;
        }
        return null;
    }

    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        String[] version = reverse(other.getApiVersion().split("\\."));
        String[] oldVersion = reverse(apiVersion.split("\\."));
        for(int i=0;i<version.length;i++){
            if(Integer.valueOf(version[i]).compareTo(Integer.valueOf(oldVersion[i]))>0){
                return 1;
            }
        }
        if(other.getApiVersion().equals(apiVersion)){
            return 0;
        }
        return -1;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String[] reverse(String[] strings) {
        for (int start = 0, end = strings.length - 1; start < end; start++, end--) {
            String temp = strings[end];
            strings[end] = strings[start];
            strings[start] = temp;
        }
        return strings;
    }
}
