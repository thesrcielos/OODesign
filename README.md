# Java Mean and Standard Deviation Calculator

This is a command-line tool written in Java that reads a file with two columns of real numbers, calculates the **mean** and **standard deviation** for each column, and displays the results. The numbers are stored in a **custom linked list implementation** compatible with Java’s Collections API.

## 🛠 Features

- Reads `.txt` files with two columns (space or comma separated)
- Uses custom singly linked list with tail pointer for O(1) appends
- Calculates **mean** and **sample standard deviation**
- Input path is read from the **console**
- Includes **unit tests** with JUnit
- Built using **Maven**

---

##  Getting Started

### ✅ Prerequisites

You will need:

- [Java 17+](https://jdk.java.net/)
- [Maven 3.8+](https://maven.apache.org/)
- Git (optional)

### 📦 Installing

Clone the repository:

``` bash
git clone https://github.com/yourusername/mean-stddev-calculator.git
cd mean-stddev-calculator
````

### Build the project with Maven:
```
mvn clean install
```
## Running the Application
Run the program with:

```
java -cp target/mean-stddev-calculator-1.0-SNAPSHOT.jar org.eci.Main
```
You will be prompted to enter the path to your .txt file, for example:

```
Enter the path to the data file: data.txt
```
## Running the Tests
Run unit tests:

```
mvn test
```
Example of test case in MathUtilsTest.java:

```
@Test
void testColumn1() {
    List<Double> data = List.of(160d, 591d, 114d, 229d, 230d, 270d, 128d, 1657d, 624d, 1503d);
    assertEquals(550.6, MathUtils.mean(data), 0.1);
    assertEquals(572.03, MathUtils.stdDev(data), 0.1);
}
```
## Design
This project implements its own MyLinkedList<E> class, which supports the List<E> interface partially and uses a tail reference for efficient inserts.

| Class            | Responsibility                           |
|------------------|-------------------------------------------|
| `Main`           | Entry point, console interaction          |
| `MyLinkedList`   | Custom singly linked list implementation  |
| `MathUtils`      | Mean and standard deviation calculations  |
| `FileDataReader` | File parsing and list construction        |

## Javadoc
Generate and view the documentation with:

```
mvn javadoc:javadoc
```
Open it at: target/reports/apidocs/index.html

## Test Report

| Class        | Method                           | Description                          | Result |
| ------------ |----------------------------------| ------------------------------------ | ------ |
| MathUtils    | `mean()`                         | Calculates average                   | ✅      |
| MathUtils    | `stdDev()`                       | Calculates sample standard deviation | ✅      |
| MyLinkedList | `add`, `get`, `iterator`, `size` | Custom linked list functionality     | ✅      |

## Built With

* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

* [Maven](https://maven.apache.org/) - Dependency Management

* [ JUnit 4](https://junit.org/junit4/)

## Contributing

Please read **CONTRIBUTING.md** for details on how to contribute.

## Authors

* Diego Armando Macia Diaz – Initial work

## License

* This project is licensed under the GNU License – see the LICENSE.md file.