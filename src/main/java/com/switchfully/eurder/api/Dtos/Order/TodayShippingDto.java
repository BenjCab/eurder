package com.switchfully.eurder.api.Dtos.Order;

import com.switchfully.eurder.domain.ItemGroup;

import java.util.List;

public class TodayShippingDto {
    private final List<GetItemGroupDto> groups;
    private final String address;


    public TodayShippingDto(List<GetItemGroupDto> groups, String address) {
        this.groups = groups;
        this.address = address;
    }

    public List<GetItemGroupDto> getGroups() {
        return groups;
    }

    public String getAddress() {
        return address;
    }
}