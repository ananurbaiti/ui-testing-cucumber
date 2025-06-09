# 🚀 UI Testing Framework with Cucumber & Selenium

Kerangka pengujian UI Web modern yang dibangun dengan **Cucumber**, **Selenium WebDriver**, dan **Java** untuk otomatisasi pengujian aplikasi web.

## ✨ Fitur Utama
- **Automasi pengujian UI** untuk fitur signup menggunakan Selenium WebDriver.
- **BDD dengan Cucumber** untuk menulis skenario pengujian yang mudah dibaca.
- **Page Object Model (POM)** untuk struktur kode yang rapi dan mudah dipelihara.
- **Penanganan alert** dan popup secara otomatis.
- **Hooks** untuk setup dan teardown pengujian.
- **Skema pengujian** positif & negatif
- **CI/CD Integration** untuk integrasi dengan GitHub Actions

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
|── .github/workflows/                         # Konfigurasi CI/CD                        
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

- Laporan hasil pengujian otomatis dihasilkan dalam format HTML.
- Lokasi laporan: ```target/cucumber-reports.html```.
- Laporan ini menampilkan detail skenario, langkah, status (pass/fail), dan durasi eksekusi.


- HTML Report: `html:target/cucumber-reports.html`

## ⚙️ Konfigurasi

- Browser: Menggunakan Chrome via WebDriverManager di ```DriverManager.java```.
- Hooks: Inisialisasi dan teardown browser di ```Hooks.java``` dengan anotasi ```@Before``` dan ```@After```.
- Runner: ```CucumberRunnerTest.java``` mengatur direktori fitur, glue, dan laporan HTML.
- Dependencies: Dikelola lewat ```build.gradle``` (Cucumber, Selenium, WebDriverManager).
- Struktur Fitur & Step: ```.feature``` di ```resources/features```, step di ```stepDefinitions```.


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

1. Tambahkan file ```.feature``` baru di direktori ```src/test/resources/features```.
2. Tulis skenario pengujian menggunakan Gherkin.
3. Buat step definitions baru atau tambahkan pada kelas yang sudah ada.

## 🔄 Integrasi CI/CD

Framework ini menyertakan konfigurasi GitHub Actions untuk continuous integration yang akan:

1. Men-setup JDK 17
2. Menginstal browser Chrome
3. Menjalankan pengujian
4. Mengupload hasil pengujian sebagai artifacts

## 📝 Praktik Terbaik yang Diterapkan

- Enkapsulasi detail implementasi dalam Page Object.
- Penamaan variabel dan metode yang jelas.
- Struktur proyek yang terorganisir.
- Logging untuk memudahkan debugging.
- Validasi state aplikasi agar tes fail cepat jika ada masalah.

## 📜 Lisensi

Proyek ini dilisensikan di bawah Lisensi MIT - lihat file LICENSE untuk detail.
