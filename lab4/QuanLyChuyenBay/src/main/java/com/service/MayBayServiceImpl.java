package com.service;

import com.entity.MayBay;
import com.repository.MayBayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MayBayServiceImpl implements MayBayService {
    @Autowired
    private MayBayRepository mayBayRepository;

    @Override
    public int countMayBayByLoaiLike(String loaiMayBay) {
        return mayBayRepository.countMayBayByLoaiLike(loaiMayBay);
    }

    @Override
    public List<String> getMaMBByHoPhiCong(String hoPhiCong) {
        return mayBayRepository.getMaMBByHoPhiCong(hoPhiCong);
    }

    @Override
    public List<MayBay> getMayBayCoTheThucHienChuyenBay(String maCB) {
        return mayBayRepository.getMayBayCoTheThucHienChuyenBay(maCB);
    }
}
