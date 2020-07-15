package cn.tx.mapper;

import cn.tx.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
    public int insert(User user);
}
