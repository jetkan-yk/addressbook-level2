package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "Blk 123, Sin Ming Rd, #32-16A, 567120";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should follow this format: BLOCK, STREET, UNIT, POSTAL CODE";
    public static final String ADDRESS_VALIDATION_REGEX = "[a-zA-Z]{0,5}\\s*\\d{1,3}[a-zA-Z]?\\s*[,]\\s*[0-9a-zA-Z\\s]+\\s*[,]\\s*[#]?\\d{1,3}([-]\\d{1,3})?[a-zA-z]?\\s*[,]\\s*\\d{6}";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
