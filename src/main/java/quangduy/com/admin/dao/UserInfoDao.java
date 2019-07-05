package quangduy.com.admin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import quangduy.com.admin.common.Define;
import quangduy.com.admin.entity.UserInfo;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserInfoDao implements IUserInfoDao {

    private String dateTime = Define.getCurrenDatetime();

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserInfo getActiveUser(String userName) {
        UserInfo activeUserInfo = new UserInfo();

        List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName= :userName and is_active = :is_active")
                .setParameter("userName", userName).setParameter("is_active", 1).getResultList();
        if(list !=null){
            activeUserInfo = (UserInfo) list.get(0);
        }
        return activeUserInfo;
    }

    @Override
    public void insertUser(UserInfo userInfo) {
        String sql = "INSERT INTO users(email, fullname, create_date, is_active, image, provider)" +
                     "VALUES(?,?,?,?,?,?) ON DUPLICATE KEY UPDATE email = VALUES(email), fullname = VALUES(fullname), create_date = VALUES(create_date), is_active = VALUES(is_active), image = VALUES(image), provider = VALUES(provider)" ;

        List<Object> listParam = new ArrayList<>();

        listParam.add(userInfo.getEmail());
        listParam.add(userInfo.getFullname());
        listParam.add(dateTime);
        listParam.add(1);
        listParam.add(userInfo.getImage());
        listParam.add(userInfo.getProvider());

        jdbcTemplate.update(sql, listParam.toArray());

    }
}
