package com.xx.xx.filters;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import java.io.IOException;

@PreMatching
public class LoggingFilter implements ContainerRequestFilter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void filter(ContainerRequestContext context)
            throws IOException {
        logger.info("[{}] request uri {}{} mediaType:{}", context.getMethod(), context.getUriInfo().getBaseUri(), context.getUriInfo().getPath(), context.getMediaType());
    }
}
