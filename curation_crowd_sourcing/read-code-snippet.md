**Warning** some of the following quotes are from the book "The Programmer's Brain". Check how it can be reused with Felienne Hermans before proceeding.

An UI that shows a snippet of code from source control (github or gitlab). A companion tool for the Book.

- Source file URL (prefer using fixed hash of a revision)
- Beginning line
- End line 

Along with the code snippet, propose exercise from the book "The Programmer's Brain"

## Exercise 1.1 - identify cognitive processes when reading code

> To practice your newly gained understanding of the three cognitive processes involved in programming, I’ve prepared three programs. This time, though, no explanation is given of what the code snippets do. You will, therefore, have to read the programs and decide what they do for yourself. The programs are again written in APL, Java, and BASIC, in that order. However, each of the programs performs a different operation, so you cannot rely on your understanding of the first program to support reading the other programs.
> 
> Read the programs carefully and try to determine what they do. While doing this, reflect on the mechanisms that you use. Use the questions in the following table to guide your self-analysis.

For each code snippet, ask you the questions : 

What does this code do? What cognitive processes are involved?

- Are you retrieving knowledge from LTM?
- If you are retrieving information from LTM, what information?
- Are you storing information in your STM?
- What information are you storing explicitly?
- What information are you ignoring because it seems irrelevant?
- Is your working memory processing some parts of the code extensively?
- Which parts of the code place a heavy load on your working memory?
- Do you understand why these parts of code make the working memory work?

### Feature


**Modules**

- Show code (code import or copy paste or previously prepared by author)
    - Shareable exercice URL
- Reproduce (code editor)
    - https:///medv.io/codejar
- Select / Highlight / note code
    - STM or LTM

**Workflow**

Given the URL of a source code snippet
Show it to the screen
Ask the questions
- What does this code do?
- What cognitive processes are involved?
    - Are you retrieving knowledge from LTM?
    - If you are retrieving information from LTM, what information?
    - Are you storing information in your STM?
    - What information are you storing explicitly?
    - What information are you ignoring because it seems irrelevant?
    - Is your working memory processing some parts of the code extensively?
    - Which parts of the code place a heavy load on your working memory?
    - Do you understand why these parts of code make the working memory work?   
- Bonus : save data and send it to the owner of the study

## 2.1 Quickly reading code - reproduce code read

> To dive into the role of STM in more depth, look at the following Java program that implements the insertion sort algorithm. You may look at the program for no more than three minutes. Use a clock or stopwatch so you know when the time is up. After the three minutes are up, cover the Java code with a sheet of paper or with your hand.
Keeping the code covered, try to reproduce it as best as you can.
> 
> To dive into your cognitive processes, have a second look at your reproduced code. Annotate which parts of the code you think came from your STM directly and which parts were retrieved from LTM. An example of the reproduced code with an annotation of cognitive processes is shown in figure 2.2.

### Feature

**Modules**

- Show code (code import or copy paste)
    - for limited time
- Reproduce (code editor)    
- Select / Highlight / note code
    - STM or LTM

**Workflow**

- Show a code snippet for 3 minutes (show a countdown)
- Then in place show a text editor to try to reproduce the code
- Show the reproduction with annotation/highlight capabilities
    - multiple colors highlighter


To dive into your cognitive processes, have a second look at your reproduced code.
Annotate which parts of the code you think came from your STM directly and which
parts were retrieved from LTM. An example of the reproduced code with an annota-
tion of cognitive processes is shown in figure 2.2.

## Exercise 2.1, 2.2, 2.3 - chunks

- Show a sentence (image of text) for 5 sec
- How much do you remember of that sentence?

### Feature

**Modules**

- Show text or image (pre-recorded by an author)
    - for limited time
- Reflect (form)
- Compare

## Exercise 2.4 - read somewhat familiare code read for short duration - helps diagnostic your (mis)understandings

> Select a piece of code that is somewhat familiar to you. It can be something from your own codebase, or a small and simple piece of code from GitHub. It doesn’t matter all that much what code you select, or the programming language used. Something the size of half a page works best, and if possible, printing it on paper is  encouraged.
> 
> Look at the code for a few seconds, then remove it from sight and try to answer the following questions:

- What is the structure of the code?
  - Is the code nested deeply or it is flat?
  - Are there any lines that stand out?
- How is whitespace used to structure the code?
  - Are there gaps in the code?
  - Are there large blobs of code?

### Feature

**Modules**

- Show code (code import or copy paste)
    - for limited time
- Select / Highlight / note code
- Reflect (form)
- Contribute back -> backlink to source code repo
- Share the exercise (shareable URL)

**Workflow**

- Pick code snippet URL
- Show it for some seconds
- Answer the questions
    - What is the structure of the code?
        - Is the code nested deeply or it is flat?
        - Are there any lines that stand out?
    - How is whitespace used to structure the code?
        - Are there gaps in the code?
        - Are there large blobs of code?

### Exercise 2.5 - Beacons - practice beacons with unfamiliar code

> Selecting the right kinds of beacons to use in code can take some practice. Use this exercise to deliberately practice using beacons in code.
> 
> **Step 1: Select code**
> For this exercise select an unfamiliar codebase, but do select one in a programming language that you are familiar with. If possible, it would be great to do this exercise on a codebase where you know someone familiar with the details. You can then use that person as a judge of your understanding. In the codebase, select one method or function.
>
> **Step 2: Study code**
Study the selected code and try to summarize the meaning of the code.
>
> **Step 3: Actively notice beacons that you use**
> Whenever you have an “aha” moment where you get a bit closer to the functionality of the code, stop and write down what it was that led you to that conclusion. This could be a comment, a variable name, a method name, or an intermediate value—all of those can be beacons.
> 
> **Step 4: Reflect**
> When you have a thorough understanding of the code and a list of beacons, reflect using these questions:
> - What beacons have you collected?
> - Are these code elements or natural language information?
> - What knowledge do they represent?
> - Do they represent knowledge about the domain of the code?
> - Do they represent knowledge about the functionality of the code?
> 
> **Step 5: Contribute back to the code (optional)**
> Sometimes, but not always, the beacons you have selected could be improved or extended. Or the code might be in need of additional beacons that aren’t there yet. This is a great moment to enrich the code with the new or improved beacons. Because you weren’t familiar with the code before this exercise, you have a good perspective on what would help someone else who is new to the codebase too.
>
> **Step 6: Compare with someone else (optional)**
> If you have a coworker or friend who wants to improve their beacon use too, you can do this exercise together. It can be interesting to reflect on the differences both of you had in reproducing code. Because we know there are large differences between beginners and experts, this exercise might also help you understand your level of skill in a programming language relative to someone else’s.

### Feature

**Modules**

- Show code (code import or copy paste)
- Select / Highlight / note code
- Reflect (form)
- Contribute back -> backlink to source code repo
- Share the exercise (shareable URL)


**Workflow**

- Show code (or copy paste code)
- Actively notice beacons
    - UI. ex. (multi) Select code from snippet (new beacon)
    - The collected beacons can be layout as a table
        | Aha! moment code collected | Beacon(s) type |
        | -------------------------- | -------------- |
        | `pointFrom(int x, int y)`  | method name    |
        | `hypothenuse`              | variable name  |
        | `for (int i = 0; i < length ; i++)` | 
- Reflect
    - help the user with hints (ex. text placeholders)

| Aha! moment code collected | Beacon(s) type | Simple / compound beacon | Code elements or natural language? | What knowledge is represented? | Do they represent knowledge about the domain of the code? | Do they represent knowledge about the fonctionality of the code? |
| ----------------------------------- | -------------- | -- | -- | -- | -- | -- |
| `pointFrom(int x, int y)`           | method name and params | compound | natural language | yes - conventions (x = horizontal coordinate, y = vertical coordinate) both together binds to the point concept | yes - 2D geometry | Constructs a point data structure |
| `hypothenuse`                       | variable name  | simple | natural language | familiar mathematical concept (pythagore theorem) | yes - 2D geometry | implementation used to solve the problem (pythagore theorem) - not needed knowledge when the function is called from outside |
| `for (int i = 0; i < length ; i++)` | loop construct | compound | code elements | ___ | no | yes - processing of multiple tasks |


## Exercise 2.6 - practice chunking - in somewhat familiar codebase recognise familiar and hard concepts by testing code reading memory

> This exercise helps you recognize what concepts you are familiar with and what concepts are harder for you by testing your code reading memory. The underlying
assumption is that, as shown by the experiments outlined, familiar concepts are easier to remember. What you can remember is what you know, so these exercises can be used for (self) diagnosis of your code knowledge.
>
> **Step 1: Select code**
> Select a codebase you are somewhat familiar with—maybe something you work with regularly, but not mainly. It can also be something you personally wrote a while ago. Make sure you have at least some knowledge of the programming language the code is written in. You have to know more or less what the code does, but not know it intimately. You want to be in a situation similar to the chess players; they know the board and the pieces but not the setup. In the codebase, select a method or function, or another coherent piece of code roughly the size of half a page, with a maximum of 50 lines of code.
> 
> **Step 2: Study code**
Study the selected code for a bit, for a maximum of two minutes. Set a timer so you don’t lose track of the time. After the timer runs out, close or cover the code.
> 
> **Step 3: Reproduce the code**
> Take a piece of paper, or open a new file in your IDE, and try to recreate the code as best as you can.
> 
> **Step 4: Reflect**
> When you are sure you have reproduced all the code you possibly can, open the original code and compare. Reflect using these questions:
> - Which parts did you produce correctly with ease?
> - Are there any parts of the code that you reproduced partly?
> - Are there parts of the code that you missed entirely?
> - Do you understand why you missed the lines that you did?
> - Do the lines of code that you missed contain programming concepts that are
unfamiliar to you?
> -  Do the lines of code that you missed contain domain concepts that are unfamiliar to you?
> 
> **Step 5: Compare with someone else (optional)**
> If you have a coworker who wants to improve their chunking abilities too, you can do this exercise together. It can be very interesting to reflect on the differences in the code you reproduce. Because we know there are large differences between beginners and experts, this exercise might also help you understand your level of skill in a programming language relative to someone else’s.

### Feature

**Modules**

- Show code (code import or copy paste)
    - For limited time
- Recreate code (code editor)
- Compare (code compare)
- Reflect (form)
- Share the exercise (shareable URL)

## 3.2 Learn programming syntax quickly

Flashcards

## Exercise 3.1 - make flashcards

> Think of the top 10 programming concepts you always have trouble remembering.
> Make a set of flashcards for each of the concepts and try using them. You can also do this collaboratively in a group or team, where you might discover that you are not the only one who struggles with certain concepts.

### Feature

- Create flashcards
    - Front face
    - Back face
- Collaborative
- Tally
- Spaced repetition

## 3.4.4 Strengthen memories by actively thinking

> One thing you can do to strengthen the initial encoding of memories is called *elaboration*. Elaboration means thinking about what you want to remember, relating it to existing memories, and making the new memories fit into schemata already stored in your LTM.

- Deliberate practice
    - plane mode programming
    - paper programming
    - flashcard (think before flip)
    - try to remember
        - design pattern

## Exercise 3.2 - elaborate new concept based on concepts you already know

> Use this exercise the next time you learn a new programming concept. Answering the following questions will help you elaborate and strengthen the new memory:
> - What concepts does this new concept make you think of? Write down all the related concepts.
> - Then, for each of the related concepts you can think of, answer these questions:
>   - Why does the new concept make me think of this concept that I already know?
>   - Does it share syntax?
>   - Is it used in a similar context?
>   - Is this new concept an alternative to one I already know?
> -  What other ways do you know to write code to achieve the same goal? Try to create as many variants of this code snippet as you can.
> - Do other programming languages also have this concept? Can you write down examples of other languages that support similar operations? How do they differ from the concept at hand?
> - Does this concept fit a certain paradigm, domain, library, or framework?


## Exercise 4.1 

> The next time you read unfamiliar code, try to monitor your own cognitive load. When the code is hard to process and you feel the need to make notes or follow the execution step by step, it is likely you are experiencing a high cognitive load.
>
> When you experience high cognitive load, it is worthwhile to examine which parts of the code are creating the different types of cognitive load. You can use the following table to analyze this.

| Lines of code | Instrinsic cognitive load | Extraneous cognitive load |
| ------------- | ------------------------- | ------------------------- |
| _ | _ | _ |
| _ | _ | _ |
| _ | _ | _ |

## 4.3.1 Creating a dependency graph

## Using a state table


```basic
1 LET N2 = ABS (INT (N))
2 LET B$ = ""
3 FOR N1 = N2 TO 0 STEP 0
4     LET N2 = INT (N1 / 2)
5     LET B$ = STR$ (N1 - N2 * 2) + B$
6     LET N1 = N2
7 NEXT N1
8 PRINT B$
9 RETURN
```

|       | N | N2 | B$ | N1 |
| -     | - | -  | -  | -  |
| init  | 7 | 7  | _  | 7  |
| loop1 |   | 3  | 1  | 3  |
| loop2 |   |    |    |    |

> Figure 4.7 An example of a partial state table of the BASIC code for  alculating the binary representation of a number

## 4.3.3 Combining dependency graphs and state tables

## Exercise 4.2

> This section and section 4.2 describe two techniques to support your working memory when reading code by offloading some information about the code onto paper: drawing a dependency graph and creating a state table. These techniques focus on different parts of the code: while the dependency graph draws your attention to how the code is organized, the state table captures the calculations in the code. When explor ing unfamiliar code, you can use both exercises to gain a full picture of its inner workings and to use as memory aids when reading the code after completing them.


> Following the steps outlined in the previous sections, create both a dependency graph and a state table for each of the following Java programs.

**Program 1**

```
public class Calculations {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd'};
        // looking for bba
        calculate(chars, 3, i -> i[0] == 1 && i[1] == 1 && i[2] == 0);
    }
    static void calculate(char[] a, int k, Predicate<int[]> decider) {
        int n = a.length;
        if (k < 1 || k > n)
            throw new IllegalArgumentException("Forbidden");
        
        int[] indexes = new int[n];
        int total = (int) Math.pow(n, k);
        while (total-- > 0) {
            for (int i = 0; i < n - (n - k); i++)
                System.out.print(a[indexes[i]]);
            System.out.println();

            if (decider.test(indexes))
                break;

            for (int i = 0; i < n; i++) {
                if (indexes[i] >= n - 1) {
                    indexes[i] = 0;
                } else {
                    indexes[i]++;
                    break;
                }
            }
        }
    }
}
```

**Program 2**

```
public class App {
    private static final int WIDTH = 81;
    private static final int HEIGHT = 5;

    private static char[][] lines;
    static {
        lines = new char[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                lines[i][j] = '*';
            }
        }
    }

    private static void show(int start, int len, int index) {
        int seg = len / 3;
        if (seg == 0) return;
        for (int i = index; i < HEIGHT; i++) {
            for (int j = start + seg; j < start + seg * 2; j++) {
                lines[i][j] = ' ';
            }
        }
        show(start, seg, index + 1);
        show(start + seg * 2, seg, index + 1);
    }

    public static void main(String[] args) {
        show(0, WIDTH, 1);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(lines[i][j]);
            }
            System.out.println();
        }
    }
}
```

## 5 - WIP TODO