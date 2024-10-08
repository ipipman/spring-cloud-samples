# SpringCloud和SpringCloud-Alibaba的关系



Spring Cloud Alibaba 是一套基于 Spring Cloud 的微服务开发工具包，它提供了一组用于开发分布式应用微服务的必需组件。Spring Cloud Alibaba 旨在帮助开发者通过 Spring Cloud 的编程模型轻松使用阿里中间件来搭建分布式应用系统。

Spring Cloud Alibaba 包括的功能有：

- **服务限流降级**：支持 Servlet、Feign、RestTemplate、Dubbo 和 RocketMQ 的限流降级功能，并支持查看限流降级 Metrics 监控。
- **服务注册与发现**：适配 Spring Cloud 的服务注册与发现标准，默认集成了 Ribbon 的支持。
- **配置管理**：支持通过 Nacos 进行外部配置管理，可以在 Nacos 控制台创建配置并进行管理。

<br>

Spring Cloud Alibaba 的优势在于它结合了 Spring Cloud 的灵活性和阿里巴巴中间件的强大功能，使得开发者能够在 Java 生态系统中快速构建高性能、可扩展的微服务架构。

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-11-131442.png" alt="image-20240811164908563" style="width:600px;" />

<br><br>

# 组件介绍



Spring Cloud Alibaba 是一套基于 Spring Cloud 的微服务开发工具包，它提供了一组用于开发分布式应用微服务的必需组件。以下是 Spring Cloud Alibaba 的主要组件：

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-11-120631.png" alt="image-20240811200629526" style="width:600px;" />

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

<br>

这些组件共同构成了 Spring Cloud Alibaba 的核心功能，使得开发者能够利用这些工具快速搭建和管理微服务架构。每个组件都有其特定的功能，可以单独使用也可以组合使用，以满足不同场景的需求。

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-11-085640.png" alt="image-20240811165636694" style="width:600px;" />

<br><br>

# 版本兼容和管理



Spring Cloud Alibaba 和 Spring Cloud 的版本管理和兼容性是一个重要的考虑因素，因为它们之间的版本兼容性直接影响到项目的稳定性和可维护性。下面是一些关于 Spring Cloud Alibaba 和 Spring Cloud 版本兼容性的关键点：

<br>

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

<br>

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

<br><br>

## Nacos 注册中心

Nacos 是一个开源的分布式服务发现与配置管理平台，由阿里巴巴集团开发并开源。Nacos 设计的初衷是为了支持云原生应用，便于构建微服务架构。它集成了服务发现、配置管理和动态配置更新的能力，简化了构建分布式系统的服务管理和配置管理过程。

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-11-120715.png" alt="image-20240811200711860" style="width:600px;" />

<br>

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

<br>

### Nacos 注册中心的优势：

- **易用性**：Nacos 提供了丰富的客户端 SDK 和 RESTful API，使得集成变得简单。
- **高可用性**：支持集群部署，具备良好的容灾能力和数据一致性保证。
- **扩展性**：可以根据需要轻松扩展 Nacos 集群的规模。
- **社区活跃**：作为一个开源项目，Nacos 拥有一个活跃的社区，提供了大量的文档和支持。

<br>

### 使用场景：

- 微服务架构中的服务发现和配置管理。
- 多环境下的配置同步和管理。
- 动态服务发现和负载均衡。
- 分布式系统的流量管理和故障恢复。

<br>

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

  <img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-11-130101.png" alt="image-20240811210053785" style="width:600px;" />

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

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-11-131521.png" alt="image-20240811204424645" style="width:600px;" />





<br><br><br>



### Ribbon 配合 Nacos 的简述

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-18-113511.png" alt="image-20240818193423325" style="width:700px;" />

Ribbon 是一个客户端负载均衡库，它允许你在多个实例之间进行负载均衡调用。而 Nacos 是一个易于构建服务发现和配置管理平台的中间件，它可以作为服务注册中心来使用。

<br>当你在 Spring Cloud 应用中集成 Nacos 时，通常会使用 spring-cloud-starter-alibaba-nacos-discovery 依赖，这个依赖已经包含了 Ribbon 的支持。这意味着你不需要单独添加 Ribbon 的依赖，因为 Nacos 的服务发现客户端已经默认集成了 Ribbon

```java
<!-- Maven 示例 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    <version>${spring-cloud-alibaba.version}</version>
</dependency>

```

<br>

使用时,需要配置RestTemplate, 并配置@LoadBalanced

```java
// 在spring容器中，创建一个对象，类型RestTemplate；名称/ID是：restTemplate
@Bean
@LoadBalanced
public RestTemplate restTemplate() {
    RestTemplate restTemplate =  new RestTemplate();
    return restTemplate;
}

// 测试Ribbon
for (int i = 0; i < 10; i++) {
    // helloService, 会被转换成nacos的服务地址
    String res2 = this.restTemplate.getForObject(
            "http://helloService/api/user/list?name=ipman", String.class);
    System.out.println("==> ribbon.url res: " + res2);
}
```





## Ribbon 的组成部分

Ribbon 是一个客户端负载均衡库，最初由 Netflix 开发，后来被广泛应用于 Spring Cloud 中。Ribbon 提供了一种方式来实现客户端负载均衡，使得客户端应用程序能够从多个服务实例中选择一个合适的服务实例来调用。

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-18-130659.png" alt="image-20240818210400737" style="width:700px;" />





Ribbon 的主要组成部分包括：

1. **ServerList**
   - **功能**：`ServerList` 负责提供服务实例列表。这些服务实例通常是通过某种服务发现机制获取的，例如 Eureka、Consul 等。
   - **实现**：Ribbon 提供了多种 `ServerList` 的实现，例如 `StaticServerList`（静态服务列表）、`CacheSafeServerList`（缓存安全服务列表）等。

2. **ServerListFilter**
   - **功能**：`ServerListFilter` 用于过滤 `ServerList` 中的服务实例。例如，可以根据健康状态或其他条件过滤服务实例。
   - **实现**：Ribbon 提供了 `AvailabilityFilteringServerList` 等过滤器实现。

3. **IRule**
   - **功能**：`IRule` 接口定义了选择服务实例的策略。Ribbon 内置了多种负载均衡策略，例如轮询、随机选择、权重选择等。
   - **实现**：
     - **RoundRobinRule**：简单轮询负载均衡。
     - **RandomRule**：随机选择服务实例。
     - **RetryRule**：重试策略，可以配合其他规则使用。
     - **WeightedResponseTimeRule**：基于响应时间的加权负载均衡。
     - **BestAvailableRule**：选择延迟最低的服务实例。
     - **ZoneAvoidanceRule**：默认规则，结合了 BestAvailableRule 和 AvailabilityFilteringRule。

4. **IPing**
   - **功能**：`IPing` 接口定义了服务实例是否存活的检测机制。通常用于检测服务实例是否可以接受请求。
   - **实现**：Ribbon 提供了 `PingUrl` 等实现。

5. **IClientConfig**
   - **功能**：`IClientConfig` 接口定义了 Ribbon 客户端的配置属性，例如连接超时、读取超时等。
   - **实现**：可以通过配置文件或编程方式设置这些配置。

6. **ILoadBalancer**
   - **功能**：`ILoadBalancer` 接口提供了负载均衡的核心功能，它负责根据给定的规则选择服务实例。
   - **实现**：Ribbon 提供了一个默认的实现 `ZoneAwareLoadBalancer`。

### 工作流程

1. **获取服务列表**：首先通过 `ServerList` 获取所有可用的服务实例列表。
2. **过滤服务实例**：通过 `ServerListFilter` 过滤掉不符合条件的服务实例。
3. **选择服务实例**：根据 `IRule` 选择一个服务实例进行调用。
4. **健康检查**：使用 `IPing` 检查服务实例是否存活。
5. **执行请求**：向选定的服务实例发送请求。

<br>
<br>

## Ribbon 负载均衡规则说明

Ribbon 是一个客户端负载均衡库，用于在微服务架构中选择合适的服务器实例进行调用。Ribbon 提供了多种内置的负载均衡策略，同时也允许用户自定义负载均衡策略。

<img src="https://ipman-1304583208.cos.ap-nanjing.myqcloud.com/rpcman/2024-08-18-132724.png" alt="image-20240818212722507" style="width:700px;" />

<br>

### 内置的负载均衡策略

#### 1. RandomRule (随机)
- **描述**: 随机选择一个可用的服务实例。
- **特点**: 简单易用，适用于大多数场景。

#### 2. RoundRobinRule (轮询)
- **描述**: 按照轮询的方式依次选择服务实例。
- **特点**: 实现简单，易于理解。

#### 3. WeightedResponseTimeRule (基于响应时间的加权)
- **描述**: 根据服务实例的平均响应时间来分配权重，响应时间越短的服务实例被选中的概率越大。
- **特点**: 能够根据服务实例的实际性能动态调整权重。

#### 4. BestAvailableRule (最佳可用)
- **描述**: 选择具有最低并发请求的服务实例。
- **特点**: 尽量减少服务实例的压力。

#### 5. RetryRule (重试)
- **描述**: 包含一个 `RandomRule` 和一个 `BestAvailableRule`，如果选择的服务实例失败，则重试选择另一个服务实例。
- **特点**: 增强了容错能力。

#### 6. ZoneAvoidanceRule (区域避免)
- **描述**: 默认的负载均衡策略，结合了 `BestAvailableRule` 和 `RoundRobinRule`，同时考虑了服务实例所在的区域。
- **特点**: 在多个可用区之间进行负载均衡，提高系统的可用性和稳定性。

### 自定义负载均衡策略

除了内置的负载均衡策略外，Ribbon 还允许用户自定义负载均衡策略。自定义负载均衡策略需要实现 `IRule` 接口，并覆盖 `choose` 方法。

#### 示例：自定义负载均衡策略

```java
# yaml配置的方式
helloService:
  ribbon:
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RoundRobinRule
```

