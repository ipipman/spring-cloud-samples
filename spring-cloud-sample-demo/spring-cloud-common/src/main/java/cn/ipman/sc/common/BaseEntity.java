package cn.ipman.sc.common;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/17 18:12
 */
public abstract class BaseEntity {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
