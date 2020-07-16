package com.example.springBoot.powerMockito;

import java.io.File;

/**
 * Created by lixiangrong on 2017/7/21.
 */

public class Class1 {

	public boolean callArgumentInstance(File file) {
		return file.exists();
	}

	public boolean callInternalInstance(String path) {
		File file = new File(path);
		return file.exists();
	}

	public boolean callFinalMethod(Class1Dependency class1Dependency) {
		return class1Dependency.isAlive();
	}

	public boolean callSystemFinalMethod(String str) {
		return str.isEmpty();
	}

	public boolean callStaticMethod() {
		return Class1Dependency.isExist();
	}

	public String callSystemStaticMethod(String str) {
		return System.getProperty(str);
	}

	public boolean callPrivateMethod() {
		return isExist();
	}

	private boolean isExist() {
		// do something
		return false;
	}

	public boolean callVoidPrivateMethod() {
		testVoid(" add Huang, Hai");
		return true;
	}

	public String partialMocking(String str) {
		String newStr = addString(str);
		testVoid(" add Huang, Hai");
		return newStr;
	}

	private String addString(String str) {
		return str + " call addString() successfully";
	}

	public void voidMethod() {
		System.out.println("Call void method successfully!");
	}

	private void testVoid(String str) {
		System.out.println("do nothing" + str);
	}

	public boolean callDependency() {
		Class1Dependency classDependency = new Class1Dependency();
		return classDependency.isGod("hh");
	}
}