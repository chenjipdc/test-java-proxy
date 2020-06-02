package top.chenjipdc.testproxy.jdk;

import top.chenjipdc.testproxy.common.TargetSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author chenjipdc@gmail.com
 * @date 2020-06-02 09:59
 *
 *
 * 1、jdk代理只能代理接口方法，并且接口方法必须实现。
 *
 * 2、返回的代理只能使用接口强转，不能使用接口实现类。
 */
public class TestJdkMain {
    public static void main(String[] args) {
        ClassLoader classLoader = TestJdkMain.class.getClassLoader();
        TestJdk testJdk = new TestJdk();
        TargetSource<TestJdk> targetSource = new TargetSource<>(testJdk);
        InvocationHandler invocationHandler = new TestJdkInvokeHandler<>(targetSource);
        Class[] classes = TestJdk.class.getInterfaces();

        Object object = Proxy.newProxyInstance(classLoader,
                classes,
                invocationHandler);

//        // 使用jdk动态代理时，必须使用接口接收类型，否则会抛异常。spring aop也一样。
//        TestJdk testJdk1 = (TestJdk)object;
//        testJdk1.sayHello("pdc");

        ITestJdk testJdk1 = (ITestJdk)object;
        testJdk1.sayHello("pdc");
    }


}
