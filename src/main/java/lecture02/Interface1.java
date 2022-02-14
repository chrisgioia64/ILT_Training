package lecture02;

public interface Interface1 {

    public default void foo() {
        System.out.println("In interface1");
    }

    public default void bar() {
        System.out.println("bar in interface1");
    }

}
