package org.test.services;


import org.springframework.stereotype.Service;
import org.test.dtos.ContactDto;
import org.test.dtos.PhoneDto;
import org.test.exceptions.ContactValidationException;
import org.test.utils.Constants;

@Service
public class ValidationService {

	public void validatePhone(ContactDto contactDetails) {

		if (contactDetails != null && contactDetails.getPhone() != null) {
			for (PhoneDto p : contactDetails.getPhone()) {
				if (!Constants.PHONETYPES.contains(p.getType())) {
					throw new ContactValidationException("Only mobile|home|work allowed for phone type");

				}
			}
		}

	}
}
