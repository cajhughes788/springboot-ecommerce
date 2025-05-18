package com.wgu._8.ecommercebackend.bootstrap;

import com.wgu._8.ecommercebackend.dao.CountryRepository;
import com.wgu._8.ecommercebackend.dao.CustomerRepository;
import com.wgu._8.ecommercebackend.dao.DivisionRepository;
import com.wgu._8.ecommercebackend.entities.Country;
import com.wgu._8.ecommercebackend.entities.Customer;
import com.wgu._8.ecommercebackend.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CountryRepository countryRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, CountryRepository countryRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.countryRepository = countryRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() <= 1) {
            Country country = new Country();
            country.setCountry_name("United States");
            country.setCreateDate(LocalDateTime.now());
            country.setLastUpdate(LocalDateTime.now());
            countryRepository.save(country);

            Division division = new Division();
            division.setDivision_name("California");
            division.setCreateDate(LocalDateTime.now());
            division.setLastUpdate(LocalDateTime.now());
            division.setCountry(country);
            divisionRepository.save(division);

            Customer c1 = new Customer();
            c1.setFirstName("Anna");
            c1.setLastName("Wasson");
            c1.setAddress("11791 Apple St");
            c1.setPostal_code("23256");
            c1.setPhone("123-456-7890");
            c1.setCreateDate(LocalDateTime.now());
            c1.setLastUpdate(LocalDateTime.now());
            c1.setDivision(division);

            Customer c2 = new Customer();
            c2.setFirstName("Seamus");
            c2.setLastName("Kramer");
            c2.setAddress("1600 Marigold Ln");
            c2.setPostal_code("14639");
            c2.setPhone("234-777-8901");
            c2.setCreateDate(LocalDateTime.now());
            c2.setLastUpdate(LocalDateTime.now());
            c2.setDivision(division);

            Customer c3 = new Customer();
            c3.setFirstName("Kellen");
            c3.setLastName("Souza");
            c3.setAddress("1200 Helena St");
            c3.setPostal_code("99333");
            c3.setPhone("208-678-9012");
            c3.setCreateDate(LocalDateTime.now());
            c3.setLastUpdate(LocalDateTime.now());
            c3.setDivision(division);

            Customer c4 = new Customer();
            c4.setFirstName("Mary");
            c4.setLastName("Gardner");
            c4.setAddress("1999 Harry Ave");
            c4.setPostal_code("99056");
            c4.setPhone("509-124-0123");
            c4.setCreateDate(LocalDateTime.now());
            c4.setLastUpdate(LocalDateTime.now());
            c4.setDivision(division);

            Customer c5 = new Customer();
            c5.setFirstName("Ian");
            c5.setLastName("Gallagher");
            c5.setAddress("419 Hughes Ln");
            c5.setPostal_code("83858");
            c5.setPhone("449-820-3334");
            c5.setCreateDate(LocalDateTime.now());
            c5.setLastUpdate(LocalDateTime.now());
            c5.setDivision(division);

            customerRepository.save(c1);
            customerRepository.save(c2);
            customerRepository.save(c3);
            customerRepository.save(c4);
            customerRepository.save(c5);
        }
    }
}
