package ru.work.forum.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "authority", unique = true)
    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Authority authority1 = (Authority) o;
        return id == authority1.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}