package top.chenjipdc.testproxy.jdk;

import top.chenjipdc.testproxy.common.TargetSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chenjipdc@gmail.com
 * @date 2020-06-02 09:57
 */
public class TestJdkInvokeHandler<T> implements InvocationHandler {

    private TargetSource<T> targetSource;

    public TestJdkInvokeHandler(TargetSource<T> targetSource) {
        this.targetSource = targetSource;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        T target = targetSource.getTarget();
        Object rest = null;
        try {
            before();
            rest = method.invoke(target, args);
            after();
        }catch (Throwable throwable){
            exception(throwable);
        }
        return rest;
    }

    private void before(){
        System.out.println("jdk proxy: method invoke before");
    }

    private void after(){
        System.out.println("jdk proxy: method invoke after");

    }

    private void exception(Throwable throwable){
        System.out.println("jdk proxy: method invoke throwable");
    }
}
