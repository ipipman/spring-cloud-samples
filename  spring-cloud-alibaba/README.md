



## SpringCloud和SpringCloudAlibaba的关系

Spring Cloud Alibaba 是一套基于 Spring Cloud 的微服务开发工具包，它提供了一组用于开发分布式应用微服务的必需组件。Spring Cloud Alibaba 旨在帮助开发者通过 Spring Cloud 的编程模型轻松使用阿里中间件来搭建分布式应用系统。

Spring Cloud Alibaba 包括的功能有：

- **服务限流降级**：支持 Servlet、Feign、RestTemplate、Dubbo 和 RocketMQ 的限流降级功能，并支持查看限流降级 Metrics 监控。
- **服务注册与发现**：适配 Spring Cloud 的服务注册与发现标准，默认集成了 Ribbon 的支持。
- **配置管理**：支持通过 Nacos 进行外部配置管理，可以在 Nacos 控制台创建配置并进行管理。

Spring Cloud Alibaba 的优势在于它结合了 Spring Cloud 的灵活性和阿里巴巴中间件的强大功能，使得开发者能够在 Java 生态系统中快速构建高性能、可扩展的微服务架构。



![image-20240811164908563](/Users/zhanghaili/Library/Application Support/typora-user-images/image-20240811164908563.png)



## 组件介绍

Spring Cloud Alibaba 是一套基于 Spring Cloud 的微服务开发工具包，它提供了一组用于开发分布式应用微服务的必需组件。以下是 Spring Cloud Alibaba 的主要组件：

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





## 版本兼容和管理

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



