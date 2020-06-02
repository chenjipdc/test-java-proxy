package top.chenjipdc.testproxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author chenjipdc@gmail.com
 * @date 2020-06-02 10:54
 */
public class TestCglibMain {

    public static void main(String[] args) {

        enhanceClass();

        enhanceInterface();

        enhanceAbstractClass();

        enhanceStaticClass();

        // 这个会抛异常：Cannot subclass final class top.chenjipdc.testproxy.cglib.FTestCglib
        enhanceFinalClass();
    }

    private static void enhanceFinalClass() {
        // 创建一个增强者
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(FTestCglib.class);
        setCallbacks(enhancer);
        setFilter(enhancer);

        FTestCglib proxy = (FTestCglib)enhancer.create();
        proxy.sayHi("final pdc");

        System.out.println("===========================");
    }

    private static void enhanceStaticClass() {
        // 创建一个增强者
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(STestCglib.StaticTestCglib.class);
        setCallbacks(enhancer);
        setFilter(enhancer);

        STestCglib.StaticTestCglib proxy = (STestCglib.StaticTestCglib)enhancer.create();
        proxy.sayHi("static pdc");

        System.out.println("===========================");
    }

    private static void enhanceAbstractClass() {
        // 创建一个增强者
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(AbsTestCglib.class);
        setCallbacks(enhancer);
        setFilter(enhancer);

        AbsTestCglib proxy = (AbsTestCglib)enhancer.create();
        proxy.sayHi("abstract pdc");

        System.out.println("===========================");
    }

    private static void enhanceClass() {
        // 创建一个增强者
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(CTestCglib.class);
        setCallbacks(enhancer);
        setFilter(enhancer);

        CTestCglib proxy = (CTestCglib)enhancer.create();
        proxy.sayHi("classs pdc");
        System.out.println("class hashcode: " + proxy.hashCode());

        System.out.println("===========================");
    }

    private static void enhanceInterface(){
        // 创建一个增强者
        Enhancer enhancer = new Enhancer();

        enhancer.setInterfaces(new Class[]{ITestCglib.class});
        setCallbacks(enhancer);
        setFilter(enhancer);

        ITestCglib proxy = (ITestCglib)enhancer.create();
        proxy.sayHello("interface pdc");

        System.out.println("===========================");
    }

    private static void setFilter(Enhancer enhancer){
        enhancer.setCallbackFilter(new TestCallbackFilter());
    }

    private static void setCallbacks(Enhancer enhancer){
        enhancer.setCallbacks(new Callback[]{new TestMethodInterceptor(), NoOp.INSTANCE});
    }

}
