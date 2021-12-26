package com.airports.api.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Map;

import static com.airports.api.utils.DataUtils.getLongValue;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    private long id;
    private String code;
    private String name;
    private String continent;
    private String wikipediaLink;
    private String keywords;

    public static Country buildCountry(Map<String, String> data) {
        return builder()
                .id(getLongValue(data, "id"))
                .code(data.get("code"))
                .name(data.get("name"))
                .continent(data.get("continent"))
                .wikipediaLink(data.get("wikipedia_link"))
                .keywords(data.get("keywords"))
                .build();
    }
}
