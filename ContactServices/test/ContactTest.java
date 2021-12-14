import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
	  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
	      addressTest;
	  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
	      tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

	//Method executed before each @test in the current class
	  @BeforeEach
	  void setUp() {
		  contactId = "123ABC456D";
		    firstNameTest = "Charles";
		    lastNameTest = "Babbage";
		    phoneNumberTest = "5551234567";
		    addressTest = "555 Main st, anytown, USA";
		    tooLongContactId = "123456789012345678";
		    tooLongFirstName = "Charles Babbage";
		    tooLongLastName = "English Mechanical Engineer";
		    tooLongPhoneNumber = "55512341234";
		    tooShortPhoneNumber = "1234567";
		    tooLongAddress = "555 Main st, anytown, anywhere, USA";
	  }

	  @Test //Used to signal that the annotated method is a test method
	  void contactTest() {
	    Contact contact = new Contact();
	    assertAll("constructor",
	              ()
	                  -> assertNotNull(contact.getContactId()),
	              ()
	                  -> assertNotNull(contact.getFirstName()),
	              ()
	                  -> assertNotNull(contact.getLastName()),
	              ()
	                  -> assertNotNull(contact.getPhoneNumber()),
	              () -> assertNotNull(contact.getAddress()));
	  }

	  @Test
	  void contactIdConstructorTest() {
	    Contact contact = new Contact(contactId);
	    assertAll("constructor one",
	              ()
	                  -> assertEquals(contactId, contact.getContactId()),
	              ()
	                  -> assertNotNull(contact.getFirstName()),
	              ()
	                  -> assertNotNull(contact.getLastName()),
	              ()
	                  -> assertNotNull(contact.getPhoneNumber()),
	              () -> assertNotNull(contact.getAddress()));
	  }

	  @Test
	  void contactIdAndFirstNameConstructorTest() {
	    Contact contact = new Contact(contactId, firstNameTest);
	    assertAll("constructor two",
	              ()
	                  -> assertEquals(contactId, contact.getContactId()),
	              ()
	                  -> assertEquals(firstNameTest, contact.getFirstName()),
	              ()
	                  -> assertNotNull(contact.getLastName()),
	              ()
	                  -> assertNotNull(contact.getPhoneNumber()),
	              () -> assertNotNull(contact.getAddress()));
	  }

	  @Test
	  void contactIdAndFullNameConstructorTest() {
	    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
	    assertAll("constructor three",
	              ()
	                  -> assertEquals(contactId, contact.getContactId()),
	              ()
	                  -> assertEquals(firstNameTest, contact.getFirstName()),
	              ()
	                  -> assertEquals(lastNameTest, contact.getLastName()),
	              ()
	                  -> assertNotNull(contact.getPhoneNumber()),
	              () -> assertNotNull(contact.getAddress()));
	  }

	  @Test
	  void contactIdFullNamePhoneNumberConstructorTest() {
	    Contact contact =
	        new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
	    assertAll("constructor four",
	              ()
	                  -> assertEquals(contactId, contact.getContactId()),
	              ()
	                  -> assertEquals(firstNameTest, contact.getFirstName()),
	              ()
	                  -> assertEquals(lastNameTest, contact.getLastName()),
	              ()
	                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
	              () -> assertNotNull(contact.getAddress()));
	  }

	  @Test
	  void allTheProperThingsConstructorTest() {
	    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
	                                  phoneNumberTest, addressTest);
	    assertAll("constructor all",
	              ()
	                  -> assertEquals(contactId, contact.getContactId()),
	              ()
	                  -> assertEquals(firstNameTest, contact.getFirstName()),
	              ()
	                  -> assertEquals(lastNameTest, contact.getLastName()),
	              ()
	                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
	              () -> assertEquals(addressTest, contact.getAddress()));
	  }

	  @Test
	  void updateFirstNameTest() {
	    Contact contact = new Contact();
	    contact.updateFirstName(firstNameTest);
	    assertAll(
	        "first name",
	        ()
	            -> assertEquals(firstNameTest, contact.getFirstName()),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.updateFirstName(null)),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.updateFirstName(tooLongFirstName)));
	  }

	  @Test
	  void updateLastNameTest() {
	    Contact contact = new Contact();
	    contact.updateLastName(lastNameTest);
	    assertAll(
	        "last name",
	        ()
	            -> assertEquals(lastNameTest, contact.getLastName()),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.updateLastName(null)),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.updateLastName(tooLongFirstName)));
	  }

	  @Test
	  void updatePhoneNumberTest() {
	    Contact contact = new Contact();
	    contact.updatePhoneNumber(phoneNumberTest);
	    assertAll("phone number",
	              ()
	                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
	              ()
	                  -> assertThrows(IllegalArgumentException.class,
	                                  () -> contact.updatePhoneNumber(null)),
	              ()
	                  -> assertThrows(
	                      IllegalArgumentException.class,
	                      () -> contact.updatePhoneNumber(tooLongPhoneNumber)),
	              ()
	                  -> assertThrows(
	                      IllegalArgumentException.class,
	                      () -> contact.updatePhoneNumber(tooShortPhoneNumber)),
	              ()
	                  -> assertThrows(IllegalArgumentException.class,
	                                  () -> contact.updatePhoneNumber(contactId)));
	  }

	  @Test
	  void updateAddressTest() {
	    Contact contact = new Contact();
	    contact.updateAddress(addressTest);
	    assertAll("phone number",
	              ()
	                  -> assertEquals(addressTest, contact.getAddress()),
	              ()
	                  -> assertThrows(IllegalArgumentException.class,
	                                  () -> contact.updateAddress(null)),
	              ()
	                  -> assertThrows(IllegalArgumentException.class,
	                                  () -> contact.updateAddress(tooLongAddress)));
	  }

	  @Test
	  void updateContactIdTest() {
	    Contact contact = new Contact();
	    contact.updateContactId(contactId);
	    assertAll(
	        "contact ID",
	        ()
	            -> assertEquals(contactId, contact.getContactId()),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.updateContactId(null)),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.updateContactId(tooLongContactId)));
	  }
	}
	