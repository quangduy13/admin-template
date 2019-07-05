package quangduy.com.admin.dao;

import quangduy.com.admin.entity.Permission;

import java.util.List;

public interface IRoleDao {

    public List<Permission> getListByUser(String email);
}
