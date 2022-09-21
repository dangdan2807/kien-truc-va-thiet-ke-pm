CREATE database QLChuyenBay;

use QLChuyenBay;

-- Table structure for chuyenbay
-- ----------------------------
DROP TABLE IF EXISTS chuyenbay;
CREATE TABLE chuyenbay (
  MaCB varchar(5) NOT NULL,
  GaDi varchar(50) DEFAULT NULL,
  GaDen varchar(50) DEFAULT NULL,
  DoDai integer DEFAULT NULL,
  GioDi time DEFAULT NULL,
  GioDen time DEFAULT NULL,
  ChiPhi integer DEFAULT NULL,
  PRIMARY KEY (MaCB)
);


-- ----------------------------
-- Records of chuyenbay
-- ----------------------------
INSERT INTO chuyenbay VALUES ('VN216', 'SGN', 'DIN', 4170, '10:30:00', '14:20:00', 262);
INSERT INTO chuyenbay VALUES ('VN254', 'SGN', 'HUI', 8765, '18:40:00', '20:00:00', 781);
INSERT INTO chuyenbay VALUES ('VN269', 'HAN', 'CXR', 1262, '14:10:00', '15:50:00', 202);
INSERT INTO chuyenbay VALUES ('VN276', 'DAD', 'CXR', 1283, '09:00:00', '12:00:00', 203);
INSERT INTO chuyenbay VALUES ('VN280', 'SGN', 'HPH', 11979, '06:00:00', '08:00:00', 1279);
INSERT INTO chuyenbay VALUES ('VN315', 'HAN', 'DAD', 134, '11:45:00', '13:00:00', 112);
INSERT INTO chuyenbay VALUES ('VN317', 'HAN', 'UIH', 827, '15:00:00', '16:15:00', 190);
INSERT INTO chuyenbay VALUES ('VN320', 'SGN', 'DAD', 2798, '06:00:00', '07:10:00', 221);
INSERT INTO chuyenbay VALUES ('VN338', 'SGN', 'BMV', 4081, '15:25:00', '16:25:00', 375);
INSERT INTO chuyenbay VALUES ('VN374', 'HAN', 'VII', 510, '11:40:00', '13:25:00', 120);
INSERT INTO chuyenbay VALUES ('VN375', 'VII', 'CXR', 752, '14:15:00', '16:00:00', 181);
INSERT INTO chuyenbay VALUES ('VN431', 'SGN', 'CAH', 3693, '05:55:00', '06:55:00', 236);
INSERT INTO chuyenbay VALUES ('VN440', 'SGN', 'BMV', 4081, '18:30:00', '19:30:00', 426);
INSERT INTO chuyenbay VALUES ('VN464', 'SGN', 'DLI', 2002, '07:20:00', '08:05:00', 225);
INSERT INTO chuyenbay VALUES ('VN474', 'PXU', 'PQC', 1586, '08:40:00', '11:20:00', 102);
INSERT INTO chuyenbay VALUES ('VN476', 'UIH', 'PQC', 485, '09:15:00', '11:50:00', 117);
INSERT INTO chuyenbay VALUES ('VN651', 'DAD', 'SGN', 2798, '19:30:00', '08:00:00', 221);
INSERT INTO chuyenbay VALUES ('VN741', 'HAN', 'PXU', 395, '06:30:00', '08:30:00', 120);

-- ----------------------------
-- Table structure for maybay
-- ----------------------------
DROP TABLE IF EXISTS maybay;
CREATE TABLE maybay (
  MaMB integer NOT NULL DEFAULT '0',
  Loai varchar(50) DEFAULT NULL,
  TamBay integer DEFAULT NULL,
  PRIMARY KEY (MaMB)
);

-- ----------------------------
-- Records of maybay
-- ----------------------------
INSERT INTO maybay VALUES ('154', 'Tupolev 154', 6565);
INSERT INTO maybay VALUES ('319', 'Airbus A319', 2888);
INSERT INTO maybay VALUES ('320', 'Airbus A320', 4168);
INSERT INTO maybay VALUES ('340', 'Airbus A340 - 300', 11392);
INSERT INTO maybay VALUES ('727', 'Boeing 727', 2406);
INSERT INTO maybay VALUES ('737', 'Boeing 737 - 800', 5413);
INSERT INTO maybay VALUES ('747', 'Boeing 747 - 400', 13488);
INSERT INTO maybay VALUES ('757', 'Boeing 757 - 300', 6416);
INSERT INTO maybay VALUES ('767', 'Boeing 767 - 400ER', 10360);
INSERT INTO maybay VALUES ('777', 'Boeing 777 - 300', 10306);

-- ----------------------------
-- Table structure for nhanvien
-- ----------------------------
DROP TABLE IF EXISTS nhanvien;
CREATE TABLE nhanvien (
  MaNV varchar(9) NOT NULL DEFAULT '',
  Ten varchar(50) DEFAULT NULL,
  Luong integer DEFAULT NULL,
  PRIMARY KEY (MaNV)
);

-- ----------------------------
-- Records of nhanvien
-- ----------------------------
INSERT INTO nhanvien VALUES ('011564812', 'Ton Van Quy', 153972);
INSERT INTO nhanvien VALUES ('141582651', 'Doan Thi Mai', 178345);
INSERT INTO nhanvien VALUES ('142519864', 'Nguyen Thi Xuan Dao', 227489);
INSERT INTO nhanvien VALUES ('159542516', 'Le Van Ky', 48250);
INSERT INTO nhanvien VALUES ('242518965', 'Tran Van Son', 120433);
INSERT INTO nhanvien VALUES ('248965255', 'Tran Thi Ba', 43723);
INSERT INTO nhanvien VALUES ('254099823', 'Nguyen Thi Quynh', 24450);
INSERT INTO nhanvien VALUES ('269734834', 'Truong Tuan Anh', 289950);
INSERT INTO nhanvien VALUES ('274878974', 'Mai Quoc Minh', 99890);
INSERT INTO nhanvien VALUES ('287321212', 'Duong Van Minh', 48090);
INSERT INTO nhanvien VALUES ('310454876', 'Ta Van Do', 212156);
INSERT INTO nhanvien VALUES ('310454877', 'Tran Van Hao', 33546);
INSERT INTO nhanvien VALUES ('348121549', 'Nguyen Van Thanh', 32899);
INSERT INTO nhanvien VALUES ('355548984', 'Tran Thi Hoai An', 212156);
INSERT INTO nhanvien VALUES ('356187925', 'Nguyen Vinh Bao', 44740);
INSERT INTO nhanvien VALUES ('390487451', 'Le Van Luat', 212156);
INSERT INTO nhanvien VALUES ('489221823', 'Bui Quoc Chinh', 23980);
INSERT INTO nhanvien VALUES ('489456522', 'Nguyen Thi Quy Linh', 127984);
INSERT INTO nhanvien VALUES ('548977562', 'Le Van Quy', 84476);
INSERT INTO nhanvien VALUES ('550156548', 'Nguyen Thi Cam', 205187);
INSERT INTO nhanvien VALUES ('552455318', 'La Que', 101745);
INSERT INTO nhanvien VALUES ('552455348', 'Bui Thi Dung', 92013);
INSERT INTO nhanvien VALUES ('567354612', 'Quan Cam Ly', 256481);
INSERT INTO nhanvien VALUES ('574489457', 'Dui Van Lap', 20);

-- ----------------------------
-- Table structure for chungnhan
-- ----------------------------
DROP TABLE IF EXISTS chungnhan;
CREATE TABLE chungnhan (
  MaNV varchar(9) NOT NULL DEFAULT '',
  MaMB integer NOT NULL DEFAULT '0',
  PRIMARY KEY (MaNV,MaMB),
  CONSTRAINT FK_CN1 FOREIGN KEY (MaNV) REFERENCES nhanvien (MaNV),
  CONSTRAINT FK_CN2 FOREIGN KEY (MaMB) REFERENCES maybay (MaMB)
);

-- ----------------------------
-- Records of chungnhan
-- ----------------------------
INSERT INTO chungnhan VALUES ('269734834', '154');
INSERT INTO chungnhan VALUES ('310454876', '154');
INSERT INTO chungnhan VALUES ('355548984', '154');
INSERT INTO chungnhan VALUES ('574489457', '154');
INSERT INTO chungnhan VALUES ('269734834', '319');
INSERT INTO chungnhan VALUES ('390487451', '319');
INSERT INTO chungnhan VALUES ('552455318', '319');
INSERT INTO chungnhan VALUES ('142519864', '320');
INSERT INTO chungnhan VALUES ('269734834', '320');
INSERT INTO chungnhan VALUES ('390487451', '320');
INSERT INTO chungnhan VALUES ('552455318', '320');
INSERT INTO chungnhan VALUES ('142519864', '340');
INSERT INTO chungnhan VALUES ('269734834', '340');
INSERT INTO chungnhan VALUES ('390487451', '340');
INSERT INTO chungnhan VALUES ('567354612', '340');
INSERT INTO chungnhan VALUES ('269734834', '727');
INSERT INTO chungnhan VALUES ('567354612', '727');
INSERT INTO chungnhan VALUES ('011564812', '737');
INSERT INTO chungnhan VALUES ('141582651', '737');
INSERT INTO chungnhan VALUES ('142519864', '737');
INSERT INTO chungnhan VALUES ('242518965', '737');
INSERT INTO chungnhan VALUES ('269734834', '737');
INSERT INTO chungnhan VALUES ('552455318', '737');
INSERT INTO chungnhan VALUES ('567354612', '737');
INSERT INTO chungnhan VALUES ('142519864', '747');
INSERT INTO chungnhan VALUES ('269734834', '747');
INSERT INTO chungnhan VALUES ('567354612', '747');
INSERT INTO chungnhan VALUES ('011564812', '757');
INSERT INTO chungnhan VALUES ('141582651', '757');
INSERT INTO chungnhan VALUES ('142519864', '757');
INSERT INTO chungnhan VALUES ('242518965', '757');
INSERT INTO chungnhan VALUES ('269734834', '757');
INSERT INTO chungnhan VALUES ('274878974', '757');
INSERT INTO chungnhan VALUES ('567354612', '757');
INSERT INTO chungnhan VALUES ('141582651', '767');
INSERT INTO chungnhan VALUES ('142519864', '767');
INSERT INTO chungnhan VALUES ('269734834', '767');
INSERT INTO chungnhan VALUES ('274878974', '767');
INSERT INTO chungnhan VALUES ('552455318', '767');
INSERT INTO chungnhan VALUES ('567354612', '767');
INSERT INTO chungnhan VALUES ('142519864', '777');
INSERT INTO chungnhan VALUES ('269734834', '777');
INSERT INTO chungnhan VALUES ('567354612', '777');

