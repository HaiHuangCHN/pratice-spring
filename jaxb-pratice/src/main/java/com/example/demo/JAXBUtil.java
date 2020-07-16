package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * "marshaller" object and "unmarshaller" object are created by JAXBContext, so
 * should instantiate JAXBContext.
 * 
 * @author h.a.huang
 */
public class JAXBUtil {
	/**
	 * Generate XML byte array
	 * 
	 * @param obj Object to be converted
	 */
	public static String marshal(Object obj) throws JAXBException {
		// Generate jaxbContext object according to target class
		JAXBContext jaxbContext = JAXBCache.instance().getJAXBContext(obj.getClass());
		// Generate marshaller object from jaxbContext, used to transfer
		// byteArrayOutputStream into XML
		Marshaller marshaller = jaxbContext.createMarshaller();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// The following is the configuration for XML
		// JAXB_FORMATTED_OUTPUT, that is auto-newline，otherwise will print out in one
		// line
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(obj, byteArrayOutputStream);
		byte[] result = byteArrayOutputStream.toByteArray();
		String xml = new String(result);// byte[] -> String
		return xml;
	}

	/**
	 * JAXB generate Java object form XML
	 * 
	 * @param data  XML stream
	 * @param clazz Target class
	 */
	public static Object unmarshal(String xml, Class<?> clazz) throws JAXBException {
		JAXBContext context = JAXBCache.instance().getJAXBContext(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		// When Java API communicate with other API written in other program languages
		// in TCP/IP socket, normally use byte[] array to communicate
		ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes());
		Object obj = unmarshaller.unmarshal(inputStream);
		return obj;
	}

	// The following is never used
	/**
	 * @param data  xml stream
	 * @param clazz
	 * @return Object generated from JAXB
	 */
	public static Object unmarshal(InputStream in, Class<?> clazz) throws JAXBException, IOException {
		JAXBContext context = JAXBCache.instance().getJAXBContext(clazz);
		byte[] bt = read(in);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bt);
		Object obj = unmarshaller.unmarshal(inputStream);
		return obj;
	}

	private static byte[] read(InputStream inputStream) throws IOException {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int num = inputStream.read(buffer);
			while (num != -1) {
				baos.write(buffer, 0, num);
				num = inputStream.read(buffer);
			}
			baos.flush();
			return baos.toByteArray();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

}