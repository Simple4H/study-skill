package com.simple4h.lambda;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.simple4h.dto.UserDto;
import com.simple4h.entity.User;
import com.simple4h.entity.UserExt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Create By Simple4H
 * Date: 2019-05-31 14:35
 */
public class Study1 {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gson = new Gson();
        List<UserDto> userDtos = new ArrayList<>();
        List<UserDto> userDtos2 = new ArrayList<>();
        User user1 = new User(1, "simple4h", "123");
        User user2 = new User(2, "hhhh", "6666");
        List<User> userList = Lists.newArrayList(user1, user2);
        UserExt userExt1 = new UserExt(1, new Date(), "110");
        UserExt userExt2 = new UserExt(2, new Date(), "120");
        List<UserExt> userExtList = Lists.newArrayList(userExt1, userExt2);
        Map<Integer, UserExt> userExtMap = userExtList.stream()
                .collect(Collectors.toMap(UserExt::getUserId, Function.identity()));
//        userList.forEach(s -> {
//            UserDto userDto = new UserDto();
//            userDto.setId(s.getId());
//            userDto.setUsername(s.getUsername());
//            userDto.setPassword(s.getPassword());
//            userDto.setBirthday(simpleDateFormat.format(userExtMap.get(s.getId()).getBirthday()));
//            userDto.setPhone(userExtMap.get(s.getId()).getPhone());
//            userDtos.add(userDto);
//        });
        List<UserDto> dtoList = userList.stream().map(s -> {
            UserDto userDto = new UserDto();
            userDto.setId(s.getId());
            userDto.setUsername(s.getUsername());
            userDto.setPassword(s.getPassword());
            userDto.setBirthday(simpleDateFormat.format(userExtMap.get(s.getId()).getBirthday()));
            userDto.setPhone(userExtMap.get(s.getId()).getPhone());
            return userDto;
        }).collect(Collectors.toList());
        String dtoJsonStr = gson.toJson(dtoList);
        System.out.println(dtoJsonStr);

        List<UserDto> lists = gson.fromJson(dtoJsonStr,List.class);
        System.out.println(lists);
    }
}
