package com.ljfl.server.biz;

import com.ljfl.server.common.exceptions.CustomException;
import com.ljfl.server.common.utils.DateUtil;
import com.ljfl.server.dto.UserDTO;
import com.ljfl.server.dto.UserSignDTO;
import com.ljfl.server.service.UserService;
import com.ljfl.server.service.UserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2019/12/29 23:15
 */
@Service
@Transactional
public class UserSignBiz {
    @Autowired
    private UserSignService userSignService;
    @Autowired
    private UserService userService;

    public void sign(UserSignDTO dto) {
        Date endDate = new Date();
        dto.setEndTime(endDate);
        String dateStr = DateUtil.dateToStr(endDate);
        Date beginDate = DateUtil.strToDate(dateStr);
        dto.setBeginTime(beginDate);
        if (userSignService.countSignUser(dto) > 0) {
            throw new CustomException("用户已签到");
        }
        userSignService.sign(dto);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(dto.getUserId());
        UserDTO user = userService.getUser(userDTO);
        Long points = user.getPoints();
        if (points == null) points = 5L;
        else points += 5;
        user.setPoints(points);
        userService.updateUser(user);
    }

    public List<UserSignDTO> listUserSign(UserSignDTO dto) {
        Date now = new Date();
        String beginDateStr = DateUtil.dateToStr(DateUtil.getDateBefore(now, 4));
        dto.setBeginTime(DateUtil.strToDate(beginDateStr));
        String endDateStr = DateUtil.dateToStr(DateUtil.getDaysAfter(now, 1));
        dto.setEndTime(DateUtil.strToDate(endDateStr));
        List<UserSignDTO> list = userSignService.listUserSign(dto);
        if (list.size() < 5) {
            Map<String, UserSignDTO> map = new HashMap<>();
            list.forEach(item -> map.put(DateUtil.longToStr(item.getCreateTime()), item));
            String timeKey = beginDateStr;
            while (!timeKey.equals(endDateStr)) {
                if (!map.containsKey(timeKey)) {
                    UserSignDTO userSignDTO = new UserSignDTO();
                    userSignDTO.setSignType("0");
                    userSignDTO.setCreateTime(DateUtil.strToLong(timeKey));
                    map.put(timeKey, userSignDTO);
                }
                Date date = DateUtil.strToDate(timeKey);
                timeKey = DateUtil.dateToStr(DateUtil.getDaysAfter(date, 1));
            }
            List<UserSignDTO> resultList = new ArrayList<>(map.values().size());
            map.values().stream().map(item -> resultList.add(item)).collect(Collectors.toList());
            Collections.sort(resultList, (a, b) -> {
                if (Objects.equals(a, b)) return 0;
                if (a == null) return 1;
                if (b == null) return -1;
                Long aTime = a.getCreateTime();
                Long bTime = b.getCreateTime();
                return Long.valueOf(aTime - bTime).intValue();
            });
            return resultList;
        }
        return list;
    }
}
