# Conteneur Gestion Project - ITIC

## Description
The Conteneur Gestion project is focused on developing a container management system. This system is designed to handle key-value pairs efficiently, providing functionalities for storing, retrieving, and managing data.
This ITIC (Information Technology and Communication Technologies) project focuses on testing a Conteneur gestion project.

## Project Contents
The project is structured into several main components:

1. **Container**: A class responsible for managing key-value pairs, crucial for storing Sudoku data.

2. **Puzzle**: A class representing Sudoku and providing methods to evaluate whether the grid is solved.

3. **Functional Tests**: Test scenarios that evaluate the proper functioning of the Container class, with a particular focus on the add method.

4. **Structural Tests**: Tests evaluating the robustness of the Puzzle class, with a specific focus on the `isSolved` method.

5. **Model-Based Tests**: Model-based tests to evaluate the behavior of the Container in different states.

6. **Mutation Tests**: An advanced approach to assess the effectiveness of test suites by introducing deliberate variations in the program's source code.

7. **Jenkins Configuration**: A Jenkins dashboard to monitor the state of pipelines and builds.

## How to Run the Project

### Software prerequisites:
-----------------------
	1. JAVA Version >= 9.0
	   (https://openjdk.java.net/install/index.html)
	2. Maven Version >= 3.0.4 (project version : 3.8.1)
	   (http://maven.apache.org/)

### Shell variables to set in your ~/.bashrc file:
----------------------------------------------
	1. if JAVA is not installed from an archive file,
$
export JAVA_HOME=<the root directory of your Java installation>
export CLASSPATH=$JAVA_HOME/lib

### Compilation and installation:
-----------------------------
	To compile and install the modules, execute the following command.
$
(cd Code; mvn install)
$

	(Note: this could be useful once you have created JUnit files, for the moment the project does not contain any JUnit file) Use the following options if you do not want to compile and execute the JUnit tests  and do not want to generate the JavaDoc files.
        Then, the build process is much more rapid.
$
(cd Code; mvn install -Dmaven.test.skip=true -DskipTests -Dmaven.javadoc.skip=true -Dcheckstyle.skip)
$

### In Eclipse:
-----------
	To load the project in Eclipse, either use the maven plugin (File >
	Import > Maven > Existing maven project), or create the Eclipse project
	using the following command and then create a Java project in Eclipse:
$
(cd Code; mvn eclipse:clean eclipse:eclipse)
$

### Steps to Launch the Project

1. **Clone the Repository**
   ```bash
   git clone [repository-link]
   cd conteneur-gestion
   ```

2. **Compile the Project with Maven**
   ```bash
   mvn clean install
   ```

3. **Run the Tests**
   ```bash
   mvn test

## Project Structure
- The source code is in `/Code`, and you will find the `pom.xml` file and the `Jenkins` folder.
- Functional and structural tests are available in the `/Conception_Tests` directory.