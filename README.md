# Store Management Project - Clicker Game

## Overview
This project is a **Cookie Clicker** style game developed as part of a school assignment to demonstrate store management and object-oriented programming concepts.

## Project Requirements
- **Class Hierarchy**:
  - **Superclass**: Represents a generic product or service the business offers.
  - **Subclasses**: Represent specific types of products (e.g., upgrades) that extend the functionality of the superclass.
  
- **Instance Variables**:
  - Instance variables declared in the superclass are shared with subclasses.
  - Additional instance variables are declared in the subclasses that are unique to them.

- **Constructors**:
  - No-argument and parameterized constructors are implemented for both the superclass and subclasses, with the subclasses calling the superclass constructor using the `super` keyword.

- **Accessor and Mutator Methods**:
  - Accessor and mutator methods are used to retrieve and modify the instance variables from outside of the class.

- **toString() Method**:
  - `toString()` methods are implemented in both the superclass and subclasses to provide meaningful information about the objects' current state.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/anthonykotoyan/ClickerIdle.git
  ```
2. Navigate to the project folder:
   ```bash
   cd ClickerIdle
   ```
3. Compile and run the program:
   ```bash
   javac Main.java
   java Main
   ```
