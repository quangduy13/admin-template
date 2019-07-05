package quangduy.com.admin.dao;

import quangduy.com.admin.entity.UserInfo;

import java.util.List;

public interface IUserInfoDao {
    public UserInfo getActiveUser(String userName);

    public void insertUser(UserInfo userInfo);
}
