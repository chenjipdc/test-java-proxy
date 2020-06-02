package top.chenjipdc.testproxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chenjipdc@gmail.com
 * @date 2020-06-02 10:59
 *
 * 实现cglib的 MethodInterceptor
 */
public class TestMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object rest = null;
        try {
            before(method);
            rest = methodProxy.invokeSuper(o, objects);
            after(method);
        }catch (Throwable throwable){
            exception(method, throwable);
        }
        return rest;
    }


    private void before(Method method){
        System.out.println("cglib proxy: method " + method.getName() + " invoke before");
    }

    private void after(Method method){
        System.out.println("cglib proxy: method " + method.getName() + " invoke after");

    }

    private void exception(Method method, Throwable throwable){
        System.out.println("cglib proxy: method " + method.getName() + " invoke throwable");
    }
}
