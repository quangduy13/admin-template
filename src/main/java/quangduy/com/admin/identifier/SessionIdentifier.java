package quangduy.com.admin.identifier;

import org.springframework.context.annotation.Configuration;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.UUID;


@Configuration
public class SessionIdentifier extends SocialConfigurerAdapter
{

    @Override
    public UserIdSource getUserIdSource() {
        return new SessionIdUserIdSource();
    }

    private static final class SessionIdUserIdSource implements UserIdSource {
    	@Override
        public String getUserId() {

            return null;
        }
    }
}