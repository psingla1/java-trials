package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass {
	public void method1()
			// Any unchecked exception allowed since compiler does not check
			// them.
			// So declaring them here is just for documentation purposes, it
			// does not matter to the compiler which unchecked exceptions are
			// declared.
			// None of these exceptions were present in the base class.
			// Base class had NullPointerException which we ignored.
			throws NumberFormatException, ArrayIndexOutOfBoundsException {
	}

	// It is a good thing if you don't throw an exception that was thrown by
	// base class. Compiler won't complain about it.
	// But you can't throw something that's not declared by base class.
	public void method2() {
	}

	public void method3()
			// same as base class's exception.
			throws IOException,
			// any derived class of base class's exceptions are allowed.
			FileNotFoundException,
			// unchecked exceptions are always allowed.
			RuntimeException, NumberFormatException,
			ArrayIndexOutOfBoundsException {
		//
	}
}
