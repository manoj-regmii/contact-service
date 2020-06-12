package org.test.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.test.dtos.ContactDto;
import org.test.dtos.PhoneDto;
import org.test.entities.ContactEntity;
import org.test.entities.PhoneEntity;
import org.test.exceptions.EntityNotFoundException;
import org.test.repositories.ContactRepository;
import org.test.utils.ContactConverter;

@Service
public class ContactService {

	@Autowired
	private ValidationService validationService;
	@Autowired
	private ContactRepository contactRepository;

	public void deleteContact(Long id) {
		contactRepository.deleteById(id);
	}

	public Set<ContactDto> getAllContacts() {

		List<ContactEntity> contactDtos = contactRepository.findAll();
		if (contactDtos == null) {
			throw new EntityNotFoundException();
		}
		return contactDtos.stream().map(d -> ContactConverter.mapContactFromEntity(d)).collect(Collectors.toSet());

	}

	public ContactDto getContactById(Long id) {
		Optional<ContactEntity> resp = contactRepository.findById(id);
		if (!resp.isPresent()) {
			throw new EntityNotFoundException();
		}
		return ContactConverter.mapContactFromEntity(resp.get());
	}

	public ContactDto saveContact(ContactDto contactDetails) {
		validationService.validatePhone(contactDetails);
		ContactEntity contact = ContactConverter.mapContactToEntity(contactDetails);
		return ContactConverter.mapContactFromEntity(contactRepository.save(contact));

	}

	public ContactDto updateContact(Long id, ContactDto contactDetails) {
		validationService.validatePhone(contactDetails);
		Optional<ContactEntity> resp = contactRepository.findById(id);
		if (!resp.isPresent()) {
			throw new EntityNotFoundException();
		} else {
			ContactEntity contactEntity = resp.get();
			update(contactDetails, contactEntity);
			return ContactConverter.mapContactFromEntity(contactRepository.save(contactEntity));
		}
	}

	public void update(ContactDto source, ContactEntity dest) {

		if (!StringUtils.isEmpty(source.getEmail())) {
			dest.setEmail(source.getEmail());
		}

		if (source.getAddress() != null) {
			if (!StringUtils.isEmpty(source.getAddress().getStreet())) {
				dest.getAddress().setStreet(source.getAddress().getStreet());
			}
			if (!StringUtils.isEmpty(source.getAddress().getState())) {
				dest.getAddress().setState(source.getAddress().getState());
			}
			if (!StringUtils.isEmpty(source.getAddress().getZip())) {
				dest.getAddress().setZip(source.getAddress().getZip());
			}
			if (!StringUtils.isEmpty(source.getAddress().getCity())) {
				dest.getAddress().setCity(source.getAddress().getCity());
			}
		}

		if (source.getName() != null) {

			if (!StringUtils.isEmpty(source.getName().getFirst())) {
				dest.setFirstName(source.getName().getFirst());
			}
			if (!StringUtils.isEmpty(source.getName().getMiddle())) {
				dest.setMiddleName(source.getName().getMiddle());
			}
			if (!StringUtils.isEmpty(source.getName().getLast())) {
				dest.setLastName(source.getName().getLast());
			}
		}

		if (source.getPhone() != null) {
			Set<PhoneDto> phone = source.getPhone();
			for (PhoneDto p : phone) {
				PhoneEntity oldPhone = getPhoneFromType(dest.getPhone(), p.getType());
				if (oldPhone != null) {
					if(!p.getNumber().isEmpty()) {
						oldPhone.setNumber(p.getNumber());
					}					
				}
			}
		}

	}

	public PhoneEntity getPhoneFromType(Set<PhoneEntity> phoneSet, String type) {
		for (PhoneEntity p : phoneSet) {
			if (p.getType().equals(type)) {
				return p;
			}
		}
		return null;

	}
}
