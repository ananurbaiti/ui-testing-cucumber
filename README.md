# 🚀 UI Testing Framework with Cucumber & Selenium

Ini adalah framework untuk otomatisasi pengujian UI berbasis Selenium dan Cucumber

## ✨ Fitur Utama
- Automatisasi pengujian UI menggunakan Selenium
- Integrasi dengan Cucumber untuk penulisan Gherkin
- Validasi popup dan alert
- Skema pengujian positif & negatif

## 💻 Teknologi yang Digunakan
- Java
- Selenium WebDriver
- Cucumber
- Gradle
- WebDriverManager
- TestNG
- IntelliJ IDEA

## 🗂️ Struktur Proyek
```
web-ui-automation21/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   └── components/
│   │   │   │       └── PopUpSignUp.java
│   │   │   └── utilities/
│   │   │       ├── AlertHandler.java
│   │   │       └── DriverManager.java
│
│   └── test/
│       ├── java/
│       │   └── com/anna/
│       │       ├── runner/
│       │       │   └── CucumberRunnerTest.java
│       │       ├── stepDefinitions/
│       │       │   ├── HomeStepDefinition.java
│       │       │   └── Hooks.java
│
│       └── resources/
│           └── features/
│               └── signup.feature
│
├── .github/workflows/        # Konfigurasi CI/CD
├── build.gradle              # Konfigurasi Gradle
└── README.md                 # Dokumentasi proyek
```


## 📋 Prasyarat
- Java 17+
- Chrome browser
- IntelliJ IDEA (atau IDE lain)
- Gradle

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

1. Buat kelas Page baru yang meng-extend BasePage
2. Tambahkan lokator WebElement menggunakan anotasi @FindBy
3. Implementasikan metode spesifik halaman

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

1. Buat file .feature baru di direktori features
2. Tulis skenario menggunakan sintaks Gherkin
3. Implementasikan step definitions di kelas step baru atau yang sudah ada

## 🔄 Integrasi CI/CD

Framework ini menyertakan konfigurasi GitHub Actions untuk continuous integration yang akan:

1. Men-setup JDK 17
2. Menginstal browser Chrome
3. Menjalankan pengujian
4. Mengupload hasil pengujian sebagai artifacts

## 📝 Praktik Terbaik yang Diterapkan

- ✅ **Enkapsulasi** - Menyembunyikan detail implementasi internal
- ✅ **Fluent Interface** - Method chaining untuk meningkatkan keterbacaan
- ✅ **Clean Code** - Penamaan yang jelas dan struktur yang terorganisir
- ✅ **Fail-fast** - Kegagalan awal dengan validasi yang tepat
- ✅ **Central configuration** - Konfigurasi terpusat untuk kemudahan pemeliharaan
- ✅ **Logging** - Pesan log yang komprehensif untuk debug

## 📜 Lisensi

Proyek ini dilisensikan di bawah Lisensi MIT - lihat file LICENSE untuk detail.
