package top.chenjipdc.testproxy.cglib;

/**
 * @author chenjipdc@gmail.com
 * @date 2020-06-02 09:45
 *
 * 这个final类不能代理
 */
public final class FTestCglib {

    public void sayHi(String who){
        System.out.println(this.getClass().getSimpleName() + " " + who + " say: hi!");
    }

}
