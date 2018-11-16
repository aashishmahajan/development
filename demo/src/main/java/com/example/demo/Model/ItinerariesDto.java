package com.example.demo.Model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ItinerariesDto {
    private OutBoundLowFareDto outbound;
    private InboundLowFareDto inbound;

    public InboundLowFareDto getInbound() {
        return inbound;
    }

    public void setInbound(InboundLowFareDto inbound) {
        this.inbound = inbound;
    }

    public OutBoundLowFareDto getOutbound() {
        return outbound;
    }

    public void setOutbound(OutBoundLowFareDto outbound) {
        this.outbound = outbound;
    }
}
