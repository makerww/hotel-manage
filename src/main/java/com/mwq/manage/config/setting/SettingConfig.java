package com.mwq.manage.config.setting;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * <p>
 * ..
 * </p>
 *
 * @author wq
 * @since 2021-09-16 13:59
 **/
@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties("setting")
public class SettingConfig {
    private List<String> allowPaths;

    private Boolean isDev;
    private String checkTokenUrl;

    public boolean isAllowPath(String path) {
        //遍历白名单
        for (String allowPath : allowPaths) {
            //判断是否允许
            if (path.startsWith(allowPath)) {
                return true;
            }
        }
        return false;
    }

}
