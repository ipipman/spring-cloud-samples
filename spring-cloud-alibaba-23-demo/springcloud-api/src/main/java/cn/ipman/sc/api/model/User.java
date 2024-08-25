package cn.ipman.sc.api.model;

import cn.ipman.sc.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/17 18:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    private String name;
    private int age;

    public User(long id, String name, int age) {
        setId(id);      // 修改父类id
        this.name = name;
        this.age = age;
        long now = System.currentTimeMillis();
        setCreateTime(now); // 父类创建时间
        setUpdateTime(now); // 父类修改时间
    }
}
