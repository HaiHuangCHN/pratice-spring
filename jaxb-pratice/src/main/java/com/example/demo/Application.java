package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class Application {

	public static void main(String[] args) throws JAXBException, SOAPException, IOException {
		User user = new User();
		user.setId(Long.valueOf(11));
		user.setAddress("testAddress");
		List<Event> list = new ArrayList<Event>();
		Event event1 = new Event();
		event1.setDetail("Accompany girlfriend");
		Date beginDate = new Date();
		event1.setBeginDate(beginDate);
		list.add(event1);
		Event event2 = new Event();
		event2.setDetail("Write code");
		list.add(event2);
		user.setOverinfos(list);
		String xml = JAXBUtil.marshal(user);
		System.out.println(xml);
		user = (User) JAXBUtil.unmarshal(xml, User.class);
		System.out.println(user.getOverinfos().get(0).getDetail());

		SOAPMessage msg = SoapUtil.generateSoapMsg();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		msg.writeTo(out);
		System.out.println(out.toString());

		SOAPMessage soapMsg = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createMessage();
		soapMsg.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "UTF-8");

		SoapUtil.generateSoapMsgHeader(soapMsg);
		ByteArrayOutputStream out2 = new ByteArrayOutputStream();
		msg.writeTo(out2);
		System.out.println(out2.toString());

		JAXBExportSchema2 jaxbExportSchema2 = new JAXBExportSchema2();
		jaxbExportSchema2.genAndOutputXsdFile(User.class, "C:\\schema");
	}

}
