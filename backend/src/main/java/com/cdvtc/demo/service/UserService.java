package com.cdvtc.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdvtc.demo.dto.LoginRequest;
import com.cdvtc.demo.dto.RegisterRequest;
import com.cdvtc.demo.dto.UserUpdateRequest;
import com.cdvtc.demo.vo.LoginResponse;
import com.cdvtc.demo.vo.UserVO;
import com.cdvtc.demo.dto.*;
import com.cdvtc.demo.entity.User;
import com.cdvtc.demo.mapper.UserMapper;
import com.cdvtc.demo.util.JwtUtil;
import com.cdvtc.demo.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService extends ServiceImpl<UserMapper, User> {

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest request) {
        User user = lambdaQuery()
                .eq(User::getUsername, request.getUsername())
                .one();

        if (user == null) {
            throw new RuntimeException("用户名或密码错误");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }

        if (user.getStatus() == 0) {
            throw new RuntimeException("账号已被禁用");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        UserVO userVO = convertToVO(user);

        return new LoginResponse(token, userVO);
    }

    public void register(RegisterRequest request) {
        // 检查用户名是否存在
        boolean exists = lambdaQuery()
                .eq(User::getUsername, request.getUsername())
                .exists();

        if (exists) {
            throw new RuntimeException("用户名已存在");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setStatus(1);

        save(user);
    }

    public UserVO getCurrentUser(String username) {
        User user = lambdaQuery()
                .eq(User::getUsername, username)
                .one();

        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        return convertToVO(user);
    }

    public IPage<UserVO> getUserList(Integer page, Integer size, String keyword) {
        Page<User> pageParam = new Page<>(page, size);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        if (StringUtils.hasText(keyword)) {
            wrapper.like(User::getUsername, keyword)
                    .or()
                    .like(User::getEmail, keyword)
                    .or()
                    .like(User::getPhone, keyword);
        }

        wrapper.orderByDesc(User::getCreateTime);

        IPage<User> userPage = page(pageParam, wrapper);

        return userPage.convert(this::convertToVO);
    }

    public void updateUser(UserUpdateRequest request) {
        User user = getById(request.getId());
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        if (StringUtils.hasText(request.getEmail())) {
            user.setEmail(request.getEmail());
        }
        if (StringUtils.hasText(request.getPhone())) {
            user.setPhone(request.getPhone());
        }
        if (request.getStatus() != null) {
            user.setStatus(request.getStatus());
        }

        updateById(user);
    }

    public void deleteUser(Long id) {
        removeById(id);
    }

    private UserVO convertToVO(User user) {
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }
}
