package org.example.customer;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService{
    private static final Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());
    @Override
    public List<Customer> processInputData(StringBuilder inputLines) {
        String[] splitLines = inputLines.toString().split("\\s+");
        List<Customer> customers = new ArrayList<>();
        for (String line : splitLines) {
            String[] data = line.split(",");
            if (data.length == 6) {
                int buildDuration = Integer.parseInt(data[5].replaceAll("s", ""));
                customers.add(new Customer(Long.parseLong(data[0]), Long.parseLong(data[1]), data[2], data[3], data[4], buildDuration));
            }
            else {
                logger.log(Level.SEVERE, "Customer data incorrect for "+ line);
                throw new RuntimeException("Customer data incorrect for "+ line);
            }
        }
        return customers;
    }

    @Override
    public Map<Long, Integer> calculateUniqueCustomerForEachContract(List<Customer> customers) {
        logger.info("Number of unique customerId for each contractId:");
        Map<Long, Integer> result = new HashMap<>();
        customers.stream().collect(Collectors.groupingBy(Customer::getContractId, Collectors.toSet())).forEach(
                (key, value) -> result.put(key, value.stream().map(Customer::getCustomerId).collect(Collectors.toSet()).size())
        );
        for (Map.Entry<Long, Integer> entry : result.entrySet()) {
            logger.info(entry.getKey() + " : " + entry.getValue());
        }
        return result;
    }

    @Override
    public Map<String, Double> calculateAverageBuildDurationForEachGeoZone(List<Customer> customers) {
        logger.info("Average build duration for each geo zone:");
        Map<String, Double> result  = customers.stream().collect(Collectors.groupingBy(Customer::getGeoZone,
                Collectors.averagingDouble(Customer::getBuildDuration)));
        for (Map.Entry<String, Double> entry : result.entrySet()) {
            logger.info(entry.getKey() + " : " + entry.getValue());
        }
        return result;
    }

    @Override
    public Map<String, Set<Long>> fetchUniqueCustomerIdsForEachGeoZone(List<Customer> customers) {
        logger.info("List of unique customerId for each geo zone:");
        Map<String, Set<Long>> result = new HashMap<>();
        customers.stream().collect(Collectors.groupingBy(Customer::getGeoZone, Collectors.toSet())).forEach(
                (key, value) -> result.put(key, value.stream().map(Customer::getCustomerId).collect(Collectors.toSet()))
        );
        for (Map.Entry<String, Set<Long>> entry : result.entrySet()) {
            logger.info(entry.getKey() + " : " + entry.getValue());
        }
        return result;
    }
}
