package com.ljfl;

import com.google.common.collect.Sets;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class})
public class LjflApplication {
    // http 请求端口，线上配置为 80
    @Value("${server.port.http}")
    private int serverPortHttp;

    // 服务器运行端口，等同于 HTTPS 请求端口，线上 443
    @Value("${server.port}")
    private int serverPortHttps;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(LjflApplication.class);
        // 这里可以补充那些加载application.xml之类的操作, 我这里给个例子，我在例子里面直接通过xml去import xml了
        Set<String> sourcesSet = Sets.newHashSet();
        sourcesSet.add("classpath*:applicationContext.xml");
        application.setSources(sourcesSet);
        application.run(args);
    }

    /**
     * http重定向到https
     */
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat;
        tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(httpConnector());

        return tomcat;
    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector(Http11NioProtocol.class.getName());
        connector.setScheme("http");
        //Connector监听的http的端口号
        connector.setPort(serverPortHttp);
        connector.setSecure(false);
        //监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(serverPortHttps);
        return connector;
    }

}
