package com.example.app.config;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/7
 * Time: 23:20
 * To change this template use File | Settings | File Templates.
 **/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * websocket配置
 * @author : wang zns
 * @date : 2019-05-06
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}