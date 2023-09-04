package ru.unibell.task.domain;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(schema = "unibell", name = "contact")
public class Contact {
    private String type;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Contact contact = (Contact) o;

        if (!getType().equals(contact.getType())) {
            return false;
        }
        return getValue().equals(contact.getValue());
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getValue().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}