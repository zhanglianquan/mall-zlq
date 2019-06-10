package com.zlq.mall.service;

import com.zlq.mall.dto.OssCallbackResult;
import com.zlq.mall.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service
 */
public interface OssService {
    OssPolicyResult policy();
    OssCallbackResult callback(HttpServletRequest request);
}
