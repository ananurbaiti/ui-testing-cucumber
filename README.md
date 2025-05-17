# 🚀 UI Testing Framework with Cucumber & Selenium

Ini adalah framework untuk otomatisasi pengujian UI berbasis Selenium dan Cucumber

## ✨ Fitur Utama
- Automasi pengujian UI untuk fitur signup menggunakan Selenium WebDriver.
- BDD dengan Cucumber untuk menulis skenario pengujian yang mudah dibaca.
- Page Object Model (POM) untuk struktur kode yang rapi dan mudah dipelihara.
- Penanganan alert dan popup secara otomatis.
- Hooks untuk setup dan teardown pengujian.
- Skema pengujian positif & negatif

## 💻 Teknologi yang Digunakan
- Java 17 (OpenJDK 64-Bit Server VM 23.0.2+7-58)
- Selenium WebDriver
- Cucumber
- Gradle
- WebDriverManager
- JUnit
- IntelliJ IDEA

## 🗂️ Struktur Proyek
```
web-ui-automation21/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/                         # Kelas-kelas halaman utama
│   │   │   │   ├── BasePage.java              # Kelas dasar halaman
│   │   │   │   ├── HomePage.java              # Halaman beranda
│   │   │   │   └── components/                # Komponen kecil pada halaman
│   │   │   │       └── PopUpSignUp.java       # Komponen popup signup
│   │   │   └── utilities/                     # Utilitas pendukung
│   │   │       ├── AlertHandler.java          # Penanganan alert
│   │   │       └── DriverManager.java         # Setup dan teardown WebDriver
│
│   └── test/
│       ├── java/
│       │   └── com/anna/
│       │       ├── runner/                    # Runner Cucumber
│       │       │   └── CucumberRunnerTest.java
│       │       ├── stepDefinitions/           # Implementasi langkah Gherkin
│       │       │   ├── HomeStepDefinition.java
│       │       │   └── Hooks.java             # Setup dan teardown per scenario
│
│       └── resources/
│           └── features/                      # File .feature Gherkin
│               └── signup.feature
│                        
├── build.gradle                               # File konfigurasi Gradle
└── README.md                                  # Dokumentasi proyek

               
```


## 📋 Prasyarat
- Java 11 atau lebih tinggi
- Chrome browser
- IntelliJ IDEA
- Gradle 7.6+

## ▶️ Cara Menjalankan Pengujian

### Menjalankan Semua Pengujian

```bash
./gradlew clean test
```

### Menjalankan Tag Tertentu

```bash
./gradlew test -Dcucumber.filter.tags="@smoke"
```

## 📊 Laporan Pengujian

Setelah menjalankan pengujian, laporan tersedia di:
- HTML Report: `html:target/cucumber-reports.htmll`

## ⚙️ Konfigurasi

- URL aplikasi dapat disesuaikan di kelas DriverManager pada method getDriver().
- Timeout dan pengaturan wait dapat diubah di BasePage method getWait(int seconds).
- WebDriverManager mengelola otomatis versi driver Chrome, pastikan koneksi internet tersedia.

## 🧩 Cara Memperluas Framework

### Menambahkan Halaman Baru

1. Buat kelas Page baru yang meng-extend ```BasePage```.
2. Tambahkan locator WebElement dengan ```@FindBy```.
3. Implementasikan metode halaman sesuai kebutuhan.

Contoh:
```java
public class ProductPage extends BasePage {
    @FindBy(id = "add-to-cart")
    private WebElement addToCartButton;
    
    public ShoppingCartPage addToCart() {
        click(addToCartButton);
        return new ShoppingCartPage();
    }
}
```

### Menambahkan Fitur Baru

1. Tambahkan file .feature baru di direktori src/test/resources/features
2. Tulis skenario pengujian menggunakan Gherkin.
3. Buat step definitions baru atau tambahkan pada kelas yang sudah ada.

## 🔄 Integrasi CI/CD

Saat ini framework ini belum terintegrasi dengan pipeline CI/CD. Kamu bisa menambahkan integrasi seperti GitHub Actions, Jenkins, atau lainnya sesuai kebutuhan di masa depan.

## 📝 Praktik Terbaik yang Diterapkan

- Enkapsulasi detail implementasi dalam Page Object.
- Penamaan variabel dan metode yang jelas.
- Struktur proyek yang terorganisir.
- Logging untuk memudahkan debugging.
- Validasi state aplikasi agar tes fail cepat jika ada masalah.

## 📜 Lisensi

Proyek ini dilisensikan di bawah Lisensi MIT - lihat file LICENSE untuk detail.
