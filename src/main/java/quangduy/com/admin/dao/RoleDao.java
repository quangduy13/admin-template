package quangduy.com.admin.dao;

import org.springframework.stereotype.Repository;
import quangduy.com.admin.entity.Permission;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class RoleDao implements IRoleDao {

    @Override
    public List<Permission> getListByUser(String email) {
        return null;
    }
}
