package quangduy.com.admin.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.SocialConfiguration;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.GenericConnectionStatusView;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.connect.GoogleConnectionFactory;
@Configuration
public class GoogleAutoConfiguration extends SocialConfiguration {

    @Autowired
    private Environment env;

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Google google(ConnectionRepository connectionRepository) {
        Connection<Google> connection = connectionRepository.findPrimaryConnection(Google.class);
        return connection != null ? connection.getApi() : null;

    }
    @Bean(name = { "connect/googleConnect", "connect/googleConnected" })
    @ConditionalOnProperty(prefix = "spring.social", name = "auto-connection-views")
    public GenericConnectionStatusView googleConnectView(){

        return new GenericConnectionStatusView("google", "Google");
    }

    @Override
    public ConnectionFactoryLocator connectionFactoryLocator() {

        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new GoogleConnectionFactory(env.getProperty("spring.social.google.appId"), env.getProperty("spring.social.google.appSecret")));
        return registry;
    }
}
