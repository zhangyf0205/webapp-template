package com.xx.xx;

import com.xx.xx.config.RestApplication;
import com.xx.xx.utils.ConfUtils;
import com.xx.xx.utils.LogInitializer;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class HttpServerLauncher extends LogInitializer {
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(ConfUtils.appConf.getProperty("http.server.port"));
        URI baseUri = UriBuilder.fromUri("http://localhost").port(port).build();
        ResourceConfig config = new RestApplication();
        Server server = JettyHttpContainerFactory.createServer(baseUri, config, false);
        server.start();
        Logger logger = LoggerFactory.getLogger(HttpServerLauncher.class);
        logger.info("http server started on " + baseUri.toString());
    }
}
