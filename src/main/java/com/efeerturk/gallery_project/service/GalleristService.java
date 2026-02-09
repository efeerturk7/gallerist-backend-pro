package com.efeerturk.gallery_project.service;

import com.efeerturk.gallery_project.dto.DtoGallerist;
import com.efeerturk.gallery_project.dto.DtoGalleristIU;
import com.efeerturk.gallery_project.enums.MessageType;
import com.efeerturk.gallery_project.exception.BaseException;
import com.efeerturk.gallery_project.exception.ErrorMessage;
import com.efeerturk.gallery_project.mapper.IGalleristMapper;
import com.efeerturk.gallery_project.model.Address;
import com.efeerturk.gallery_project.model.Gallerist;
import com.efeerturk.gallery_project.repository.AddressRepository;
import com.efeerturk.gallery_project.repository.GalleristRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GalleristService {
    private final IGalleristMapper galleristMapper;
    private final GalleristRepository galleristRepository;
    private final AddressRepository addressRepository;

    private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {

        Optional<Address> optAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
        if (optAddress.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristIU.getAddressId().toString()));
        }

        Gallerist gallerist = galleristMapper.toEntity(dtoGalleristIU);
        gallerist.setCreateTime(new Date());
        gallerist.setAddress(optAddress.get());

        return gallerist;

    }


    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {
        Gallerist savedGallerist=galleristRepository.save(createGallerist(dtoGalleristIU));
        return galleristMapper.toDto(savedGallerist);
    }

}
