# Java-parser

Constructor + parser + evaluator + tabulator of arithmetic expressions



Supported operations: `+`,  `-`,  `*`,  `/`,  `mod`, `abs`, `square`

Expressions can contain variables `x`, `y`, `z`

Expressions can be constructed such way and be converted to string with full set of parentheses:

``` java
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).toString() // ((2 * x) - 3)
```



Expressions have `equals` method



Expression can be evaluated in following types (as types of variables):

- `int` with overflow detection (`-i`)
- `double` (`-d`)
- `BigInteger` (`-bi`)
- `int` without overflow detection (`-u`)
- `byte` (`-b`)
- `int` by modulo 1009 (`-p`)

Achieved by using generics and wrappers around number types



Expression can be parsed from a string like `x * (x - 2)*x + 1` with arbitrary mumber of spaces

Achieved with **recursive descent parser**



Tabulator provides a CLI and produces a table of evaluation results for each x, y and z in given ranges

