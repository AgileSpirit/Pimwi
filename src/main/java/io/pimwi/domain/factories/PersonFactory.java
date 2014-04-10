package io.pimwi.domain.factories;

import io.pimwi.domain.entities.Person;

/**
 * User: OCTO-JBU
 * Date: 03/04/2014
 * Time: 10:47
 */
public class PersonFactory {

    public static Person create(String firstName, String lastName, String email, String phoneNumber) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setPhoneNumber(phoneNumber);
        person.setPicture("data:image/jpeg;base64,/9j/4AAQSkZJRgABAgAAAQABAAD//gAEKgD/2wBDAAYEBQYFBAYGBQYHBwYIChAKCgkJChQODwwQFxQYGBcUFhYaHSUfGhsjHBYWICwgIyYnKSopGR8tMC0oMCUoKSj/2wBDAQcHBwoIChMKChMoGhYaKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCj/wgARCABAAEADACIAAREBAhEB/8QAGAABAQEBAQAAAAAAAAAAAAAAAAUEAwb/xAAXAQEBAQEAAAAAAAAAAAAAAAACAAMB/8QAFwEBAQEBAAAAAAAAAAAAAAAAAgADAf/aAAwDAAABEQIRAAAB9kNs2rtSCl4fRSqxBkKq7cmvJp9DDUsagK3VItrNpFeDXMaB1qaQsuoCY9i5B5+iyPn/xAAgEAABAwQCAwAAAAAAAAAAAAACAwQQARESIAAzIjEy/9oACAEAAAEFApBEi4aGIatgvLkMS0a9cO/Wjbqh386Na+UOCupojS6kHSxyKZFxFLCVks6kBDAIiO5oiXP/xAAXEQEBAQEAAAAAAAAAAAAAAAABABAR/9oACAECEQE/AYJNJ0nOby//xAAYEQADAQEAAAAAAAAAAAAAAAAAAQIQMf/aAAgBAREBPwEdEvX0XdonHWqz/8QAIhAAAQMDAwUAAAAAAAAAAAAAARAgIQARUQISMDFBYXGB/9oACAEAAAY/AlxV5JduK3Hdv1dPAGkZX00KWQK8rcdakJkviDX/xAAfEAACAgEFAQEAAAAAAAAAAAABERAhIAAxQVFhgaH/2gAIAQAAAT8hm2NfdOgOSE1iKEgABDFuS/ZiiLu5T3eKSZVQNAsTJ8FmTCkc4dXdnVkksptJacTexvQ9DmMfza//2gAMAwAAARECEQAAEP8ALD//AN5//Uq/1+/2/8QAGhEAAgMBAQAAAAAAAAAAAAAAAAEQETFRQf/aAAgBAhEBPxAs09FODE5MwuxKhqx8n//EABoRAQACAwEAAAAAAAAAAAAAAAEAERAhMVH/2gAIAQERAT8QjDRFWnPacsncO8eMW9sFGyek/8QAIRABAAECBgMBAAAAAAAAAAAAAREQIQAgMUFRYYGRobH/2gAIAQAAAT8QqACLvr9YISGwQBzGaKwoFNO6Rgp0mQ0nK56l+FVZ7PzLPABEQ3aqAhO14tfKbiASDyVK5Pab5Y3KSHBVQwzSdxcjJL4BgDA2GCArbmJEJZwhfHke6QrDdvzBlQSEE4cKA4HQ+Mf/2Q==");
        return person;
    }

    public static Person create(String firstName, String lastName, String email, String phoneNumber, String picture) {
        Person person = create(firstName, lastName, email, phoneNumber);
        person.setPicture(picture);
        return person;
    }
}
