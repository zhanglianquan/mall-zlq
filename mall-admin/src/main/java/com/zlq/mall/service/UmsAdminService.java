package com.zlq.mall.service;

import com.zlq.mall.dto.UmsAdminParam;
import com.zlq.mall.model.UmsAdmin;
import com.zlq.mall.model.UmsPermission;
import com.zlq.mall.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台管理员Service
 *
 * @author zlq
 */

public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
