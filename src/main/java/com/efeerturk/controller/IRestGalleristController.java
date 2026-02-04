package com.efeerturk.controller;

import com.efeerturk.dto.DtoGallerist;
import com.efeerturk.dto.DtoGalleristIU;

public interface IRestGalleristController {

	public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);
}
