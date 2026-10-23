# Category C: Linear Data Structures Practice Assignment Solutions
**Course:** STEP SEM-3 · CodInClub | Powered by BridgeLabz  
**Document:** `CATEGORY-C-DATA-STRUCTURE_PRACTICE`  

---

## Part B — Quiz (Questions & Detailed Answers)

### Q1. String Object Comparison
**Question:**  
Consider two String objects, `s1` and `s2`, created as follows:
```java
String s1 = new String("hello");
String s2 = new String("hello");
```
Which of the following statements is true regarding the comparison of `s1` and `s2` in Java?

- **A.** `s1 == s2` is true, and `s1.equals(s2)` is true.
- **B.** `s1 == s2` is false, and `s1.equals(s2)` is false.
- **C.** `s1 == s2` is true, and `s1.equals(s2)` is false.
- **D.** `s1 == s2` is false, and `s1.equals(s2)` is true.

**Correct Answer:** **D. `s1 == s2` is false, and `s1.equals(s2)` is true.**  
**Explanation:** The `new` operator creates two distinct objects at different heap memory addresses, so the reference comparison `s1 == s2` evaluates to `false`. However, `String.equals()` compares the actual sequence of characters, which are identical (`"hello"`), so it evaluates to `true`.

---

### Q2. StringBuilder Operations
**Question:**  
Given the following sequence of operations on a `StringBuilder` object:
```java
StringBuilder sb = new StringBuilder();
sb.append("Java");
sb.append(" Lab");
sb.reverse();
```
What will be the content of the `StringBuilder` object `sb` after these operations?

- **A.** `"Java Lab"`
- **B.** `"baL avaJ"`
- **C.** `"Lab Java"`
- **D.** `"avaL baJ"`

**Correct Answer:** **B. `"baL avaJ"`**  
**Explanation:** Appending `"Java"` and `" Lab"` produces `"Java Lab"`. The `reverse()` method reverses the entire character sequence, yielding `"baL avaJ"`.

---

### Q3. Constructor Overloading & Delegation
**Question:**  
Consider a `Student` class with the following constructors:
```java
class Student {
    String name;
    String department;

    public Student() {
        this("Unknown", "Not assigned");
    }

    public Student(String name) {
        this(name, "Not assigned");
    }

    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
```
If the following code is executed:
```java
Student s = new Student("Ravi");
```
Which constructor will be directly called by `new Student("Ravi")`?

- **A.** `public Student()`
- **B.** `public Student(String name)`
- **C.** `public Student(String name, String department)`
- **D.** The code will result in a compile-time error due to ambiguity.

**Correct Answer:** **B. `public Student(String name)`**  
**Explanation:** Passing a single `String` argument matches the constructor signature `Student(String name)` directly. That constructor then delegates internally to the 2-parameter constructor via `this(name, "Not assigned")`.

---

### Q4. Reference Variable Alias & Mutation
**Question:**  
Consider a `Wallet` class with a `balance` field and an `add(int amount)` method. If `w1` and `w2` are Wallet reference variables, and the following operations occur:
```java
Wallet w1 = new Wallet(500);
Wallet w2 = w1;
w2.add(200);
```
What will be the balance seen through `w1` and `w2` after `w2.add(200)` is executed?

- **A.** `w1 balance: 500, w2 balance: 700`
- **B.** `w1 balance: 700, w2 balance: 500`
- **C.** `w1 balance: 500, w2 balance: 500`
- **D.** `w1 balance: 700, w2 balance: 700`

**Correct Answer:** **D. `w1 balance: 700, w2 balance: 700`**  
**Explanation:** The assignment `w2 = w1` copies the reference, meaning both `w1` and `w2` refer to the exact same `Wallet` instance on the heap. Mutating the object via `w2.add(200)` modifies the shared instance, so both see a balance of 700.

---

### Q5. Static Class Variables
**Question:**  
Consider a `Visitor` class that tracks the total number of visitors using a static variable `count`.
```java
class Visitor {
    private static int count = 0;
    private String name;

    public Visitor(String name) {
        this.name = name;
        count++; // Increment the shared counter
    }

    public static int getTotalVisitors() {
        return count;
    }
}
```
If three `Visitor` objects are created:
```java
new Visitor("Asha");
new Visitor("Ravi");
new Visitor("Neha");
```
What will be the value returned by `Visitor.getTotalVisitors()` after these objects are created?

- **A.** `0`
- **B.** `1`
- **C.** `3`
- **D.** Undefined, as static variables require an object instance.

**Correct Answer:** **C. `3`**  
**Explanation:** Static variables belong to the class and are shared across all instances. Each constructor call increments the single shared `count` variable, resulting in `count = 3`.

---

### Q6. Array Iteration
**Question:**  
Consider an integer array named `scores` with elements `[45, 78, 92, 60, 85]`. If you iterate through this array using a standard for loop from index 0 to `scores.length - 1` and print each element:
```java
int[] scores = {45, 78, 92, 60, 85};
for (int i = 0; i < scores.length; i++) {
    System.out.print(scores[i] + " ");
}
```
What will be the output?

- **A.** `45 78 92 60 85`
- **B.** `85 60 92 78 45`
- **C.** `45 78 92 60`
- **D.** Error: Index out of bounds.

**Correct Answer:** **A. `45 78 92 60 85`**  
**Explanation:** The loop traverses indices 0 through 4 sequentially, printing each corresponding element separated by a space.

---

### Q7. Loop Control (continue Statement)
**Question:**  
Analyze the following for loop in Java:
```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }
    System.out.print(i + " ");
}
```
What will be the output when this code segment is executed?

- **A.** `1 2 3 4 5`
- **B.** `1 2 4 5`
- **C.** `3`
- **D.** `1 2`

**Correct Answer:** **B. `1 2 4 5`**  
**Explanation:** When `i == 3`, the `continue` statement skips the remainder of the current iteration body, so 3 is not printed. Iterations for 1, 2, 4, and 5 execute normally.

---

### Q8. Pass-By-Value with Primitives
**Question:**  
Consider the following Java code snippet:
```java
class MyClass {
    public static void change(int n) {
        n = 10;
    }
    public static void main(String[] args) {
        int x = 5;
        change(x);
        System.out.println(x);
    }
}
```
What will be printed to the console when the main method is executed?

- **A.** `5`
- **B.** `10`
- **C.** `0`
- **D.** An error will occur because n is not initialized.

**Correct Answer:** **A. `5`**  
**Explanation:** Java is strictly pass-by-value. When `x` is passed to `change(int n)`, a copy of the primitive value `5` is assigned to parameter `n`. Reassigning `n = 10` inside the method does not affect the variable `x` in `main`.

---

### Q9. Numeric Division and Type Promotion
**Question:**  
Consider the following Java code:
```java
int total = 250;
double count = 3;
double avg = total / count;
System.out.println(avg);
```
What will be the output when this code is executed?

- **A.** `83`
- **B.** `83.0`
- **C.** `83.33333333333333`
- **D.** `83.33`

**Correct Answer:** **C. `83.33333333333333`**  
**Explanation:** Because `count` is a `double`, Java performs binary numeric promotion, converting `total` to `250.0`. Floating-point division `250.0 / 3.0` evaluates to `83.33333333333333`.

---

### Q10. Abstract Classes & Polymorphism
**Question:**  
Consider a `Payment` abstract class with an abstract method `pay()` and a `Card` subclass that extends `Payment` and overrides the `pay()` method to include a 2% fee.
```java
abstract class Payment {
    abstract void pay(double amount);
}
class Card extends Payment {
    @Override
    void pay(double amount) {
        double fee = amount * 0.02;
        System.out.println("Paid " + (amount + fee) + " by card");
    }
}
```
If the following code is executed:
```java
Payment p = new Card();
p.pay(500);
```
What will be the output?

- **A.** `Paid 500.0 by card`
- **B.** `Paid 510.0 by card`
- **C.** Error: Cannot instantiate abstract class Payment.
- **D.** Error: Payment class does not have a concrete pay method.

**Correct Answer:** **B. `Paid 510.0 by card`**  
**Explanation:** `Card` is a concrete subclass instantiated via `new Card()`. Dynamic method dispatch invokes `Card.pay(500)`. Fee is `500 * 0.02 = 10.0`, so `amount + fee = 510.0`.

---

### Q11. String Immutability
**Question:**  
Consider the following Java code snippet:
```java
String name = "java";
String upperName = name.toUpperCase();
```
Which of the following statements accurately describes the state of the `name` object after the `toUpperCase()` method call, based on Java's String immutability?

- **A.** The name object's value changes to "JAVA".
- **B.** The name object's value remains "java", and a new String object "JAVA" is created for upperName.
- **C.** Both name and upperName refer to the same new String object "JAVA".
- **D.** The original name object is destroyed, and a new one is created.

**Correct Answer:** **B. The name object's value remains "java", and a new String object "JAVA" is created for upperName.**  
**Explanation:** `String` objects are immutable in Java. Any method that appears to modify a String creates and returns a brand-new `String` instance, leaving the original unmodified.

---

### Q12. String Constant Pool vs Heap Allocation
**Question:**  
Given the Java code snippet, how many String objects are created in memory, considering the String pool?
```java
String s1 = "hello";
String s2 = "hello";
String s3 = new String("hello");
```

- **A.** `1`
- **B.** `2`
- **C.** `3`
- **D.** `0`

**Correct Answer:** **B. `2`**  
**Explanation:** `"hello"` literal creates 1 object in the String constant pool, reused by both `s1` and `s2`. `new String("hello")` explicitly forces the creation of a 2nd distinct object on the regular heap.

---

### Q13. String Method Indexing
**Question:**  
Consider the `Word` class and code snippet. What will be the output?
```java
class Word {
    private String text = "Campus";
    public char letterAt(int i) { return text.charAt(i); }
    public int getTextLength() { return text.length(); }
}
Word myWord = new Word();
System.out.println(myWord.getTextLength());
System.out.println(myWord.letterAt(2));
```

- **A.** `6 / m`
- **B.** `6 / p`
- **C.** `5 / m`
- **D.** `7 / p`

**Correct Answer:** **A. `6 / m`**  
**Explanation:** `"Campus".length()` is 6. With 0-based indexing: 'C'(0), 'a'(1), 'm'(2). Thus `letterAt(2)` returns `'m'`.

---

### Q14. String indexOf
**Question:**  
Given the Java code snippet, what will be the output?
```java
String email = "user@domain.com";
int index = email.indexOf("@");
System.out.println(index);
```

- **A.** `4`
- **B.** `0`
- **C.** `5`
- **D.** `-1`

**Correct Answer:** **A. `4`**  
**Explanation:** 0-based index calculation: 'u'(0), 's'(1), 'e'(2), 'r'(3), '@'(4).

---

### Q15. Default Constructor State
**Question:**  
Consider the `Book` class with a default constructor:
```java
class Book {
    private String title;
    private double price;
    public Book() {
        this.title = "Unknown";
        this.price = 0.0;
    }
    public String getDetails() {
        return "Title: " + title + ", Price: " + price;
    }
}
Book b = new Book();
System.out.println(b.getDetails());
```

- **A.** `Title: null, Price: 0.0`
- **B.** `Title: Unknown, Price: 0.0`
- **C.** `Title: , Price: 0.0`
- **D.** Compilation Error

**Correct Answer:** **B. `Title: Unknown, Price: 0.0`**  
**Explanation:** The default constructor initializes `title` to `"Unknown"` and `price` to `0.0`.

---

### Q16. Parameterized Constructor
**Question:**  
Consider the `Book` class with a parameterized constructor:
```java
class Book {
    private String title;
    private double price;
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
    public String getDetails() {
        return "Title: " + title + ", Price: " + price;
    }
}
Book b = new Book("Java Programming", 450.0);
System.out.println(b.getDetails());
```

- **A.** `Title: Java Programming, Price: 450.0`
- **B.** `Title: null, Price: 0.0`
- **C.** `Title: , Price: 0.0`
- **D.** Compilation Error

**Correct Answer:** **A. `Title: Java Programming, Price: 450.0`**  
**Explanation:** The constructor parameters are assigned directly to instance fields, producing `"Title: Java Programming, Price: 450.0"`.

---

### Q17. Object Counting in Memory
**Question:**  
Given the `Wallet` class and the code snippet, how many `Wallet` objects exist in memory after the execution of these lines?
```java
class Wallet {
    int balance;
    public Wallet(int amount) { this.balance = amount; }
}
Wallet w1 = new Wallet(500);
Wallet w2 = w1;
Wallet w3 = new Wallet(500);
```

- **A.** `1`
- **B.** `2`
- **C.** `3`
- **D.** `0`

**Correct Answer:** **B. `2`**  
**Explanation:** Each `new` operator invocation allocates one object. `w1` and `w3` instantiate new objects (2 total). `w2 = w1` copies a reference, not creating a new object.

---

### Q18. State Mutation via Shared Reference
**Question:**  
Consider the `Wallet` class and code snippet. What will be the output after the `add()` method is called through `w2`?
```java
class Wallet {
    int balance;
    public Wallet(int amount) { this.balance = amount; }
    public void add(int amount) { this.balance += amount; }
}
Wallet w1 = new Wallet(500);
Wallet w2 = w1;
w2.add(200);
System.out.println("w1 balance: " + w1.balance);
System.out.println("w2 balance: " + w2.balance);
```

- **A.** `w1 balance: 500 / w2 balance: 700`
- **B.** `w1 balance: 700 / w2 balance: 500`
- **C.** `w1 balance: 700 / w2 balance: 700`
- **D.** `w1 balance: 500 / w2 balance: 500`

**Correct Answer:** **C. `w1 balance: 700 / w2 balance: 700`**  
**Explanation:** `w1` and `w2` point to the identical heap instance. Calling `add(200)` increments `balance` to 700, visible through both reference variables.

---

### Q19. Instance Independence
**Question:**  
Consider the `Student` class and code snippet. What will be the output after `s1.setName("Anu")` is called?
```java
class Student {
    String name;
    public Student(String name) { this.name = name; }
    public void setName(String newName) { this.name = newName; }
}
Student s1 = new Student("Asha");
Student s2 = new Student("Ravi");
s1.setName("Anu");
System.out.println("s1 name: " + s1.name);
System.out.println("s2 name: " + s2.name);
```

- **A.** `s1 name: Asha / s2 name: Ravi`
- **B.** `s1 name: Anu / s2 name: Anu`
- **C.** `s1 name: Anu / s2 name: Ravi`
- **D.** `s1 name: Asha / s2 name: Anu`

**Correct Answer:** **C. `s1 name: Anu / s2 name: Ravi`**  
**Explanation:** `s1` and `s2` refer to distinct object instances. Updating `s1`'s name alters only `s1`, while `s2` retains its independent value `"Ravi"`.

---

### Q20. Static Counter Accumulation
**Question:**  
Consider the `Visitor` class with a static `visitorCount` variable:
```java
class Visitor {
    static int visitorCount = 0; // Shared by all visitors
    public Visitor() {
        visitorCount++;
    }
}
Visitor v1 = new Visitor();
Visitor v2 = new Visitor();
Visitor v3 = new Visitor();
System.out.println("Total visitors: " + Visitor.visitorCount);
```

- **A.** `Total visitors: 0`
- **B.** `Total visitors: 1`
- **C.** `Total visitors: 3`
- **D.** `Total visitors: Error`

**Correct Answer:** **C. `Total visitors: 3`**  
**Explanation:** `visitorCount` is static and incremented on each instance instantiation. Three object creations increment `visitorCount` from 0 to 3.

---

## Part C — Concept Questions & Answers

### Question 1: String Immutability & Performance Impact
**Prompt:**  
*Explain the concept of String immutability in Java and discuss its impact on performance when a String object undergoes repeated modifications. How can this performance impact be mitigated?*

**Answer:**  
In Java, `String` objects are **immutable**, meaning that once created, their internal character data cannot be altered. Whenever a `String` undergoes modification (such as concatenation using `+`), Java allocates a completely new `String` object in memory, copies over the characters, and discards the old one.  
When strings are modified repeatedly (for example inside a loop of $N$ iterations), this results in $\mathcal{O}(N^2)$ time complexity and generates numerous transient objects, placing significant overhead on the Garbage Collector.  
**Mitigation:** This performance impact is mitigated by using mutable character sequence buffers:
- **`StringBuilder`:** Highly efficient, unsynchronized mutable buffer designed for single-threaded operations.
- **`StringBuffer`:** Thread-safe, synchronized alternative for concurrent environments.

---

### Question 2: Resolving Variable Shadowing Using `this`
**Prompt:**  
*In a Java class constructor, when both an instance variable and a constructor parameter share the same name, how does the 'this' keyword resolve this ambiguity? Provide an example scenario to illustrate its use.*

**Answer:**  
When a constructor parameter or local variable shares the same name as an instance variable, the local parameter **shadows** the instance field within that scope. The `this` keyword represents a reference to the current object invoking the constructor or method. Prefixing the identifier with `this.` informs the compiler that the target is the object's instance variable rather than the local parameter.

**Example:**
```java
public class Student {
    private String name;

    public Student(String name) {
        // 'name' refers to the parameter; 'this.name' refers to the instance field
        this.name = name; 
    }
}
```

---

### Question 3: Objects vs. Reference Variables & Memory Assignment
**Prompt:**  
*Differentiate between an object and a reference variable in Java. Explain what occurs in memory when one reference variable is assigned the value of another, detailing the implications for object manipulation.*

**Answer:**  
- **Object:** An entity instantiated in heap memory containing state (instance variables) and behavior (methods).
- **Reference Variable:** A variable declared on the stack that stores the memory address (pointer) of an object located on the heap.

When one reference variable is assigned to another (e.g., `w2 = w1`), only the memory address stored in `w1` is copied to `w2`. No new object is allocated on the heap. Consequently, both variables become aliases pointing to the same single object instance. Any modification made through `w2` directly mutates the state of the shared object and is immediately observed through `w1`.

---

### Question 4: Use Cases for Static vs. Instance Variables
**Prompt:**  
*Discuss the appropriate use cases for static variables and instance variables in Java. Provide a scenario where a static member would be preferred and another where an instance member is more suitable, justifying your choices.*

**Answer:**  
- **Static Variables:** Belong to the class itself and are shared globally across all instances. Preferred for class-level attributes, counters, or constants.  
  *Scenario:* A shared counter `static int totalStudentsEnrolled` in a `Student` class or constants like `Math.PI`. Justification: All students share one single aggregate count; keeping separate copies per student would waste memory and cause state synchronization bugs.
- **Instance Variables:** Belong to a specific object instance. Preferred for modeling unique, per-object state.  
  *Scenario:* `private String studentId;` or `private String studentName;`. Justification: Each student possesses their own distinct identity and name that must not overwrite other students' data.

---

### Question 5: Comparison of `for`, `while`, and `do-while` Loops
**Prompt:**  
*Compare and contrast the for, while, and do-while loops in Java. Describe specific programming scenarios where each type of loop would be the most suitable choice, explaining your reasoning.*

**Answer:**  
1. **`for` Loop:** A pre-test loop that combines initialization, condition checking, and step increment in a compact header.  
   *Scenario:* Iterating over fixed-size data structures like arrays or lists (`for (int i = 0; i < arr.length; i++)`). Ideal when the number of iterations is known before entering the loop.
2. **`while` Loop:** A pre-test loop that evaluates its condition before executing the loop body. If the condition is initially false, the body never runs.  
   *Scenario:* Reading data from a network socket or file until an end-of-stream / null token is reached (`while ((line = reader.readLine()) != null)`). Ideal when iteration count depends on dynamic runtime conditions.
3. **`do-while` Loop:** A post-test loop that executes its body first before evaluating the condition. It is guaranteed to execute at least once.  
   *Scenario:* Console menu prompts where the user must be prompted at least once and re-prompted on invalid input.

---

### Question 6: Pass-By-Value in Java (Primitives vs. Object References)
**Prompt:**  
*Explain the concept of pass-by-value in Java. Differentiate its behavior and implications when a method receives a primitive data type as an argument versus when it receives an object reference.*

**Answer:**  
Java is **strictly pass-by-value**. This means arguments passed into methods are always copies of the caller's values:
- **Primitive Types (`int`, `double`, `boolean`, etc.):** The method receives a bitwise copy of the primitive value. Any alterations made to the parameter inside the method do not affect the caller's variable outside.
- **Object References:** The method receives a copy of the reference address (pointer) pointing to the object on the heap.  
  - *Mutating Object State:* Calling setter methods or modifying fields through this copied reference mutates the actual heap object, affecting the caller.
  - *Reassigning the Reference:* Reassigning the parameter variable itself (`param = new Object()`) changes only the local copy of the pointer; the caller's original reference remains unchanged.

---

### Question 7: Integer Division and Fractional Truncation
**Prompt:**  
*Describe how integer division operates in Java, specifically how it handles fractional results. Explain why an explicit type cast might be necessary to obtain a precise floating-point result from an arithmetic expression involving integers.*

**Answer:**  
In Java, applying the division operator `/` between two integer operands performs integer division. The fractional part is completely discarded (truncated toward zero), not rounded. For example, `7 / 2` evaluates to integer `3`.

If the result is stored in a `double` variable without casting (e.g. `double res = 7 / 2;`), integer division occurs first, yielding `3`, which is then widened to `3.0`. To preserve fractional accuracy, at least one operand must be explicitly cast to a floating-point type (`double` or `float`) prior to division (e.g., `(double) 7 / 2` yields `3.5`), forcing floating-point arithmetic.

---

### Question 8: Principle of Encapsulation
**Prompt:**  
*Elaborate on the principle of encapsulation in Object-Oriented Programming. Discuss how Java's access modifiers (e.g., private) combined with getter and setter methods contribute to enforcing encapsulation and ensuring data integrity.*

**Answer:**  
**Encapsulation** is the fundamental OOP principle of bundling data (fields) and the methods that operate on that data into a single cohesive class, while restricting direct external access to internal implementation details (data hiding).

- **`private` Access Modifier:** Prevents external classes from directly accessing or corrupting fields with arbitrary or invalid states (e.g., setting a bank balance to negative).
- **Public Getters & Setters:** Provide a controlled, audited interface. Setters can enforce business rules and validation logic (e.g., `if (amount > 0) balance += amount; else throw new IllegalArgumentException();`), while getters can return defensive copies of mutable objects, safeguarding internal data integrity.

---

### Question 9: `==` Operator vs. `equals()` Method
**Prompt:**  
*Explain the fundamental distinction between using the == operator and the equals() method when comparing two objects in Java. Illustrate how overriding the equals() method affects object comparison.*

**Answer:**  
- **`==` Operator:** Performs reference identity comparison. It evaluates to `true` if and only if both reference variables point to the exact same physical memory address on the heap.
- **`equals()` Method:** Defined in `java.lang.Object`. By default, `Object.equals()` performs reference identity (`this == obj`). However, classes can override it to implement logical value equality, checking whether two distinct objects have matching field contents.

**Illustration:**
```java
String a = new String("test");
String b = new String("test");

System.out.println(a == b);      // false (distinct memory addresses)
System.out.println(a.equals(b));  // true  (String overrides equals() to compare content)
```

---

### Question 10: Method Overloading vs. Method Overriding
**Prompt:**  
*Differentiate between method overloading and method overriding in Java, both of which are forms of polymorphism. Explain when each is resolved (compile-time vs. run-time) and provide a concise example for each concept.*

**Answer:**  
| Characteristic | Method Overloading (Static Polymorphism) | Method Overriding (Dynamic Polymorphism) |
| :--- | :--- | :--- |
| **Definition** | Same method name with different parameter signatures in the same class. | Subclass provides a specific implementation of a method defined in its superclass with the exact same signature. |
| **Resolution** | Compile-time (Static binding based on reference type). | Runtime (Dynamic method dispatch based on actual object type). |
| **Inheritance** | Does not require inheritance. | Strictly requires an inheritance relationship. |

**Example of Overloading:**
```java
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

**Example of Overriding:**
```java
class Animal {
    void speak() { System.out.println("Animal makes a sound"); }
}
class Dog extends Animal {
    @Override
    void speak() { System.out.println("Dog barks"); }
}
```
