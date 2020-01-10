package com.sly.baseplatform.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.baseplatform.common.model.User;

import java.util.List;

/**
 * 用户mapper
 *
 * @author SLY
 * @time 2019/12/23
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户id查询用户
     *
     * @param id
     * @return
     * @author SLY
     * @time 2019/12/23
     */
    User findUserById(String id);

    /**
     * 查询用户列表
     *
     * @param page
     * @param user
     * @return
     * @author SLY
     * @time 2019/12/25
     */
    List<User> findUserList(Page<User> page, User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    int updateUser(User user);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    int deleteUser(String userId);

    /**
     * 激活用户
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    int activeUser(String userId);

    /**
     * 禁用用户
     *
     * @param userId
     * @return
     * @author SLY
     * @time 2020/1/2
     */
    int disableUser(String userId);

    /**
     * 根据用户名称查询用户
     *
     * @param username
     * @return
     * @author SLY
     * @time 2020/1/10
     */
    User findUserByUsername(String username);
}
