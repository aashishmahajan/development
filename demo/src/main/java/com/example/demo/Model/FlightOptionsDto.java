package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@NoArgsConstructor
public class FlightOptionsDto {
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime departs_at;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime arrives_at;
    private OriginFlightInfo origin;
    private DestinationFLightInfo destination;

    public LocalDateTime getDeparts_at() {
        return departs_at;
    }

    public void setDeparts_at(LocalDateTime departs_at) {
        this.departs_at = departs_at;
    }

    public LocalDateTime getArrives_at() {
        return arrives_at;
    }

    public void setArrives_at(LocalDateTime arrives_at) {
        this.arrives_at = arrives_at;
    }

    public OriginFlightInfo getOrigin() {
        return origin;
    }

    public void setOrigin(OriginFlightInfo origin) {
        this.origin = origin;
    }

    public DestinationFLightInfo getDestination() {
        return destination;
    }

    public void setDestination(DestinationFLightInfo destination) {
        this.destination = destination;
    }
}
