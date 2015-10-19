# Functional Programming Principles with Scala

## Introduction

* Paradigm : distinct concepts or thought patterns
* 3 programming paradigms : functional, imperative, logic
* OOP : can be combined with other (not actually a paradigm)
* Imperative Programming 
	- modifying mutable variables through assignments
	- using control structures
* Von Neumann computer
	- process <-- bus(32/64) --> memory

* strong correlation between 
	- mutable variables and memory cells
	- dereferencing variables and *load* instruction
	- variable assignment and *store*
	- control structures and *jump*

* Imperative programming is limited by the *Von-Neumann bottleneck*

* Functional Programming : **Avoid Mutations**, *newer ways to abstract and compose functions*

* Enables the construction of elegant programs with focus on functions

* Functions are treated specially
	- can be defined anywhere (even inside another function)
	- pass a function as a parameter 
	- return function as a result
	
* Any language with a programming construct, **blocks** which are functions that we can pass around (Ruby, Javascript)

* Scala : 2003

* **Why functional programming?**
	- simpler reasoning principles
	- better modularity
	- exploiting parallelism

### Elements of Programming

* Features of any programming language
	- primitive types
	- combine expressions
	- abstract expressions (variable name)

* FP : **REPL** Read Evaluate Print Loop

* Definitions *def* can have parameters

```scala
def sq(x : Int) = x * x; 

```

* Type of Definition

```scala
def sqf(x : Int) : Double = x * x;
```

* Primitive types in Scala : Int, Double, Boolean (capitalized)

* Evaluation of function
	- evaluate arguments : left to right
	- replace functions's *application* (name) by the right-hand side (whatever after = )
	- at the same time, in the RHS, replace the formal parameters by actual arguments
	
* **Substitution Model** ( lambda calculus )
	- substitution model cannot express *side effects*
	- i++ : i is incremented; old value is replaced by new i
	- avoiding side effects => simpler model of evaluation

* Infinite loop
	
```scala
def loop : Int = loop
```

* *Call by Value* and *Call by Name*
	- evaluate parameters before evaluating the RHS : **Call by Value**
	- use parameters without reduction and evaluate the RHS **Call by Name**
	- we get the same final result in both cases as long as [1] the reduced expressions are composed of functions and [2] both the evaluations terminate


### Evaluation strategies and Termination

* Forcing Call by Name
	- a function parameter that starts with => is not evaluated
	
```scala
def returnOne( x : Int, y : => Int ) = 1;
returnOne(3,loop); // reduces to returnOne(3,loop) 
// further reduces to 1, loop never get evaluated
```

### Conditionals and Value definitions

* Conditional evaluation of expression not statements

* Boolean
	- constants		: *true, false*
	- negation   	: !b
	- conjunction	: b && b
	- disjunctions : b || b

* Short-circuit evaluation (eg : a && false --> false)

* *def*-form is "by-name" : RHS evaluated on each use (only when the function is called, is the RHS evaluated)

* *val*-form is "by-value" : RHS evaluated at definition itself

```scala
val y = sq(2) // y refers to 4; never to sq(2)
```


### Newton's Method : Square root approximation

* *Recursive* functions should have explicit return types, since it calls itself, and we need a return type to break the loop


### Blocks and Lexical Scoping

* Fundamental structuring mechanisms in Scala
* *Block* : delimited by braces {...}
* Last expression of the block gives the value of the block
* Block rules
	- a definition inside a block is not seen(accessible) to the outer region
	- a block prefers the definition inside it, in case there is a definition outside with the same name

* By nesting definitions, the values (or params) are available to all the inner definitions

* Long expressions that span to multiple lines can be put under parenthesis (...) 
