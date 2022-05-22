# Redis 笔记

[Redis 官网](redis.io)

[redis 命令](http://redis.cn/commands.html)

linux虚拟机 密码： 11071999iuc

Docker 安装Redis

```shell
#启动 docker
systemctl start docker
# 开启自启动
systemctl enable docker

docker pull redis：6.0.8
docker images
docker run -p 6379:6379 --name myredis -v /usr/local/docker/redis.conf:/etc/redis/redis.conf -v /usr/local/docker/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes
docker ps
#进入 redis 容器 fb547a3478d5
docker exec -it 容器id/服务名 redis-cli
#docker exec -it fb547a3478d5 redis-cli
auth 123456
```

## redis 传统五大数据结构及应用

### String（字符）

#### 常用命令

- set key value
- get key
- 同时设置、获取多个  mset k1 v1 k2 v2 ...   mget k1 k2 ...
- 数字增减  
  - 递增  incr key
  - 增加指定数值 incrby key increment
  - 递减 decr key
  - 减少指定数值 decrby key decrement
- 获取字符串长度 STRLEN key
- **分布式锁**
  - setnx key value  
    - setnx (set if not exist)  key 不存在才创建 key
  - set key value [EX seconds] [PX millsenconds] [NX] [XX]
    - EX: key 在多少秒之后过期
    - PX：key 在多少毫秒之后过期
    - NX：当 key 不存在时，才创建 key，效果等同于 setnx 
    - XX：当 key 存在时，覆盖 key

#### 应用场景

1. 商品编号、订单编号采用 INCR 命令生成
2. 点赞

### Hash（散列，map）

redis 中的 hash 对应 Java 中的 **Map<String, Map<Object, Object>>**

#### 常用命令

- 一次设置一个字段值 hset key field value   比如  hset person name cuixinfeng
- 一次获取一个字段值 hget key field          比如 hget person name
- 一次设置多个字段值 hmset key field value [field value ...]
- 一次获取多个字段值  hmget key field [field ...]
- 获取所有字段值 hgetall key  
- 获取某个key内的全部数量
- 删除一个key hdel

#### 应用场景

购物车  早期，当前中小厂可用

- 新增 hset shopcar：uid1024 224477 1
- 增加 hincrby shopcar:uid1024 224477 1
- 总数 hlen shopcar:uid1024 
- 全选 hgetall shopcar:uid1024 

### List（列表）

#### 常用命令

- LPUSH key value
- RPUSH key value
- LRANGE key start stop
- LLEN key

#### 应用场景

微信文章订阅公众号

```shell
127.0.0.1:6379> lpush subarticle:uid1010 11 22
(integer) 2
127.0.0.1:6379> lrange subarticle:uid1010 0 -1
1) "22"
2) "11"
```

 subarticle:uid1010 表示uid为1010的用户的订阅文章

11 22 分别代表两篇不同文章

lrange subarticle:uid1010 0 -1 表示展示用户订阅的所有文章

### Set（集合）

#### 常用命令

- SADD
- SREM
- SMEMBERS
- SISMEMBER
- SCARD
- SRANDMEMBER
- SPOP

```shell
127.0.0.1:6379> sadd set1 1 1 1 2 3 4 5 5
(integer) 5
127.0.0.1:6379> SMEMBERS set1
1) "1"
2) "2"
3) "3"
4) "4"
5) "5"
127.0.0.1:6379> SREM set1 1
(integer) 1
127.0.0.1:6379> SMEMBERS set1
1) "2"
2) "3"
3) "4"
4) "5"
127.0.0.1:6379> SISMEMBER set1 1
(integer) 0
127.0.0.1:6379> SISMEMBER set1 2
(integer) 1
127.0.0.1:6379> SCARD set1
(integer) 4
127.0.0.1:6379> SPOP set1
"2"
127.0.0.1:6379> SPOP set1 2
1) "4"
2) "5"
```

集合运算 交并补

- sdiff  A-B
- sunion A∪B
- sinter A∩B

#### 应用场景

1. 微信抽奖小程序

   ```shell
   127.0.0.1:6379> SADD key 1 2 3 4 5 6 7 8 9 10 # 共10 个人抽奖
   (integer) 10
   127.0.0.1:6379> scard key # 查看参加人数
   (integer) 10
   127.0.0.1:6379> SRANDMEMBER key 2 # 随机抽 2 个人，元素不删除
   1) "4"
   2) "1"
   127.0.0.1:6379> spop key 3 # 随机抽 3 个人，元素删除
   1) "6"
   2) "1"
   3) "4"
   ```

2. 微信朋友圈点赞

   ```shell
   127.0.0.1:6379> SADD pub:msgId z3 l4 w5 # 新增对某个消息点赞的人
   (integer) 3
   127.0.0.1:6379> SREM pub:msgId z3 # 取消点赞
   (integer) 1
   127.0.0.1:6379> SMEMBERS pub:msgId # 查看所有点赞的人
   1) "w5"
   2) "l4"
   127.0.0.1:6379> scard pub:msgId # 统计所有点赞人数
   (integer) 2
   127.0.0.1:6379> SISMEMBER pub:msgId w5 # 判断某个用户是否对某个消息点赞
   (integer) 1
   ```

3. 微博好友关注社交关系  **共同关注**

   ```shell
   127.0.0.1:6379> sadd acui 1 2 3 4 5 # acui关注的人
   (integer) 5
   127.0.0.1:6379> SADD zhoujielun 2 3 4 7 8 # 周杰伦关注的人
   (integer) 5
   127.0.0.1:6379> SINTER acui zhoujielun # 取交集，共同关注的人
   1) "2"
   2) "3"
   3) "4"
   ```

4. QQ内推可能认识的人

   ```shell
   127.0.0.1:6379> SADD s1 1 2 3 4 5 # s1 的好友
   (integer) 5
   127.0.0.1:6379> SADD s2 2 3 4 5 6 # s2 的好友
   (integer) 5
   127.0.0.1:6379> SDIFF s1 s2 # s2 可能认识的人
   1) "1"
   127.0.0.1:6379> SDIFF s2 s1 # s1 可能认识的人
   1) "6"
   ```

### SortedSet（有序集合，简称 zSet）

为 set 中添加带有 score 的元素，可以按照 score 排序

#### 常用命令



#### 应用场景

排行榜

```shell
127.0.0.1:6379> ZADD goods:sellsort 9 1001 15 1002 # 商品编号1001的销量是9，商品编号1002的销量是15
(integer) 2
127.0.0.1:6379> ZINCRBY goods:sellsort 2 1001 # 有一个客户买了 2 件 1001，1001销量加 2
"11"
127.0.0.1:6379> ZRANGE goods:sellsort 0 10 withscores # 求商品销量前 10 名
1) "1001"
2) "11"
3) "1002"
4) "15"
127.0.0.1:6379> ZREVRANGE goods:sellsort 0 10 withscores # 大的在前
1) "1002"
2) "15"
3) "1001"
4) "11"
```

### 其它类型

Bitmap（位图）

HyperLogLog（统计）

GEO（地理）

```shell
# 在redis 客户端，可以使用 help @[类型] 来查看文档
127.0.0.1:6379> help @string

APPEND key value
summary: Append a value to a key
since: 2.0.0

BITCOUNT key [start end]
summary: Count set bits in a string
since: 2.6.0

......
```

## 分布式锁

分布式锁是指在分布式微服务架构下，拆分后的各个微服务之间为了避免冲突和数据故障而加入的一种锁

#### 实战

##### 业务代码

建两个module 

boot-redis01 boot-redis02  除了端口号都一样

业务类 实现减库存业务

```java
@RestController
@Slf4j
public class GoodController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/buy_goods")
    public String buy_goods() {
        String result = stringRedisTemplate.opsForValue().get("goods:001");// ==get(key) 看库存够不够
        int goodNumber = result == null ? 0 : Integer.parseInt(result);
        if (goodNumber > 0) {
            int realNumber = goodNumber - 1; // 库存够，卖一个
            stringRedisTemplate.opsForValue().set("goods:001", String.valueOf(realNumber));
            log.info("成功买到商品， 库存还剩下【{}】件，\t 服务端口为【{}】", realNumber, serverPort);
            return "成功买到商品\t, 服务端口为" + serverPort;
        } else {
            log.info("商品售罄、活动结束、欢迎下次光临，\t服务端口为【{}】", serverPort);
        }
        return "商品售罄、活动结束、欢迎下次光临" + "\t服务端口为:"+serverPort;
    }
}
```

##### 改进点

###### v1.0 没有加锁，并发下数字不对，会出现超卖现象

- synchronized		""不见不散""

- ReentrantLock     与synchronized 不同，ReentrantLock    不会一直阻塞

  ```java
          // ReentrantLock 用法1
  //        lock.lock();
  //        try{
  //            //... method body
  //        } catch (Exception e) {
  //            e.printStackTrace();
  //        }
  //        lock.unlock();
          
  //        //ReentrantLock 用法2
  //        if (lock.tryLock()) { // 尝试获取锁
  //            try {
  //                // manipulate protected state
  //            } finally {
  //                lock.unlock();
  //            }
  //        } else {
  //            // perform alternative actions
  //        }
  //        //ReentrantLock 用法3
  //        if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) { // 超时等待,给一个规定时间，拿不到锁就放弃
  //            try {
  //                // manipulate protected state
  //            } finally {
  //                lock.unlock();
  //            }
  //        } else {
  //            // perform alternative actions
  //        }
  ```

###### 加入 ngnix 代理

docker 安装 ngnix

```shell
docker pull ngnix

docker run 

mkdir -p /root/nginx/www /root/nginx/logs /root/nginx/conf

docker images

docker cp 876b34885be5:/etc/nginx/nginx.conf /root/nginx/conf

docker run -d -p 80:80 --name nginx-web -v /root/nginx/www:/usr/share/nginx/html -v /root/nginx/conf/nginx.conf:/etc/nginx/nginx.conf -v /root/nginx/logs:/var/log/nginx nginx
```

配置文件

```nginx
#nginx.conf
user  nginx;
worker_processes  auto;

error_log  /var/log/nginx/error.log notice;
pid        /var/run/nginx.pid;


events {
    worker_connections  1024;
}


http {
    include       /etc/nginx/mime.types;
    default_type  application/octet-stream;

    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    keepalive_timeout  65;

    #gzip  on;

    # 配置负载均衡  weight 为权重
    upstream mynginx{
        server 192.168.47.32:1111 weight=1;
        server 192.168.47.32:2222 weight=1;
    }

    include /etc/nginx/conf.d/*.conf;
    server{
        listen          80;
        server_name      192.168.136.130;
		
        # 反向代理
        location / {
            proxy_pass http://mynginx;
            index index.html index.htm;
        }
    }
}

```

Jmeter 压力测试

- 添加 线程组（100个线程  1s 循环 1 次）
- 添加 HTTP 请求 http://192.168.136.130/buy_goods

结果出现超卖现象，同一个商品被卖多次

###### v2.0 分布式下超卖问题

解决  利用 redis 的 setnx （set if not exist）,并保证锁的释放

```java
public class GoodController {
    //...

    private static final String REDIS_LOCK = "MinusStockLock"; // 向redis中添加一个 key 为 “MinusStockLock” 的元素模拟锁

    @GetMapping("/buy_goods")
    public String buy_goods() throws InterruptedException {
        String uniqValue = UUID.randomUUID().toString() + Thread.currentThread().getName();
        
        try {
            Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, uniqValue);//相当于 set Nx

            if (!flag) {
                return "抢锁失败";
            }

            //... 正常减库存
        } finally {
            stringRedisTemplate.delete(REDIS_LOCK); // 解锁 出现异常可能无法释放锁，必须在代码层面保证锁的释放，也就是放到finally中
        }
    }
}
```

###### v3.0 服务器宕机，代码没有走到 finally，没办法保证解锁，需要加入一个过期时间限定 key

```java

Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, uniqValue); // 相当于 set Nx
stringRedisTemplate.expire(REDIS_LOCK, 10L, TimeUnit.SECONDS); // 加入一个过期时间限定 key

```

###### v4.0 加锁与设置过期时间不是一个原子操作

```java
Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, uniqValue, 10L, TimeUnit.SECONDS);//相当于 setnx  保证加锁与设置过期时间的原子性
```



###### v5.0 张冠李戴，误删了别人的锁  (redis 分布式锁在删除的时候的注意事项)

如 A 线程执行过程中，MinusStockLock 锁过期了，B 线程进来，A 最终会删掉 B 的锁

![image-20220524154131135](D:\workspace\vscode\leetcode\src\main\java\redisLearning\README.assets\image-20220524154131135.png)

判断 value 是否是自己的，决定是否删除

```java
finally {
    
    if (stringRedisTemplate.opsForValue().get(REDIS_LOCK).equals(uniqValue)) {
        stringRedisTemplate.delete(REDIS_LOCK); // 解锁 出现异常可能无法释放锁，必须在代码层面保证锁的释放，也就是放到finally中
    }
}
```

###### v6.0 判断和删除不是原子性的

解决 

- lua 脚本
- redis 事务

redis 事务

- `MULTI ` `EXEC` 

  ```shell
  127.0.0.1:6379> MULTI#标志事务的开始
  OK
  127.0.0.1:6379> set k1 v11
  QUEUED
  127.0.0.1:6379> set k2 v22
  QUEUED
  127.0.0.1:6379> EXEC # 相当于 MySQL 的提交
  1) OK
  2) OK
  ```

- `WATCH`

  ```shell
  # 中间有人加塞也不会影响客户端 A 事务的执行，会覆盖其它人
  # 客户端 A
  127.0.0.1:6379> MULTI
  OK
  127.0.0.1:6379> set k1 v111
  QUEUED
  127.0.0.1:6379> set k2 v222
  QUEUED
  
  # 客户端 B
  127.0.0.1:6379> set k1 abc
  OK
  127.0.0.1:6379> get k1
  "abc"
  
  # 客户端 A
  127.0.0.1:6379> EXEC
  1) OK
  2) OK
  127.0.0.1:6379> GET k1
  "v111"
  
  # WATCH 用法
  
  # 正常流程
  
  127.0.0.1:6379> WATCH k1
  OK
  127.0.0.1:6379> MULTI
  OK
  127.0.0.1:6379> set k1 AAA
  QUEUED
  127.0.0.1:6379> set k2 AAA
  QUEUED
  127.0.0.1:6379> EXEC
  1) OK
  2) OK
  127.0.0.1:6379> UNWATCH
  OK
  
  # 异常流程
  # 客户端 A
  127.0.0.1:6379> WATCH k1
  OK
  127.0.0.1:6379> MULTI
  OK
  127.0.0.1:6379> set k1 11
  QUEUED
  127.0.0.1:6379> set k2 22
  QUEUED
  
  # 客户端 B
  127.0.0.1:6379> set k1 BBB # 中途修改 k1
  OK
  127.0.0.1:6379> get k1
  "abc"
  
  # 客户端 A
  127.0.0.1:6379> EXEC
  (nil)  # 发现 k1 被修改返回 null
  ```

  用redis事务解决

  ```java
  finally {
      while (true) {
          stringRedisTemplate.watch(REDIS_LOCK);
          if (stringRedisTemplate.opsForValue().get(REDIS_LOCK).equalsIgnoreCase(uniqValue)) {
              stringRedisTemplate.setEnableTransactionSupport(true);
              stringRedisTemplate.multi();
              stringRedisTemplate.delete(REDIS_LOCK);
              List<Object> list = stringRedisTemplate.exec();
              if (list == null) {
                  continue;
              }
          }
          stringRedisTemplate.unwatch();
          break;
      }
  ```

  用 lua 脚本解决

  ```java
  finally {
      Jedis jedis = RedisUtils.getJedis();
  
      String script = "if redis.call('get', KEYS[1]) == ARGV[1] " +
          "then " +
          "return redis.call('del', KEYS[1]) " +
          "else " +
          "return 0 " +
          "end";
      try {
          Object o = jedis.eval(script, Collections.singletonList(REDIS_LOCK), Collections.singletonList(uniqValue));
          if ("1".equals(o.toString())) {
              System.out.println("------del redis lock ok");
          } else {
              System.out.println("------del redis lock error");
          }
      } finally {
          if (null != jedis) {
              jedis.close();
          }
      }
  }
  ```

  

  ###### 如何保证执行时间小于过期时间——缓存时间续约

  ###### 集群模式下 redis 和 zookeeper 的 CAP 对比

  A C 不可兼得

  redis ：

  - AP 高可用 分区容错
  - 异步复制可能造成锁丢失，如： 主节点没来得及把刚刚set进来的这条数据给从节点，就挂了

  zookeeper：

  - CP 强一致 分区容错

###### 综上所述

redis 集群下，要使用 RedLock（redis 分布式锁） 之 Redisson 落地实现

###### Redisson 版本

```java
@Configuration
public class RedisConfig {
    
    //...
    
    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useSingleServer()
            .setAddress("redis://192.168.136.130:6379")
            .setDatabase(0)
            .setPassword("123456");
        return (Redisson) Redisson.create(config);
    }
}
```

```java
public class GoodController {
    //...

    @Autowired
    private Redisson redisson;

    private static final String REDIS_LOCK = "MinusStockLock"; 

    @GetMapping("/buy_goods")
    public String buy_goods() throws Exception {
        RLock redissonLock = redisson.getLock(REDIS_LOCK);
        redissonLock.lock();
        try {
			// 减库存
        } finally {
            // 保证要释放的锁是当前线程持有的锁
            if (redissonLock.isLocked() && redissonLock.isHeldByCurrentThread()) {
                redissonLock.unlock();
            }
        }
    }
}

```

###### reddisson 看门口机制



#### 分布式锁总结



## 缓存过期淘汰策略

- 查看Redis 最大内存  配置文件 redis.conf  64位默认最大内存，32位3G

- 生产设置   不超过四分之三

- ```nginx
  maxmemory <bytes>
  ```

- redis 内存满了会怎样  **OOM**

  ```shell
  (error) OOM command not allowed when used memory > 'maxmemory'.
  ```

 

## LRU算法