package com.ctrlcutter.frontend.util.provider;

import java.util.List;
import java.util.stream.Collectors;

import com.ctrlcutter.frontend.dtos.HotstringDTO;
import com.ctrlcutter.frontend.entities.hotstring.Hotstring;
import com.ctrlcutter.frontend.entities.hotstring.IHotstringProvider;
import com.ctrlcutter.frontend.util.rest.RestRequestHelper;

public class HotstringProvider implements IHotstringProvider {

    @Override
    public List<Hotstring> provideUserHotstrings() {
        List<HotstringDTO> hotstringDTOs = RestRequestHelper.getAllHotstrings();
        List<Hotstring> hotstrings = hotstringDTOs.stream().map(this::mapHotstringDTOToHotstring).collect(Collectors.toList());
        return hotstrings;
    }

    private Hotstring mapHotstringDTOToHotstring(HotstringDTO hotstringDTO) {
        Hotstring hotstring = new Hotstring(hotstringDTO.getOptions(), hotstringDTO.getCommand(), hotstringDTO.getParameter());
        return hotstring;
    }
}
