#Operators

| Operations  |Maths | C Programming | 
| :----       | :--- |    :----   |
| Sum | + | + |
| Difference | -   | -  |
| Product | × | *  |
| Quotient | ÷ | / |
| Remainder | | % (Modulus operator)|

All the above operators needs two operands. Hence binary operator. Operands are the data used with the operator. 
Examples
```
a = 2 + 3; 
```
Here, 2 and 3 are the operands. Addition of 2 and 3 is 5 and assigned to `a`.

```
a = 2 + 3 + 5; 
```
Here, After the expression i evaluated the `a` is assigned with 9. To find the value of `a`, we need to know the priority in which the expression is evaluated.


![Priority 1](https://firebasestorage.googleapis.com/v0/b/codex-trees.appspot.com/o/c-lang%2Foperators%2Fpriority1.jpg?alt=media&token=9714b5bc-91b1-40a4-a631-3fa10f6b4ea4)

|Note: <br>If two operators have same priority, then use precedence rule / order of associativity / order of evaluation |
|:---|



a = 2 + 3* 5;<br> &nbsp; &nbsp; &nbsp;  2 + 15 <br> &nbsp; &nbsp; &nbsp; &nbsp; 17

a = (2 + 3) * 5;<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  5 * 5 <br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 25


|Note: <br>In C, () are not having any priority. But, they are used to change default priority.|
|:---|


a = 5/2
&nbsp; &nbsp; &nbsp; 2

a = 8/9
&nbsp; &nbsp; &nbsp; 0

a = 5/2.0
&nbsp; &nbsp; &nbsp; 2.5

a = 5.0/2.0
&nbsp; &nbsp; &nbsp; 2.5

| Operand | Operand| Result |
| :--- | :--- | :--- |
| int | int | int |
| int | float | float |
| float | int | float |
| float | float | float |

---
 You are completed with this post 🥳. Let's move to the next post [Modulus Operator](/c-lang/modulus-operator)
