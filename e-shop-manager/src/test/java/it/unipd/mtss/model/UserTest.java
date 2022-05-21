////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

import it.unipd.mtss.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    User user;

    String name;
    int age;

    @Before
    public void setup() {
        name = "Pompelmo";
        age = 54;

        user = new User(name, age);
    }

    @Test
    public void testGetName() {
        assertEquals(name, user.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(age, user.getAge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        new User(null, age);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeAge() {
        new User(name, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        new User("", age);
    }

    @Test
    public void testEqualsItSelf() {
        assertTrue(user.equals(user));
    }

    @Test
    public void testUserCopyEqualsUser() {
        User user1 = new User(name, age);
        assertTrue(user.equals(user1) && user1.equals(user));
    }

    @Test
    public void testDifferentName() {
        User user1 = new User(name.concat("gg"), age);
        assertFalse(user.equals(user1));
    }

    @Test
    public void testDifferentAge() {
        User user1 = new User(name, age + 5);
        assertFalse(user.equals(user1));
    }

    @Test
    public void testDifferentUser() {
        User user1 = new User(name.concat("gg"), age + 5);
        assertFalse(user.equals(user1));
    }

    @Test
    public void testDifferentThanNull() {
        assertFalse(user.equals(null));
    }

    @Test
    public void testDifferentClass() {
        assertFalse(user.equals(new Object()));
    }

    @Test
    public void testUserUnder18() {
        user = new User(name, 17);
        assertTrue(user.isUnder18());
    }

    @Test
    public void testUserIs18() {
        user = new User(name, 18);
        assertFalse(user.isUnder18());
    }

    @Test
    public void testUserOver18() {
        user = new User(name, 19);
        assertFalse(user.isUnder18());
    }

    @Test
    public void testIsWinner() {
        user = new User("_name1", 17);
        assertTrue(user.isWinner());
    }
    @Test
    public void testHashCode() {
        user = new User("_name1", 17);
        assertEquals(301897024, user.hashCode());
    }

    @Test
    public void testIsNotWinner() {
        user = new User("_name2", 17);
        assertFalse(user.isWinner());
    }


}