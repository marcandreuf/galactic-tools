# galactic-tools
Implementation of the Galactic calculator exercise using TDD and my best knowladge of software principles.

## How to run

The galaxy tool can be executed using the gradle application plugin. To do that we just need to clone the project into a local folder and run the following terminal commands:

```
    cd <project folder>
    gradle run -Dexec.args="testInput.txt"
```

Or alternatively configure a Run execution in the IDE tool with the argument:
```
    testInput.txt
```

The output test data is written in the console and also an output file is generated at the following path.
```
    build/resources/main/testOutput.txt
```
To run the test suite of Unit and Integration tests from gradle. Open a terminal and use the following commands:

```
    cd <project-home>
    gradle clean test
```

### Set up project

1. From IDE import project as Gradle project.
2. Import all gradle dependencies.
3. Execute Gradle task "build".
4. Run test cases with Gradle task "test".
5. Enjoy :-)

### The solution design:

There is a [Umlet](http://www.umlet.com/) diagram in the root folder called "UmlLet_model.png" with the main class diagram of this solution.

Update: The diagram is not up to date with the last implementation. I am working on it to add the last modifications.

# Problem Three: Merchant's Guide to the Galaxy

You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).

Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.

The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.

Roman numerals are based on seven symbols:

Symbol

Value

I 1

V 5

X 10

L 50

C 100

D 500

M 1,000


Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 - 100) + (50 - 10) + (5 - 1) = 1944.

The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
Only one small-value symbol may be subtracted from any large-value symbol.
A number written in Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. In the above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.
(Source: Wikipedia http://en.wikipedia.org/wiki/Roman_numerals)

Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.

You are expected to handle invalid queries appropriately.

Test input:<br>
glob is I<br>
prok is V<br>
pish is X<br>
tegj is L<br>
glob glob Silver is 34 Credits<br>
glob prok Gold is 57800 Credits<br>
pish pish Iron is 3910 Credits<br>
how much is pish tegj glob glob ?<br>
how many Credits is glob prok Silver ?<br>
how many Credits is glob prok Gold ?<br>
how many Credits is glob prok Iron ?<br>
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?<br>

Test Output:<br>
pish tegj glob glob is 42<br>
glob prok Silver is 68 Credits<br>
glob prok Gold is 57800 Credits<br>
glob prok Iron is 782 Credits<br>
I have no idea what you are talking about<br>
