<h2>Work with MutableLists</h2>
<html>
 <head></head>
 <body>
  <p>Kotlin provides many useful functions that can come in handy when you work with lists and modify their contents. In this topic, we'll look at various groups of commonly used functions and show you how to use them with examples.</p> 
  <h5>Outputting a list</h5> 
  <p>The first function is <code class="language-kotlin">joinToString()</code>. It helps us output our list in different ways using the <code class="language-kotlin">separator</code> attribute.</p> 
  <p>Use <code class="language-kotlin">joinToString()</code> to see the resulting list and print its contents:</p> 
  <pre><code class="language-kotlin">val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
println(southernCross.joinToString())   //  Acrux, Gacrux, Imai, Mimosa</code></pre> 
  <p>Remember that <code class="language-kotlin">joinToString()</code> takes elements from a mutable list in the order in which they are stored and presents them as a comma-delimited string line.</p> 
  <p>You can also use another delimiter to separate elements :</p> 
  <pre><code class="language-kotlin">println(southernCross.joinToString(" -&gt; "))   //  Acrux -&gt; Gacrux -&gt; Imai -&gt; Mimosa</code></pre> 
  <h5>Working with multiple lists</h5> 
  <p>Now, let’s look at a couple of things you might want to know about when working with several string lists. </p> 
  <ul> 
   <li>Mutable lists can be joined.</li> 
  </ul> 
  <p>You can concatenate several lists as shown in the following example:</p> 
  <pre><code class="language-kotlin">val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
val stars = mutableListOf("Ginan", "Mu Crucis")

val newList = southernCross + stars
println(newList.joinToString())    //  Acrux, Gacrux, Imai, Mimosa, Ginan, Mu Crucis</code></pre> 
  <ul> 
   <li>Mutable lists can be compared.</li> 
  </ul> 
  <p>You can use the operators <code class="language-kotlin">==</code> and <code class="language-kotlin">!=</code> to compare lists – their contents and sizes:</p> 
  <pre><code class="language-kotlin">val firstList = mutableListOf("result", "is", "true")
val secondList = mutableListOf("result", "is", "true")
val thirdList = mutableListOf("result")

println(firstList == secondList)  //  true
println(firstList == thirdList)   //  false
println(secondList != thirdList)  //  true</code></pre> 
  <p>Note that <code class="language-kotlin">true</code> is returned only if the elements of the two lists match completely and are arranged in the same order.</p> 
  <h5>Changing the list contents</h5> 
  <p>The keywords <code class="language-kotlin">val</code> and <code class="language-kotlin">var</code> tell you how the value/reference of a variable should be handled.</p> 
  <p><strong>var</strong> – the value/reference assigned to a variable can be changed at any time.<br> <strong>val</strong> – the value/reference can be assigned to a variable only once and cannot be changed later during the execution.</p> 
  <p>No matter which keyword you're using, <code class="language-kotlin">val</code> or <code class="language-kotlin">var</code>, you can<strong> </strong>still edit the values of the existing elements through their index. This is possible because when we change the contents of a list, we do not create a new list (the link to the list is not changed):</p> 
  <pre><code class="language-kotlin">val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
var stars = mutableListOf("Ginan", "Mu Crucis")
southernCross[1] = "star"
stars[1] = "star"

println(southernCross[1]) // star
println(stars[1]) // star</code></pre> 
  <p>There are ways to remove list elements and add new elements to the list.</p> 
  <p>You can use the functions <code class="language-kotlin">add</code>, <code class="language-kotlin">remove</code>, and <code class="language-kotlin">clear</code> to change lists:</p> 
  <pre><code class="language-kotlin">val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
val stars = mutableListOf("Ginan", "Mu Crucis")
val names = mutableListOf("Jack", "John", "Katie")
val food = mutableListOf("Bread", "Cheese", "Meat")
val fruits = mutableListOf("Apple", "Banana", "Grape", "Mango")

southernCross.removeAt(0)
southernCross.remove("Mimosa")

stars.add("New star")
stars.add(0, "First star")

names.clear()

food.addAll(fruits)

println(names) // []
println(southernCross.joinToString()) // Gacrux, Imai
println(stars.joinToString()) // First star, Ginan, Mu Crucis, New star
println(food.joinToString()) // Bread, Cheese, Meat, Apple, Banana, Grape, Mango</code></pre> 
  <ul> 
   <li><code class="language-kotlin">add(element)</code> and <code class="language-kotlin">add(index, element)</code> insert new items at any position in the list. If you don't specify the index, the item will be added to the end of the list.</li> 
   <li><code class="language-kotlin">list1.addAll(list2)</code> adds all elements from <code class="language-kotlin">list2</code> to the end of the <code class="language-kotlin">list1</code>.</li> 
   <li><code class="language-kotlin">remove(element)</code> and <code class="language-kotlin">removeAt(index)</code> delete an item from the list. The former function deletes a single instance of the specified element from the list (it returns <code class="language-kotlin">true</code> if item was successfully removed, otherwise it returns <code class="language-kotlin">false</code>). The latter function deletes the element at the specified position and returns the element that has been removed.</li> 
   <li><code class="language-kotlin">clear()</code> deletes all elements from the list.</li> 
  </ul> 
  <p>Also, you can use <code class="language-kotlin">+=</code> to add new elements to the list:</p> 
  <pre><code class="language-kotlin">val vowels = mutableListOf('a', 'o', 'i', 'e', 'u')
val intList1 = mutableListOf(1, 2, 3, 4, 5)
val intList2 = mutableListOf(5, 4, 3, 2, 1)
    
vowels += 'y'
intList1 += intList2

println(vowels)   // [a, o, i, e, u, y]
println(intList1) // [1, 2, 3, 4, 5, 5, 4, 3, 2, 1]</code></pre> 
  <h5>Copy list content</h5> 
  <p>Kotlin doesn't have any functions to copy existing lists. However, you can do it using the <code class="language-kotlin">toMutableList()</code> function:</p> 
  <pre><code class="language-kotlin">val list = mutableListOf(1, 2, 3, 4, 5)
val copyList = list.toMutableList()

print(copyList) // [1, 2, 3, 4, 5]</code></pre> 
  <p>This function creates a new MutableList and adds the contents of <code class="language-kotlin">list</code> to the new list. It works like this:</p> 
  <pre><code class="language-kotlin">val list = mutableListOf(1, 2, 3, 4, 5)
val copyList = mutableListOf&lt;Int&gt;()
copyList.addAll(list)

print(copyList) // [1, 2, 3, 4, 5]</code></pre> 
  <h5>Other useful functions</h5> 
  <p>There are some operations that can be really useful when you work with lists and their contents:</p> 
  <ul> 
   <li><code class="language-kotlin">list.isEmpty()</code> and <code class="language-kotlin">list.isNotEmpty()</code> – check whether the list is empty.</li> 
   <li><code class="language-kotlin">list.sublist(from, to)</code> – creates a smaller list (sublist), which includes items of the original list with the following indexes: <code class="language-kotlin">from</code>, <code class="language-kotlin">from + 1</code>, ..., <code class="language-kotlin">to - 2</code>, <code class="language-kotlin">to - 1</code>. The element with the index <code class="language-kotlin">to</code> is not included.</li> 
  </ul> 
  <pre><code class="language-kotlin">val numbers = mutableListOf(1, 2, 3, 4, 5)
val sublist = mutableListOf&lt;Int&gt;()
if (numbers.isNotEmpty() &amp;&amp; numbers.size &gt;= 4) {
     sublist = numbers.subList(1, 4)
}

print(sublist) // [2, 3, 4]</code></pre> 
  <ul> 
   <li><code class="language-kotlin">element in list</code> – checks if an element belongs to the list.</li> 
   <li><code class="language-kotlin">list.indexOf(element)</code> – searches for the index of an element in the list. The result of this function is -1 if there is no such element in the list. Otherwise, when we access the list by the calculated index, we get the element.</li> 
  </ul> 
  <pre><code class="language-kotlin">val numbers = mutableListOf(1, 2, 3, 4, 5)

if (5 in numbers) {
    println(numbers.indexOf(5)) // 4
}

print(numbers.indexOf(7)) // -1</code></pre> 
  <ul> 
   <li><code class="language-kotlin">list.minOrNull()</code> and <code class="language-kotlin">list.maxOrNull()</code> – search for the minimum and maximum elements in the list.</li> 
   <li><code class="language-kotlin">list.sum()</code> – returns the sum of the elements in the list.</li> 
   <li><code class="language-kotlin">list.sorted()</code> and <code class="language-kotlin">list.sortedDescending()</code> – build a sorted list (ascending or descending) from the available list.</li> 
  </ul> 
  <pre><code class="language-kotlin">val numbers = mutableListOf(1, 2, 3, 4, 5)
    
val vowels = mutableListOf('e', 'a', 'y', 'i', 'u', 'o')
    
println(numbers.minOrNull()) // 1
println(numbers.maxOrNull()) // 5
println(numbers.sum())      // 15
    
println(vowels.sorted()) // [a, e, i, o, u, y]
println(vowels.sortedDescending()) // [y, u, o, i, e, a]</code></pre> 
  <h5>Conclusion</h5> 
  <p>Let's sum things up now! You've figured out how to use some familiar functions and techniques when working with string lists.</p> 
  <p>Now you can:</p> 
  <ul> 
   <li>use <code class="language-kotlin">joinToString()</code> to create a single string from the list and output it;</li> 
   <li>use <code class="language-kotlin">==</code> and <code class="language-kotlin">!=</code> to compare two mutable lists;</li> 
   <li>add new elements to a list or remove elements from it;</li> 
   <li>perform various manipulations on lists and list elements.</li> 
  </ul> 
  <p></p>
  <div class="alert alert-primary">
    This is a lot of material! Good news for you: you can work with mutable lists of any type in the same way. Good luck! 
  </div>
  <p></p>
 </body>
</html>