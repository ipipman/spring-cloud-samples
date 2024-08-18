package cn.ipman.sc.common.service;

import cn.ipman.sc.common.BaseRequest;
import cn.ipman.sc.common.BaseResponse;

import java.util.Map;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/18 20:09
 */
public interface BaseService<T> {

    BaseResponse<T> service(BaseRequest<T> request, Map<String, Object> params);

}
