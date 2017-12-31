package com.addoiles.db.cache;

/**
 * Description: 缓存对象
 *
 * @author Yangrunkang
 * DateTime:  2017/12/8 14:10
 */
@Deprecated
public class Cache {

    /**
     * 缓存数据
     */
    private Object value;

    /**
     * 过期时间
     */
    private Integer expireTime;

    /**
     * 创建时间
     */
    private Integer createdTime;

    private Cache() {
        super();
    }

    /*  不允许永久缓存
    public Cache(Object value) {
        this.value = value;
    }*/

    public Cache(Object value, Integer expireTime) {
        this.value = value;
        this.expireTime = expireTime;
    }

    public Cache(Object value, Integer expireTime, Integer createdTime) {
        this.value = value;
        this.expireTime = expireTime;
        this.createdTime = createdTime;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
    }
}
