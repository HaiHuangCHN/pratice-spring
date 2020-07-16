package com.example.demo;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

/**
 * JAXB export Schema
 *
 * @author h.a.huang
 */
public class JAXBExportSchema1 {
	public static void main(String[] args) {
		JAXBContext jct;
		try {
			jct = JAXBContext.newInstance(User.class);
			jct.generateSchema(new Resolver());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class Resolver extends SchemaOutputResolver {
	@Override
	public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
		File file = new File(
				"C:\\Users\\h.a.huang\\Documents\\GitHub\\spring-pratice\\jaxb-pratice\\src\\main\\resources",
				suggestedFileName);
		StreamResult result = new StreamResult(file);
		result.setSystemId(file.toURI().toURL().toString());
		return result;
	}
}