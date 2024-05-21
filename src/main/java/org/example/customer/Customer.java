package org.example.customer;

public class Customer {
    public Customer() {
    }
    private long customerId;
    private long contractId;
    private String geoZone;
    private String teamCode;
    private String projectCode;
    private int buildDuration;

    public Customer(long customerId, long contractId, String geoZone, String teamCode, String projectCode, int buildDuration) {
        this.customerId = customerId;
        this.contractId = contractId;
        this.geoZone = geoZone;
        this.teamCode = teamCode;
        this.projectCode = projectCode;
        this.buildDuration = buildDuration;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public String getGeoZone() {
        return geoZone;
    }

    public void setGeoZone(String geoZone) {
        this.geoZone = geoZone;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public int getBuildDuration() {
        return buildDuration;
    }

    public void setBuildDuration(int buildDuration) {
        this.buildDuration = buildDuration;
    }
}
