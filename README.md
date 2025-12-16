# Design Patterns Implementation

This repository contains implementations of various software design patterns in Java. Each pattern is implemented in its own package with practical examples.

## Table of Contents
1. [State Pattern](#state-pattern)
2. [Interpreter Pattern](#interpreter-pattern)
3. [Facade Pattern](#facade-pattern)
4. [Memento Pattern](#memento-pattern)

## State Pattern

**Location:** `src/State/`

Implementation of the State design pattern using a traffic light system as an example. The pattern allows an object to alter its behavior when its internal state changes.

### Classes:
- `LightState` - Interface defining the state behavior
- `TrafficLight` - Context class that maintains the current state
- `RedLightState` - Concrete state implementation for red light
- `YellowLightState` - Concrete state implementation for yellow light
- `GreenLightState` - Concrete state implementation for green light
- `Main` - Demo application showing state transitions

### Behavior:
The traffic light cycles through states: Red → Green → Yellow → Red, with each state printing a message and transitioning to the next state.

## Interpreter Pattern

**Location:** `src/Interpreter/inventorypricing/`

Implementation of the Interpreter design pattern for evaluating pricing formulas in an inventory system. The pattern defines a grammatical representation for a language and provides an interpreter to deal with the grammar.

### Classes:
- `Expression` - Interface for interpreting expressions
- `NumberExpression` - Terminal expression for numeric values
- `VariableExpression` - Terminal expression for variables
- `PlusExpression` - Non-terminal expression for addition
- `SubtractExpression` - Non-terminal expression for subtraction
- `MultiplyExpression` - Non-terminal expression for multiplication
- `DivideExpression` - Non-terminal expression for division
- `PricingContext` - Context holding variable values
- `PricingCalculatorApp` - Main application demonstrating the interpreter

### Features:
Supports four pricing formulas:
1. `(Base Price × Quantity) + Tax`
2. `((Base Price × Quantity) + Tax) - Discount`
3. `((Base Price × Quantity) × (1 - Discount%)) + Tax`
4. `Formula 2 + Shipping Fee`

Interactive calculator that allows users to input values and select formulas for price calculation.

## Facade Pattern

**Location:** `src/facade/SCD assignment/`

Implementation of the Facade design pattern for simplifying complex subsystems. The pattern provides a unified interface to a set of interfaces in a subsystem.

### Classes:
- `AuthenticationService` - Handles user authentication
- `AccountService` - Manages account operations
- `TransactionService` - Processes financial transactions
- `NotificationService` - Sends user notifications
- `OnlineBankingFacade` - Unified interface simplifying banking operations
- `FacadePattern` - Demo application showing facade usage

### Behavior:
The facade simplifies a fund transfer operation by coordinating authentication, balance checking, fund transfer, and notification sending behind a single method call.
].
## Memento Pattern

**Location:** `src/memento/`

Implementation of the Memento design pattern for saving and restoring object states. The pattern captures and externalizes an object's internal state without violating encapsulation.

### Classes:
- `TextEditor` - Originator class whose state needs to be saved/restored
- `Memento` - Stores the internal state of the TextEditor
- `History` - Caretaker that manages mementos with undo/redo functionality
- `MementoDemo` - Demo application showing undo/redo operations

### Features:
- Simple text editor with append functionality
- Full undo/redo capability using two stacks
- State preservation without exposing internal details

### Group member
Name                   ID
1.`Elias Aynkulu`     -  1402639
2.`Dessalegn Mulat`     - 1401145
3.`Habtamu Kebede`      - 1401334
4.`Amanuel Getachew`    - 1500016
5.`Haileyesus Melesew`  - 1402967
6.`Kidestmariam Getenet`- 140
