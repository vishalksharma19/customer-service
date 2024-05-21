package org.example.customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerApplication {
    private final static Logger logger = Logger.getLogger(CustomerApplication.class.getName());

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputLines = new StringBuilder();
        String inputLine;
        try {
            while ((inputLine = reader.readLine()) != null && !inputLine.isEmpty()) {
                inputLines.append(inputLine).append("\n");
            }
            reader.close();
            CustomerServiceImpl customerService = new CustomerServiceImpl();
            //process input to customers
            List<Customer> customers = customerService.processInputData(inputLines);
            //Number of unique customerId for each contractId
            customerService.calculateUniqueCustomerForEachContract(customers);
            //Average build duration for each geo zon
            customerService.calculateAverageBuildDurationForEachGeoZone(customers);
            //List of unique customerId for each geo zone
            customerService.fetchUniqueCustomerIdsForEachGeoZone(customers);
        } catch (IOException ex){
            logger.log(Level.SEVERE, ex.toString(), ex);
        }
    }
}
