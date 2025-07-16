# 🧠 LRU Cache – Low Level Design (LLD)

This project implements the **Least Recently Used (LRU) Cache** system using **Low-Level Design** principles. It follows a modular, scalable, and object-oriented approach, ideal for interviews and system design practice.

---

## 📌 Objective

To design and implement a cache that:
- Stores key-value pairs with a fixed capacity
- Removes the **least recently used** item when capacity is reached
- Supports `O(1)` time complexity for `get()` and `put()` operations

---

## 🧠 Design Concepts Used

- ✅ Object-Oriented Programming (OOP)
- ✅ SOLID Principles
- ✅ Design Patterns:
  - **Doubly Linked List** (for tracking recent usage)
  - **Hash Map** (for fast key access)

---

## 📦 Class Design

LRUCache
┣━━ int capacity
┣━━ Map<Integer, Node> cache
┣━━ Node head, tail ➝ for doubly linked list
┣━━ get(key): int
┣━━ put(key, value): void

Node
┣━━ int key
┣━━ int value
┣━━ Node prev, next


---

## 🧰 Tech Stack

- **Language**: Java
- **IDE**: IntelliJ / VS Code
- **Build Tool**: Maven (optional)

---

## ✅ Features

- 🚀 `O(1)` access and update
- 🗂️ Automatic eviction of least recently used data
- 🔁 Doubly linked list + HashMap combo for performance
- ♻️ Reusable and extendable design

---

## 🛠️ How It Works

- `get(key)`:
  - If found, move the node to the front (most recently used)
  - Else, return -1

- `put(key, value)`:
  - If key exists, update value and move to front
  - Else, insert new node
    - If over capacity, remove tail (least recently used)

---

## ▶️ Sample Usage

```java
LRUCache cache = new LRUCache(2);
cache.put(1, 10);
cache.put(2, 20);
cache.get(1);       // returns 10, marks key 1 as recently used
cache.put(3, 30);    // evicts key 2
cache.get(2);       // returns -1 (not found)
