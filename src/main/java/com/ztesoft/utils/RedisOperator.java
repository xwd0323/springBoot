package com.ztesoft.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dong on 2018/4/24.
 */
@Component
public class RedisOperator {
        @Autowired
        private StringRedisTemplate stringRedisTemplate;

        /**
         * @param key
         * @return key的剩余存活时间
         */
        public long getTimeToLive(String key){
            return stringRedisTemplate.getExpire(key);
        }

        /**
         * 删除某key值
         * @param key
         */
        public void delKey(String key){
            stringRedisTemplate.delete(key);
        }

        /**
         *序列化key
         * @param key
         * @return 若key不存在，返回为null,否则返回序列化后的值
         */
        public byte[] SetDump(String key){
            return stringRedisTemplate.dump(key);
        }

        /**
         * 判断是否存在key
         * @param key
         * @return 存在则返回true,不存在返回false
         */
        public Boolean existsKey(String key){
            return stringRedisTemplate.hasKey(key);
        }

        /**
         * 赋予key值剩生命时间(感觉自己成神了)
         * @param key
         * @param timeOut
         */
        public void giveLiveTime(String key,long timeOut){
            stringRedisTemplate.expire(key,timeOut, TimeUnit.SECONDS);
        }

        /**
         * 获取所有符合pattern的key值
         * @param pattern
         * @return keys
         */
        public Set<String> getAllKeysByPattern(String pattern){
            return stringRedisTemplate.keys(pattern);
        }

        /**
         * 将当前数据库的key移到指定索引的数据库中，Redis默认数据库索引为0，springboot可以进行配置
         * @param key
         * @param dataBaseIndex
         */
        public void moveKeyToOtherDB(String key,int dataBaseIndex){
            stringRedisTemplate.move(key,dataBaseIndex);
        }

        /**
         * 赐予某key永生(移除其剩余生存时间，从生死簿上划掉名字)
         * @param key
         */
        public void givePermanentLife(String key){
            stringRedisTemplate.persist(key);
        }

        /**
         * 返回随机的一个key
         * @return
         */
        public String getRandomKey(){
            return stringRedisTemplate.randomKey();
        }

        /**
         * 重新命名key
         * @param oldName
         * @param newName
         */
        public void giveNewName(String oldName,String newName){
            stringRedisTemplate.rename(oldName,newName);
        }

        /**
         * 返回该key对应的value数据类型
         * @param key
         * @return
         */
        public Object getTypeOfKeyValue(String key){
            return stringRedisTemplate.type(key);
        }

        /**
         * 字符串命令
         * 设置一个key-value,value为字符串
         * @param key
         * @param value
         */
        public void set(String key,String value){
            stringRedisTemplate.opsForValue().set(key,value);
        }

        /**
         * 字符串命令
         * 获取key对应的value值
         * @param key
         * @return
         */
        public String get(Object key){
            return stringRedisTemplate.opsForValue().get(key);
        }

        /**
         * 字符串命令
         * 获取该key对应的value值的某段
         * @param key
         * @param startIndex
         * @param endIndex
         * @return
         */
        public String subValue(String key,long startIndex,long endIndex){
            return stringRedisTemplate.opsForValue().get(key,startIndex,endIndex);
        }
    }
