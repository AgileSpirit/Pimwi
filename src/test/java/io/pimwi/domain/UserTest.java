package io.pimwi.domain;

import io.pimwi.domain.entities.User;
import io.pimwi.domain.factories.UserFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * User: OCTO-JBU
 * Date: 02/04/2014
 * Time: 19:33
 */
public class UserTest {

    @Test
    public void testCreate_withLoginAndPassword_shouldBeOk() throws Exception {
        // When
        User actual = UserFactory.create("jdoe", "P@ssw0rd");

        // Then
        // -- User
        Assertions.assertThat(actual.getLogin()).isEqualTo("jdoe");
        Assertions.assertThat(actual.getPassword()).isEqualTo("P@ssw0rd");
        // -- User.identity
        Assertions.assertThat(actual.getIdentity()).isNotNull();
        Assertions.assertThat(actual.getIdentity().getFirstName()).isEqualTo("N/A");
        Assertions.assertThat(actual.getIdentity().getLastName()).isEqualTo("N/A");
        Assertions.assertThat(actual.getIdentity().getEmail()).isEqualTo("N/A");
        Assertions.assertThat(actual.getIdentity().getPhoneNumber()).isEqualTo("N/A");
        // -- User.contacts
        Assertions.assertThat(actual.getFriends()).isEmpty();
    }

    @Test
    public void testCreate_withCharacteristics_shouldBeOk() throws Exception {
        // Given
        Map<String, String> characteristics = new HashMap<>();
        characteristics.put(UserFactory.LOGIN, "jdoe");
        characteristics.put(UserFactory.PASSWORD, "P@ssw0rd");
        characteristics.put(UserFactory.FIRST_NAME, "John");
        characteristics.put(UserFactory.LAST_NAME, "Doe");
        characteristics.put(UserFactory.EMAIL, "john.doe@mail.com");
        characteristics.put(UserFactory.PHONE_NUMBER, "0123456789");

        // When
        User actual = UserFactory.create(characteristics);

        // Then
        // -- User
        Assertions.assertThat(actual.getLogin()).isEqualTo("jdoe");
        Assertions.assertThat(actual.getPassword()).isEqualTo("P@ssw0rd");
        // -- User.identity
        Assertions.assertThat(actual.getIdentity()).isNotNull();
        Assertions.assertThat(actual.getIdentity().getFirstName()).isEqualTo("John");
        Assertions.assertThat(actual.getIdentity().getLastName()).isEqualTo("Doe");
        Assertions.assertThat(actual.getIdentity().getEmail()).isEqualTo("john.doe@mail.com");
        Assertions.assertThat(actual.getIdentity().getPhoneNumber()).isEqualTo("0123456789");
        // -- User.contacts
        Assertions.assertThat(actual.getFriends()).isEmpty();
    }

}