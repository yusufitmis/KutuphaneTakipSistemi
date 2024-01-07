create database kutuphaneyonetim;
CREATE TABLE kitaplar (
  kitapID INT NOT NULL AUTO_INCREMENT,
  ISBN VARCHAR(50) NOT NULL,
  kitapAdi VARCHAR(50) NOT NULL,
  yazar VARCHAR(50) NOT NULL,
  durum VARCHAR(20) DEFAULT 'RAFTA',
  PRIMARY KEY (kitapID),
  INDEX idx_kitaplar_durum (durum)
);
CREATE TABLE kullanicilar (
  kullaniciID INT NOT NULL AUTO_INCREMENT,
  adSoyad VARCHAR(50) NOT NULL,
  kullaniciAdi VARCHAR(50) NOT NULL,
  sifre VARCHAR(50) NOT NULL,
  KullaniciTipi VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (kullaniciID)
);
CREATE TABLE odunckitaplar (
  oduncID INT NOT NULL AUTO_INCREMENT,
  kullaniciID INT DEFAULT NULL,
  kitapID INT DEFAULT NULL,
  durum VARCHAR(50) DEFAULT NULL,
  ISBN VARCHAR(50) DEFAULT NULL,
  kitapAdi VARCHAR(50) DEFAULT NULL,
  yazar VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (oduncID),
  INDEX kullaniciID (kullaniciID),
  INDEX kitapID (kitapID),
  INDEX fk_odunckitaplar_durum (durum),
  CONSTRAINT odunckitaplar_ibfk_1 FOREIGN KEY (kullaniciID) REFERENCES kullanicilar (kullaniciID),
  CONSTRAINT odunckitaplar_ibfk_2 FOREIGN KEY (kitapID) REFERENCES kitaplar (kitapID)
);
CREATE TABLE personel (
  personelID INT NOT NULL AUTO_INCREMENT,
  adSoyad VARCHAR(50) NOT NULL,
  kullaniciAdi VARCHAR(50) NOT NULL,
  sifre VARCHAR(50) NOT NULL,
  kullaniciTipi VARCHAR(10) DEFAULT 'personel',
  PRIMARY KEY (personelID)
);
INSERT INTO `kullanicilar` VALUES (9,'Burak Onur','burak67','123','ogrenci'),(10,'Samet Gülsüm','samet41','123','ogrenci'),(11,'Mehmet Barış','mehmet60','123','ogrenci'),(12,'Yusuf İtmiş','yusuf21','123','ogrenci'),(13,'Ali Yıldız','ali1','123','Öğrenci'),(14,'Demir Bilek','demir1','123','Personel'),(15,'Füsun Yavuzer','füsun1','123','ogretimuyesi');
INSERT INTO `kitaplar` VALUES (71,'381234567845','Robot Rüyalar','Bilge Korkmaz','RAFTA'),(74,'7631234567856','Kaybolan Zaman','Baran Erten','RAFTA'),(75,'1281234567857','Sonsuz Hikayeler','Ece Yıldız','RAFTA'),(77,'8711234567862','Gizli Bahçe','Burak Çelik','RAFTA'),(80,'4581234567858','Kelebek Rüyaları','Efe Çetin','RAFTA'),(81,'7781234567843','Paralel Evrenden Gelenler','Selin Avcı','RAFTA'),(82,'9781234218322','Cesur Kalpler','Emre Kaya','RAFTA'),(83,'1978123834','Kırık Düşler','Can Aydın','RAFTA'),(84,'9781234562833','Yalnız Yıldız','Aslı Demir','RAFTA'),(85,'7681234567859','Yıldızların Ardında','Duru Yılmaz','RAFTA'),(90,'9781232178311','Göç Zamanı','Deniz Yılmaz','RAFTA'),(91,'8181234567844','Uzayın Derinlikleri','Kaan Yılmaz','RAFTA'),(92,'1278125567842','Zamanın Kapıları','Beril Karahan','RAFTA'),(93,'7081234567855','Gülen Melekler','Esra Karataş','RAFTA'),(94,'5781234567851','Masallar Diyarı','Demet Arslan','RAFTA'),(95,'2348123456861','Karanlık Yol','Cemre Akçora','RAFTA'),(96,'5781234567853','Rüya Avcıları','Ezgi Şahin','RAFTA'),(97,'1781234567854','Gizemli Orman','Caner Demir','RAFTA'),(98,'381234567845','Robot Rüyalar','Bilge Korkmaz','RAFTA'),(103,'8631234567860','Işığın Peşinde','Kerem Aksoy','RAFTA');
INSERT INTO `personel` VALUES (1,'admin','admin','123','personel'),(2,'Füsun Yavuzer','füsun1','123','personel');