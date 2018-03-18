package com.gett.infra.hibernate.pojo.datagenerator;

public class PerfectoDevice {

    private int id;
    private int deviceId;
    private String lastDriverScrum;
    private String lastRiderScrum;
    private String lastDriverInstalledApp;
    private String lastRiderInstalledApp;
    private String lastDriverPhoneNumber;
    private String lastRiderPhoneNumber;

    public PerfectoDevice() {
    }

    public PerfectoDevice(int id, int deviceId, String lastDriverScrum, String lastRiderScrum,
                          String lastDriverInstalledApp, String lastRiderInstalledApp, String lastDriverPhoneNumber, String lastRiderPhoneNumber) {
        this.id = id;
        this.deviceId = deviceId;
        this.lastDriverScrum = lastDriverScrum;
        this.lastRiderScrum = lastRiderScrum;
        this.lastDriverInstalledApp = lastDriverInstalledApp;
        this.lastRiderInstalledApp = lastRiderInstalledApp;
        this.lastDriverPhoneNumber = lastDriverPhoneNumber;
        this.lastRiderPhoneNumber = lastRiderPhoneNumber;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getLastDriverScrum() {
        return lastDriverScrum;
    }

    public void setLastDriverScrum(String lastDriverScrum) {
        this.lastDriverScrum = lastDriverScrum;
    }

    public String getLastRiderScrum() {
        return lastRiderScrum;
    }

    public void setLastRiderScrum(String lastRiderScrum) {
        this.lastRiderScrum = lastRiderScrum;
    }

    public String getLastDriverInstalledApp() {
        return lastDriverInstalledApp;
    }

    public void setLastDriverInstalledApp(String lastDriverInstalledApp) {
        this.lastDriverInstalledApp = lastDriverInstalledApp;
    }

    public String getLastRiderInstalledApp() {
        return lastRiderInstalledApp;
    }

    public void setLastRiderInstalledApp(String lastRiderInstalledApp) {
        this.lastRiderInstalledApp = lastRiderInstalledApp;
    }

    public String getLastDriverPhoneNumber() {
        return lastDriverPhoneNumber;
    }

    public void setLastDriverPhoneNumber(String lastDriverPhoneNumber) {
        this.lastDriverPhoneNumber = lastDriverPhoneNumber;
    }

    public String getLastRiderPhoneNumber() {
        return lastRiderPhoneNumber;
    }

    public void setLastRiderPhoneNumber(String lastRiderPhoneNumber) {
        this.lastRiderPhoneNumber = lastRiderPhoneNumber;
    }
}
