# VoiceControlTest

**Тестовый проект для проверки голосового управлениея на Android**

## Описание

Проект VoiceControlTest предназначен для проверки голосового управления в Android-приложениях.

Проект полностью написан на Kotlin. В большинстве окон используется Jetpack Compose, лишь одно окно использует View для проверки работы голосовых команд в старых интерфейсах.

## Установка и запуск

1. **Клонируйте репозиторий:**
   ```bash
   git clone https://github.com/ako2345/VoiceControlTest.git
   ```
2. **Откройте проект в Android Studio.**
3. **Соберите и запустите приложение на эмуляторе или реальном устройстве.**

## Используемые технологии

- **Kotlin** — основной язык разработки.
- **Android SDK** — для работы с голосовым вводом и системными API.
- **Gradle** — для сборки проекта.
- **Jetpack Compose** — для современного UI.

## Структура проекта

```
VoiceControlTest/
├── .idea/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       ├── res/
│   │       └── AndroidManifest.xml
├── gradle/
├── build.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle
```