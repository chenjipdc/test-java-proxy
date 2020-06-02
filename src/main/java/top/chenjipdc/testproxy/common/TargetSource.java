package top.chenjipdc.testproxy.common;

/**
 * @author chenjipdc@gmail.com
 * @date 2020-06-02 09:56
 */
public class TargetSource<T> {

    private T target;

    public TargetSource() {
    }

    public TargetSource(T target) {
        this.target = target;
    }

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }
}
