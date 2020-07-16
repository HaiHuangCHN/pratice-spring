//package com.example.springBoot.jUnitTest;
//
//import static org.hamcrest.CoreMatchers.allOf;
//import static org.hamcrest.CoreMatchers.both;
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.everyItem;
//import static org.hamcrest.CoreMatchers.hasItems;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.not;
//import static org.hamcrest.CoreMatchers.startsWith;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.fail;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//public class JUnitTest {
//
//	@Test
//	public void testAssetThatExamples() {
//
//		// 'theString' should contain 'S' and 'r'
//		assertThat("theString", both(containsString("S")).and(containsString("r")));
//
//		List<String> items = Arrays.asList("John", "James", "Julia", "Jim");
//
//		// items list should have James and Jim
//		assertThat(items, hasItems("James", "Jim"));
//
//		// Every item in the list should have the character 'J'
//		assertThat(items, everyItem(containsString("J")));
//
//		// check all of the matchers
//		assertThat("Once", allOf(equalTo("Once"), startsWith("O")));
//
//		// negation of all of the matchers
//		assertThat("Once", not(allOf(equalTo("test"), containsString("test"))));
//	}
//
//	@Test(expected = FileNotFoundException.class)
//	public void testReadFile() throws IOException {
//		FileReader reader = new FileReader("test.txt");
//		reader.read();
//		reader.close();
//	}
//
//	@Test
//	public void testReadFile2() {
//		try {
//			FileReader reader = new FileReader("test.txt");
//			reader.read();
//			reader.close();
//			fail("Expected an IOException to be thrown");
//		} catch (IOException e) {
//			assertThat(e.getMessage(), is("test.txt (No such file or directory)"));
//		}
//	}
//
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
//
//	@Test
//	public void testReadFile3() throws IOException {
//
//		thrown.expect(IOException.class);
//		thrown.expectMessage(startsWith("test.txt (No such file or directory)"));
//		FileReader reader = new FileReader("test.txt");
//		reader.read();
//		reader.close();
//	}
//
//}
