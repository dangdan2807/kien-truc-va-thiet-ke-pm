package com.server;

import com.entity.ChuyenBay;
import com.repository.ChuyenBayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService {
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;

    @Override
    public List<ChuyenBay> getChuyenBayDiDatLat() {
        String maGaDen = "DAD";
        return chuyenBayRepository.searchChuyenBayByGaDen(maGaDen);
    }
}
