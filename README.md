# 📈 Futures Trading Profit & Loss Calculator

## 🚀 Overview

### **The Problem:**
Day traders need a **quick and accurate** way to calculate their **profit & loss (PnL)** for futures trades. Manually tracking PnL can lead to **errors, delays, and miscalculations**, which can impact trading decisions.

### **The Solution:**
The **Futures Trading PnL Calculator** is a **Spring Boot REST API** that **automates PnL calculations** for futures traders. Simply input **trade details** (entry/exit price, contract type, and trade direction), and the API instantly calculates **profit or loss**, eliminating manual errors.

<p align="center" style="display: flex; flex-direction: column; align-items: center; gap: 20px;">
  
  <!-- Image 1: Java Code Before Spring Boot -->
  <div>
    <h3>📌 Initial Java Code (Before Spring Boot Integration)</h3>
    <p>This image shows the original standalone Java implementation of the trading calculator, before integrating it with Spring Boot.</p>
    <img width="547" alt="Java Code Before Spring Boot" src="https://github.com/user-attachments/assets/534f4ebf-4b70-4329-a42d-9ca8a9491deb" />
  </div>

  <!-- Image 2: Integrated with Spring Boot -->
  <div>
    <h3>🚀 Integrated with Spring Boot</h3>
    <p>Now converted into a Spring Boot application! This image showcases the <code>TradeService</code> class, where trade calculations are handled.</p>
    <img src="https://github.com/user-attachments/assets/66483efb-80f5-4c56-961a-040418c9b1f5" alt="Spring Boot Integration - TradeService Class" width="550"/>
  </div>

  <!-- Image 3: Successful API Request in Postman -->
  <div>
    <h3>✅ Successful API Request (Profit Calculation)</h3>
    <p>A successful API request in Postman, showing a <code>POST</code> request to calculate profit for an ES (E-mini S&P) contract trade, resulting in a <strong>$1250 profit</strong>.</p>
    <img src="https://github.com/user-attachments/assets/3533817b-6513-4ec2-8a6c-ad2fabcfb6f9" alt="Successful API Request in Postman" width="550"/>
  </div>

  <!-- Image 4: Unsuccessful API Request (Invalid Contract) -->
  <div>
    <h3>❌ Unsuccessful API Request (Invalid Contract)</h3>
    <p>A failed API request in Postman, showing a <code>404 Not Found</code> error when trying to calculate a trade for an invalid contract type <code>XYZ</code>.</p>
    <img src="https://github.com/user-attachments/assets/f9361812-a181-4c94-9546-d52cc03897e6" alt="404 Error - Invalid Contract" width="550"/>
  </div>
</p>

## 🛠️ Core Features

✅ **Instant PnL Calculation**
- Real-time profit/loss calculations for futures trades
- Support for both long (BUY) and short (SELL) positions
- Precise calculations using BigDecimal for financial accuracy

✅ **Comprehensive Contract Support**
- Major futures contracts (ES, NQ, CL, GC, etc.)
- Contract-specific point values and specifications
- Easily extensible for new contract types

✅ **Robust Error Handling**
- Validation for all input parameters
- Custom exception handling
- Detailed error messages and suggestions
- Rate limiting protection

## 💻 Technical Stack

### Backend
- **Java 21**
- **Spring Boot 3.x**
  - Spring Web (REST API)
  - Spring Data JPA
  - Spring Security
  - Spring Cache
- **Database**
  - H2 (Development)
  - MySQL (Production)


