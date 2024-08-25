package cn.ipman.sc.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * service register aspect.
 */
@Aspect
@Component
public class ServiceRegisterAspect {

    // 定义常量，用于标识配置属性的键
//    public final static String TYPE = "type";
    public final static String DC = "dc";
    public final static String ZONE = "zone";
    public final static String ENV = "env";
    public final static String GROUP = "group";

    // 注入环境对象，用于获取配置属性
    @Autowired
    Environment environment;

    /**
     * 在服务注册之前执行的操作
     *
     * @param jp 切点对象，用于获取目标方法的参数等信息
     */
    @Before("execution(* org.springframework.cloud.client.serviceregistry.ServiceRegistry.register(..))")
    public void beforeRegister(JoinPoint jp) {

        // 从环境变量中获取服务注册相关的配置信息，默认值分别为"BJ"、"B001"、"DEV"、"DEFAULT"
        String dc    = environment.getProperty(DC, "BJ");
        String zone  = environment.getProperty(ZONE, "B001");
        String env   = environment.getProperty(ENV, "DEV");
        String group = environment.getProperty(GROUP, "DEFAULT");

        // 打印服务注册的配置信息
        System.out.println("ServiceRegisterAspect.beforeRegister for dc/zone/env/group: "
                           + dc + "/" + zone + "/" + env + "/" + group);

        // 获取目标方法的参数
        Object[] args = jp.getArgs();
        for (Object o : args) {
            // 检查参数是否为Registration类型，如果是则进行元数据设置
            if (o instanceof Registration registration) {
                // 将配置信息作为元数据设置到服务注册对象中
                registration.getMetadata().put(DC, dc);
                registration.getMetadata().put(ZONE, zone);
                registration.getMetadata().put(ENV, env);
                registration.getMetadata().put(GROUP, group);
                // 打印设置后的元数据
                System.out.println(registration.getMetadata());
            }
        }
    }
}