package com.manish.user.mapper;

import com.manish.user.dto.AddUserRequest;
import com.manish.user.entity.User;
import com.manish.user.util.Name;
import com.manish.user.util.NameUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(AddUserRequest request) {
        User user = new User();
        Name name = NameUtils.getSeparatedNames(request.getName());
        user.setFirstName(name.getFirstName());
        user.setLastName(name.getLastName());
        user.setEmail(request.getEmail());

        return user;
    }
}
