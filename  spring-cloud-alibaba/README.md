# SpringCloud和SpringCloudAlibaba的关系



Spring Cloud Alibaba 是一套基于 Spring Cloud 的微服务开发工具包，它提供了一组用于开发分布式应用微服务的必需组件。Spring Cloud Alibaba 旨在帮助开发者通过 Spring Cloud 的编程模型轻松使用阿里中间件来搭建分布式应用系统。

Spring Cloud Alibaba 包括的功能有：

- **服务限流降级**：支持 Servlet、Feign、RestTemplate、Dubbo 和 RocketMQ 的限流降级功能，并支持查看限流降级 Metrics 监控。
- **服务注册与发现**：适配 Spring Cloud 的服务注册与发现标准，默认集成了 Ribbon 的支持。
- **配置管理**：支持通过 Nacos 进行外部配置管理，可以在 Nacos 控制台创建配置并进行管理。

Spring Cloud Alibaba 的优势在于它结合了 Spring Cloud 的灵活性和阿里巴巴中间件的强大功能，使得开发者能够在 Java 生态系统中快速构建高性能、可扩展的微服务架构。



<img src="/Users/zhanghaili/Library/Application Support/typora-user-images/image-20240811164908563.png" alt="image-20240811164908563" style="zoom:67%;" />



# 组件介绍



Spring Cloud Alibaba 是一套基于 Spring Cloud 的微服务开发工具包，它提供了一组用于开发分布式应用微服务的必需组件。以下是 Spring Cloud Alibaba 的主要组件：

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-11-120631.png" alt="image-20240811200629526" style="zoom:70%;" />

- **Nacos**：
  - **服务注册与发现**：作为服务注册中心，支持服务的注册与发现。
  - **配置管理**：作为配置中心，支持外部化配置和动态刷新。
- **Sentinel**：
  - **流量控制**：提供流量控制功能，包括限流和熔断。
  - **降级**：支持服务降级策略，确保系统稳定运行。
- **RocketMQ**：
  - **消息队列**：支持消息的发布与订阅模式，用于异步通信。
- **Seata**：
  - **分布式事务**：提供高性能的微服务事务解决方案。

这些组件共同构成了 Spring Cloud Alibaba 的核心功能，使得开发者能够利用这些工具快速搭建和管理微服务架构。每个组件都有其特定的功能，可以单独使用也可以组合使用，以满足不同场景的需求。

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-11-085640.png" alt="image-20240811165636694" style="zoom:50%;" />





# 版本兼容和管理



Spring Cloud Alibaba 和 Spring Cloud 的版本管理和兼容性是一个重要的考虑因素，因为它们之间的版本兼容性直接影响到项目的稳定性和可维护性。下面是一些关于 Spring Cloud Alibaba 和 Spring Cloud 版本兼容性的关键点：

### Spring Cloud Alibaba 版本管理

- **Spring Cloud Alibaba** 通常会基于某个版本的 **Spring Cloud** 进行开发，并添加额外的功能来支持阿里巴巴的中间件。
- **Spring Cloud Alibaba** 的版本通常与 **Spring Cloud** 的版本保持一定的同步，但也会根据自身的发展节奏进行更新。

### 版本兼容性

- **Spring Cloud** 官方文档提供了版本兼容性矩阵，指导用户如何选择合适的版本组合。
- **Spring Cloud Alibaba** 的版本通常会在发布说明中指明兼容的 **Spring Cloud** 和 **Spring Boot** 版本。

#### 兼容性规则示例

- 如果你使用 **Spring Cloud Hoxton**，那么推荐使用的 **Spring Boot** 版本为 **2.2.x**。
- 如果你使用 **Spring Cloud Alibaba 2021.1**，那么推荐使用的 **Spring Boot** 版本可能为 **2.4.x** 或更高版本。

### 使用 BOM (Bill of Materials)

- **Spring Cloud Alibaba** 提供了一个 **BOM** 文件来管理所有相关组件的版本。
- 在 Maven 项目中，可以通过引入 **spring-cloud-alibaba-dependencies** BOM 来自动管理版本，避免手动指定版本号。

#### 示例

- 2023.x 分支对应的是 Spring Cloud 2023 与 Spring Boot 3.2.x，最低支持 JDK 17。
- 2022.x 分支对应的是 Spring Cloud 2022 与 Spring Boot 3.0.x，最低支持 JDK 17。
- 2021.x 分支对应的是 Spring Cloud 2021 与 Spring Boot 2.6.x，最低支持 JDK 1.8。
- 2020.0 分支对应的是 Spring Cloud 2020 与 Spring Boot 2.4.x，最低支持 JDK 1.8。
- 2.2.x 分支对应的是 Spring Cloud Hoxton 与 Spring Boot 2.2.x，最低支持 JDK 1.8。
- greenwich 分支对应的是 Spring Cloud Greenwich 与 Spring Boot 2.1.x，最低支持 JDK 1.8。
- finchley 分支对应的是 Spring Cloud Finchley 与 Spring Boot 2.0.x，最低支持 JDK 1.8。
- 1.x 分支对应的是 Spring Cloud Edgware 与 Spring Boot 1.x，最低支持 JDK 1.7。

```java
<dependencyManagement>
    <dependencies>
        <!--整合spring cloud-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Greenwich.SR1</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
        <!--整合spring cloud alibaba-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-alibaba-dependencies</artifactId>
            <version>0.9.0.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

版本兼容性和管理对于使用 Spring Cloud Alibaba 和 Spring Cloud 的项目至关重要。通过遵循最佳实践和使用 BOM 文件，可以有效地管理版本，确保项目的顺利运行。



## Nacos 注册中心

Nacos 是一个开源的分布式服务发现与配置管理平台，由阿里巴巴集团开发并开源。Nacos 设计的初衷是为了支持云原生应用，便于构建微服务架构。它集成了服务发现、配置管理和动态配置更新的能力，简化了构建分布式系统的服务管理和配置管理过程。

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-11-120715.png" alt="image-20240811200711860" style="zoom: 50%;" />

### Nacos 注册中心的核心功能包括：

1. **服务发现与注册**：
   - 允许服务提供者注册自己的服务实例到 Nacos 服务器。
   - 服务消费者可以从 Nacos 获取服务实例列表。
   - 提供基于 DNS 和基于 RPC 的服务发现机制。

2. **配置管理**：
   - 动态配置服务允许应用程序在运行时获取和更新配置。
   - 支持灰度发布和回滚配置变更。
   - 支持多环境、多应用的配置隔离。

3. **动态 DNS 服务**：
   - 可以作为 DNS 服务器，提供基于域名的服务发现。
   - 支持服务的健康检查，能够实时更新服务的可用状态。

4. **服务管理**：
   - 提供服务的元数据管理。
   - 支持服务的流量管理，如权重路由、熔断等。

5. **安全性**：
   - 支持认证和授权机制，保护服务和配置的安全。

6. **监控和审计**：
   - 记录服务调用的日志和指标。
   - 支持对配置变更的审计追踪。

### Nacos 注册中心的优势：

- **易用性**：Nacos 提供了丰富的客户端 SDK 和 RESTful API，使得集成变得简单。
- **高可用性**：支持集群部署，具备良好的容灾能力和数据一致性保证。
- **扩展性**：可以根据需要轻松扩展 Nacos 集群的规模。
- **社区活跃**：作为一个开源项目，Nacos 拥有一个活跃的社区，提供了大量的文档和支持。

### 使用场景：

- 微服务架构中的服务发现和配置管理。
- 多环境下的配置同步和管理。
- 动态服务发现和负载均衡。
- 分布式系统的流量管理和故障恢复。

### 如何开始使用 Nacos 注册中心：

1. **下载安装**：可以从 Nacos 的 GitHub 仓库或者官方网站下载二进制文件或 Docker 镜像。
   1. 下载地址: https://nacos.io/download/nacos-server/
2. **启动服务**：按照官方文档启动 Nacos 服务。
   1. sh bin/startup.sh -m standalone
   2. 访问地址: http://127.0.0.1:8848/nacos/
3. **集成应用**：使用提供的 SDK 或 API 将 Nacos 集成到您的应用中。

- 添加pom依赖

```java
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
  </dependency>
```

- 添加yaml配置, 在nacos中 applicaiton.name 是应用服务的名称. cloud.nacos 是具体的配置, 包含 server地址和元数据管理

  <img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-11-130101.png" alt="image-20240811210053785" style="zoom: 33%;" />

```java
spring:
  application:
    # 服务名称尽量用-，不要用_，不要用特殊字符
    name: user-center
	cloud:
    nacos:
      discovery:
        # 指定nacos server的地址
        server-addr: localhost:8848
        # 指定namespace
        # namespace: 56116141-d837-4d15-8842-94e153bb6cfb
        # NJ
        # 指定集群名称
        cluster-name: BJ
        # 元数据管理
        metadata:
          instance: c
          haha: hehe
          version: v1
```

- 测试服务发现, 通过discoveryClient访问nacos注册中心获取服务信息

```java
  // 引入
  @Autowired
  private DiscoveryClient discoveryClient;

	/**
   * 测试：服务发现，证明内容中心总能找到用户中心
   *
   * @return 用户中心所有实例的地址信息
   */
  @GetMapping("test2")
  public List<ServiceInstance> getInstances() {
      // 查询指定服务的所有实例的信息
      // consul/eureka/zookeeper...
      return this.discoveryClient.getInstances("user-center");
  }
```

![image-20240811204424645](/Users/zhanghaili/Library/Application Support/typora-user-images/image-20240811204424645.png)







