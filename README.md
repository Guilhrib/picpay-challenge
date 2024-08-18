# PicPay Backend Challenge

This project is a solution for the PicPay Backend Challenge, developed to enhance my knowledge and explore new concepts in backend development.

## Project Overview

The project is an API that facilitates the creation of transactions between two wallets. The process involves several key steps:

1. **Validation:** Ensuring the transaction is valid based on predefined rules.
2. **Processing:** Executing the transaction and updating wallet balances synchronously.
3. **Notification:** Users involved in the transaction are notified asynchronously.

### Technical Details

- **Synchronous Operations:** Transaction and wallet updates are handled in a synchronous manner to ensure data consistency.
- **Asynchronous Notifications:** Notifications are handled asynchronously. The event is published to a Kafka topic, where a consumer service listens and sends out the appropriate notifications to users.

### Tech Stack

- **Java**: Core language for development.
- **Spring Boot**: Framework used to build the API.
- **H2 Database**: In-memory database for testing and development.
- **SLF4J**: Logging framework for tracking application events.
- **Kafka**: Messaging system for handling asynchronous notifications.

## Purpose

The primary goal of this project was to improve my backend development skills and gain hands-on experience with Java, Spring Boot, and Kafka. It provided a practical understanding of handling synchronous and asynchronous operations within a microservices architecture.

---

Thank you for taking the time to check out this project! Feel free to contribute, raise issues, or reach out if you have any questions.
