package com.example.springBoot.powerMockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
//import static org.hamcrest.CoreMatchers.any;
//import static org.hamcrest.CoreMatchers.anything;

import com.example.springBoot.powerMockito.Class1;
import com.example.springBoot.powerMockito.Class1Dependency;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

import java.io.File;

/**
 * Created by lixiangrong on 2017/7/21. There are two implementations of
 * PowerMock: One is based on EasyMock, and another is based on Mockito
 */

//  When use PowerMock, we normally add @RunWith(PowerMockRunner.class) first to
//  change Runner into PowerMockRunner.class But if just normal mock
//  (testCallArgumentInstance), it is no matter whether we add or not.

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Class1.class, Class1Dependency.class, Class1Test.class}) // We must add annotation @PrepareForTest & @RunWith. And it
															// is recommended to add at class-level, not method level. And it is no matter if add extra
public class Class1Test {

	@Mock
	private File file;

	@Mock
	private Class1Dependency dependency;

	@Spy
	@InjectMocks
	private Class1 class1 = new Class1(); // Must new an instance for class1 if it is a spy
	
	@Test
	public void testVoid() {
		class1.voidMethod();
	}

	@Test
	public void testCallArgumentInstance() {

		/**
		 * Mock an object, or you can use the following:
		 * 
		 * @Mock File file;
		 */
//		File file = PowerMockito.mock(File.class);

		/**
		 * Record action of a mock
		 */
		PowerMockito.when(file.exists()).thenReturn(true);

		/**
		 * Verify the result
		 */
		Assert.assertTrue(class1.callArgumentInstance(file));
	}

	@Test
	public void testCallInternalInstance() throws Exception {
		File file = PowerMockito.mock(File.class);

		PowerMockito.whenNew(File.class).withArguments("bbb").thenReturn(file);
		PowerMockito.when(file.exists()).thenReturn(true);

		Assert.assertTrue(class1.callInternalInstance("bbb"));
		PowerMockito.verifyNew(File.class).withArguments("bbb");// case sensitive
	}

	@Test
	public void testCallFinalMethod() {

		Class1Dependency class1Dependency = PowerMockito.mock(Class1Dependency.class);

		PowerMockito.when(class1Dependency.isAlive()).thenReturn(true);

		Assert.assertTrue(class1.callFinalMethod(class1Dependency));
	}

	@Test
	public void testCallSystemFinalMethod() {
		String str = PowerMockito.mock(String.class);

		PowerMockito.when(str.isEmpty()).thenReturn(false);

		Assert.assertFalse(class1.callSystemFinalMethod(str));
	}

	@Test
	public void testCallStaticMethod() {

		PowerMockito.mockStatic(Class1Dependency.class);
		PowerMockito.when(Class1Dependency.isExist()).thenReturn(true);

		Assert.assertTrue(class1.callStaticMethod());
	}

	@Test
	public void testCallSystemStaticMethod() {

		PowerMockito.mockStatic(System.class);
		PowerMockito.when(System.getProperty("aaa")).thenReturn("bbb");

		Assert.assertEquals("bbb", class1.callSystemStaticMethod("aaa"));
	}

	@Test
	public void testCallPrivateMethod() throws Exception {

		PowerMockito.when(class1.callPrivateMethod()).thenCallRealMethod();
		PowerMockito.when(class1, "isExist").thenReturn(true);

		Assert.assertTrue(class1.callPrivateMethod());
		PowerMockito.verifyPrivate(class1).invoke("isExist");// This also works for private static methods.
	}

	@Test
	public void testCallVoidPrivateMethod() throws Exception {

		PowerMockito.doNothing().when(class1, "testVoid", anyString());// the argument could be either real argument or
																		// matchers
		Assert.assertTrue(class1.callVoidPrivateMethod());
	}

	@Test
	public void testPartialMocking() throws Exception {
		/**
		 * Same as:
		 * 
		 * @Spy private Class1 class1 = new Class1();
		 */

		PowerMockito.doNothing().when(class1, "testVoid", anyString());// the argument should be real argument,
																		// shouldn't be matchers
		String strActual = class1.partialMocking("Huang, Hai");
		String strExpected = "Huang, Hai call addString() successfully";
		Assert.assertEquals(strExpected, strActual);
		PowerMockito.verifyPrivate(class1, times(1)).invoke("testVoid", anyString());
	}

	@Test
	public void testDependency() throws Exception {
		PowerMockito.whenNew(Class1Dependency.class).withAnyArguments().thenReturn(dependency);
		PowerMockito.when(dependency.isGod(anyString())).thenReturn(true);

		Assert.assertTrue(class1.callDependency());
	}
}