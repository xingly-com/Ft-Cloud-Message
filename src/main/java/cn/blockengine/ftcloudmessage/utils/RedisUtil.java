package cn.blockengine.ftcloudmessage.utils;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取键过期时间
     * @param key 键
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 查询键是否存在
     * @param key 键
     */
    public boolean hasKey(String key) {
        try {
            return Boolean.TRUE.equals(redisTemplate.hasKey(key));
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除键
     * @param key 键
     */
    public boolean del(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取值
     * @param key 键
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 存入值
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key,value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 存入值设置时间
     * @param key 键
     * @param value 值
     * @param time 时间
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else {
                set(key,value);
            }
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增or递减
     * @param key 键
     * @param cnt 递增变量
     */
    public long incr(String key, long cnt) {
        if (cnt > 0) {
            return redisTemplate.opsForValue().increment(key,cnt);
        }else if (cnt < 0) {
            cnt = -cnt;
            return redisTemplate.opsForValue().decrement(key,cnt);
        }
        return 0;
    }

    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    public Collection<String> keys(final String pattern)
    {
        return redisTemplate.keys(pattern);
    }

    /**
     * 删除集合对象
     *
     * @param collection 多个对象
     * @return
     */
    public boolean deleteObject(final Collection collection)
    {
        return redisTemplate.delete(collection) > 0;
    }
}
