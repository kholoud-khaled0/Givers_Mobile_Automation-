📱 TheApp - Cross-Platform Mobile Test Automation Framework
A robust and scalable Hybrid mobile UI automation framework for Android and iOS platforms, built using Java + Appium + TestNG, following the Page Object Model design with support for data-driven testing, parallel execution, and detailed reporting using Allure.

📦 Project Structure & Layered Architecture
TheApp/
│
├── pom.xml                              # Maven configuration
├── test_runners/
│   ├── AndroidTestSuite.xml             # Android test suite
│   ├── CrossPlatformTestSuite.xml       # (Default) runs both Andriod and Ios in parallel
│   └── IosTestSuite.xml                 # iOS test suite
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── listeners/               # Retry logic, logs, event hooks
│   │       ├── screens/
│   │       │   ├── android/             # Android-specific page objects and implementation
│   │       │   ├── ios/                 # iOS-specific page objects and implementation
│   │       │   ├── base/                # Cross-platform screen abstractions
│   │       │   └── screenFactory/       # Factory to instantiate correct screen
│   │       ├── utils/
│   │       │   ├── appium/              # Appium driver, AppiumDriver Factory, wait logic
│   │       │   ├── android/ios/         # Platform-specific helpers
│   │       │   └── common/              # Assertions, logging, file I/O
│   │       │   
│   └── resources/
│       ├── Env/                         # Android & iOS config files
│       └── *.properties                 # Allure, Log4j2, and test config
│
├── src/test/
│   ├── java/
│   │   ├── testClasses/                 # TestNG test cases
│   │   └── utils/                       # DataProviders ,Data models and Test Factory
│   └── resources/
│       └── *.json                       # Test data 
🧪 Test Execution Flow
This framework supports platform-agnostic test logic with screen factories and soft assertions. Test execution is handled using TestNG with optional retries for flaky cases.

🔄 Cross-Platform Test Design
Shared base interfaces abstract screen behaviors.
screenFactory chooses Android or iOS implementations dynamically.
Tests are written once and run across platforms.
       HomeScreen homeScreen = ScreenFactory.getHomeScreen();
       LoginScreen loginScreen= homeScreen.navToLogin();
       SecretScreen secretScreen= loginScreen.login(userName, passWord);
✅ Test Coverage
✔️ Functional Test Classes:
LoginTests – authentication flow
EchoBoxTests – text input and display verification
CloudListTest – scroll actions and Alert Handling
🧰 Core Features
1. Cross-Platform Page Object Model
Abstract base interfaces for screen logic
Concrete page objects per platform
Single test suite, multi-platform execution
2. Screen Factory Pattern
Centralized decision logic for Android vs iOS
Simplifies test maintenance
Keeps test code clean and DRY
3. Listeners & Test Lifecycle
ExecutionListener: Centralized control over test suite setup/teardown.
Retry & Result Listeners: Automatically retries broken tests only and logs results consistently.
Method-Level Hooks: Add pre/post logic without modifying test methods.
Test Isolation: Keeps test logic focused by handling non-test concerns behind the scenes.
Reusable Design: Modular listeners work across multiple projects.
DynamicAllureListener:dynamically sets Allure story labels, descriptions, and history IDs for each test based on runtime fields in the test class.
4. Custom Assertions
Soft Assertions: Accumulates multiple failures without stopping execution.
Thread-Safe & Clean: Per-thread tracking and cleanup ensure safe execution.
Integrated with TestNG: Works seamlessly with its lifecycle.
5. Logging System
log4j2.properties handles terminal and file logs
Allure Integration: Attaches logs per test for better traceability.
Console & File Output: Real-time ANSI-colored logs and rolling file logs under test_outputs/logs.
Standard API: Uses Log4j2 without extra boilerplate.
6. Flexible Test Data & Dynamic Initialization
Factory-based dynamic test initialization with JSON-driven data injection using POJOs for scalable and flexible testing.
📊 Reporting
Allure test report Showing Default Test Suite Behaviors Section in Allure Report

🔗 View Full Allure Report

🧪 Configuration Management
Device Setup:
Modify device config:
Env/AndroidEnv.properties
Env/IosEnv.properties
Global Settings:
Set paths and toggles via testConfiguration.properties
⚙️ How to Run
Prerequisites:
Java JDK 23+
Maven 3.6+
Node.js
Appium CLI or Appium Desktop Server
Android/iOS Emulator or real device
🚀 Run Tests:
Profiles & Test Suites
Profile	Description	Suite XML File
default	Cross-platform test suite	test_runners/CrossPlatformTestSuite.xml
android	Android-specific tests	test_runners/AndroidTestSuite.xml
ios	iOS-specific tests	test_runners/IosTestSuite.xml
Commands:

mvn clean test
mvn clean test -Pandroid
mvn clean test -Pios
🧠 Ideas for Extension
Integrate with TestNG Grid or device farms
Add CI/CD triggers via Jenkins
Enable Slack or Email alerts
Expand scenario coverage (E2E, more Features, more edge cases)
