package cn.tx.test;
//import jdk.internal.module.Resources;
import cn.tx.domain.User;
import cn.tx.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Demo1 {
    @Test
    public void Demo1() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=factory.openSession();
        List<User>list=session.selectList("cn.tx.mapper.UserMapper.findAll");
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void testInsert()throws IOException{
        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=factory.openSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("测试");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("北京路");
        mapper.insert(user);
        session.commit();
        System.out.println(user.getId());
        session.close();
        inputStream.close();
    }

}
