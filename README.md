# Fee Service Interview Exercise

## Background
This is a simple microservice responsible for calculating the total fees for a product.
It receives a list of charge codes, looks up their configured fee amounts from a database, sums them up, and applies fee relief rules.

## Requirements
1. **Endpoint**: `POST /api/v1/fees/calculate`
2. **Input**: A list of charge codes (e.g. `["BAGGING_FEE", "PERSONALIZATION_FEE", "GIFT_WRAP_FEE"]`).
3. **Output**: The total fees and the list of charge codes submitted.
4. **Business Logic**:
   - Look up the fee amount for each charge code.
   - Sum the fee amounts.
   - **Fee Relief Rules**:
     - If total is above £20, apply 50% relief.
     - If total is above £10, apply 20% relief.
     - If total is above £5, apply 10% relief.
   - The thresholds are mutually exclusive. (e.g., > £20 gets only the 50% OFF, and not the 10% or 20% OFF).

## Setup
- Java 25
- Spring Boot
- H2 in-memory database
- Gradle

## Evaluation
The implementation intentionally contains a mix of code smells, correctness bugs, and operational concerns.
Your task is to review this repository, identify potential problems, and explain why it is a problem.
