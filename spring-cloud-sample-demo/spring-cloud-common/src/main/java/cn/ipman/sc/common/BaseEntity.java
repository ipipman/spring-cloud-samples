package cn.ipman.sc.common;

import lombok.Data;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/17 18:12
 */
@Data
public abstract class BaseEntity {

    private long id;

    private long createTime;

    private long updateTime;

}
