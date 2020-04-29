//package com.nuoya.mybatis.cache;
//
//import org.apache.ibatis.cache.Cache;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import redis.clients.jedis.Jedis;
//
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
///**
// * mybatis二级缓存
// * https://blog.csdn.net/xushiyu1996818/article/details/89215428
// */
//public class MybatisRedisCache implements Cache {
//    private static final Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);
//    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//    private  String id; // 在构造函数自动注入，为namespace的名字
//    private Jedis jedis = getRedisTemplate();
//    private static final long EXPIRE_TIME_IN_MINUTES = 30; // redis过期时间
//
//    public MybatisRedisCache(final String id) {
//        if (id == null) {
//            throw new IllegalArgumentException("Cache instances require an ID");
//        }
//        this.id = id;
//        logger.debug("创建了mybatis的redis缓存"+id);
//    }
//
//    public MybatisRedisCache() {
//    }
//
//    @Override
//    public String getId() {
//        return id;
//    }
//    /**
//     * Put query result to redis
//     *
//     * @param key
//     * @param value
//     */
//    @Override
//    @SuppressWarnings("unchecked")
//    public void putObject(Object key, Object value) {
//        RedisTemplate redisTemplate = getRedisTemplate();
//        HashOperations opsForHash=redisTemplate.opsForHash();
//        opsForHash.put(id,key,value);
//        logger.debug("redis cache "+id+" put key: "+key.toString()+" value: "+value.toString());
//    }
//    /**
//     * Get cached query result from redis
//     *
//     * @param key
//     * @return
//     */
//    @Override
//    public Object getObject(Object key) {
//        RedisTemplate redisTemplate = getRedisTemplate();
//        HashOperations opsForHash=redisTemplate.opsForHash();
//        logger.debug("redis cache "+id+" get key: "+key.toString());
//        return opsForHash.get(id, key);
//    }
//    /**
//     * Remove cached query result from redis
//     *
//     * @param key
//     * @return
//     */
//    @Override
//    @SuppressWarnings("unchecked")
//    public Object removeObject(Object key) {
//        RedisTemplate redisTemplate = getRedisTemplate();
//        logger.debug("redis cache "+id+" remove key: "+key.toString());
//        HashOperations opsForHash=redisTemplate.opsForHash();
//        opsForHash.delete(id, key);
//        return null;
//    }
//    /**
//     * Clears this cache instance
//     */
//    @Override
//    public void clear() {
//        Jedis redisTemplate = getRedisTemplate();
//        redisTemplate.execute((RedisCallback) connection -> {
//            redisTemplate.delete(id);
//            return null;
//        });
//        logger.debug("Clear all the cached query result from redis "+id);
//    }
//    @Override
//    public int getSize() {
//        return 0;
//    }
//    @Override
//    public ReadWriteLock getReadWriteLock() {
//        return readWriteLock;
//    }
//    private Jedis getRedisTemplate() {
////        if (redisTemplate == null) {
////            redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
////        }
////        return redisTemplate;
//    }
//}
