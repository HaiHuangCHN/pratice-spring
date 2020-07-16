package com.example.demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public final class JAXBCache {
	private static final JAXBCache INSTANCE = new JAXBCache();
	private static final ConcurrentMap<String, JAXBContext> CONTEXT_CACHE = new ConcurrentHashMap<String, JAXBContext>();

	private JAXBCache() {
	}

	public static JAXBCache instance() {
		return INSTANCE;
	}

	public JAXBContext getJAXBContext(Class<?> clazz) throws JAXBException {
		JAXBContext context = CONTEXT_CACHE.get(clazz.getName());
		if (context == null) {
			context = JAXBContext.newInstance(clazz);
			CONTEXT_CACHE.putIfAbsent(clazz.getName(), context);
		}
		return context;
	}
}