# Vigenere and Caesar ciphers program

Author: Daniel Chojnacki

[122554@SAN](mailto:122554@student.san.edu.pl)
[@Florke64](https://mastodon.social/@Florke64)

## Package Structure

```
com.simpleciphers
├── Main.java
├── ciphers
│   ├── Cipher.java
│   ├── CaesarCipher.java
│   └── VigenereCipher.java
├── io
│   ├── FileReader.java
│   └── FileWriter.java
└── exceptions
├── CipherException.java
└── FileException.java
```

## Best Practices Applied

- Single Responsibility Principle (SRP)

> Each class has a single responsibility, such as handling encryption/decryption or file I/O.

-  Open/Closed Principle (OCP)

> The architecture is open for extension (adding new cipher types) but closed for modification (existing code does not need changes).

- Exception Handling

> Custom exceptions provide clear error handling and separation of concerns.

- Interface Usage

> The Cipher interface defines a contract for different cipher implementations, making the code extensible and polymorphic.