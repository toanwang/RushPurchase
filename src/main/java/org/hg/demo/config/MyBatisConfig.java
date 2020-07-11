package org.hg.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wzh
 * @time: 2020/7/11 14:57
 * @description:
 */
@Configuration
@MapperScan("org.hg.demo.mapper")
public class MyBatisConfig {
}
