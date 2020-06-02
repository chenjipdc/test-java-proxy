package top.chenjipdc.testproxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author chenjipdc@gmail.com
 * @date 2020-06-02 11:48
 *
 * 根据不同的method使用不同的callback，accept返回值即是数组里面的callback的下标
 *
 */
public class TestCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if (method.getName().equals("hashCode")){
            return 0;
        }
        return 1;
    }
}
