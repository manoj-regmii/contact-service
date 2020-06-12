package org.test.controllers;

import java.util.HashSet;
import java.util.Set;

import org.test.dtos.AddressDto;
import org.test.dtos.ContactDto;
import org.test.dtos.NameDto;
import org.test.dtos.PhoneDto;

public class TestUtils {

	public static ContactDto dummyContact() {
		ContactDto c = new ContactDto();
		c.setEmail("yadav.bastola@yahoo.com");
		c.setId(1l);

		NameDto name = new NameDto();
		name.setFirst("Yadav");
		name.setLast("Banstola");
		c.setName(name);

		Set<PhoneDto> phoneDtos = new HashSet<>();
		PhoneDto homePhone = new PhoneDto();
		homePhone.setNumber("302-532-9427");
		homePhone.setType("mobile");

		PhoneDto workPhone = new PhoneDto();
		homePhone.setNumber("302-611-9148");
		homePhone.setType("home");
		phoneDtos.add(homePhone);
		phoneDtos.add(workPhone);

		c.setPhone(phoneDtos);

		AddressDto addressDto = new AddressDto();
		addressDto.setStreet("2751 prosperity ave");
		addressDto.setCity("Cannon");
		addressDto.setState("Delaware");
		addressDto.setZip(19797);
		c.setAddress(addressDto);

		return c;
	}

	public static ContactDto dummyContactResponse() {
		ContactDto c = new ContactDto();
		c.setEmail("regmi.asde@yahoo.com");
		c.setId(1l);

		NameDto name = new NameDto();
		name.setFirst("Manoj");
		name.setLast("Regmi");
		c.setName(name);

		Set<PhoneDto> phoneDtos = new HashSet<>();
		PhoneDto homePhone = new PhoneDto();
		homePhone.setNumber("123-456-9427");
		homePhone.setType("mobile");

		PhoneDto workPhone = new PhoneDto();
		homePhone.setNumber("222-234-2345");
		homePhone.setType("home");
		phoneDtos.add(homePhone);
		phoneDtos.add(workPhone);

		c.setPhone(phoneDtos);

		AddressDto addressDto = new AddressDto();
		addressDto.setStreet("9075 lee highway");
		addressDto.setCity("Fairfax");
		addressDto.setState("Virginia");
		addressDto.setZip(22031);
		c.setAddress(addressDto);

		return c;
	}

	public static String dummyContactresponse() {

		return "{\n" + "\"name\": {\n" + "\"first\": \"Manoj\",\n" + "\"last\": \"Regmi\",\n" + "\"middle\": \"Bdr\"\n"
				+ "},\n" + "\"address\": {\n" + "\"street\": \"9075 lee highway\",\n" + "\"city\": \"Fairfax\",\n"
				+ "\"state\": \"Virginia\",\n" + "\"zip\": 22031\n" + "},\n" + "\"phone\": [\n" + "{\n"
				+ "\"number\": \"123-456-9427\",\n" + "\"type\": \"mobile\"\n" + "},\n" + "{\n"
				+ "\"number\": \"222-234-2345\",\n" + "\"type\": \"home\"\n" + "}\n" + "],\n"
				+ "\"email\": \"regmi.asde@yahoo.com\"\n" + "}\n";
	}

	public static String dummySaveContactrequest() {

		return "{\n" + "\"name\": {\n" + "\"first\": \"Manoj\",\n" + "\"last\": \"Regmi\",\n" + "\"middle\": \"Bdr\"\n"
				+ "},\n" + "\"address\": {\n" + "\"street\": \"9075 lee highway\",\n" + "\"city\": \"Fairfax\",\n"
				+ "\"state\": \"Virginia\",\n" + "\"zip\": 22031\n" + "},\n" + "\"phone\": [\n" + "{\n"
				+ "\"number\": \"123-456-9427\",\n" + "\"type\": \"mobile\"\n" + "},\n" + "{\n"
				+ "\"number\": \"222-234-2345\",\n" + "\"type\": \"home\"\n" + "}\n" + "],\n"
				+ "\"email\": \"regmi.asde@yahoo.com\"\n" + "}\n";
	}
	
	public static String dummyAllContactsResponse() {
		return "[\n" + "{\n" + "\"name\": {\n" + "\"first\": \"Manoj\",\n" + "\"last\": \"Regmi\",\n" + "\"middle\": \"Bdr\"\n"
				+ "},\n" + "\"address\": {\n" + "\"street\": \"9075 lee highway\",\n" + "\"city\": \"Fairfax\",\n"
				+ "\"state\": \"Virginia\",\n" + "\"zip\": 22031\n" + "},\n" + "\"phone\": [\n" + "{\n"
				+ "\"number\": \"123-456-9427\",\n" + "\"type\": \"mobile\"\n" + "},\n" + "{\n"
				+ "\"number\": \"222-234-2345\",\n" + "\"type\": \"home\"\n" + "}\n" + "],\n"
				+ "\"email\": \"regmi.asde@yahoo.com\"\n" + "}\n" + "]\n";
				
				
	}
}
