package org.example.customer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CustomerService {
    /**
     * process Input lines to list of Customer
     * @param inputLines
     * @return list of Customer
     */
    List<Customer> processInputData(StringBuilder inputLines);

    /**
     * calculate Unique Customer For Each Contract
     * @param customers
     * @return
     */
    Map<Long, Integer> calculateUniqueCustomerForEachContract(List<Customer> customers);

    /**
     * calculate Average Build Duration For Each GeoZone
     * @param customers
     * @return
     */
    Map<String, Double> calculateAverageBuildDurationForEachGeoZone(List<Customer> customers);

    /**
     * fetch Unique Customer Ids For Each GeoZone
     * @param customers
     * @return
     */
    Map<String, Set<Long>> fetchUniqueCustomerIdsForEachGeoZone(List<Customer> customers);
}
