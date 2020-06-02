package top.chenjipdc.testproxy.cglib;

/**
 * @author chenjipdc@gmail.com
 * @date 2020-06-02 09:45
 *
 * 这个类没有实现接口
 */
public class CTestCglib {

    public void sayHi(String who){
        System.out.println(this.getClass().getSimpleName() + " " + who + " say: hi!");
    }

}
