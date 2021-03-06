package org.shaneking.leon.rr.g5.cfg;

import org.shaneking.leon.rr.j5f5interceptor.WebRrReqIpsInterceptor;
import org.shaneking.leon.rr.j5f5interceptor.WebRrReqUrlInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebRrMvcCfg implements WebMvcConfigurer {
  @Value("${sk.leon.rr.req.ips.enabled:true}")
  private boolean reqIpsEnabled;

  @Value("${sk.leon.rr.req.url.enabled:true}")
  private boolean reqUrlEnabled;

  @Autowired(required = false)
  private WebRrReqIpsInterceptor reqIpsInterceptor;

  @Autowired(required = false)
  private WebRrReqUrlInterceptor reqUrlInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    if (reqIpsEnabled && reqIpsInterceptor != null) {
      registry.addInterceptor(reqIpsInterceptor).addPathPatterns("/**");
    }
    if (reqUrlEnabled && reqUrlInterceptor != null) {
      registry.addInterceptor(reqUrlInterceptor).addPathPatterns("/**");
    }
  }
}
