package lecture02;

public class InterfaceImpl implements Interface1, Interface2 {

    @Override
    public void foo() {
        Interface1.super.foo();
        bar();
    }
}
