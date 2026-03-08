# Technical Resources & Dependencies

## Core Tech Stack
- **Language:** Kotlin
- **Minimum SDK:** Android 8.0 (API 26)
- **Target SDK:** Android 14 (API 34)
- **Architecture:** MVVM + Clean Architecture
- **Dependency Injection:** Dagger Hilt

## Required Dependencies

### UI & Navigation
- `androidx.core:core-ktx:1.12.0`
- `androidx.appcompat:appcompat:1.6.1`
- `com.google.android.material:material:1.11.0`
- `androidx.constraintlayout:constraintlayout:2.1.4`
- `androidx.navigation:navigation-compose:2.7.5`

### ML & Vision (Offline Focused)
- `com.google.mlkit:text-recognition:16.0.0`
- `com.google.mlkit:object-detection:17.0.1`
- `com.google.mlkit:image-labeling:17.0.8`
- `com.google.mlkit:barcode-scanning:17.2.0`
- `org.tensorflow:tensorflow-lite:2.14.0`

### Persistence & Background
- `androidx.room:room-runtime:2.6.1`
- `androidx.room:room-ktx:2.6.1`
- `androidx.work:work-runtime-ktx:2.9.0`

### Testing
- `junit:junit:4.13.2`
- `androidx.test.espresso:espresso-core:3.5.1`

## Key APIs & SDKs
- **CameraX:** Camera handling for scanner and recognition.
- **Android TTS:** Text-to-Speech output.
- **SpeechRecognizer:** Voice command input.
- **AlarmManager:** Critical notifications/reminders.

## Design Constraints
- **Min Touch Target:** 48dp x 48dp.
- **Contrast Ratio:** 7:1 (WCAG AAA).
- **Scalable Font:** Support up to 200% zoom.
- **TalkBack:** Mandatory content descriptions on all interactive elements.
