📄 FileHandler - Java File Operations
This Java console-based application allows users to perform basic file operations such as:

1. Writing to a file

2. Reading from a file

3. Modifying file content

It uses standard Java I/O classes like BufferedReader, BufferedWriter, FileReader, and FileWriter.
---------------------------------------------------------------------------------------------------------------------------
📁 File Structure

task1/

│

├── FileHandler.java
---------------------------------------------------------------------------------------------------------------------------

🚀 How It Works
When you run the program, it presents a menu:

vbnet
Copy
Edit
Choose an operation:
1 - Write to file
2 - Read from file
3 - Modify file content
4 - Exit
✅ 1. Write to file
You can enter any text to write to sample.txt.

Type exit to stop writing and return to the main menu.

It appends new lines without erasing existing content.

📖 2. Read from file
Displays the content of sample.txt line-by-line.

If the file is empty, it notifies you.

✏️ 3. Modify file content
Replaces all occurrences of a given word or phrase with new text.

If the target word is not found, it notifies you.

All changes are saved directly into the same file.

❌ 4. Exit
Closes the program safely.
---------------------------------------------------------------------------------------------------------------------------

⚙️ Technologies Used
Java SE (Standard Edition)

Console-based user input with Scanner

File handling using Java I/O (java.io package)
---------------------------------------------------------------------------------------------------------------------------
💡 How to Run
Compile:
javac task1/FileHandler.java

Run:
java task1.FileHandler

Note: You don’t need to manually create the sample.txt file. It will be auto-generated on the first run.
---------------------------------------------------------------------------------------------------------------------------
🧠 Concepts Practiced
+ File I/O

+ Exception Handling

+ String manipulation

+ Menu-driven logic

+ Buffered Streams

+ Basic CRUD (Create, Read, Update)
