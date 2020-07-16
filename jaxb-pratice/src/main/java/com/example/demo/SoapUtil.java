package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

public class SoapUtil {

	public static SOAPMessage generateSoapMsg() throws SOAPException {
		SOAPMessage soapMsg = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createMessage();
		soapMsg.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "UTF-8");

		// Envelope
		SOAPEnvelope soapEnvelope = soapMsg.getSOAPPart().getEnvelope();
		SOAPElement ns1 = soapEnvelope.addNamespaceDeclaration("ns1", "http://test/1");
		SOAPElement ns2 = soapEnvelope.addNamespaceDeclaration("ns2", "http://test/2");
		SOAPElement ns3 = soapEnvelope.addNamespaceDeclaration("ns3", "http://test/3");
		SOAPElement ns4 = soapEnvelope.addNamespaceDeclaration("ns4", "http://test/4");

		// Header
		SOAPHeader soapHeader = soapEnvelope.getHeader();
		QName usernameQName = new QName(ns1.getNamespaceURI("ns1"), "username", "ns1");
		soapHeader.addChildElement(usernameQName).setValue("Huang, Hai");
		QName sourceQName = new QName(ns2.getNamespaceURI("ns2"), "source", "ns2");
		SOAPElement sourceElement = soapHeader.addChildElement(sourceQName);
		sourceElement.addChildElement(sourceQName).setValue("EXT");
		sourceElement.setAttribute("attr", "http://attr/1");

		// Body
		SOAPBody soapBody = soapEnvelope.getBody();
		QName ename = new QName(ns3.getNamespaceURI("ns3"), "request", "ns3");
		SOAPElement ele = soapBody.addChildElement(ename);
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("Smith", "friend");
		hashMap.put("Anderson", "friend");
		hashMap.put("Lewis", "friend");
		hashMap.put("Cook", "friend");
		hashMap.put("Cook", "friend");
		for (Map.Entry<String, String> entry : hashMap.entrySet()) {
			ele.addChildElement(new QName(ns4.getNamespaceURI("ns4"), entry.getValue(), "ns4"))
					.setValue(entry.getKey());
		}
		return soapMsg;
	}

	public static void generateSoapMsgHeader(SOAPMessage soapMsg) throws SOAPException {
		// Envelope
		SOAPEnvelope soapEnvelope = soapMsg.getSOAPPart().getEnvelope();
		SOAPElement ns1 = soapEnvelope.addNamespaceDeclaration("ns1", "http://test/1");
		SOAPElement ns2 = soapEnvelope.addNamespaceDeclaration("ns2", "http://test/2");

		// Header
		SOAPHeader soapHeader = soapEnvelope.getHeader();
		QName usernameQName = new QName(ns1.getNamespaceURI("ns1"), "username", "ns1");
		soapHeader.addChildElement(usernameQName).setValue("Huang, Hai");
		QName sourceQName = new QName(ns2.getNamespaceURI("ns2"), "source", "ns2");
		SOAPElement sourceElement = soapHeader.addChildElement(sourceQName);
		sourceElement.addChildElement(sourceQName).setValue("EXT");
		sourceElement.setAttribute("attr", "http://attr/1");
	}

}
