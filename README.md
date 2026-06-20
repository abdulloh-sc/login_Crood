# Login System — REST API darsi (Swagger bilan)

Spring Boot REST API misoli. Login va ro'yxatdan o'tish, Swagger UI orqali sinaladi (Postman kerak emas).

## Talablar
- JDK 17 yoki undan yuqori
- IntelliJ IDEA (Community yoki Ultimate)
- Internet (birinchi ishga tushganda Maven kutubxonalarni yuklab oladi)

## IntelliJ'da ochish
1. IntelliJ IDEA'ni oching → **File → Open**
2. `login-demo` papkasini tanlang (ichida `pom.xml` bor) → **OK**
3. IntelliJ Maven loyihasini avtomatik taniydi va kutubxonalarni yuklaydi.
   Pastdagi progress tugashini kuting (birinchi marta biroz vaqt oladi).

## Ishga tushirish
1. `src/main/java/com/example/login/LoginApp.java` faylini oching
2. `main` metod yonidagi yashil ▶ tugmasini bosing → **Run 'LoginApp'**
3. Console'da `Tomcat started on port 8080` chiqsa — server tayyor

## Swagger'ni ochish (brauzerda)
Brauzerda quyidagini oching:

    http://localhost:8080/swagger-ui.html

Agar ishlamasa, to'liq variantini sinang:

    http://localhost:8080/swagger-ui/index.html

## Sinab ko'rish
1. **Authentication** bo'limini oching → `/auth/login`
2. **Try it out** tugmasini bosing
3. JSON namuna allaqachon to'ldirilgan (admin / 1234)
4. **Execute** bosing → pastda javob va status kod (200) ko'rinadi

Tayyor foydalanuvchilar:
- admin / 1234
- ali / parol

Sinov natijalari:
- to'g'ri parol  → 200 (Tizimga muvaffaqiyatli kirdingiz)
- xato parol     → 401 (Login yoki parol noto'g'ri)
- yangi register → 201 (Ro'yxatdan o'tdingiz)
- band username  → 400 (Bu username band)

## Loyiha tuzilishi
    src/main/java/com/example/login/
      LoginApp.java                  -> main (dasturni ishga tushiradi)
      model/User.java                -> foydalanuvchi modeli
      dto/LoginRequest.java          -> kelgan JSON'ni qabul qiladi
      repository/UserRepository.java -> @Repository (Bean)
      service/UserService.java       -> @Service (Bean)
      controller/AuthController.java -> @RestController (endpoint'lar)
      config/SwaggerConfig.java      -> Swagger sarlavhasi

## Eslatma
Bu o'quv misoli — parol ochiq matnda saqlanyapti. Real loyihada parol
hash'lanadi (BCrypt) va himoya Spring Security + JWT bilan qilinadi.
Bu keyingi darslarda.
