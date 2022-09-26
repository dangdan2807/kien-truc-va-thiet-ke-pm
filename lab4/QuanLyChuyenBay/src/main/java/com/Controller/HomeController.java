package com.Controller;

import com.entity.ChungNhan;
import com.entity.ChuyenBay;
import com.entity.MayBay;
import com.entity.NhanVien;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.service.ChungNhanService;
import com.service.ChuyenBayService;
import com.service.MayBayService;
import com.service.NhanVienService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("")
public class HomeController {
    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);
    private static Gson gson = new Gson();
    @Autowired
    private ChuyenBayService chuyenBayService;

    @Autowired
    private MayBayService mayBayService;

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChungNhanService chungNhanService;

    // [GET] /
    @GetMapping("/")
    public String home() {
        return "hello";
    }

    // [GET] /docs
    @GetMapping("/docs")
    public String docs() {
        return "hello";
    }

    // [GET] /insert-db
    @GetMapping("/insert-db")
    public String insertDb() {
        List<ChuyenBay> dsChuyenBay = new ArrayList<>();
        dsChuyenBay.add(new ChuyenBay("VN216", "SGN", "DIN", 4170, Time.valueOf("10:30:00"), Time.valueOf("14:20:00"), 26));
        dsChuyenBay.add(new ChuyenBay("VN254", "SGN", "HUI", 8765, Time.valueOf("18:40:00"), Time.valueOf("20:00:00"), 781));
        dsChuyenBay.add(new ChuyenBay("VN269", "HAN", "CXR", 1262, Time.valueOf("14:10:00"), Time.valueOf("15:50:00"), 202));
        dsChuyenBay.add(new ChuyenBay("VN276", "DAD", "CXR", 1283, Time.valueOf("09:00:00"), Time.valueOf("12:00:00"), 203));
        dsChuyenBay.add(new ChuyenBay("VN280", "SGN", "HPH", 11979, Time.valueOf("06:00:00"), Time.valueOf("08:00:00"), 1279));
        dsChuyenBay.add(new ChuyenBay("VN315", "HAN", "DAD", 134, Time.valueOf("11:45:00"), Time.valueOf("13:00:00"), 112));
        dsChuyenBay.add(new ChuyenBay("VN317", "HAN", "UIH", 827, Time.valueOf("15:00:00"), Time.valueOf("16:15:00"), 190));
        dsChuyenBay.add(new ChuyenBay("VN320", "SGN", "DAD", 2798, Time.valueOf("06:00:00"), Time.valueOf("07:10:00"), 221));
        dsChuyenBay.add(new ChuyenBay("VN338", "SGN", "BMV", 4081, Time.valueOf("15:25:00"), Time.valueOf("16:25:00"), 375));
        dsChuyenBay.add(new ChuyenBay("VN374", "HAN", "VII", 510, Time.valueOf("11:40:00"), Time.valueOf("13:25:00"), 120));
        dsChuyenBay.add(new ChuyenBay("VN375", "VII", "CXR", 752, Time.valueOf("14:15:00"), Time.valueOf("16:00:00"), 181));
        dsChuyenBay.add(new ChuyenBay("VN431", "SGN", "CAH", 3693, Time.valueOf("05:55:00"), Time.valueOf("06:55:00"), 236));
        dsChuyenBay.add(new ChuyenBay("VN440", "SGN", "BMV", 4081, Time.valueOf("18:30:00"), Time.valueOf("19:30:00"), 426));
        dsChuyenBay.add(new ChuyenBay("VN464", "SGN", "DLI", 2002, Time.valueOf("07:20:00"), Time.valueOf("08:05:00"), 225));
        dsChuyenBay.add(new ChuyenBay("VN474", "PXU", "PQC", 1586, Time.valueOf("08:40:00"), Time.valueOf("11:20:00"), 102));
        dsChuyenBay.add(new ChuyenBay("VN476", "UIH", "PQC", 485, Time.valueOf("09:15:00"), Time.valueOf("11:50:00"), 117));
        dsChuyenBay.add(new ChuyenBay("VN651", "DAD", "SGN", 2798, Time.valueOf("19:30:00"), Time.valueOf("08:00:00"), 221));
        dsChuyenBay.add(new ChuyenBay("VN741", "HAN", "PXU", 395, Time.valueOf("06:30:00"), Time.valueOf("08:30:00"), 120));

        chuyenBayService.insertChuyenBays(dsChuyenBay);

        List<MayBay> dsMayBay = new ArrayList<>();
        dsMayBay.add(new MayBay(154, "Tupolev 154", 6565));
        dsMayBay.add(new MayBay(319, "Airbus A319", 2888));
        dsMayBay.add(new MayBay(320, "Airbus A320", 4168));
        dsMayBay.add(new MayBay(340, "Airbus A340 - 300", 11392));
        dsMayBay.add(new MayBay(727, "Boeing 727", 2406));
        dsMayBay.add(new MayBay(737, "Boeing 737 - 800", 5413));
        dsMayBay.add(new MayBay(747, "Boeing 747 - 400", 13488));
        dsMayBay.add(new MayBay(757, "Boeing 757 - 300", 6416));
        dsMayBay.add(new MayBay(767, "Boeing 767 - 400ER", 10360));
        dsMayBay.add(new MayBay(777, "Boeing 777 - 300", 10306));

        mayBayService.insertMayBays(dsMayBay);

        List<NhanVien> dsNhanvien = new ArrayList<>();

        dsNhanvien.add(new NhanVien("011564812", "Ton Van Quy", 153972));
        dsNhanvien.add(new NhanVien("141582651", "Doan Thi Mai", 178345));
        dsNhanvien.add(new NhanVien("142519864", "Nguyen Thi Xuan Dao", 227489));
        dsNhanvien.add(new NhanVien("159542516", "Le Van Ky", 48250));
        dsNhanvien.add(new NhanVien("242518965", "Tran Van Son", 120433));
        dsNhanvien.add(new NhanVien("248965255", "Tran Thi Ba", 43723));
        dsNhanvien.add(new NhanVien("254099823", "Nguyen Thi Quynh", 24450));
        dsNhanvien.add(new NhanVien("269734834", "Truong Tuan Anh", 289950));
        dsNhanvien.add(new NhanVien("274878974", "Mai Quoc Minh", 99890));
        dsNhanvien.add(new NhanVien("287321212", "Duong Van Minh", 48090));
        dsNhanvien.add(new NhanVien("310454876", "Ta Van Do", 212156));
        dsNhanvien.add(new NhanVien("310454877", "Tran Van Hao", 33546));
        dsNhanvien.add(new NhanVien("348121549", "Nguyen Van Thanh", 32899));
        dsNhanvien.add(new NhanVien("355548984", "Tran Thi Hoai An", 212156));
        dsNhanvien.add(new NhanVien("356187925", "Nguyen Vinh Bao", 44740));
        dsNhanvien.add(new NhanVien("390487451", "Le Van Luat", 212156));
        dsNhanvien.add(new NhanVien("489221823", "Bui Quoc Chinh", 23980));
        dsNhanvien.add(new NhanVien("489456522", "Nguyen Thi Quy Linh", 127984));
        dsNhanvien.add(new NhanVien("548977562", "Le Van Quy", 84476));
        dsNhanvien.add(new NhanVien("550156548", "Nguyen Thi Cam", 205187));
        dsNhanvien.add(new NhanVien("552455318", "La Que", 101745));
        dsNhanvien.add(new NhanVien("552455348", "Bui Thi Dung", 92013));
        dsNhanvien.add(new NhanVien("567354612", "Quan Cam Ly", 256481));
        dsNhanvien.add(new NhanVien("574489457", "Dui Van Lap", 20));

        nhanVienService.insertNhanViens(dsNhanvien);

        List<ChungNhan> dsChungNhan = new ArrayList<>();

        dsChungNhan.add(new ChungNhan(new NhanVien("269734834"), new MayBay(154)));
        dsChungNhan.add(new ChungNhan(new NhanVien("310454876"), new MayBay(154)));
        dsChungNhan.add(new ChungNhan(new NhanVien("355548984"), new MayBay(154)));
        dsChungNhan.add(new ChungNhan(new NhanVien("574489457"), new MayBay(154)));
        dsChungNhan.add(new ChungNhan(new NhanVien("269734834"), new MayBay(319)));
        dsChungNhan.add(new ChungNhan(new NhanVien("390487451"), new MayBay(319)));
        dsChungNhan.add(new ChungNhan(new NhanVien("552455318"), new MayBay(319)));
        dsChungNhan.add(new ChungNhan(new NhanVien("142519864"), new MayBay(320)));
        dsChungNhan.add(new ChungNhan(new NhanVien("269734834"), new MayBay(320)));
        dsChungNhan.add(new ChungNhan(new NhanVien("390487451"), new MayBay(320)));
        dsChungNhan.add(new ChungNhan(new NhanVien("552455318"), new MayBay(320)));
        dsChungNhan.add(new ChungNhan(new NhanVien("142519864"), new MayBay(340)));
        dsChungNhan.add(new ChungNhan(new NhanVien("269734834"), new MayBay(340)));
        dsChungNhan.add(new ChungNhan(new NhanVien("390487451"), new MayBay(340)));
        dsChungNhan.add(new ChungNhan(new NhanVien("567354612"), new MayBay(340)));
        dsChungNhan.add(new ChungNhan(new NhanVien("269734834"), new MayBay(727)));
        dsChungNhan.add(new ChungNhan(new NhanVien("567354612"), new MayBay(727)));
        dsChungNhan.add(new ChungNhan(new NhanVien("011564812"), new MayBay(737)));
        dsChungNhan.add(new ChungNhan(new NhanVien("141582651"), new MayBay(737)));
        dsChungNhan.add(new ChungNhan(new NhanVien("142519864"), new MayBay(737)));
        dsChungNhan.add(new ChungNhan(new NhanVien("242518965"), new MayBay(737)));
        dsChungNhan.add(new ChungNhan(new NhanVien("269734834"), new MayBay(737)));
        dsChungNhan.add(new ChungNhan(new NhanVien("552455318"), new MayBay(737)));
        dsChungNhan.add(new ChungNhan(new NhanVien("567354612"), new MayBay(737)));
        dsChungNhan.add(new ChungNhan(new NhanVien("142519864"), new MayBay(747)));
        dsChungNhan.add(new ChungNhan(new NhanVien("269734834"), new MayBay(747)));
        dsChungNhan.add(new ChungNhan(new NhanVien("567354612"), new MayBay(747)));
        dsChungNhan.add(new ChungNhan(new NhanVien("011564812"), new MayBay(757)));
        dsChungNhan.add(new ChungNhan(new NhanVien("141582651"), new MayBay(757)));
        dsChungNhan.add(new ChungNhan(new NhanVien("142519864"), new MayBay(757)));
        dsChungNhan.add(new ChungNhan(new NhanVien("242518965"), new MayBay(757)));
        dsChungNhan.add(new ChungNhan(new NhanVien("269734834"), new MayBay(757)));
        dsChungNhan.add(new ChungNhan(new NhanVien("274878974"), new MayBay(757)));
        dsChungNhan.add(new ChungNhan(new NhanVien("567354612"), new MayBay(757)));
        dsChungNhan.add(new ChungNhan(new NhanVien("141582651"), new MayBay(767)));
        dsChungNhan.add(new ChungNhan(new NhanVien("142519864"), new MayBay(767)));
        dsChungNhan.add(new ChungNhan(new NhanVien("269734834"), new MayBay(767)));
        dsChungNhan.add(new ChungNhan(new NhanVien("274878974"), new MayBay(767)));
        dsChungNhan.add(new ChungNhan(new NhanVien("552455318"), new MayBay(767)));
        dsChungNhan.add(new ChungNhan(new NhanVien("567354612"), new MayBay(767)));
        dsChungNhan.add(new ChungNhan(new NhanVien("142519864"), new MayBay(777)));
        dsChungNhan.add(new ChungNhan(new NhanVien("269734834"), new MayBay(777)));
        dsChungNhan.add(new ChungNhan(new NhanVien("567354612"), new MayBay(777)));

        chungNhanService.insertChungNhans(dsChungNhan);

        return "ok";
    }

}
