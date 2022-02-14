package lecture02;

import java.util.Optional;

@FunctionalInterface
public interface Functional1 {

	public void apply();
	
	default void foo() {
		
	}
	
}
