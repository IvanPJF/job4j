package ru.job4j.mail;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MailTest {



    @Test
    public void whenTwoUsersThisOneUserThenReturnOneUser() {
        Mail mail = new Mail();
        String commonMail = "common@mail.ru";
        Set<String> user1Mails = Set.of("xxx@mail.ru", "yyy@mail.ru", commonMail);
        Set<String> user2Mails = Set.of("zzz@mail.ru", "sss@mail.ru", commonMail);
        User userOne = new User("User1");
        User userTwo = new User("User2");
        userOne.addEmails(user1Mails);
        userTwo.addEmails(user2Mails);
        Set<User> rawUsers = new TreeSet<>(Set.of(userOne, userTwo));
        Set<User> result = mail.mergePossibleUsers(rawUsers);
        User exp = new User("User1");
        exp.addEmails(user1Mails);
        exp.addEmails(user2Mails);
        Set<User> expected = new HashSet<>(Set.of(exp));
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoUsersThisTwoUsersThenReturnTwoUsers() {
        Mail mail = new Mail();
        Set<String> user1Mails = Set.of("xxx@mail.ru", "yyy@mail.ru");
        Set<String> user2Mails = Set.of("zzz@mail.ru", "sss@mail.ru");
        User userOne = new User("User1");
        User userTwo = new User("User2");
        userOne.addEmails(user1Mails);
        userTwo.addEmails(user2Mails);
        Set<User> rawUsers = new TreeSet<>(Set.of(userOne, userTwo));
        Set<User> result = mail.mergePossibleUsers(rawUsers);
        Set<User> expected = new HashSet<>(Set.of(userOne, userTwo));
        assertThat(result, is(expected));
    }
}