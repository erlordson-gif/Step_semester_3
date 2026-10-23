# Category C: Abstraction & Interface Practice Assignment Solutions
**Course:** STEP SEM-3 · CodInClub | Powered by BridgeLabz  
**Document:** `Category C - Abstraction_Interface_Class Vs Interface`  

---

## Part B — Quiz (Questions & Detailed Answers)

### Q1. Definition of Abstraction
**Question:**  
Which of the following best describes abstraction in object-oriented programming?

- **A.** Showing all internal details of an object to the user
- **B.** Protecting data inside an object from unauthorized access
- **C.** Hiding how an object performs its operations and showing only what it does
- **D.** Allowing a class to inherit from multiple parent classes

**Correct Answer:** **C. Hiding how an object performs its operations and showing only what it does**  
**Explanation:** Abstraction focuses on exposing essential behavior to the outside world while concealing internal implementation mechanics and complexities.

---

### Q2. Properties of an Abstract Class
**Question:**  
Which statement about an abstract class in Java is true?

- **A.** It must contain at least one abstract method
- **B.** It can be instantiated if it has no abstract methods
- **C.** It cannot be instantiated directly
- **D.** It can extend multiple other classes

**Correct Answer:** **C. It cannot be instantiated directly**  
**Explanation:** In Java, an abstract class cannot be instantiated using the `new` operator, even if it contains zero abstract methods. It serves as an incomplete template meant to be subclassed.

---

### Q3. Unimplemented Abstract Methods in Subclasses
**Question:**  
If a concrete class extends an abstract class but fails to implement an inherited abstract method, what is the consequence?

- **A.** Java automatically provides an empty implementation for the method
- **B.** The class must be declared abstract, or the code will not compile
- **C.** A runtime error will occur only when the unimplemented method is called
- **D.** The compiler will issue a warning but still allow compilation

**Correct Answer:** **B. The class must be declared abstract, or the code will not compile**  
**Explanation:** A concrete subclass is required to provide implementations for all inherited abstract methods. If it fails to implement even one, the subclass itself remains incomplete and must be declared `abstract`; otherwise, a compile-time error is generated.

---

### Q4. Disallowed Modifiers for Abstract Methods
**Question:**  
Which of the following modifiers is NOT allowed for an abstract method in Java?

- **A.** `protected`
- **B.** `public`
- **C.** `private`
- **D.** `default` (package-private)

**Correct Answer:** **C. `private`**  
**Explanation:** An abstract method has no body and relies entirely on subclasses to provide an implementation via method overriding. A `private` method is not inherited or accessible by subclasses, creating an inherent contradiction that Java disallows at compile time.

---

### Q5. Implicit Modifiers for Interface Fields
**Question:**  
Fields declared within a Java interface are implicitly:

- **A.** `private` and `static`
- **B.** `protected` and `final`
- **C.** `public`, `static`, and `final`
- **D.** `public` and instance-specific

**Correct Answer:** **C. `public`, `static`, and `final`**  
**Explanation:** Any constant/variable declared in a Java interface is automatically treated as `public static final`, regardless of whether those keywords are explicitly written.

---

### Q6. Multiple Interface Implementation
**Question:**  
How many interfaces can a single Java class implement?

- **A.** Only one interface at a time
- **B.** At most two interfaces
- **C.** Any number of interfaces
- **D.** None, if the class already extends another class

**Correct Answer:** **C. Any number of interfaces**  
**Explanation:** Java does not support multiple class inheritance (a class can only extend one superclass), but it allows a class to implement any number of comma-separated interfaces (`class C extends B implements I1, I2, I3`).

---

### Q7. Access Modifier for Implemented Interface Methods
**Question:**  
If a class implements an interface, what access modifier must it use for the implemented methods?

- **A.** `default` (package-private)
- **B.** `private`
- **C.** `protected`
- **D.** `public`

**Correct Answer:** **D. `public`**  
**Explanation:** All abstract methods declared in a Java interface are implicitly `public`. In Java, an overriding method cannot assign weaker access privileges than the overridden method, so the implementing class must explicitly declare the method as `public`.

---

### Q8. Single Inheritance vs. Multiple Interfaces
**Question:**  
Why does Java allow a class to implement multiple interfaces but only extend a single class?

- **A.** Implementing interfaces makes the code run faster
- **B.** Classes are unable to contain any methods
- **C.** Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance
- **D.** Interfaces are compiled independently from classes

**Correct Answer:** **C. Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance**  
**Explanation:** Multiple inheritance of classes can cause ambiguity when two superclasses maintain contradictory instance state (fields). Because interfaces do not possess instance state/fields, inheriting behavior from multiple interfaces avoids state collisions.

---

### Q9. Conflicting Interface Default Methods
**Question:**  
What happens if a class implements two interfaces that both provide a default method with the same signature, and the class does not override this method?

- **A.** The method from the first interface listed in the implements clause is used
- **B.** The method from the last interface listed in the implements clause is used
- **C.** A runtime exception occurs when the method is called
- **D.** A compile-time error occurs until the class overrides the method

**Correct Answer:** **D. A compile-time error occurs until the class overrides the method**  
**Explanation:** When two implemented interfaces declare default methods with identical signatures, Java will not guess or prioritize order. The compiler issues an error demanding that the implementing class explicitly override the conflicting method and resolve the ambiguity.

---

### Q10. Constructors in Abstract Classes
**Question:**  
Which of the following is true regarding constructors in Java?

- **A.** Concrete classes cannot have constructors
- **B.** Abstract classes can have constructors that run when a subclass object is created
- **C.** Interfaces must have at least one constructor
- **D.** Constructors in abstract classes are used to create objects of the abstract class directly

**Correct Answer:** **B. Abstract classes can have constructors that run when a subclass object is created**  
**Explanation:** Abstract classes cannot be directly instantiated, but they can have constructors to initialize common instance fields. When a concrete subclass constructor is invoked, it chains to the abstract superclass constructor via `super()`.

---

## Part C — Concept Questions & Answers

### Question 1: Abstraction & Real-Life Example
**Prompt:**  
*Explain abstraction in your own words. Provide a real-life example, different from those mentioned in the material, detailing what is shown to the user and what details are hidden.*

**Answer:**  
Abstraction is the fundamental software design principle of providing a clean, high-level interface while hiding the internal complexities and mechanics needed to perform that action. It separates "what an object does" from "how it actually does it."

**Real-Life Example: An Automated Teller Machine (ATM)**
- **What is shown to the user:** A simple touch screen showing options like *"Withdraw Cash"*, a keypad to enter the amount and PIN, and a slot to collect banknotes.
- **What details are hidden from the user:** The cryptographic hashing of the PIN, secure communication with remote banking networks via ISO 8583 protocols, ledger database transactions, bill-dispenser optical sensors, and internal cash cassette motors. The user achieves their goal seamlessly without needing to know any of these internal mechanics.

---

### Question 2: Abstraction vs. Encapsulation
**Prompt:**  
*Describe the primary difference between abstraction and encapsulation. Explain how these two concepts work together within a single class to manage complexity and data protection.*

**Answer:**  
- **Abstraction (Design / Interface Level):** Focuses on hiding implementation details and presenting only essential features. It is achieved using abstract classes and interfaces to define *contracts*.
- **Encapsulation (Implementation / Data Level):** Focuses on data protection and binding methods to fields. It is achieved by declaring instance variables `private` and exposing controlled `public` getter and setter methods with validation logic.

**How They Work Together:**  
Encapsulation acts as the protective shield that guards an object's internal variables from corrupt or unauthorized access, while Abstraction provides the high-level, intuitive API that client code interacts with. For example, a `BankAccount` class encapsulates `private double balance` (preventing direct illegal assignment) and abstracts away transactions behind a clean `withdraw(double amount)` method.

---

### Question 3: Constructors in Abstract Classes
**Prompt:**  
*An abstract class cannot be instantiated, yet it can define a constructor. Explain why an abstract class might have a constructor and describe when this constructor is executed.*

**Answer:**  
- **Why it defines a constructor:** Abstract classes frequently define shared state (instance variables) common to all subclasses (such as an `id`, `ownerName`, or base configuration). Defining a constructor allows the abstract class to guarantee that these common fields are initialized correctly and consistently, enforcing essential class invariants.
- **When it executes:** Although the abstract class cannot be instantiated on its own with `new`, its constructor is automatically executed during the instantiation of a concrete subclass. Through constructor chaining, the subclass constructor invokes `super(...)` as its very first statement, running the abstract class constructor before the subclass constructor executes its own body.

---

### Question 4: Disallowed Modifiers for Abstract Methods
**Prompt:**  
*Explain why an abstract method cannot be declared with the private, static, or final modifiers. Provide a reason for each of these restrictions.*

**Answer:**  
1. **`private`:** Abstract methods are declared without a body and exist solely to be overridden by subclasses. Because `private` methods are not inherited or accessible outside their declaring class, a subclass cannot override them. Combining `abstract` and `private` creates an unresolvable contradiction.
2. **`final`:** The `final` keyword explicitly forbids method overriding. Since an abstract method mandates overriding, the two keywords are mutually exclusive.
3. **`static`:** Static methods belong to the class itself and are resolved at compile-time via static binding (method hiding). In contrast, abstract methods rely on dynamic polymorphism (runtime method dispatch) determined by the actual subclass instance at runtime.

---

### Question 5: The Diamond Problem & Java's Solution
**Prompt:**  
*What is the 'diamond problem' in the context of inheritance? Explain how Java's design, allowing a class to implement multiple interfaces but extend only one class, addresses or avoids this problem.*

**Answer:**  
The **Diamond Problem** occurs in multiple class inheritance when a class $D$ inherits from two classes $B$ and $C$, both of which inherit from a common base class $A$. If both $B$ and $C$ override a method or introduce conflicting state from $A$, class $D$ encounters ambiguity: it cannot determine which parent version of the state or method to inherit.

**How Java Solves It:**
- **Single Class Inheritance:** Java restricts classes to extending only one superclass (`single inheritance of state`). This ensures that every object has an unambiguous, single ancestral line of instance variables.
- **Multiple Interfaces:** Java allows classes to implement multiple interfaces because interfaces historically had no instance fields (state). 
- **Default Methods (Java 8+):** When two interfaces define conflicting default methods with the exact same signature, the Java compiler refuses to guess and forces a compile-time error. The programmer must explicitly resolve the collision by overriding the method in the subclass (e.g., using `InterfaceName.super.methodName()`).
