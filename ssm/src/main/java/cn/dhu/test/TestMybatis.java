package cn.dhu.test;

import cn.dhu.dao.IAccountDao;
import cn.dhu.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhbr
 * @date 2019/4/21 22:47
 */
public class TestMybatis {
    @Test
    public void run1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        IAccountDao dao = sqlSession.getMapper(IAccountDao.class);
        List<Account> all = dao.findAll();
        for (Account account:all){
            System.out.println(account);
        }
        sqlSession.close();
        inputStream.close();
    }
    @Test
    public void run2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        IAccountDao dao = sqlSession.getMapper(IAccountDao.class);
        dao.saveAccount(new Account("赵六", 500d));

        sqlSession.commit();

        sqlSession.close();
        inputStream.close();
    }
}
