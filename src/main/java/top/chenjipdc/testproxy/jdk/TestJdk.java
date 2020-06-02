package top.chenjipdc.testproxy.jdk;

/**
 * @author chenjipdc@gmail.com
 * @date 2020-06-02 10:05
 */
public class TestJdk implements ITestJdk{

    @Override
    public void sayHello(String who){
        System.out.println("test jdk proxy: " + who + " say hello!");
    }
}

interface ITestJdk {
    void sayHello(String who);
}