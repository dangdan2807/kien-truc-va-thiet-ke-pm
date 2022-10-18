package com.service;

import com.Controller.ChuyenBayController;
import com.entity.ChuyenBay;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService {
    static final String URL_API = "http://localhost:13000/chuyen-bay";
    private static Gson gson = new Gson();

    private static RestTemplate restTemplate = new RestTemplate();
    ;

    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);

    @Override
    public List<ChuyenBay> getChuyenBay() {
        Object[] chuyenbays = restTemplate.getForEntity(URL_API, Object[].class).getBody();
        List<ChuyenBay> arr = new ArrayList<>();
        for (Object item : chuyenbays) {
            arr.add(gson.fromJson(gson.toJson(item), ChuyenBay.class));
        }
        return arr;
    }

    @Override
    public ChuyenBay getChuyenBayById(String maCB) {
        Object chuyenbay = restTemplate.getForEntity(URL_API + "/" + maCB, Object.class).getBody();
        if (chuyenbay == null) {
            return null;
        }
        return gson.fromJson(gson.toJson(chuyenbay), ChuyenBay.class);
    }

    @Override
    public void saveChuyenBay(ChuyenBay chuyenBay) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("maCB", chuyenBay.getMaCB());
        restTemplate.put(URL_API + "/" + chuyenBay.getMaCB(), chuyenBay, params);
    }

    @Override
    public void deleteChuyenBay(String maCB) {
        Map< String, String > params = new HashMap< String, String >();
        params.put("maCB", maCB);
        restTemplate.delete(URL_API + "/" + maCB, params);
    }

    @Override
    public void insertChuyenBay(ChuyenBay chuyenBay) {
        restTemplate.postForEntity(URL_API, chuyenBay, ChuyenBay.class);
    }
}
