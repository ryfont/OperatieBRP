/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "creation_time", nullable = false)
    private Date creationTime;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "modification_time", nullable = false)
    private Date modificationTime;
    
    @Version
    private long version = 0;

    public Long getId() {
        return id;
    }

    /**
     * Gets a builder which is used to create Person objects.
     * @param firstName The first name of the created user.
     * @param lastName  The last name of the created user.
     * @return  A new Builder instance.
     */
    public static Builder getBuilder(String firstName, String lastName) {
        return new Builder(firstName, lastName);
    }
    
    public Date getCreationTime() {
        return creationTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the full name of the person.
     * @return  The full name of the person.
     */
    @Transient
    public String getName() {
        StringBuilder name = new StringBuilder();
        
        name.append(firstName);
        name.append(" ");
        name.append(lastName);
        
        return name.toString();
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public long getVersion() {
        return version;
    }

    public void update(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @PreUpdate
    public void preUpdate() {
        modificationTime = new Date();
    }
    
    @PrePersist
    public void prePersist() {
        Date now = new Date();
        creationTime = now;
        modificationTime = now;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * A Builder class used to create new Person objects.
     */
    public static class Builder {
        Person built;

        /**
         * Creates a new Builder instance.
         * @param firstName The first name of the created Person object.
         * @param lastName  The last name of the created Person object.
         */
        Builder(String firstName, String lastName) {
            built = new Person();
            built.firstName = firstName;
            built.lastName = lastName;
        }

        /**
         * Builds the new Person object.
         * @return  The created Person object.
         */
        public Person build() {
            return built;
        }
    }

    /**
     * This setter method should only be used by unit tests.
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
}