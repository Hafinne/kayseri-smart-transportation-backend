# kayseri-smart-transportation-backend

# 🚌 Kayseri Akıllı Ulaşım Analizörü (Spring Boot)

Bu proje, Kayseri'deki toplu taşıma verimliliğini artırmak amacıyla geliştirilmiş bir backend prototipidir. 

### ✨ Özellikler
* **Akıllı Önerici:** Kullanıcı koordinatlarına göre en yakın durağı hesaplar.
* **Doluluk Analizi:** En yakın duraktaki otobüsler arasından doluluk oranı en düşük olanı önerir.
* **Vibe Coding:** Proje, yapay zeka asistanları (Cursor) kullanılarak hızlı prototipleme ile geliştirilmiştir.

### 🛠 Teknolojiler
* **Java 21 / Spring Boot 3.3.4**
* **MySQL** (Veri saklama ve yönetim)
* **Spring Data JPA & Hibernate** (ORM)
* **Maven** (Bağımlılık yönetimi)

### 🚀 Nasıl Çalıştırılır?
1. MySQL'de `kayseri_ulasim` veritabanını oluşturun.
2. `application.properties` dosyasındaki DB şifresini güncelleyin.
3. `./mvnw spring-boot:run` komutu ile başlatın.


