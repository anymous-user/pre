package com.xd.pre.handler;

import com.xd.pre.dto.RoleDto;
import com.xd.pre.security.util.SecurityUtil;
import com.xd.pre.service.ISysDeptService;
import com.xd.pre.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname ThisLevelChildenDataScope
 * @Description TODO
 * @Author Created by Lihaodong (alias:小东啊) lihaodongmail@163.com
 * @Date 2019-06-08 16:30
 * @Version 1.0
 */
@Component("3")
public class ThisLevelChildenDataScope implements AbstractDataScopeHandler {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysDeptService deptService;


    @Override
    public List<Integer> getDeptIds(RoleDto roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
        Integer deptId = userService.findByUserName(SecurityUtil.getUser().getUsername()).getDeptId();
        return deptService.selectDeptIds(deptId);
    }
}
