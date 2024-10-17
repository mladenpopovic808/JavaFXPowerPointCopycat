# JavaFXPowerPointCopycat --> JavaFX PowerPoint Clone

A JavaFX application that mimics the basic functionality of PowerPoint, allowing users to create projects consisting of presentations and slides. Each slide can contain rectangles that hold text or multimedia content. The application also supports customization of rectangle properties and provides serialization features to save and load projects.

## Features

- **Project Management**: 
  - Users can create multiple projects, each containing a set of presentations.
  - Presentations consist of multiple slides, each of which can hold customizable elements.
  
- **Slide Elements**: 
  - Users can add **rectangles** to slides, which can contain either **text** or **multimedia content**.
  - Customize rectangle properties such as:
    - **Fill color**
    - **Border thickness**
    - **Border style** (solid or dashed)
  
- **Serialization and Persistence**: 
  - Save and load entire projects, including all presentations and slides.
  - The application supports **serialization**, allowing users to store the current project state and retrieve it later.
  - The application automatically **remembers the last open project context**, so when the user reopens the app, they can continue from where they left off.

## How It Works

1. **Create a Project**: Start by creating a new project. Each project can have multiple presentations.
2. **Add Slides**: Within each presentation, you can add as many slides as needed.
3. **Insert Elements**: On each slide, you can insert rectangles that will serve as containers for text or multimedia. Customize their appearance with colors, border thickness, and styles.
4. **Save & Load Projects**: Save the project at any time, and load previously saved projects using the serialization feature.
5. **Automatic Context Save**: When you close the application, the current project context (open presentations and slides) is saved to a file. Upon reopening the application, you can choose to load the previous context and continue working.



## Prerequisites

- Java 1.8 or higher
- JavaFX SDK (ensure it is configured in your IDE or build tool)
- A JavaFX-compatible IDE (e.g., IntelliJ IDEA, Eclipse)


