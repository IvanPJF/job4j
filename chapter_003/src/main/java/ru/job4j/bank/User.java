package ru.job4j.bank;

/**
 * Клиент банка.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 28.10.2018
 *@version 0.1
 */
public class User implements Comparable<User> {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.setName(name);
        this.setPassport(passport);
    }

    @Override
    public int compareTo(User o) {
        int result = this.getName().compareTo(o.getName());
        return result != 0 ? result : this.getPassport().compareTo(o.getPassport());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            User other = (User) obj;
            result = this.getPassport().equals(other.getPassport());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return this.getPassport().hashCode();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
