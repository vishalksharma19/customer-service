package org.example.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerServiceTest {

    @Test
    void processInputDataTest() {
        StringBuilder inputData = new StringBuilder("2343225,2345,us_east,RedTeam,ProjectApple,3445s " + "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s ");
        List<Customer> expectedCustomers = Arrays.asList(new Customer(2343225,2345, "us_east", "RedTeam", "ProjectApple", 3445),
                new Customer(1223456,2345, "us_west", "BlueTeam", "ProjectBanana", 2211));
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        List<Customer> actualCustomers = customerServiceImpl.processInputData(inputData);
        Assertions.assertThat(expectedCustomers).usingRecursiveComparison()
                .ignoringCollectionOrder().isEqualTo(actualCustomers);

    }

    @Test
    void processInputDataTestWhenInputIsIncorrect() {
        StringBuilder inputData = new StringBuilder("2343225,2345,us_east,RedTeam,ProjectApple,3445s " + "1223456,2345,us_west,BlueTeam,2211s ");
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        assertThrows(RuntimeException.class,
                ()-> customerServiceImpl.processInputData(inputData));
    }

    @Test
    void calculateUniqueCustomerForEachContractTest() {
        Map<Long, Integer> expectedResult = new HashMap<>();
        expectedResult.put(2345L,2);
        List<Customer> customers = Arrays.asList(new Customer(2343225,2345, "us_east", "RedTeam", "ProjectApple", 3445),
                new Customer(1223456,2345, "us_west", "BlueTeam", "ProjectBanana", 2211));
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        Map<Long, Integer> actualResult = customerServiceImpl.calculateUniqueCustomerForEachContract(customers);
        Assertions.assertThat(expectedResult).usingRecursiveComparison()
                .ignoringCollectionOrder().isEqualTo(actualResult);

    }

    @Test
    void calculateAverageBuildDurationForEachGeoZoneTest() {
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("us_east",2828.0);
        List<Customer> customers = Arrays.asList(new Customer(2343225,2345, "us_east", "RedTeam", "ProjectApple", 3445),
                new Customer(1223456,2345, "us_east", "BlueTeam", "ProjectBanana", 2211));
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        Map<String, Double> actualResult = customerServiceImpl.calculateAverageBuildDurationForEachGeoZone(customers);
        Assertions.assertThat(expectedResult).usingRecursiveComparison()
                .ignoringCollectionOrder().isEqualTo(actualResult);

    }

    @Test
    void fetchUniqueCustomerIdsForEachGeoZoneTest() {
        Map<String, Set<Long>> expectedResult = new HashMap<>();
        Set<Long> customerIds = new HashSet<>();
        customerIds.add(2343225L);
        customerIds.add(1223456L);
        expectedResult.put("us_east",customerIds);
        List<Customer> customers = Arrays.asList(new Customer(2343225,2345, "us_east", "RedTeam", "ProjectApple", 3445),
                new Customer(1223456,2345, "us_east", "BlueTeam", "ProjectBanana", 2211));
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        Map<String, Set<Long>> actualResult = customerServiceImpl.fetchUniqueCustomerIdsForEachGeoZone(customers);
        Assertions.assertThat(expectedResult).usingRecursiveComparison()
                .ignoringCollectionOrder().isEqualTo(actualResult);

    }
}
