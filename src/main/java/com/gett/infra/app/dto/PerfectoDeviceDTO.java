package com.gett.infra.app.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PerfectoDeviceDTO {

    public int id;
    public int deviceId;
    public String lastDriverScrum;
    public String lastRiderScrum;
    public String lastDriverInstalledApp;
    public String lastRiderInstalledApp;
    public String lastDriverPhoneNumber;
    public String lastRiderPhoneNumber;

}
