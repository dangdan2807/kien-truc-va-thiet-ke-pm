package com.service;

import com.repository.MayBayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MayBayServiceImpl implements MayBayService {
    @Autowired
    private MayBayRepository mayBayRepository;

    @Override
    public int countMayBayByLoaiLike(String loaiMayBay) {
        return mayBayRepository.countMayBayByLoaiLike(loaiMayBay);
    }
}
