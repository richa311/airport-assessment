package com.airports.api.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Map;

import static com.airports.api.utils.DataUtils.getLongValue;
import static com.airports.api.utils.DataUtils.getStringValue;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Runway {

    @Id
    private long id;
    private Long airportRef;
    private String airportIdent;
    private String lengthFt;
    private String widthFt;
    private String surface;
    private String lighted;
    private String closed;
    private String leIdent;
    private String leLatitudeDeg;
    private String leLongitudeDeg;
    private String leElevationFt;
    private String leHeadingDegT;
    private String leDisplacedThresholdFt;
    private String heIdent;
    private String heLatitudeDeg;
    private String heLongitudeDeg;
    private String heElevationFt;
    private String heHeadingDegT;
    private String heDisplacedThresholdFt;

    public static Runway buildRunway(Map<String, String> value) {
        return builder()
                .id(getLongValue(value, "id"))
                .airportRef(getLongValue(value, "airport_ref"))
                .airportIdent(getStringValue(value, "airport_ident"))
                .lengthFt(getStringValue(value, "length_ft"))
                .widthFt(getStringValue(value, "width_ft"))
                .surface(getStringValue(value, "surface"))
                .lighted(getStringValue(value, "lighted"))
                .closed(getStringValue(value, "closed"))
                .leIdent(getStringValue(value, "le_ident"))
                .leLatitudeDeg(getStringValue(value, "le_latitude_deg"))
                .leLongitudeDeg(getStringValue(value, "le_longitude_deg"))
                .leElevationFt(getStringValue(value, "le_elevation_ft"))
                .leHeadingDegT(getStringValue(value, "le_heading_degT"))
                .leDisplacedThresholdFt(getStringValue(value, "le_displaced_threshold_ft"))
                .heIdent(getStringValue(value, "he_ident"))
                .heLatitudeDeg(getStringValue(value, "he_latitude_deg"))
                .heLongitudeDeg(getStringValue(value, "he_longitude_deg"))
                .heElevationFt(getStringValue(value, "he_elevation_ft"))
                .heHeadingDegT(getStringValue(value, "he_heading_degT"))
                .heDisplacedThresholdFt(getStringValue(value, "he_displaced_threshold_ft"))
                .build();
    }
}
