package com.way2it.yk.web.dao;


import com.way2it.yk.web.entity.SalerEntity;

import java.util.List;
import java.util.Optional;

public interface SalerDao {
    List<SalerEntity> getAllSalers();

    Optional<SalerEntity> getSalerById(Integer Id);

    void saveSaler(SalerEntity salerEntity);

    void deleteSaler(SalerEntity salerEntity);
}