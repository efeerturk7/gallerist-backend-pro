package com.efeerturk.service;

import com.efeerturk.dto.DtoGallerist;
import com.efeerturk.dto.DtoGalleristIU;

public interface IGalleristService {

	public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);
}
