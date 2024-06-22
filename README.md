# Cesar i Vigenère

Autor: Daniel Chojnacki

[122554@SAN](mailto:122554@student.san.edu.pl)
[@Florke64](https://mastodon.social/@Florke64)

## Sposób użycia

```
java -jar SimpleCiphers.jar <cipher> <mode> <inputFile> <outputFile> [keyFile/shiftFile]
```

> Brak argumentow uruchomi program w trybie interaktywnym.

### Przykłady użycia

#1
```
java -jar SimpleCiphers.jar caesar encrypt input.txt output.txt 3
```

#2
```
java -jar SimpleCiphers.jar vigenere decrypt input.txt output.txt key
```

### Dostepne szyfry

`caesar`, `vigenere`

### Dostępne tryby działania

`encrypt`, `decrypt`

## Struktura Projektu

```
pl.florke.simpleciphers
├── Main.java
├── ui
│   └── CharacterUserInterface.java
├── ciphers
│   ├── Cipher.java
│   ├── CaesarCipher.java
│   └── VigenereCipher.java
├── exceptions
│   ├── CipherException.java
│   ├── FileException.java
│   └── UnsupportedCharacterException.java
├── util
│   └── AlphabetUtil.java
└── io
    ├── FileReader.java
    └── FileWriter.java
```
