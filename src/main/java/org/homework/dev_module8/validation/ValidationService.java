package org.homework.dev_module8.validation;

public class ValidationService {

    public void validateId(long id) throws ValidationException {
        if (id < 1) {
            throw new ValidationException("Id less then 0");
        }
    }

    public void validateName(String name) throws ValidationException {
        if (name.length() < 2 || name.length() > 16) {
            throw new ValidationException("Name length incorrect");
        } else if (name.chars().anyMatch(Character::isDigit)) {
            throw new ValidationException("Name contain digit");
        }
    }
}
