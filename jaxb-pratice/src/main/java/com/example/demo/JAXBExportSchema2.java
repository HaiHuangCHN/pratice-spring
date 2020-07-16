package com.example.demo;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

/**
 * Result is different when run directly and debug
 * 
 * @author h.a.huang
 *
 */
public class JAXBExportSchema2 {

	public CustomSchemaOutputResolver resolver;

	public void genAndOutputXsdFile(Class clazz, String targetPath) {
		resolver = new CustomSchemaOutputResolver(targetPath,
				clazz.getSimpleName() + ".xsd");

		Class[] classes = { clazz };
		createXsd(classes);

		System.out.println("All done");
	}

	public void createXsd(Class[] classes) {
		try {
			JAXBContext context = JAXBContext.newInstance(classes);
			context.generateSchema(resolver);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class CustomSchemaOutputResolver extends SchemaOutputResolver {

		private File file;

		public CustomSchemaOutputResolver(String dir, String fileName) {
			try {
				file = new File(dir, fileName);
				if (!file.exists()) {
					file.createNewFile();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
			StreamResult result = new StreamResult(file);
			result.setSystemId(file.toURI().toURL().toString());
			return result;
		}
	}
}
