package com.airports.api.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Map;

import static com.airports.api.utils.DataUtils.getLongValue;
import static com.airports.api.utils.DataUtils.getStringValue;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id
    private long id;
    private String ident;
    private String type;
    private String name;
    private String latitudeDeg;
    private String longitudeDeg;
    private String elevationFt;
    private String continent;
    private String isoCountry;
    private String isoRegion;
    private String municipality;
    private String scheduledService;
    private String gpsCode;
    private String iataCode;
    private String localCode;
    private String homeLink;
    private String wikipediaLink;
    @Lob
    @Column(length = 1024)
    private String keywords;

    public static Airport buildAirport(Map<String, String> value) {
        return builder()
                .id(getLongValue(value, "id"))
                .ident(getStringValue(value, "ident"))
                .type(getStringValue(value, "type"))
                .name(getStringValue(value, "name"))
                .latitudeDeg(getStringValue(value, "latitude_deg"))
                .longitudeDeg(getStringValue(value, "longitude_deg"))
                .elevationFt(getStringValue(value, "elevation_ft"))
                .continent(getStringValue(value, "continent"))
                .isoCountry(getStringValue(value, "iso_country"))
                .isoRegion(getStringValue(value, "iso_region"))
                .municipality(getStringValue(value, "municipality"))
                .scheduledService(getStringValue(value, "scheduled_service"))
                .gpsCode(getStringValue(value, "gps_code"))
                .iataCode(getStringValue(value, "iata_code"))
                .localCode(getStringValue(value, "local_code"))
                .homeLink(getStringValue(value, "home_link"))
                .wikipediaLink(getStringValue(value, "wikipedia_link"))
                .keywords(getStringValue(value, "keywords"))
                .build();
    }
}
