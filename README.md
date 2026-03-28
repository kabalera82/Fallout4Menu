# Fallout 4 Menu — JavaFX

A JavaFX desktop application that recreates the iconic Fallout 4 main menu interface, including animated transitions and a loading screen.

## Overview

This project is a UI study that replicates the visual style of Fallout 4's main menu. It demonstrates JavaFX scene building, CSS-style theming via Java code, fade animations, and layered layout composition — all without FXML, using pure Java scene graph construction.

## Tech Stack

![Java](https://img.shields.io/badge/Java_24-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX_21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white)

- Java 24
- JavaFX 21.0.4 (controls, graphics)
- Maven 3.x build system

## Features

- Fallout 4–inspired menu with background image and sepia tone effect
- Animated `FadeTransition` on menu entry
- `MenuBox` container with styled `MenuItem` entries: **NEW**, **CONTINUE**, **SETTINGS**, **EXIT**
- `LoadingScreen` component with transition animation
- Modular component design — each visual element is its own class

## Project Structure

```
src/main/java/tech/kabadev/fallout4menuapp/
├── Fallout4MenuApp.java   # Application entry point, scene assembly
├── Colors.java            # Central color constants for the theme
├── LoadingScreen.java     # Animated loading screen component
├── MenuBox.java           # Menu container layout
└── MenuItem.java          # Clickable menu item with hover effects
```

## Getting Started

**Requirements:** Java 24 (JDK), Maven 3.6+

```bash
mvn javafx:run
```

Or build and run the JAR:

```bash
mvn clean package
java -jar target/Fallout4MenuApp-1.0-SNAPSHOT.jar
```

## Notes

This is a visual/UI practice project focused on JavaFX scene graph construction and animation. It does not implement actual game logic — the menu items trigger navigation stubs (loading screen transition, application exit, etc.).

## Author

Marcos Padilla — [github.com/kabalera82](https://github.com/kabalera82)
