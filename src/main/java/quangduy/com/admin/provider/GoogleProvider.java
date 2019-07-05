package quangduy.com.admin.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.plus.Person;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import quangduy.com.admin.dao.IRoleDao;
import quangduy.com.admin.dao.IUserInfoDao;
import quangduy.com.admin.entity.Permission;
import quangduy.com.admin.entity.UserBean;
import quangduy.com.admin.entity.UserInfo;

import java.util.List;

@Service
public class GoogleProvider {

    private static final String GOOGLE = "google";

    @Autowired
    private BaseProvider baseProvider;

    @Autowired
    private IRoleDao iRoleDao;

    @Autowired
    private IUserInfoDao iUserInfoDao;

    public Person getGoogleUserData(Model model){

        Google google = baseProvider.getGoogle();
        Person googleUser = google.plusOperations().getGoogleProfile();
        UserInfo userInfo = new UserInfo();

        userInfo.setEmail(googleUser.getAccountEmail());
        userInfo.setFullname(googleUser.getDisplayName());
        userInfo.setImage(googleUser.getImageUrl());
        userInfo.setProvider(GOOGLE);
        iUserInfoDao.insertUser(userInfo);

        List<Permission> permissions = iRoleDao.getListByUser(googleUser.getAccountEmail());

        return googleUser;
    }


}
