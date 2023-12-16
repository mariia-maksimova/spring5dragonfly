package marinemaks.springframework.spring5dragonfly.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    private String line1;
    private String line2;
    private String city;
    private String county;
    private String country;
    private String postcode;

    @OneToMany(mappedBy = "address")
    private Set<Publisher> publishers = new HashSet<>();;

    public Address() {
    }
    public Address(String line1, String line2, String city, String county, String country, String postcode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", country='" + country + '\'' +
                ", postcode='" + postcode + '\'' +
                ", publishers=" + publishers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!Objects.equals(id, address.id)) return false;
        if (!Objects.equals(line1, address.line1)) return false;
        if (!Objects.equals(line2, address.line2)) return false;
        if (!Objects.equals(city, address.city)) return false;
        if (!Objects.equals(county, address.county)) return false;
        if (!Objects.equals(country, address.country)) return false;
        if (!Objects.equals(postcode, address.postcode)) return false;
        return Objects.equals(publishers, address.publishers);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (line1 != null ? line1.hashCode() : 0);
        result = 31 * result + (line2 != null ? line2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (publishers != null ? publishers.hashCode() : 0);
        return result;
    }
}