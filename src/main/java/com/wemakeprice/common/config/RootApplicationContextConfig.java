package com.wemakeprice.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Root는 controller를 제외한 모든 설정을 지정한다. root-context.xml과 동일하다
 * 
 * @author Jung Chul
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.wemakeprice.*", "com.wemakeprice.common" })
public class RootApplicationContextConfig {
}
