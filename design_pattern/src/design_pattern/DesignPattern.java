package design_pattern;

/*
 * Design patterns are solutions to recurring problems; guidelines on how to tackle certain problems
 * 
 * Types of Design Patterns
 * 1. Creational - Focused towards how to instantiate an object or group of related objects.
 * 2. Structural - Mostly concerned with object composition or in other words how the entities can use each other.
 *                 They help in answering "How to build a software component?".
 * 3. Behavioral - It is concerned with assignment of responsibilities between the objects. 
 *                 What makes them different from structural patterns is they don't just specify the structure 
 *                 but also outline the patterns for message passing/communication between them. 
 *                 Or in other words, they assist in answering "How to run a behavior in software component?"               
 */

/*
 * Design Principle
 * 1. Single responsiblity principle (SRP)
 * 2. Don't repeat yourself (DRY)
 * 
 * 3. Liskov's substitution principle (LSP) - The Liskov Substitution Principle states that any class 
 *    that is the child of a parent class should be usable in place of its parent without any unexpected behaviour.
 *    Four conditions for abiding by the LSP
 *    a. Methods must take the same parameters
 *    b. The preconditions for any method can’t be greater than that of its parent
 *        Any inherited method should not have more conditionals that change the return of that method, such as throwing an Exception
 *        ex : class Parent { void fun(x) { if(x<10){//do}}
 *        class Child extends Parent {void fun(x){ if(x>20) {//do}}
 *        Breaks LSP as fun function in child behaves differently as Parent 
 *    c. Post conditions must be at least equal to that of its parent
 *    Inherited methods should return the same type as that of its parent
 *    d. Exception types must match
 *    If a method is designed to return a FileNotFoundException in the event of an error, 
 *    the same condition in the inherited method must return a FileNotFoundException too
 * 
 * 4. Class should be unit testable
 * 5. Avoid static method
 * 
 * 
 * 
 */
public class DesignPattern {

}
