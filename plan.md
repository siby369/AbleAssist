# AbleAssist Development Plan

This plan follows a modular, accessibility-first approach to building the AbleAssist platform for Android.

## Phase 1: Foundation & Accessibility Core (Weeks 1-2)
*Goal: A functional, navigable app shell that is 100% compatible with screen readers and high-contrast needs.*

- [ ] **1.1 Project Initialization**
    - [ ] Create Android Studio project (Kotlin, Min SDK 26, Target SDK 34).
    - [ ] Set up Clean Architecture structure (`data`, `domain`, `ui`, `ml`, `services`).
    - [ ] Configure `build.gradle` with necessary dependencies (Hilt, Jetpack Compose/Navigation).
- [ ] **1.2 UI & Navigation Foundation**
    - [ ] Implement Jetpack Navigation Component.
    - [ ] Create Home Screen with large, accessible buttons (min 48dp).
    - [ ] Implement Splash Screen.
- [ ] **1.3 Accessibility Implementation**
    - [ ] Configure TalkBack support (content descriptions, traversal order).
    - [ ] Implement High Contrast themes (Light/Dark/High-Contrast Yellow).
    - [ ] Create Settings screen for text size and haptic feedback toggles.

## Phase 2: Core Study Features (Weeks 3-6)
*Goal: Enable students to scan and hear textbooks.*

- [ ] **2.1 Document Scanner (CameraX + ML Kit)**
    - [ ] Implement CameraX preview.
    - [ ] Integrate ML Kit Text Recognition (Offline).
    - [ ] Create OCR Result processing and storage (Room).
- [ ] **2.2 Smart Reader (TTS)**
    - [ ] Integrate Android TextToSpeech (TTS).
    - [ ] Implement synchronized text highlighting during playback.
    - [ ] Add playback controls (Speed, Play/Pause, Skip).
- [ ] **2.3 Voice Command Integration**
    - [ ] Set up SpeechRecognizer for basic navigation commands ("Go to scanner", "Read document").

## Phase 3: Daily Living Features (Weeks 7-10)
*Goal: Assistant for object recognition and reminders.*

- [ ] **3.1 Object & Scene Recognition**
    - [ ] ML Kit Object Detection integration.
    - [ ] Real-time scene description via TTS.
- [ ] **3.2 Medication Reminders**
    - [ ] AlarmManager/WorkManager implementation.
    - [ ] Voice-confirmed reminders ("I took my medicine").
- [ ] **3.3 Currency & Barcode Scanner**
    - [ ] Custom TFLite model for currency recognition.
    - [ ] Barcode scanning for product ID.

## Phase 4: Adaptive Learning & Optimization (Weeks 11-12)
- [ ] **4.1 Adaptive UI**
    - [ ] Track frequent features and surface them to the home screen.
    - [ ] Auto-adjust font size based on user history.
- [ ] **4.2 Performance Tuning**
    - [ ] Optimize ML models for battery efficiency.
    - [ ] Offline database indexing (FTS5).

## Phase 5: Testing & Launch Prep
- [ ] Accessibility Audit.
- [ ] Beta testing with real users.
- [ ] Play Store deployment.
